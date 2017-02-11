import java.io.File; 
import java.awt.BorderLayout; 
import java.awt.Robot; 
import java.awt.Toolkit; 
import java.awt.Rectangle; 
import java.io.IOException; 
import java.awt.AWTException; 
import javax.imageio.ImageIO; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.image.BufferedImage; 
import javax.swing.JButton; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class Screenshot { 
		File file; 
		private void panel(){ 
			JFrame frame = new JFrame("Screenshot"); 
			JPanel panel = new JPanel();
			JButton button = new JButton("To save the picture click here"); 
		    JButton choose = new JButton("When do you want to save?"); 
			choose.addActionListener(new ChooseListener()); 
			button.addActionListener(new ButtonListener()); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frame.getContentPane().add(BorderLayout.CENTER,panel);
			panel.add(choose);
			panel.add(button);
			frame.setSize(350,150); 
			frame.setVisible(true); 
			frame.setResizable(false); 
		} 
		class ChooseListener implements ActionListener { 
			@Override 
			public void actionPerformed(ActionEvent arg0) { 
			  new MyFrame(); 
			} 
		} 

		class ButtonListener implements ActionListener { 
			@Override 
			public void actionPerformed(ActionEvent arg0) { 
				try{ if(file!=null){
					ImageIO.write(yourScreen(), "png", new File(file,"myscreen.png"));
					JOptionPane.showMessageDialog(null, "You saved the picture in "+file);
					}else {
						JOptionPane.showMessageDialog(null, "Select the needs folder for saving ");
					}
					
				} catch (IOException e) { 
					System.out.println("IO exception"+e); 
				} 
			} 

		} 
		class MyFrame extends JFrame {
			public MyFrame(){
			setBounds(0,0,500,500); 
			JFileChooser dialog = new JFileChooser(); 
			dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
			dialog.setApproveButtonText("Select"); 
			dialog.setDialogTitle("Select a file to save "); 
			dialog.setFileSelectionMode(JFileChooser.SAVE_DIALOG); 
			dialog.showOpenDialog(this); 
			file =dialog.getSelectedFile(); 
			setVisible(false);
			}
		}
		private static BufferedImage yourScreen() { 
			try { 
				return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())) ; 
			} catch (SecurityException e) { 
			} catch (AWTException e) { 
			} 
			return null; 
		} 
		public static void main(String[] args) { 
			Screenshot myScreenshot = new Screenshot(); 
			myScreenshot.panel(); 

		} 
	}

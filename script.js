$(document).ready(function(){
	$('#showFirst').on('click', function(){
		$('#textFirst').load('textFirst.txt');
	});
	$('#showSecond').on('click', function(){
		$('#textSecond').load('textSecond.txt');
	});
	$('#showThird').on('click', function(){
		$('#textThird').load('textThird.txt');
	});
	$('#reset').on('click',function(){
		$('#textFirst').load('textFirst.txt');
		$('#textSecond').load('textSecond.txt');
		$('#textThird').load('textThird.txt');
	});
	$('p').on('click',function(){
		var content = $(this).text();
		var lexicon = new RiLexicon();
		var rs = new RiString(content);
		var pos = rs.pos();
		var words = rs.words();
		var output = " ";
		for(var i=0;i<words.length;i++){
			if(pos[i]==='nn'){
				output += lexicon.randomWord('nn');
			}else{
				output += words[i];
			}
			output += " ";
		}
		$(this).html(output);
	});
});
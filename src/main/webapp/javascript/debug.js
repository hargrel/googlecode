window.onresize = printdebug;

function printdebug() {
	var width = $(window).width();
	var height = $(window).height();
	
	$("p#dimensions").text(width + " x " + height);
	
	var movevertical = (Math.random() * height) + "px";
	var movehorizontal = (Math.random() * width) + "px";
	
	$("p#canvas").css("top",movevertical);
	$("p#canvas").css("left",movehorizontal);
}

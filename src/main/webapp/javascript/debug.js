/** Use this file for debug purposes. */

function debug() {
	var canvas = new windowCanvas();
	
	$("p#dimensions").text(canvas.size.width + " x " + canvas.size.height);

	$("a#google").css("top", (canvas.randomCoordinate.y + "px"));
	$("a#google").css("left", (canvas.randomCoordinate.x + "px"));

}
/** Use this file for debug purposes. */

function debug() {
	var windowArea = new windowCanvas();
	var linkArea = new linkCanvas(new resolution(80, 84));
	
	$("p#dimensions").text(windowArea.size.width + " x " + windowArea.size.height);

	$("p#imgcanvas").text(linkArea.size.width + " x " + linkArea.size.height);

	$("a#google").css("top", (linkArea.randomCoordinate.y + "px"));
	$("a#google").css("left", (linkArea.randomCoordinate.x + "px"));

}
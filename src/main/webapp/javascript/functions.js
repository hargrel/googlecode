/** Custom functions (like static methods) */

function moveObject() {
	moveDiv("#google", new coordinate(100, 100), new coordinate(500, 500));
}

/* Moves an object "#id" from the start "coordinate" to the end "coordinate". */
/* y = m(x - x1) + y1 */
function moveDiv(id, start, end) {
	var slope = Math.floor((end.y - start.y) / (end.x - start.x));
	var xCount = start.x;
	var interval = setInterval(mover, 1);
	var slideDistance = end.x - start.x;

	function mover() {
		if (xCount < end.x) {
			var yCount = slope * (xCount - start.x) + start.y;
			var slidePosition = (xCount + 1) - start.x;
			
			$(id).css("top", (yCount + "px"));
			$(id).css("left", (xCount + "px"));
			
			xCount += slideSpeed(slidePosition, slideDistance);
		} else {
			clearInterval(interval);
		}		
	}
	
	function slideSpeed(position, distance) {
		var halfway = distance / 2;
		
		if (position < halfway) {
			return Math.ceil((position / halfway) * 5);
		} else {
			return 5;
		}
	}
}
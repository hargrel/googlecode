/** Custom functions (like static methods) */

function moveObject() {
	moveDiv("#google", new coordinate(50, 50), new coordinate(900, 500));
}

/* Moves an object "#id" from the start "coordinate" to the end "coordinate". */
function moveDiv(id, start, end) {
	var slope = calculateGradient(start, end);
	var xCount = start.x;
	var distance = end.x - start.x;

	var interval = setInterval(mover, 1);
	function mover() {
		if (xCount < end.x) {
			var yCount = pointSlopeEquation(slope, xCount, start.x, start.y);
			var position = (xCount + 1) - start.x;
			
			$(id).css("top", (yCount + "px"));
			$(id).css("left", (xCount + "px"));
			
			xCount += slideSpeed(position, distance);
		} else {
			clearInterval(interval);
		}		
	}	
}

function calculateGradient(start, end) {
	return (end.y - start.y) / (end.x - start.x);
}

function pointSlopeEquation(slope, x, x1, y1) {
	return slope * (x - x1) + y1;
}

function slideSpeed(position, distance) {
	var halfway = distance / 2;
	var minSpeed = 0.2;
	var topSpeed = 5;
	var distanceOffset = topSpeed * 2;
	
	if (position < halfway) {
		return accelerationSpeed();
	} else if (position < distance){
		return decelerationSpeed();
	} else {
		return minSpeed;
	}
	
	function accelerationSpeed() {
		var speed = (position / halfway) * topSpeed;
		if (speed < minSpeed) {
			return minSpeed;
		}
		return speed;
	}
	
	function decelerationSpeed() {
		var speed = distanceOffset - (position / distance) * distanceOffset;
		if (speed < minSpeed) {
			return minSpeed;
		}
		return speed;
	}
}

function randomScreenCoordinate(resolution) {
	var x = Math.floor(resolution.width * Math.random());
	var y = Math.floor(resolution.height * Math.random());
	
	return new coordinate(x, y);
}
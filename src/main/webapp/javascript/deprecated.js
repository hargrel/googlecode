/*

function moveDiv() {
	var divId = "#google";
	var position = $(divId).position();
	var start = new coordinate(position.left, position.top);
	var linkArea = new linkCanvas(new resolution(80, 84));
	
	moveObject("#google", start, randomScreenCoordinate(linkArea.size));
}


function moveObject(id, start, end) {
	var slope = calculateGradient(start, end);
	var xCount = start.x;
	var distance = Math.abs(end.x - start.x);

	var interval = setInterval(mover, 1);
	function mover() {
		var yCount = pointSlopeEquation(slope, xCount, start.x, start.y);
		var position;

		$(id).css("top", (yCount + "px"));
		$(id).css("left", (xCount + "px"));

		if (start.x < end.x) {
			if (xCount < end.x) {
				position = (xCount + 1) - start.x;
				xCount += slideSpeed(position, distance);				
			} else {
				clearInterval(interval);
			}
		} else {
			if (xCount > end.x) {
				position = start.x - xCount + 1;
				xCount -= slideSpeed(position, distance);				
			} else {
				clearInterval(interval);
			}
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












function windowCanvas() {
	this.size = new resolution($(window).width(), $(window).height());
	this.randomCoordinate = randomScreenCoordinate(this.size);
}

function linkCanvas(linkSize) {
	this.size = calculateSize(linkSize);
	this.randomCoordinate = randomScreenCoordinate(this.size);
	
	function calculateSize(linkSize) {
		var area = new windowCanvas().size;
		
		if (linkSize.width > area.width || linkSize.height > area.height) {
			area.width = linkSize.width;
			area.height = linkSize.height;
		} else {
			area.width -= linkSize.width;
			area.height -= linkSize.height;
		}
		
		return area;
	}
}


function coordinate(x, y) {
	this.x = x;
	this.y = y;
}

function resolution(width, height) {
	this.width = width;
	this.height = height;	
}



linkCanvas = new windowCanvas();

if (linkDimension.width > linkCanvas.size.width || linkDimension.height > linkCanvas.size.height) {
	linkCanvas.size.width = linkDimension.width;
	linkCanvas.size.height = linkDimension.height;
} else {
	linkCanvas.size.width -= linkDimension.width;
	linkCanvas.size.height -= linkDimension.height;
}

return linkCanvas;	

*/
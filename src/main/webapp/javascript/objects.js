/** Custom objects used for Clusters */

/* The browser inner area object. */
function windowCanvas() {
	this.size = new windowSize($(window).width(), $(window).height());
	this.randomCoordinate = randomScreenCoordinate(this.size);
}

/* Outputs a random coordinate within the boundaries of the screen size. */
function randomScreenCoordinate(windowSize) {
	var x = Math.floor(windowSize.width * Math.random());
	var y = Math.floor(windowSize.height * Math.random());
	
	return new coordinate(x, y);
}

/* The coordinate object. */
function coordinate(x, y) {
	this.x = x;
	this.y = y;
}

/* The window size object. */
function windowSize(width, height) {
	this.width = width;
	this.height = height;	
}
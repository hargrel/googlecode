/** Custom objects used for Clusters */

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






//linkCanvas = new windowCanvas();
//
//if (linkDimension.width > linkCanvas.size.width || linkDimension.height > linkCanvas.size.height) {
//	linkCanvas.size.width = linkDimension.width;
//	linkCanvas.size.height = linkDimension.height;
//} else {
//	linkCanvas.size.width -= linkDimension.width;
//	linkCanvas.size.height -= linkDimension.height;
//}
//
//return linkCanvas;		
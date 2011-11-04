
function linkWindow() {
	var linkWidth = $('a.sitelink img').css('width');
	var linkHeight = $('a.sitelink img').css('height');
	
	if (linkWidth > $(window).width() || linkHeight > $(window).height()) {
		this.width = linkWidth;
		this.height = linkHeight;
	} else {
		this.width = $(window).width() - linkWidth;
		this.height = $(window).height() - linkHeight;
	}
}


function coordinates(left, top) {
	this.left = left;
	this.top = top;
}

function randomCoordinates(linkWindow) {
	this.left = Math.floor(linkWindow.width * Math.random());
	this.top = Math.floor(linkWindow.height * Math.random());
}
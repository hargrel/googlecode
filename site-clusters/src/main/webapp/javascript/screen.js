
function linkWindowObj() {
	var linkWidth = 80;     // $('a.sitelink img').css('width');
	var linkHeight = 84;    // $('a.sitelink img').css('height');
	
	if (linkWidth > $(window).width() || linkHeight > $(window).height()) {
		this.width = linkWidth;
		this.height = linkHeight;
	} else {
		this.width = $(window).width() - linkWidth;
		this.height = $(window).height() - linkHeight;
	}
}


function randomPosition(linkWindow) {
	var left = Math.floor(linkWindow.width * Math.random());
	var top = Math.floor(linkWindow.height * Math.random());
	
	return ({left: left, top: top});
}
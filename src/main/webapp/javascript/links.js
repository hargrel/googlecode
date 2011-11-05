function moveLinks() {
	$('.sitelink').each(function () {
		moveLink("#" + $(this).attr('id'));
	});
}

function moveLink(id) {
	var moveStrings = new randomMoveStrings(id);
	
	$(id).animate({left: moveStrings.left, top: moveStrings.top}, 1000);
}

function randomMoveStrings(id) {
	var newLinkPosition = randomPosition(new linkWindowObj());
	
	var leftDistance = newLinkPosition.left - $(id).position().left;	
	var topDistance = newLinkPosition.top - $(id).position().top;
	
	return ({left: "+=" + leftDistance, top: "+=" + topDistance});	
}


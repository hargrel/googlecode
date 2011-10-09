/* Writes a set of script tags for loading in HTML in one line */

loadscript('javascript/jquery/jquery-1.6.4.min.js');
loadscript('javascript/searchfade.js');
loadscript('javascript/debug.js');

function loadscript(src) {
	document.write('<script type="text/javascript" src="' + src + '"></script>');
}


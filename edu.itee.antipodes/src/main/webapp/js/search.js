var map = null;
var marker;

function initialize() {
    if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map_canvas"));
        map.addControl(new GLargeMapControl());
        map.setCenter(new GLatLng(23.324, 65.039), 2);

        geocoder = new GClientGeocoder();
		GDownloadUrl("xml/search.xml", function(data) {
          var xml = GXml.parse(data);
          var markers = xml.documentElement.getElementsByTagName("marker");
          for (var i = 0; i < markers.length; i++) {
            var latlng = new GLatLng(parseFloat(markers[i].getAttribute("lat")),
                                    parseFloat(markers[i].getAttribute("lng")));
            var location = markers[i].getAttribute("loc");
			var marker = createMarker(latlng,location)
          }//for
        });//GDownload
    }
}

function createMarker(point,loc) {
        var marker = new GMarker(point);
        GEvent.addListener(marker, "click", function() {
        		if (document.forms['search'].locationName.value == ""){
                	document.forms['search'].locationName.value = loc;}
                else{
                	document.forms['search'].locationName.value += "," + loc;
                }
        		});
		map.addOverlay(marker);
        return marker;
      }
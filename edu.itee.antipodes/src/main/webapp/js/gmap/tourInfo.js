var map = null;
var marker;

//TO DO
//hidden input for map.setCenter

function initialize() {
	if (GBrowserIsCompatible()) {
		var url = window.top.location.search;
		map = new GMap2(document.getElementById("map_canvas"));
		map.setMapType(G_SATELLITE_MAP);
		var latlng = new GLatLng(document.getElementById("latitude").value, document.getElementById("longitude").value);
		map.setCenter(latlng, 2);
		map.addControl(new GSmallMapControl());
		geocoder = new GClientGeocoder();
			GDownloadUrl('xml/routes.jsp'+url, function(data) {
	          var xml = GXml.parse(data);
	          var markers = xml.documentElement.getElementsByTagName("marker");
	          for (var i = 0; i < markers.length; i++) {
	        	var latlng = new GLatLng(parseFloat(markers[i].getAttribute("lat")),
                          		parseFloat(markers[i].getAttribute("lng")));
	        	var encodedPoint = markers[i].getAttribute("pt");
	        	var encodedLevel = markers[i].getAttribute("lvl");
	            var imageURL = markers[i].getAttribute("img");
	            var marker = createMarker(latlng,imageURL);
				var polyline = createPolyline(encodedPoint,encodedLevel)
	          }//for
	        });//GDownload
	    }
	}

function createPolyline(point,level) {
	var polyline = new GPolyline.fromEncoded({
		color: "#FFFF00",
		weight: 10,
		points: point,
		levels: level,
		zoomFactor: 32,
		numLevels: 4
		});
	map.addOverlay(polyline);
	return polyline;
}

function createMarker(point,img) {
    var marker = new GMarker(point);
    marker.openInfoWindowHtml('<img src="uploads/images/' + img + '" width="250px"/>'); 
    map.addOverlay(marker);
    return marker;
  }

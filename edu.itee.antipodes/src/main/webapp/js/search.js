var map = null;
var geocoder = null;
var marker;
var tabAccuracy = new Array(2,4,6,10,12,13,16,16,17,18);


function initialize() {
    if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map_canvas"));
        map.addControl(new GLargeMapControl());
        map.setCenter(new GLatLng(23.324, 65.039), 2);

        geocoder = new GClientGeocoder();
		GDownloadUrl("xml/data.xml", function(data) {
          var xml = GXml.parse(data);
          var markers = xml.documentElement.getElementsByTagName("marker");
          for (var i = 0; i < markers.length; i++) {
            var latlng = new GLatLng(parseFloat(markers[i].getAttribute("lat")),
                                    parseFloat(markers[i].getAttribute("lng")));
			//var latlng2 = new GLatLng(parseFloat(markers[i+1].getAttribute("lat")),
              //                      parseFloat(markers[i+1].getAttribute("lng")));
			var marker = createMarker(latlng,latlng)
			//var marker = createPolyline(latlng,latlng2,latlng)
            //map.addOverlay(new GMarker(latlng));
          }//for
        });//GDownload
        GEvent.addListener(map, "click", clicked);
    }
}

function createMarker(point,text) {
        var marker = new GMarker(point);
		map.addOverlay(marker);
        return marker;
      }

function clicked(overlay, latlng) {
    if (latlng) {
        geocoder.getLocations(latlng, function(addresses) {
            if(addresses.Status.code != 200) {
                alert("reverse geocoder failed to find an address for " + latlng.toUrlValue());
            }
            else {
                //map.clearOverlays();
                address = addresses.Placemark[0];
                marker = new GMarker(latlng, {draggable: true});
                //map.addOverlay(marker);

                point2address();

                GEvent.addListener(marker, "dragstart", function() {
                    map.closeInfoWindow();
                });

                GEvent.addListener(marker, "dragend", point2address);
            }
        })
    }
}

function point2address(flag) {
    point = marker.getPoint();
    geocoder.getLocations(point, function(addresses) {
        if(addresses.Status.code != 200) {
            alert("reverse geocoder failed to find an address for " + point.toUrlValue());
        }
        else {
            address = addresses.Placemark[0];
			loc = address.address;
			country = address.AddressDetails.Country.CountryName;
			city = address.AddressDetails.Country.AdministrativeArea.AdministrativeAreaName;
            var myHtml = '<b>Reversed Geocoded Address:</b>&nbsp;'+address.address + '<br/>' +  
                   '<b>Accuracy:</b>&nbsp;' + address.AddressDetails.Accuracy;
            //display location name to text field
            if (document.forms['search'].locationName.value == ""){
            	document.forms['search'].locationName.value = city;}
            else{
            	document.forms['search'].locationName.value += ", " + city;
            }
            if (flag == 'plus original address') {
                myHtml = '<b>Original Address:</b>&nbsp;'+document.frm.address.value + '<br/>' +
                         '<b>Coordinates:</b>&nbsp;' + point.toUrlValue() + '<br/><br/>' + 
                         myHtml;
            }
            marker.openInfoWindow( myHtml);
        }
        //map.setZoom( tabAccuracy[address.AddressDetails.Accuracy] );
    });
}

function addCoordsToMap(response) {
    map.clearOverlays();
    if (!response || response.Status.code != 200) {
        alert('Address not found');
    } 
    else {
        place = response.Placemark[0];
        point = new GLatLng(place.Point.coordinates[1],
                            place.Point.coordinates[0]);
        marker = new GMarker(point, {draggable: true});
        map.addOverlay(marker);

        point2address("plus original address");
        
        GEvent.addListener(marker, "dragstart", function() {
            map.closeInfoWindow();
        });

        GEvent.addListener(marker, "dragend", point2address);
    }
}

function showAddress(address) {
    if (geocoder) {
        geocoder.getLocations(address,addCoordsToMap)
    }
}
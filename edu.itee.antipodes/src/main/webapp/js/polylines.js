 if (GBrowserIsCompatible()) { 

      // A function to create the marker and set up the event window
      // Dont try to unroll this function. It has to be here for the function closure
      // Each instance of the function preserves the contends of a different instance
      // of the "marker" and "html" variables which will be needed later when the event triggers.    
      function createMarker(point,text) {
        var marker = new GMarker(point);
        GEvent.addListener(marker, "click", function() {
          marker.openInfoWindow(document.createTextNode(text));
          document.forms['test'].locations.value = point ;
        });
		map.addOverlay(marker);
        return marker;
      }
      
      function createPolyline(point1,point2) {
          var marker = new GPolyline([point1,point2],"#FF0000",10);
          GEvent.addListener(marker, "click", function() {
  		   //marker.openInfoWindow(document.createTextNode(text));									 
  		  document.forms['test'].locations.value = point1;
  		  //geocoder.getLocations(point1, showAddress);
          });
  		map.addOverlay(marker);
          return marker;
        }
      
      function showAddress(response) {
          if (!response || response.Status.code != 200) {
            alert("Status Code:" + response.Status.code);
          } else {
            place = response.Placemark[0];
            var loc = place.address;
    		var locs = place.AddressDetails.Country.AdministrativeArea.SubAdministrativeArea.Locality.LocalityName;
    		document.forms['test'].locations.value = locs;
          
          }
        }

      // Display the map, with some controls and set the initial location 
      var map = new GMap2(document.getElementById("map_canvas"));
      map.setMapType(G_SATELLITE_MAP);
      map.setCenter(new GLatLng(-45.028202, 168.654728), 15);
      map.addControl(new GLargeMapControl());
    
      // Set up three markers with info windows 
    
      GDownloadUrl("xml/data2.xml", function(data) {
          var xml = GXml.parse(data);
          var markers = xml.documentElement.getElementsByTagName("marker");
          for (var i = 0; i < markers.length; i++) {
            var latlng = new GLatLng(parseFloat(markers[i].getAttribute("lat")),
                                    parseFloat(markers[i].getAttribute("lng")));
            var latlng2 = new GLatLng(parseFloat(markers[i+1].getAttribute("lat")),
    								parseFloat(markers[i+1].getAttribute("lng")));
			//var marker = createMarker(latlng,latlng)
			var marker = createPolyline(latlng,latlng2)
            //map.addOverlay(new GMarker(latlng));
          }//for
        });//GDownload
 }
    
    // display a warning if the browser was not compatible
    else {
      alert("Sorry, the Google Maps API is not compatible with this browser");
    }
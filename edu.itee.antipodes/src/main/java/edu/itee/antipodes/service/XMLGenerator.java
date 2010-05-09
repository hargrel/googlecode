package edu.itee.antipodes.service;

import java.io.*;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import edu.itee.antipodes.domain.db.Location;
import edu.itee.antipodes.repository.DaoManager;
import edu.itee.antipodes.repository.LocationDao;
 
public class XMLGenerator {
	public void main(String[] args) throws Exception {
		
		LocationDao ld = DaoManager.getLocationDao();
		List<Location> ll = ld.getLocationList();
		
		//Create XML DOM document
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
		Element rootElement = document.createElement("markers");
        document.appendChild(rootElement);
		for (Location location : ll){
			Element em = document.createElement("marker");
			em.setAttributeNS(null, "loc", location.getLocationName());
			em.setAttributeNS(null, "lat", Double.toString(location.getLatitude()));
			em.setAttributeNS(null, "lng", Double.toString(location.getLongitude()));
			rootElement.appendChild(em);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource source = new DOMSource(document);
        File file = new File("src/main/webapp/xml/search.xml");
        StreamResult result =  new StreamResult(file);
        transformer.transform(source, result);
	}
}
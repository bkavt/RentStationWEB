package by.htp.salon.logics;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.salon.domain.Equipment;
import by.htp.salon.domain.utils.Bike;
import by.htp.salon.domain.utils.Rollers;
import by.htp.salon.domain.utils.Skates;
import by.htp.salon.domain.utils.Units;

import static by.htp.salon.util.ConstantValue.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParserRead {

	public static void readEqList() throws ParserConfigurationException, Exception, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBild = factory.newDocumentBuilder();
		Document doc = docBild.parse(new File(FILE_RENT_EQUIP_LIST));
		
		Element eqip=(Element) doc.getElementsByTagName(RENT_STATION).item(0);
		greatEquip(eqip);
		
	}

	public static void greatUnit(Units unit, Element el) {
		unit.setTitle(el.getElementsByTagName(TITLE).item(0).getChildNodes().item(0).getNodeValue());
		unit.setCost(Double.parseDouble(el.getElementsByTagName(COST).item(0).getChildNodes().item(0).getNodeValue()));
		unit.setWeight(
				Double.parseDouble(el.getElementsByTagName(WEIGHT).item(0).getChildNodes().item(0).getNodeValue()));
		unit.setId(Integer.parseInt(el.getAttribute(ID)));
	}
	public static void greatEquip(Element eqip){
		NodeList list = eqip.getElementsByTagName(UNITS);
		List<Equipment> eqList = new ArrayList();
		for (int i = 0; i < list.getLength(); i++) {
			Equipment eq;
			Element el = (Element) list.item(i);
			Element elBike = (Element) el.getElementsByTagName(BIKE).item(0);
			if (elBike != null) {
				Bike bike = new Bike();
				greatUnit(bike, elBike);
				System.out.println(bike);
				eqList.add(bike);
			}
			Element elSkate = (Element) el.getElementsByTagName(SKATE).item(0);
			if (elSkate != null) {
				Skates sk = new Skates();
				greatUnit(sk, elSkate);
				System.out.println(sk);
				eqList.add(sk);
			}
			Element elRol = (Element) el.getElementsByTagName(ROLLERS).item(0);
			if (elRol != null) {
				Rollers rol = new Rollers();
				greatUnit(rol, elRol);
				System.out.println(rol);
				eqList.add(rol);
			}
		}
		System.out.println(eqList);
	}
		
}


package by.htp.salon.logics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;

import org.w3c.dom.Element;

import by.htp.salon.domain.Client;
import by.htp.salon.domain.Equipment;
import by.htp.salon.domain.Manager;
import by.htp.salon.domain.Order;
import by.htp.salon.domain.accessory.Accessory;
import by.htp.salon.domain.accessory.Helmet;
import by.htp.salon.domain.utils.Bike;
import by.htp.salon.domain.utils.Rollers;
import by.htp.salon.domain.utils.Skates;
import by.htp.salon.domain.utils.Units;

public class DomParser {
	private static final String RENT_STATION = "rent-station";
	private static final String CLIENTS = "clients";
	private static final String CLIENT = "client";
	private static final String NAME = "name";
	private static final String SONAME = "soname";
	private static final String DOCUMENT = "documetn";
	private static final String ID = "id";
	private static final String EQUIPMENTS = "equipments";
	private static final String UNITS = "units";
	private static final String BIKE = "bike";
	private static final String SKATE = "skate";
	private static final String ROLLERS = "rollers";
	private static final String TITLE = "title";
	private static final String COST = "cost";
	private static final String WEIGHT = "weight";
	private static final String SIZE = "size";
	private static final String ACCESSORY = "accessory";
	private static final String HELMET = "helmet";
	private static final String ELBOW_PADS = "elbow_pads";
	private static final String KNEE_PADS = "knee_pads";
	private static final String ORDER = "order";
	private static final String ORDERS = "orders";
	private static final String FILE_CLIENT_LIST = "salon_rentail_clients.xml";
	private static final String FILE_FREE_EQUIP_LIST = "salon_rentail_free_equip.xml";
	private static final String FILE_RENT_EQUIP_LIST = "salon_rentail_rent_equip.xml";
	private static final String FILE_ORDER_LIST = "salon_order_equip.xml";

	public static Document greatDoc() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document document = docBuilder.newDocument();

		return document;
	}

	public static void writeFile(Document doc, String str) {
		TransformerFactory factoryTr = TransformerFactory.newInstance();
		try {
			Transformer tranformer = factoryTr.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult srteamFile = new StreamResult(new File(str));
			tranformer.transform(domSource, srteamFile);

		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public static void importClientList(List<Client> clientList) throws ParserConfigurationException {

		Document document = greatDoc();

		Element rentStation = document.createElement(RENT_STATION);
		document.appendChild(rentStation);

		Element clients = document.createElement(CLIENTS);
		rentStation.appendChild(clients);

		for (Client cl : clientList) {

			importClient(document, clients, cl);

		}
		writeFile(document, FILE_CLIENT_LIST);

	}

	public static void importClient(Document document, Element clients, Client cl) {
		Element client = document.createElement(CLIENT);
		clients.appendChild(client);

		Element name = document.createElement(NAME);
		name.appendChild(document.createTextNode(cl.getName()));

		Element soname = document.createElement(SONAME);
		soname.appendChild(document.createTextNode(cl.getSoname()));

		Element doc = document.createElement(DOCUMENT);
		doc.appendChild(document.createTextNode(cl.getDocument()));

		client.appendChild(name);
		client.appendChild(soname);
		client.appendChild(doc);

		Attr idClient = document.createAttribute(ID);
		idClient.setValue(String.valueOf(cl.getId()));
		client.setAttributeNode(idClient);

	}

	public static void importFreeEquipList(Equipment[] eqlist) throws ParserConfigurationException {
		importEquipList(eqlist, FILE_FREE_EQUIP_LIST);
	}

	public static void importRentEquipList(Equipment[] eqlist) throws ParserConfigurationException {
		importEquipList(eqlist, FILE_RENT_EQUIP_LIST);
	}

	public static void importEquipList(Equipment[] eqlist, String file) throws ParserConfigurationException {

		Document document = greatDoc();
		Element rentStation = document.createElement(RENT_STATION);
		document.appendChild(rentStation);

		for (Equipment eq : eqlist) {
			importEquip(document, rentStation, eq);

		}
		writeFile(document, file);

	}

	public static void importEquip(Document document, Element el, Equipment eq) {
		if (eq != null) {
			Element equipments = document.createElement(EQUIPMENTS);
			el.appendChild(equipments);

			if ("by.htp.salon.domain.utils.Bike".equals(eq.getClass().getName())) {
				equipments.appendChild(importBike(document, (Bike) eq));
			}

			if ("by.htp.salon.domain.utils.Skates".equals(eq.getClass().getName())) {
				equipments.appendChild(importSkates(document, (Skates) eq));
			}

			if ("by.htp.salon.domain.utils.Rollers".equals(eq.getClass().getName())) {
				equipments.appendChild(importRollers(document, (Rollers) eq));
			}
			if ("by.htp.salon.domain.accessory.Helmet".equals(eq.getClass().getName())) {
				equipments.appendChild(importHelmet(document, (Accessory) eq));
			}
			if ("by.htp.salon.domain.accessory.KneePads".equals(eq.getClass().getName())) {
				equipments.appendChild(importKneePads(document, (Accessory) eq));
			}
			if ("by.htp.salon.domain.accessory.ElbowPads".equals(eq.getClass().getName())) {
				equipments.appendChild(importElbowPads(document, (Accessory) eq));
			}

		}
	}

	public static void importAccessory(Document document, Element el, Accessory eq) {

		Element title = document.createElement(TITLE);
		el.appendChild(title);
		title.appendChild(document.createTextNode(eq.getTitle()));

		Element cost = document.createElement(COST);
		el.appendChild(cost);
		cost.appendChild(document.createTextNode(String.valueOf(eq.getCost())));

		Element size = document.createElement(SIZE);
		el.appendChild(size);
		size.appendChild(document.createTextNode(String.valueOf(eq.getSize())));

	}

	public static Element importHelmet(Document document, Accessory eq) {
		Element unit = document.createElement(ACCESSORY);

		Element helmet = document.createElement(HELMET);
		unit.appendChild(helmet);

		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		helmet.setAttributeNode(idEq);

		importAccessory(document, helmet, eq);

		return unit;
	}

	public static Element importElbowPads(Document document, Accessory eq) {
		Element unit = document.createElement(ACCESSORY);

		Element elbowPads = document.createElement(ELBOW_PADS);
		unit.appendChild(elbowPads);

		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		elbowPads.setAttributeNode(idEq);

		importAccessory(document, elbowPads, eq);

		return unit;
	}

	public static Element importKneePads(Document document, Accessory eq) {
		Element unit = document.createElement(ACCESSORY);

		Element KneePads = document.createElement(KNEE_PADS);
		unit.appendChild(KneePads);

		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		KneePads.setAttributeNode(idEq);

		importAccessory(document, KneePads, eq);

		return unit;
	}

	public static void importUnit(Document document, Element el, Units eq) {

		Element title = document.createElement(TITLE);
		el.appendChild(title);
		title.appendChild(document.createTextNode(eq.getTitle()));

		Element cost = document.createElement(COST);
		el.appendChild(cost);
		cost.appendChild(document.createTextNode(String.valueOf(eq.getCost())));

		Element weight = document.createElement(WEIGHT);
		el.appendChild(weight);
		weight.appendChild(document.createTextNode(String.valueOf(eq.getWeight())));

	}

	public static Element importBike(Document document, Bike eq) {
		Element unit = document.createElement(UNITS);

		Element bike = document.createElement(BIKE);
		unit.appendChild(bike);

		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		bike.setAttributeNode(idEq);

		importUnit(document, bike, eq);

		return unit;
	}

	public static Element importSkates(Document document, Skates eq) {
		Element unit = document.createElement(UNITS);
		Element skates = document.createElement(SKATE);
		unit.appendChild(skates);
		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		skates.setAttributeNode(idEq);

		importUnit(document, skates, eq);

		Element size = document.createElement(SIZE);
		skates.appendChild(size);
		size.appendChild(document.createTextNode(String.valueOf(eq.getSize())));

		return unit;
	}

	public static Element importRollers(Document document, Rollers eq) {
		Element unit = document.createElement(UNITS);
		Element rollers = document.createElement(ROLLERS);
		unit.appendChild(rollers);
		Attr idEq = document.createAttribute(ID);
		idEq.setValue(String.valueOf(eq.getId()));
		rollers.setAttributeNode(idEq);

		importUnit(document, rollers, eq);

		Element size = document.createElement(SIZE);
		rollers.appendChild(size);
		size.appendChild(document.createTextNode(String.valueOf(eq.getSize())));

		return unit;
	}

	public static void importOrderList(Order[] list) throws ParserConfigurationException {
		Document document = greatDoc();
		Element rentStation = document.createElement(RENT_STATION);
		document.appendChild(rentStation);

		Element orders = document.createElement(ORDERS);
		rentStation.appendChild(orders);
		int i=0;
		for (Order ord : list) {
			if (ord != null) {
				Element order = document.createElement(ORDER);
				orders.appendChild(order);
				importClient(document, order, ord.getClient());
				importEquip(document, order, ord.getEquip());
				
				Attr idOrd = document.createAttribute(ID);
				idOrd.setValue(String.valueOf(i++));
				order.setAttributeNode(idOrd);
			}
		}
		writeFile(document, FILE_ORDER_LIST);
	}

}

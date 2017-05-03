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
import by.htp.salon.domain.utils.Bike;
import by.htp.salon.domain.utils.Skates;
import by.htp.salon.domain.utils.Units;

public class DomParser {
	static Document document;	

	
public static void importData(Manager man) throws ParserConfigurationException	{	
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder=factory.newDocumentBuilder();
		document= docBuilder.newDocument();
		
		Element rentStation = document.createElement("rent-station");
		document.appendChild(rentStation);
		Element clients = document.createElement("clients");
		rentStation.appendChild(clients);
			
			
					List<Client> clientList=new ArrayList(man.getClientList());
					
					for(Client cl:clientList){
						Element client = document.createElement("client");
						clients.appendChild(client);
							Element name = document.createElement("name");
								name.appendChild(document.createTextNode(cl.getName()));
							Element soname = document.createElement("soname");
								soname.appendChild(document.createTextNode(cl.getSoname()));
							Element doc = document.createElement("document");
								doc.appendChild(document.createTextNode(cl.getDocument()));
							client.appendChild(name);
							client.appendChild(soname);
							client.appendChild(doc);
								
								Attr idClient=document.createAttribute("id");
								idClient.setValue(String.valueOf(cl.getId()));
								client.setAttributeNode(idClient);
						
					}
					
					int i=0;
					for (Equipment eq: man.getRentEquip().getEquip()){
					 if(eq!=null){
						
						Element equipments = document.createElement("equipments");
						rentStation.appendChild(equipments);
						
							if ("by.htp.salon.domain.utils.Bike".equals(eq.getClass().getName())){
							equipments.appendChild(importBike((Bike) eq));
							}
						
							if ("by.htp.salon.domain.utils.Skates".equals(eq.getClass().getName())){
								equipments.appendChild(importSkates((Skates) eq));
								}
						
						
				/*		Element title = document.createElement("title");
							equipments.appendChild(title);
							String str=eq.getTitle();
								title.appendChild(document.createTextNode(str));
							Attr idEq=document.createAttribute("id");
							idEq.setValue(String.valueOf(++i));
							equipments.setAttributeNode(idEq);
							System.out.println(str);
							Element accessory = document.createElement("accessory");
							equipments.appendChild(accessory);/**/
					 	}
							
					}
						
			
					
					
			
			TransformerFactory factoryTr= TransformerFactory.newInstance();
			try {
				Transformer tranformer=factoryTr.newTransformer();
				DOMSource domSource = new DOMSource(document);
				StreamResult srteamFile= new StreamResult(new File("salon_rentail.xml"));
				tranformer.transform(domSource, srteamFile);
							
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
									
						
	}
	public static Element importBike(Bike eq){
		Element unit=document.createElement("unit");
			Element bike=document.createElement("bike");
			unit.appendChild(bike);
			Attr idEq=document.createAttribute("id");
			idEq.setValue(String.valueOf(eq.getId()));
			bike.setAttributeNode(idEq);
				Element title=document.createElement("title");
				bike.appendChild(title);
				title.appendChild(document.createTextNode(eq.getTitle()));
				
				Element cost=document.createElement("cost");
				bike.appendChild(cost);
				cost.appendChild(document.createTextNode(String.valueOf(eq.getCost())));
				
				Element weight=document.createElement("weight");
				bike.appendChild(weight);
				weight.appendChild(document.createTextNode(String.valueOf(eq.getWeight())));
				
		
		return unit;
	}		
	
	public static Element importSkates(Skates eq){
		Element unit=document.createElement("unit");
			Element skates=document.createElement("skates");
			unit.appendChild(skates);
			Attr idEq=document.createAttribute("id");
			idEq.setValue(String.valueOf(eq.getId()));
			skates.setAttributeNode(idEq);
				Element title=document.createElement("title");
				skates.appendChild(title);
				title.appendChild(document.createTextNode(eq.getTitle()));
				
				Element cost=document.createElement("cost");
				skates.appendChild(cost);
				cost.appendChild(document.createTextNode(String.valueOf(eq.getCost())));
				Units buf=(Units) eq;
				Element weight=document.createElement("weight");
				skates.appendChild(weight);
				weight.appendChild(document.createTextNode(String.valueOf(eq.getWeight())));
				
				
				Element size=document.createElement("size");
				skates.appendChild(weight);
				size.appendChild(document.createTextNode(String.valueOf(eq.getSize())));
		
		
		return unit;
	}				
				
						
}

package by.htp.salon.launch;

import by.htp.salon.domain.Equipment;
import by.htp.salon.domain.Manager;
import by.htp.salon.domain.OrderList;
import by.htp.salon.domain.RentStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import by.htp.salon.domain.Client;
import by.htp.salon.domain.accessory.ElbowPads;
import by.htp.salon.domain.accessory.Helmet;
import by.htp.salon.domain.accessory.KneePads;
import by.htp.salon.domain.utils.Bike;
import by.htp.salon.domain.utils.Rollers;
import by.htp.salon.domain.utils.Skates;
import by.htp.salon.logics.DomParser;
import by.htp.salon.logics.MyIO;


public class Main {
	
	public static void main(String[] args) throws ParserConfigurationException {
		RentStation station=new RentStation();
		Manager manager=new Manager();
		
		
		
		
		
		Equipment eq1=new Bike();
		eq1.setTitle("Bike");
		Equipment eq2=new Rollers();
		eq2.setTitle("Rollers");
		Equipment eq3=new Skates();
		eq3.setTitle("Skates");
		Equipment eq4=new Rollers();
		eq4.setTitle("Rollers");
		Equipment eq5=new Skates();
		eq5.setTitle("Skates");
		Equipment eq6=new Bike();
		eq6.setTitle("Bike");

		Equipment ac1=new Helmet();
		ac1.setTitle("Helmet");
		Equipment ac2=new KneePads();
		ac2.setTitle("KneePads");
		Equipment ac3=new KneePads();
		ac3.setTitle("KneePads");
		Equipment ac4=new Helmet();
		ac4.setTitle("Helmet");
		Equipment ac5=new ElbowPads();
		ac5.setTitle("ElbowPads");
		Equipment ac6=new ElbowPads();
		ac6.setTitle("ElbowPads");
		
		Client p1 = new Client("Vasya","Ivanov","Pasport");
		Client p2 = new Client("Pert","Sidorov","Pasport");
		
		
		
		station.newEquip(eq1);
		station.newEquip(eq2);
		station.newEquip(eq3);
		station.newEquip(eq4);
		station.newEquip(eq5);
		station.newEquip(eq6);
		station.newEquip(ac1);
		station.newEquip(ac2);
		station.newEquip(ac3);
		station.newEquip(ac4);
		station.newEquip(ac5);
		station.newEquip(ac6);
		
		station.showList();
		System.out.println("All-----------");
		
		Equipment[] list=new Equipment[1];
		list=station.getList();
		manager.setList(list);
		manager.showFreeEquip();
		System.out.println("FreeEquip---------");
		manager.showRentEquip();
		System.out.println("Rent-------------");
		
		
		manager.newOrder(manager.findByTitle("Skates"), p1);
		manager.newOrder(manager.findByTitle("Bike"), p1);
		manager.newOrder(manager.findByTitle("Helmet"), p1);
		manager.newOrder(manager.findByTitle("Rollers"), p1);
		
		
		manager.showClientUnit(p1);
		System.out.println("P1-------------");
		
		manager.newOrder(manager.findByTitle("Bike"), p2);
		manager.showClientUnit(p2);				
		System.out.println("P2-----------");
		
		manager.showFreeEquip();
		System.out.println("Free---------");

		manager.showRentEquip();
		System.out.println("Rent---------");
		
		DomParser.importData(manager);
		
		
		
		DomParser.importClient(manager.getClientList());
		System.out.println(manager.getClientList()); 
		
		
		
		
	}

}

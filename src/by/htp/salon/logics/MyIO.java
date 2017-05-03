package by.htp.salon.logics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import by.htp.salon.domain.Equipment;
import by.htp.salon.domain.accessory.Accessory;
import by.htp.salon.domain.accessory.ElbowPads;
import by.htp.salon.domain.accessory.Helmet;
import by.htp.salon.domain.accessory.KneePads;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public  class MyIO {
	private  RentUnit myRentList=new RentUnit();
	private  Date dateNow = new Date();
	private  SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy_MM_dd");
	private String nameFile;
	
	private String getDate(){
		
		nameFile="d://kurs//rent_unit_"+formatForDateNow.format(dateNow)+".txt";
		//System.out.println(nameFile);
		return formatForDateNow.format(dateNow)+".txt";
	}
	
	
	
	public  void WriteList(RentUnit list) {
		myRentList=list;
		int size=myRentList.getSizeList();
		
	    nameFile="d://Kurs//rent_unit.txt";  //_"+getDate();
	    File file=new File(nameFile);
		
		    try(FileWriter myFile=new FileWriter(file,false)){
				for (int i=0;i<size;i++){
					
					
					myFile.write(myRentList.getByIndex(i).toString()+"\r\n");
					
				}	
		    }
			catch(IOException ex){
	            
	            System.out.println(ex.getMessage());
	        } 
	}
	
	
	
	public void ReadEquip(/*String nameFile*/){
		File file=new File("d://kurs//rent_unit.txt"); //(nameFile);_2017_04_14
		
		try(FileReader fr=new FileReader(file)){
			BufferedReader buf=new BufferedReader(fr);
			String str;
			
			while ((str=buf.readLine())!=null){
									//System.out.println(str);
									createFromFile(str);
			}
	    }
		catch(IOException ex){
            
            System.out.println(ex.getMessage());
        } 
	}


	public Equipment createFromFile(String str){
		String[] buf=str.split("=");
		
		Equipment eqip=null;
		switch(buf[0]){
			case "ElbowPads":{
				Equipment acc=new ElbowPads(buf[2],Double.parseDouble(buf[3]),Double.parseDouble(buf[1]));
				acc.setId(Integer.parseInt(buf[4])); 
				eqip=acc;
				break;
				
			}
			case "Helmet":{
				Equipment acc1=new Helmet(buf[2],Double.parseDouble(buf[3]),Double.parseDouble(buf[1]));
				acc1.setId(Integer.parseInt(buf[4])); 
				eqip=acc1;
				break;
				
			}
			case "KneePads":{
				Equipment acc2=new KneePads(buf[2],Double.parseDouble(buf[3]),Double.parseDouble(buf[1]));
				acc2.setId(Integer.parseInt(buf[4])); 
				eqip=acc2;
				break;
				
			}
			
		
		
		
		}
		System.out.println(eqip);
		
		
		
		return eqip;
	}
		
		
		
		
	














}


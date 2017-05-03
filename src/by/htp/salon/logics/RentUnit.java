package by.htp.salon.logics;


import java.util.Arrays;

import by.htp.salon.domain.Equipment;
import by.htp.salon.domain.Order;
import by.htp.salon.domain.utils.Units;

public final class RentUnit {
	private Equipment[] equip;
	private int index=0;
	private int size=10;
	
	{
		equip=new Equipment[size];
	}
	public void add(Equipment equip){
		this.equip[index]=equip;
		index++;
		if (index >= size) {
			size++;
			Equipment[] equipCopy = new Equipment[size];
			for (int i = 0; i < this.equip.length; i++) {
				equipCopy[i] = this.equip[i];
			}
			this.equip = equipCopy;
		}
	}
	
	public Equipment[] getEquip() {
		return equip;
	}

	public void setEquip(Equipment[] equip) {
		this.equip = equip;
	}

	public int find(Equipment equip){
		int index=-1;
		for (int i=0; i<this.equip.length; i++){
			if (equip.equals(this.equip[i])){
				index=i;
				break;
			}
		}
		return index;
		
	}
	 public void delByIndex(int index){
	 	this.equip[index]=null;
	 	for(int i=index; i<this.equip.length-1;i++){
	 		this.equip[i]=this.equip[i+1];
	 	}
	 }public void showAll(){
		 for(int i=0; i<equip.length-1;i++){
		 		if (equip[i]!=null){
		 			System.out.println(equip[i]);}
		 	}
	 }
	 public void reset(){
		 size=10;
		 index=0;
		 equip=new Equipment[size];
	}
	
	 public Equipment getByIndex(int i){
		 return equip[i];
	 }
	  public int getSizeList(){
		  int size=0;
		  for(int i=0; i<equip.length-1;i++){
		 		if (equip[i]!=null){
		 			size++;}
		 	}
		  return size;
	  }

	  



	@Override
	public String toString() {
		return "RentStation [equip=" + Arrays.toString(equip) + "]";
	}
		
	
	
	
	
	
}

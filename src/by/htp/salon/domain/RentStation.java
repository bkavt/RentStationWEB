package by.htp.salon.domain;

import java.util.Arrays;

import by.htp.salon.logics.RentUnit;

public class RentStation {
	private RentUnit equip=new RentUnit();
	
	
	public Equipment[] getList() {
		 return equip.getEquip();
	}
	
	
	public void newEquip(Equipment equip){
		this.equip.add(equip);
		/*this.equip[index]=equip;
		index++;
		if (index >= size) {
			size++;
			Equipment[] equipCopy = new Equipment[size];
			for (int i = 0; i < this.equip.length; i++) {
				equipCopy[i] = this.equip[i];
			}
			this.equip = equipCopy;
		}*/
	}

	public void showList() {
		 equip.showAll();
	}
	
	
	
	
}

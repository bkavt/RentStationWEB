package by.htp.salon.service;

import java.util.ArrayList;
import java.util.List;

import by.htp.salon.entity.Equip;

public class EquipServiceImpl implements EquipServise{

	@Override
	public List<Equip> list() {
		List<Equip> equipment = new ArrayList<Equip>();
		equipment.add(new Equip("eq1",1));
		equipment.add(new Equip("eq2",2));
		equipment.add(new Equip("eq3",13));
		return equipment;
	}


}

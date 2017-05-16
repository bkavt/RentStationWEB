package by.htp.salon.service;

import java.util.ArrayList;
import java.util.List;

import by.htp.salon.dao.EquipDao;
import by.htp.salon.dao.EquipDaoImpl;
import by.htp.salon.entity.Equip;

public class EquipServiceImpl implements EquipServise{
	private EquipDao dao;	

public EquipServiceImpl() {
		dao=new EquipDaoImpl();
	}

	@Override
	public List<Equip> list() {
		/*List<Equip> equipment = new ArrayList<Equip>();
		equipment.add(new Equip("eq1",1));
		equipment.add(new Equip("eq2",2));
		equipment.add(new Equip("eq3",13));*/
		return dao.getFreeEquipList();
	}

	@Override
	public boolean changeEquipStatus(Long equipId, int status) {
		dao.changeEquipStatus(equipId, status);
		return false;
	}

	@Override
	public List<Equip> rentList() {
		return dao.getRentEquipList() ;
	}


}

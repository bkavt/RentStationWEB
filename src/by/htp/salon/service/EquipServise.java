package by.htp.salon.service;

import java.util.List;

import by.htp.salon.entity.Equip;

public interface EquipServise {
	List<Equip> list();
	boolean changeEquipStatus(Long equipId, int status);
	List<Equip> rentList();
}

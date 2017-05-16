package by.htp.salon.dao;

import java.util.List;

import by.htp.salon.entity.Equip;
import by.htp.salon.entity.Order;

public interface EquipDao {
	List<Equip> getFreeEquipList();
	List<Equip> getRentEquipList();
	boolean changeEquipStatus(Long equipId, int status);
}

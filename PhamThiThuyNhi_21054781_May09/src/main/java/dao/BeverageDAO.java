package dao;

import java.rmi.Remote;
import java.util.List;

import entity.Item;

public interface BeverageDAO extends Remote{
//	 listItems (supplierName: String) : List<Item>
	public List<Item> listItems(String supplierName) throws Exception;

}

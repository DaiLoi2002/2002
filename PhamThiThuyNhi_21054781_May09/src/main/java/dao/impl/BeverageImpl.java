package dao.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.BeverageDAO;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class BeverageImpl  extends UnicastRemoteObject implements BeverageDAO{
	private EntityManager em;

	public BeverageImpl() throws Exception {
		em = Persistence.createEntityManagerFactory("data").createEntityManager();
	}
	@Override
	public List<Item> listItems(String supplierName) {
		String jpql = "SELECT i FROM Item i WHERE i.beverage.supplierName = :supplierName";
		return em.createQuery(jpql, Item.class).setParameter("supplierName", supplierName).getResultList();
	}

}

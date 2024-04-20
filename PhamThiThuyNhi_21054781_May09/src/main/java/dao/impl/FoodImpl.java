package dao.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.stream.Collectors;

import dao.FoodDAO;
import entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FoodImpl extends UnicastRemoteObject implements FoodDAO{
	private EntityManager em;

	public FoodImpl() throws Exception {
		em = Persistence.createEntityManagerFactory("data").createEntityManager();
	}
	
	@Override
	public boolean addFood(Food food) {
		try {
			em.getTransaction().begin();
			em.persist(food);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

//	Tính  giá  gốc  của từng món  ăn sau khi  chế biết  thành phẩm.  Kết quả sắp xếp  giảm 
//	dần theo đơn giá gốc.
	@Override
	public Map<Food, Double> listFoodAndCost() {
		String query = "SELECT f FROM Food f ORDER BY f.cost DESC";
//		try {
//			return em.createQuery(query, Food.class).getResultList().stream()
//					.collect(Collectors.toMap(f -> f, f -> f.getCost()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
			
	}
	
}

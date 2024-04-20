package dao;

import java.rmi.Remote;
import java.util.Map;

import entity.Food;

public interface FoodDAO extends Remote{

	public boolean addFood(Food food) throws Exception;
//	+ public listFoodAndCost(): Map<Food, Double
	public Map<Food, Double> listFoodAndCost() throws Exception;

	
}

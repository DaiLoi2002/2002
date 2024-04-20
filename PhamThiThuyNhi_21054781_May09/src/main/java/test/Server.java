package test;

import java.rmi.registry.LocateRegistry;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.BeverageDAO;
import dao.FoodDAO;
import dao.impl.BeverageImpl;
import dao.impl.FoodImpl;
import entity.Food;
import entity.Item;
import entity.Type;

public class Server {
	private static final String URL = "rmi:/H92M09/4781/";
	private static Type APPETIZER;

	public static void main(String[] args) throws Exception {

		FoodDAO foodDAO = new FoodImpl();
		foodDAO.addFood(new Food("F", 10, 20, APPETIZER));

	
		System.out.println("Food added");

		BeverageDAO beverageDAO = new BeverageImpl();
		List<Item> items = beverageDAO.listItems("Anna Food Distributors");
		for (Item item : items) {
			System.out.println(item);
		}
		
		System.out.println("Server is running...");

		try {
			Context context = new InitialContext();
			LocateRegistry.createRegistry(4781);
			context.bind(URL + "food", foodDAO);
			context.bind(URL + "beverage", beverageDAO);
			System.out.println("Server is running...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

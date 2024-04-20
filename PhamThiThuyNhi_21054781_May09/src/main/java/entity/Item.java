package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item implements Serializable {
	@Id
//	@Column(name = "item_id")
	private String id;
	private String name;
	private double price;
	private String description;
	@Column(name = "on_special")
	private boolean onSpecial;
	
    @OneToOne
    @JoinColumn(name = "id")
    private Food food;
    
    @OneToOne
    @JoinColumn(name = "id")
    private Beverage beverage;

	@ManyToMany
	@JoinTable(name = "items_ingredients", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private Set<Ingredient> ingredients;

	public Item() {
	}

	public Item(String id, String name, double price, String description, boolean onSpecial) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
	}

	
	
	public Item(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnSpecial() {
		return onSpecial;
	}

	public void setOnSpecial(boolean onSpecial) {
		this.onSpecial = onSpecial;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", onSpecial=" + onSpecial + "]";
	}

}

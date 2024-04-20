package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "beverages")

public class Beverage extends Item implements Serializable {
	private Size size;
	@Column(name = "supplier_name")
	private String supplierName;

    @OneToOne(mappedBy = "beverage")
    private Item item;
    

	
	
	public Beverage() {
	}

	public Beverage(String id, String name, double price, String description, boolean onSpecial, Size size,
			String supplierName) {
		super(id, name, price, description, onSpecial);
		this.size = size;
		this.supplierName = supplierName;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Beverage [size=" + size + ", supplierName=" + supplierName + "]";
	}

}

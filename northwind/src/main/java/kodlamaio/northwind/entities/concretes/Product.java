package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	// Anotasyon: calisma aninda bilgi toplama
	// Anatosyonlarin sirasi onem arz edebilir

	@Id // tablonun id sini böyle verilrir
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Id 1 1 artirialacak
	@Column(name = "product_id") // column namelrei verilir
	private int id;
//asagida iliskilendirme (joincolumn) yaptigimiz icin commente aldık
//	@Column(name = "category_id")
//	private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	/*
	 * @AllArgsConstructor @NoArgsConstructor eklediğim icin commete aldık 
	 * public Product() { }
	 * 
	 * public Product(int id, int categoryId, String productName, double unitPrice,
	 * short unitsInStock, String quantityPerUnit) { this.id = id; this.categoryId =
	 * categoryId; this.productName = productName; this.unitPrice = unitPrice;
	 * this.unitsInStock = unitsInStock; this.quantityPerUnit = quantityPerUnit; }
	 */
	
	//iliskilendirme islemi category tablosu ile
	@ManyToOne()//once olduumuz yer=Many
	@JoinColumn(name="category_id")
	private Category category;
	
	
}

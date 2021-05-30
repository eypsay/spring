package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);// onemli olan getBy ile baslamak.tablodaki columna bakar Prodcut bulup
													// get islemi yapar

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	// select * from products where prodctname= abc
	// and categoryId= 123
	// where category in(1,2,3)

	List<Product> getByCategoryIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	// JPQL sorgulari objeler üzerinden yapma
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") // bu kısımda veritabını unut
	// bunlar benim Entitimden
	// alırım.
	List<Product> getByNameAndCategory(String productName, int categoryId);
//select * from products where prodcutname=aasd and categoryId=123
	
	//rodcutWithCategoryDto(p.prodcutId, p.prodcutNmae,c.categoryName)->burası entityden yazılır table dan degil
	//@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName,c.categoryName) From Cateogry c Inner join c.products p")
	  @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
	  		+ "(p.id, p.productName, c.categoryName) "
			 //(p.id, p.productName,c.categoryName)
	  		+ "From Category c Inner Join c.products p")
	         //From Cateogry c Inner join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// once base tablo yazılır(category)one->many(product)
	//select * from Category c inner join Product p
	//on c.category_id=p.category_id
}

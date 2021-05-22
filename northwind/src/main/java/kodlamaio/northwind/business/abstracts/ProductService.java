package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
//List<Product> getAll(); bnu yerine result lı olan yapıları yazdık
	DataResult<List<Product>> getAll();

	Result add(Product product);

}

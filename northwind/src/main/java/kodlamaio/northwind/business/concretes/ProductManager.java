package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccesDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service // bu class service gorevi gorecek demek
public class ProductManager implements ProductService {
	private ProductDao productDao;

	// Autowired: bean =procetc classı demek, spring arka planda spring verdigimiz
	// yapyıa gore(productDao) bir instance olsuturur ve bize verir
	// olustacagin her injcetion icin Auptwired eklersin
	@Autowired
	public ProductManager(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {

		// return this.productDao.findAll();
		// gerekn sarta gore errordataresult dondurebilecegimden dolayı donus tiipi
		// DataResult
		return new SuccesDataResult<List<Product>>(this.productDao.findAll(), "Data Lsitelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi!");
	}

}

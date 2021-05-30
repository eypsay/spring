package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccesDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

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

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccesDataResult<Product>(this.productDao.getByProductName(productName),
				"Data Lsitelendi(getByProdcutName)");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {

		// business codelar buraya ekelencek
		return new SuccesDataResult<Product>(
				this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId),
				"Data Lsitelendi(getByProductNameAndCategoryId)");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccesDataResult<List<Product>>(
				this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),
				"Data Lsitelendi(getByProductNameOrCategoryId)");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccesDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),
				"Data Lsitelendi(getByCategoryIdIn)");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccesDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),
				"Data Lsitelendi(getByProductNameContains)");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccesDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),
				"Data Lsitelendi(getByProductNameStartsWith)");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccesDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),
				"Data Lsitelendi(getByNameAndCategory)");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccesDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");

		return new SuccesDataResult<List<Product>>(this.productDao.findAll(sort), "Sıralama Basarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProdcutWithCategoryDetails() {
		
		return new SuccesDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "DTO Data Lsitelendi");
	}

}

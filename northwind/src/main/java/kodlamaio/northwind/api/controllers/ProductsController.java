package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccesDataResult;
import kodlamaio.northwind.entities.concretes.Product;

//controller:android,web ,Ios Angular gibi ortamların bizim
//backhandimizle kunosabilisei
//dıs dunyayla sistemimizn iletisim kurabilsmesni saglar

@RestController // java olmayanalarada beni tanısın
//birden fazla controller olabilir urun yonetimi,sepet islemleri vb contollre icin
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getall")

	// public List<Product> getAll() {
	// return this.productService.getAll();
	// asagidaki kodla refactor ettik
	public DataResult<List<Product>> getAll() {
		 return this.productService.getAll();
		
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		//return new Result(true, "Ürün Eklendi");
		return this.productService.add(product);

	}
}

//kodlama.io/api/products boyle bir ,stek gelirse burası karislayavak
//istekler 2 tür 1- bna veri ver  2- veriyi degistir

//swagger birco ortamda test edeilidigimz oratam
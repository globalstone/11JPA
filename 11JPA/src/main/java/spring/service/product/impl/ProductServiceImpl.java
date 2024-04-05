package spring.service.product.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.entity.Product;
import spring.service.product.ProductRepository;
import spring.service.product.ProductService;

@Service("productService")
@Transactional()
public class ProductServiceImpl implements ProductService{
	
	///Field
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) throws Exception {
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Long prodNo) throws Exception {
		
		Optional<Product> result = productRepository.findById(prodNo);
		
		if( result.isPresent() ) {
			return result.get();
		}

		return null;
	}

	@Override
	public Product updateProduct(Product product) throws Exception {
		//=> 없으면 insert OR 있으면 update
		return productRepository.save(product);
	}

	@Override
	public void removeProduct(Long prodNo) throws Exception {
		productRepository.deleteById(prodNo);
	}

	@Override
	public List<Product> getProductList() throws Exception {
		return productRepository.findAll();
	}
	
}	
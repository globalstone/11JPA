package spring.service.product;

import java.util.List;
import java.util.Map;

import spring.entity.Product;

public interface ProductService {
	
		//==> 상품정보 ::  INSERT ( 상품가입 )
		public Product addProduct(Product product) throws Exception;
		
		//==> 상품정보 ::  SELECT  ( 상품정보 검색 ) 
		public Product getProduct(Long prodNo) throws Exception;

		//==> 상품정보 ::  UPDATE  ( 상품정보 변경  )
		public Product updateProduct(Product product) throws Exception;
		
		//==> 상품정보 ::  DELETE  ( 상품정보 삭제 )
		public void removeProduct(Long prodNo) throws Exception;
		
		//==> 상품정보 ::  SELECT  ( 상품 정보 검색 )
		//public List<Product> getProductList(Search search) throws Exception;
		public List<Product> getProductList() throws Exception;

}	
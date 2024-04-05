package spring.service.product;

import java.util.List;
import java.util.Map;

import spring.entity.Product;

public interface ProductService {
	
		//==> ��ǰ���� ::  INSERT ( ��ǰ���� )
		public Product addProduct(Product product) throws Exception;
		
		//==> ��ǰ���� ::  SELECT  ( ��ǰ���� �˻� ) 
		public Product getProduct(Long prodNo) throws Exception;

		//==> ��ǰ���� ::  UPDATE  ( ��ǰ���� ����  )
		public Product updateProduct(Product product) throws Exception;
		
		//==> ��ǰ���� ::  DELETE  ( ��ǰ���� ���� )
		public void removeProduct(Long prodNo) throws Exception;
		
		//==> ��ǰ���� ::  SELECT  ( ��ǰ ���� �˻� )
		//public List<Product> getProductList(Search search) throws Exception;
		public List<Product> getProductList() throws Exception;

}	
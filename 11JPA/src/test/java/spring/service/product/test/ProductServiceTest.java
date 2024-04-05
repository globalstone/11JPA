package spring.service.product.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import spring.entity.Product;
import spring.service.product.ProductRepository;
import spring.service.product.ProductService;

/*
 *	FileName :  ProductServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 5�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */

//======================  ����� �κ� ====================
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
@SpringBootTest
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �� ������ ����ü��  Meta-data �� �̿� Wiring
	//==> �� �� ��ü�� Injection ��
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	//@Test
	public void testAddProduct() throws Exception {
		System.out.println("\n===================================");
		
//		Product product = new Product();
//		product.setProdName("1234");
//		product.setProdDetail("���� : 1234");
//		product.setPrice(1234L);
//		product.setImageFile("1234.jpg");
		
		Product product = Product.builder()
								.prodName("1234")
								.prodDetail("���� : 1234")
								.price(1234L)
								.imageFile("1234.jpg").build();

		System.out.println( productService.addProduct(product) );
		
		System.out.println("===================================\n");
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		System.out.println("\n===================================");
		
		//==> �ּ� ó���ϸ� �ǹ� Ȯ��
		
		//System.out.println( productService.getProduct(10001L) );
		
		System.out.println( productService.getProduct(11001L) );
		
		System.out.println("===================================\n");
	}
	
	//@Test
	 public void testUpdateProduct() throws Exception{
		System.out.println("\n===================================");
		
		Product product = productRepository.findById(10001L).get();
		
		//==> �ּ�ó�� �� , �� Ȯ�� : save() �ǹ� ���� => ������ insert OR ������ update
		product.setProdDetail("���� : 1111 ����");
		
		System.out.println( productService.updateProduct(product) );
		
		System.out.println("===================================\n");
	 }
	 
	 //@Test
	 public void removeProduct() throws Exception{
		System.out.println("\n===================================");
		
		System.out.println(productRepository.count());
		
		//==> �ι� ���� : 1��°, 2��° �ǹ� Ȯ��.
		//==> 2��° : �����Ұ� ������ Exception
		productService.removeProduct(10021L);
		
		System.out.println(productRepository.count());
		
		System.out.println("===================================\n");
	 }
	
	//@Test
	 public void testGetUserList() throws Exception{
		System.out.println("\n===================================");
		
		System.out.println(productRepository.count());
		
		List<Product> list = productService.getProductList();
		
		System.out.println( list );
		System.out.println( list.size() );
		
		System.out.println("===================================\n");
	 }

}	
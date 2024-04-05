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
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 5를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */

//======================  변경된 부분 ====================
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
@SpringBootTest
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 로 지정된 구현체가  Meta-data 를 이용 Wiring
	//==> 한 각 객체를 Injection 함
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
//		product.setProdDetail("설명 : 1234");
//		product.setPrice(1234L);
//		product.setImageFile("1234.jpg");
		
		Product product = Product.builder()
								.prodName("1234")
								.prodDetail("설명 : 1234")
								.price(1234L)
								.imageFile("1234.jpg").build();

		System.out.println( productService.addProduct(product) );
		
		System.out.println("===================================\n");
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		System.out.println("\n===================================");
		
		//==> 주석 처리하며 의미 확인
		
		//System.out.println( productService.getProduct(10001L) );
		
		System.out.println( productService.getProduct(11001L) );
		
		System.out.println("===================================\n");
	}
	
	//@Test
	 public void testUpdateProduct() throws Exception{
		System.out.println("\n===================================");
		
		Product product = productRepository.findById(10001L).get();
		
		//==> 주석처리 전 , 후 확인 : save() 의미 이해 => 없으면 insert OR 있으면 update
		product.setProdDetail("설명 : 1111 변경");
		
		System.out.println( productService.updateProduct(product) );
		
		System.out.println("===================================\n");
	 }
	 
	 //@Test
	 public void removeProduct() throws Exception{
		System.out.println("\n===================================");
		
		System.out.println(productRepository.count());
		
		//==> 두번 실행 : 1번째, 2번째 의미 확인.
		//==> 2번째 : 삭제할게 없으면 Exception
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
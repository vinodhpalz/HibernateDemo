package model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	
	
	private static AnnotationConfigApplicationContext context;
	private static IPoductDAO pd;
	private Product product;
	

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("model");
		context.refresh();
		pd = (IPoductDAO)context.getBean("productDAO");
	}
	
	
	@Test
	public void testInsertProduct() {
		product = new Product();
		product.setPname("Angular");
		product.setPcost(6000);
		assertEquals("Successfully inserted a single product from the table", true,pd.insertProduct(product));
	}
	
	@Test
	public void testUpdateProduct() {
		product = pd.getProduct(72);
		product.setPname("Dog");
		assertEquals("Successfully fetched a single product from the table", true,pd.updateProduct(product));
	}
	@Test
	public void testdeleteProduct() {
		product = pd.getProduct(85);
		assertEquals("Successfully deleted a single product from the table", true,pd.deleteProduct(product));
	}
	@Test
	public void testGetProduct() {
		IPoductDAO pd = new ProductDAO();
		product = pd.getProduct(35);
		
		assertEquals("Successfully fetched a single product from the table", "Bottle",product.getPname());
	}
}

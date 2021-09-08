package oos.test;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import oos.model.ProductList;
import oos.model.Product;

public class ProductListTest
{
	private ProductList productList;

	public ProductListTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        productList= new ProductList();
    }

    @After
    public void tearDown() {
    }

   /**
     * Test case for add, getAll, getCount methods of class ProductList.
     */
    @Test
    public void testAddGetAllGetCount() {
		Product product1 = new Product();
		product1.setProdNum("Prod1");
		product1.setProdName("Mouse123");
		product1.setProdUnitPrice(12);
		product1.setProdManufacturer("ABC Maouse");
		product1.setProdDateOfManufacturing("12/02/2003");
		testInvariant();
		productList.add(product1);
		testInvariant();
	
		List<Product> products = productList.getAll();
    assertTrue("product1 missing", products.contains(product1));

    assertTrue("There is no product 1", product1.getProdNum() == "Prod1");
    assertFalse("There is product 2", product1.getProdNum() == "Prod2");

    assertTrue("There is no product 1 name Mouse123", product1.getProdName() == "Mouse123");
    assertFalse("There is product 1 name Mouse8910", product1.getProdName() == "Mouse8910");

    assertTrue("There is no product 1 price of $12", product1.getProdUnitPrice() == 12);
    assertFalse("There is product 1 price of $9", product1.getProdUnitPrice() ==  9);

    assertTrue("There is no product manufaturer ABC Maouse", product1.getProdManufacturer() == "ABC Maouse");
    assertFalse("There is product manufaturer XYZ Maouse", product1.getProdManufacturer() == "XYZ Maouse");

    assertTrue("There is no product manufacturing date 12/02/2003", product1.getProdDateOfManufacturing() == "12/02/2003");
    assertFalse("There is product manufacturing date 31/12/2023", product1.getProdDateOfManufacturing() == "31/12/2023");
    
		assertTrue("count error", productList.getCount() == 1);
		assertFalse("count error", productList.getCount() > 1);
    }

    /**
     * Test of invariant method, of class ProductList.
     */
    @Test
    public void testInvariant() {
		assertTrue("productList is null",productList.invariant());
    }

}

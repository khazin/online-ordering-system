package oos.test;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import oos.model.CustomerList;
import oos.model.Customer;

public class CustomerListTest
{
	private CustomerList customerList;

	public CustomerListTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        customerList= new CustomerList();
    }

    @After
    public void tearDown() {
    }

   /**
     * Test case for add, getAll, getCount methods of class CustomerList.
     */
    @Test
    public void testAddGetAllGetCount() {
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		customer1.setCustNum("Cust1");
		customer1.setCustName("John");
		customer1.setCustAddress("123 Ave");
		customer1.setCustContact("98765432");
		customer1.setCustIC("S18649073G");
		testInvariant();
		customerList.add(customer1);
    testInvariant();
    
		List<Customer> customers = customerList.getAll();
    assertTrue("customer1 missing", customers.contains(customer1));
    
		assertTrue("No customer 1 found", customer1.getCustNum() == "Cust1");
    assertFalse("There is customer 2", customer1.getCustNum() == "Cust2");
    
    assertTrue("No customer name John found", customer1.getCustName() == "John");
    assertFalse("There is customer name Paul", customer1.getCustName() == "Paul");
    
    assertTrue("No address 123 Ave found", customer1.getCustAddress() == "123 Ave");
    assertFalse("There is address of 8910 St", customer1.getCustAddress() == "8910 St");
    
    assertTrue("No contact no 98765432 found", customer1.getCustContact() == "98765432");
    assertFalse("There is contact no 12345678", customer1.getCustContact() == "12345678");
    
    assertTrue("No IC of S18649073G found", customer1.getCustIC() == "S18649073G");
    assertFalse("There is IC of G8963922F", customer1.getCustIC() == "G8963922F");
    
		assertTrue("count error", customerList.getCount() == 1);
		assertFalse("count error", customerList.getCount() > 1);
    }

    /**
     * Test of invariant method, of class CustomerList.
     */
    @Test
    public void testInvariant() {
		assertTrue("customerList is null",customerList.invariant());
    }

}

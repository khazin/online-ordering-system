package oos.test;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import oos.model.OrderList;
import oos.model.Order;

public class OrderListTest
{
	private OrderList orderList;

	public OrderListTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        orderList= new OrderList();
    }

    @After
    public void tearDown() {
    }

   /**
     * Test case for add, getAll, getCount methods of class OrderList.
     */
    @Test
    public void testAddGetAllGetCount() {
		Order order1 = new Order();
		order1.setOrdNum("Ord1");
		order1.setCustNum("Cust1");
		order1.setOrdDate("Jan/2018");
		testInvariant();
		orderList.add(order1);
		testInvariant();

		List<Order> orders = orderList.getAll();
    assertTrue("order1 missing", orders.contains(order1));
    
		assertFalse("customer 2 found", order1.getCustNum() == "Cust2");
    assertTrue("No customer 1 found", order1.getCustNum() == "Cust1");
    
		assertFalse("There is order date on Jan/2019", order1.getOrdDate() == "Jan/2019");
    assertTrue("No order date on Jan/2018", order1.getOrdDate() == "Jan/2018");

    assertFalse("order 2 found", order1.getOrdNum() == "Ord2");
    assertTrue("No order 1 found", order1.getOrdNum() == "Ord1");

		assertFalse("count error", orderList.getCount() > 1);
		assertTrue("count error", orderList.getCount() == 1);
    }

    /**
     * Test of invariant method, of class OrderList.
     */
    @Test
    public void testInvariant() {
		assertTrue("orderList is null",orderList.invariant());
    }

}

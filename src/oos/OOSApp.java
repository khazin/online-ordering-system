package oos;
import oos.view.*;
import oos.model.*;
import oos.controller.*;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

/**
 * Online Ordering System (OOS)
 * <p>
 * The main class to run
 *
 * @version 1.0
 * @since   2020-06-14
 */
public class OOSApp extends JFrame
{

    public OOSApp ()
    {
		//title of frame
		super("Online Ordering System (OOS))");
		
		//instantiate product list(model), controller & view
		ProductList productList;
		ProductController productController;
		View productView;

		CustomerList customerList;
		CustomerController customerController;
		View customerView;

		OrderList orderList;
		OrderController orderController;
    	View orderView;

		//set font
		this.setFont(View.generalFont);

		//initialise product model, view & controller
    	productList = new ProductList();
    	productController = new ProductController();
    	productController.setModel(productList);
    	productView = new ProductView(productList, productController);

		//initialise customer model, view & controller
      	customerList = new CustomerList();
      	customerController = new CustomerController();
      	customerController.setModel(customerList);
    	customerView = new CustomerView(customerList, customerController);

		//initialise order model, view & controller
      	orderList = new OrderList();
      	orderController = new OrderController();
      	orderController.setModel(orderList);
    	orderView = new OrderView(orderList, orderController);

		// create tab pane 
  		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(View.generalFont);

		//  tab pane for product, customer and order
		tabbedPane.addTab("Product Management", productView);
  	    tabbedPane.addTab("Customer Management", customerView);
  	    tabbedPane.addTab("Order Management", orderView);

  	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    getContentPane().add(tabbedPane);
  	    pack();
  	    setVisible(true);
    }

    /**
	* The main program for the Online Ordering System (OOS)
	*
	* @param args
	*	command line arguments
	* @post. Online Ordering System (OOS)is launched
	*/
    public static void main (String[] args)
    {
    	   new OOSApp();
    }
}

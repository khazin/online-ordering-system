package oos.view;

import oos.view.View;
import oos.model.Customer;
import oos.model.CustomerList;
import oos.controller.CustomerController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class CustomerDisplayView  extends View {
	private JPanel contents;
    private final static int SIZE=20;
    private JLabel custNumLabel = new JLabel("Customer Number");
    private JLabel custNameLabel = new JLabel("Customer Name");
    private JLabel custICLabel = new JLabel("Customer IC");
    private JLabel custAddressLabel = new JLabel("Address");
    private JLabel custContactLabel = new JLabel("Contact");
    private JLabel countLabel = new JLabel("Count");
    private JTextField countTextField = new JTextField(SIZE);

	/**
	 * 
	 * @param model customer model
	 * @param controller customer controller
	 * @pre. true
	 * @post. display customer is set
	 */
    public CustomerDisplayView(CustomerList model, CustomerController controller)
    {
        super (model, controller);
        setLayout(new BorderLayout());
        displayContents();
        add(countLabel, BorderLayout.WEST);
        add(countTextField, BorderLayout.EAST);
        displayCount();
	}

	public void displayContents()
	{
		CustomerList model = (CustomerList)getModel();
		contents = new JPanel();

		// set layout and add labels
		contents.setLayout(new GridLayout(0,5));
		contents.add(custNumLabel);
		contents.add(custNameLabel);
		contents.add(custICLabel);
		contents.add(custAddressLabel);
		contents.add(custContactLabel);
		JTextField textField;

		for (Customer c:  model.getAll())
		{

			//show customer number
			textField = new JTextField(SIZE);
			textField.setText(c.getCustNum());
			contents.add(textField);

			//show customer name
			textField = new JTextField(SIZE);
			textField.setText(c.getCustName());
			contents.add(textField);

			//show customer IC
			textField = new JTextField(SIZE);
			textField.setText(""+c.getCustIC());
			contents.add(textField);

			//show customer address
			textField = new JTextField(SIZE);
			textField.setText(c.getCustAddress());
			contents.add(textField);

			//show customer contact
			textField = new JTextField(SIZE);
			textField.setText(c.getCustContact());
			contents.add(textField);
       	}
       	add(contents, BorderLayout.NORTH);
    }

	// show number of customers
    public void displayCount()
    {
		countTextField.setText(""+getModel().getCount());
	}

	public void update(String messageId)
  	{
		remove(contents);
		displayContents();
		displayCount();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.pack();
        topFrame.repaint();
    }
}

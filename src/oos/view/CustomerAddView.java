package oos.view;

import oos.view.View;
import oos.model.Customer;
import oos.model.CustomerList;
import oos.controller.CustomerController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerAddView extends View {
	private final static int SIZE = 20;
	
	//input fields
	private JTextField custNumField = new JTextField("", SIZE);
	private JTextField custNameField = new JTextField("", SIZE);
	private JTextField custICField = new JTextField("", SIZE);
	private JTextField custAddressField = new JTextField("", SIZE);
	private JTextField custContactField = new JTextField("", SIZE);

	//labels
	private JLabel custNumLabel = new JLabel("Customer Number");
	private JLabel custNameLabel = new JLabel("Customer Name");
	private JLabel custICLabel = new JLabel("Customer IC");
	private JLabel custAddressLabel = new JLabel("Address");
	private JLabel custContactLabel = new JLabel("Contact");

	//buttons
	private JButton addButton = new JButton("Add Customer");
	private JButton resetButton = new JButton("Reset Customer");

	/**
	 * 
	 * @param model      customer model
	 * @param controller customer controller 
	 * @pre. true 
	 * @post. add view for customer is set
	 */
	public CustomerAddView(CustomerList model, CustomerController controller) {
		super(model, controller);

		// set layout and add labels and fields
		setLayout(new GridLayout(0, 2));
		add(custNumLabel);
		add(custNumField);
		add(custNameLabel);
		add(custNameField);
		add(custICLabel);
		add(custICField);
		add(custAddressLabel);
		add(custAddressField);
		add(custContactLabel);
		add(custContactField);
		add(addButton);
		add(resetButton);

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set textfields to empty
				custNumField.setText("");
				custNameField.setText("");
				custICField.setText("");
				custAddressField.setText("");
				custContactField.setText("");
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//saving data from input field
				String custNum = custNumField.getText();
				String custName = custNameField.getText();
				String custIC = custICField.getText();
				String custAddress = custAddressField.getText();
				String custContact = custContactField.getText();

				if (custNum.isEmpty() || custName.isEmpty() || custIC.isEmpty() || custAddress.isEmpty() || custContact.isEmpty()) {
					
					// validate input field
					if (custNum.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer number");
					}
					if (custName.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer name");
					}
					if (custIC.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer IC");
					}
					if (custAddress.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer address");
					}
					if (custContact.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer contact number");
					}
				} else {
					// set customer
					Customer c = new Customer();
					c.setCustNum(custNum);
					c.setCustName(custName);
					c.setCustIC(custIC);
					c.setCustAddress(custAddress);
					c.setCustContact(custContact);
					CustomerController controller = (CustomerController) getController();
					controller.addCustomer(c);
					JOptionPane.showMessageDialog(null, "Customer successfully added");
					
				}

					// set textfield to empty
					custNumField.setText("");
					custNameField.setText("");
					custICField.setText("");
					custAddressField.setText("");
					custContactField.setText("");
			}
		});
	}
}

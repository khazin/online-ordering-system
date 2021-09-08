package oos.view;

import oos.view.View;
import oos.model.Order;
import oos.model.OrderList;
import oos.controller.OrderController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class OrderAddView extends View {
	private final static int SIZE = 20;
	private String[] dateStrings = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec"};
	private String[] yearStrings = {"2018","2019","2020"};

	//input field
	private JTextField ordNumField = new JTextField("", SIZE);
	private JTextField custNumField = new JTextField("", SIZE);
	private JComboBox<String> ordMonthComboBox = new JComboBox<String>(dateStrings);
	private JComboBox<String> ordYearComboBox = new JComboBox<String>(yearStrings);

	//labels
	private JLabel ordNumLabel = new JLabel("Order Number");
	private JLabel custNumLabel = new JLabel("Customer Number");
	private JLabel ordMonthLabel = new JLabel("Month Of Order");
	private JLabel ordYearLabel = new JLabel("Year Of Order");

	//buttons
	private JButton addButton = new JButton("Add Order");
	private JButton resetButton = new JButton("Reset Order");

	/**
	 * 
	 * @param model order model
	 * @param controller order controller
	 * @pre. true
	 * @post. add view for order is set
	 */
	public OrderAddView(OrderList model, OrderController controller) {
		super(model, controller);

		// set layout and add labels and fields
		setLayout(new GridLayout(0, 2));
		add(ordNumLabel);
		add(ordNumField);
		add(custNumLabel);
		add(custNumField);
		add(ordMonthLabel);
		add(ordMonthComboBox);
		add(ordYearLabel);
		add(ordYearComboBox);
		add(addButton);
		add(resetButton);

		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set textfield to empty
				ordNumField.setText("");
				custNumField.setText("");
			}
		});

		// add new order
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//saving data from input field
				String ordNum = ordNumField.getText();
				String custNum = custNumField.getText();
				String ordDate = (String) ordMonthComboBox.getSelectedItem() + "-"
						+ (String) ordYearComboBox.getSelectedItem();

				if (ordNum.isEmpty() || 
					custNum.isEmpty() ||
					ordDate.isEmpty())
				{
					//validate input field
					if (ordNum.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter order number");
					}
					if (custNum.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter customer number");
					}
					if (ordDate.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter order dates");
					}
				} else {
					//set order
					Order o = new Order();

					o.setOrdNum(ordNum);
					o.setCustNum(custNum);
					o.setOrdDate(ordDate);
					OrderController controller = (OrderController) getController();
					controller.addOrder(o);
					JOptionPane.showMessageDialog(null, "Order successful");
				}
				
					// set textfield to empty
					ordNumField.setText("");
					custNumField.setText("");
				
			}
		});
	}
}

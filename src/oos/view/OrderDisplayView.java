package oos.view;

import oos.view.View;
import oos.model.Order;
import oos.model.OrderList;
import oos.controller.OrderController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class OrderDisplayView  extends View {
	private JPanel contents;
    private final static int SIZE=20;
    private JLabel ordNumlabel = new JLabel("Order Number");
    private JLabel custNumLabel = new JLabel("Customer Number");
    private JLabel ordDateLabel = new JLabel("Date of Order");
    private JLabel countLabel = new JLabel("Count");
    private JTextField countTextField = new JTextField(SIZE);

	/**
	 * 
	 * @param model model order
	 * @param controller model controller
	 * @pre. true
	 * @post. display view for order is set
	 */
    public OrderDisplayView(OrderList model, OrderController controller)
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
		OrderList model = (OrderList)getModel();
		contents = new JPanel();
		// set layout and add labels
		contents.setLayout(new GridLayout(0,3));
		contents.add(ordNumlabel);
		contents.add(custNumLabel);
		contents.add(ordDateLabel);
		JTextField textField;

		for (Order o:  model.getAll()){

			//show order number
			textField = new JTextField(SIZE);
			textField.setText(o.getOrdNum());
			contents.add(textField);

			//show customer number
			textField = new JTextField(SIZE);
			textField.setText(o.getCustNum());
			contents.add(textField);

			//show order date
			textField = new JTextField(SIZE);
			textField.setText(o.getOrdDate());
			contents.add(textField);
       	}
       	add(contents, BorderLayout.NORTH);
	}
	
	// show number of orders
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

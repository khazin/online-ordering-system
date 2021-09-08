package oos.view;

import oos.view.View;
import oos.model.Product;
import oos.model.ProductList;
import oos.controller.ProductController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ProductDisplayView  extends View {
	private JPanel contents;
    private final static int SIZE=20;
    private JLabel numberLabel = new JLabel("Product Number");
    private JLabel nameLabel = new JLabel("Product Name");
    private JLabel unitPriceLabel = new JLabel("Unit Price");
    private JLabel manufacturerLabel = new JLabel("Manufacturer");
    private JLabel dateOfManufacturingLabel = new JLabel("Date Of Manufacturing");
    private JLabel countLabel = new JLabel("Count");
    private JTextField countTextField = new JTextField(SIZE);

	/**
	 * 
	 * @param model product model
	 * @param controller product controller
	 * @pre. true
	 * @post. display view for customer is set
	 */
    public ProductDisplayView(ProductList model, ProductController controller)
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
		ProductList model = (ProductList)getModel();
		contents = new JPanel();
		// set layout and add labels
		contents.setLayout(new GridLayout(0,5));
		contents.add(numberLabel);
		contents.add(nameLabel);
		contents.add(unitPriceLabel);
		contents.add(manufacturerLabel);
		contents.add(dateOfManufacturingLabel);
		JTextField textField;

		for (Product p:  model.getAll())
		{

			textField = new JTextField(SIZE);
			textField.setText(p.getProdNum());
			contents.add(textField);

			textField = new JTextField(SIZE);
			textField.setText(p.getProdName());
			contents.add(textField);

			textField = new JTextField(SIZE);
			textField.setText(""+p.getProdUnitPrice());
			contents.add(textField);

			textField = new JTextField(SIZE);
			textField.setText(p.getProdManufacturer());
			contents.add(textField);

			textField = new JTextField(SIZE);
			textField.setText(p.getProdDateOfManufacturing());
			contents.add(textField);
       	}
       	add(contents, BorderLayout.NORTH);
    }

	// show number of products
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

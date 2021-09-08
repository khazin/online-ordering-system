package oos.view;

import oos.view.View;
import oos.model.Product;
import oos.model.ProductList;
import oos.controller.ProductController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ProductAddView  extends View {
	private final static int SIZE=20;
	
	//input fields
    private JTextField prodNumField = new JTextField("", SIZE);
    private JTextField prodNameField = new JTextField("", SIZE);
    private JTextField prodUnitPriceField = new JTextField("", SIZE);
    private JTextField prodManufacturerField = new JTextField("", SIZE);
    private JTextField prodDateOfManufacturingField = new JTextField("", SIZE);

	//labels
    private JLabel prodNumLabel = new JLabel("Product Number");
    private JLabel prodNameLabel = new JLabel("Product Name");
    private JLabel prodUnitPriceLabel = new JLabel("Unit Price");
    private JLabel prodManufacturerLabel = new JLabel("Manufacturer");
	private JLabel prodDateOfManufacturingLabel = new JLabel("Date Of Manufacturing");
	
	//buttons
    private JButton addButton = new JButton ("Add Product");
	private JButton resetButton = new JButton ("Reset Product");
	

	/**
	 * 
	 * @param model product model
	 * @param controller product controller
	 * @pre. true
	 * @post. add view for product is set
	 * 
	 */
    public ProductAddView(ProductList model, ProductController controller)
    {
		super (model, controller);
		
		// set layout and add labels and fields
		setLayout(new GridLayout(0,2));
		add(prodNumLabel); 
		add(prodNumField);
		add(prodNameLabel); 
		add(prodNameField);
		add(prodUnitPriceLabel); 
		add(prodUnitPriceField);
		add(prodManufacturerLabel); 
		add(prodManufacturerField);
		add(prodDateOfManufacturingLabel); 
		add(prodDateOfManufacturingField);
		add(addButton); 
		add(resetButton);

        resetButton.addActionListener (
					new ActionListener ()
					{
						public void actionPerformed (ActionEvent e)
						{
							//set textfields to empty
							prodNumField.setText("");
							prodNameField.setText("");
							prodUnitPriceField.setText("");
							prodManufacturerField.setText("");
							prodDateOfManufacturingField.setText("");
						}
					}
				);
		addButton.addActionListener (
					new ActionListener ()
					{
						public void actionPerformed (ActionEvent e)
						{
							//saving data from input field
							String number = prodNumField.getText();
							String name = prodNameField.getText();
							String unitPrice = prodUnitPriceField.getText();
							String manufacturer = prodManufacturerField.getText();
							String dateOfManufacturing = prodDateOfManufacturingField.getText();

							if (number.isEmpty() || name.isEmpty() || unitPrice.isEmpty() || manufacturer.isEmpty() || dateOfManufacturing.isEmpty()) {
								// validate input field
								if (number.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter product number");
								}
								if (name.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter product name");
								}
								if (unitPrice.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter product unit price");
								}
								
								if (manufacturer.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter product manufacturer");
								}
								if (dateOfManufacturing.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Please enter product date of manufacturing");
								}
							} else {
								final String pricePattern = "[0-9][0-9]*";

								if (!Pattern.matches(pricePattern, unitPrice)) {
									JOptionPane.showMessageDialog(null, "Please enter numbers for price");
								}
								// set product data
								Product p = new Product();
								p.setProdNum(number);
								p.setProdName(name);
								p.setProdUnitPrice(Float.valueOf(unitPrice).floatValue());
								p.setProdManufacturer(manufacturer);
								p.setProdDateOfManufacturing(dateOfManufacturing);
								ProductController controller = (ProductController) getController();
								controller.addProduct(p);
								JOptionPane.showMessageDialog(null, "Product successfully added");
							}
								// set textfield to empty
								prodNumField.setText("");
								prodNameField.setText("");
								prodUnitPriceField.setText("");
								prodManufacturerField.setText("");
								prodDateOfManufacturingField.setText("");
						}
					}
				);
    }
}

package oos.view;
import oos.view.View;
import oos.view.ProductAddView;
import oos.view.ProductDisplayView;
import oos.model.ProductList;
import oos.controller.ProductController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView  extends View
{
    private JButton addButton = new JButton ("Add Panel");
    private JButton displayButton = new JButton ("Display Panel");
    private ProductAddView addView;
    private ProductDisplayView displayView;

    private JPanel cards = new JPanel(new CardLayout());
    private JPanel buttons = new JPanel();
    private static final String ADD = "ADD";
    private static final String DISPLAY = "DISPLAY";

	/**
	 * 
	 * @param model product mddel
	 * @param controller product controller
	 * @pre. true
	 * @post. product view is set
	 */
    public ProductView(ProductList model, ProductController controller)
    {
		super (model, controller);
		addView=new ProductAddView(model,controller);
		displayView=new ProductDisplayView(model,controller);

		//add button to panel
		buttons.add(addButton);
		buttons.add(displayButton);

        // Set Button Font
		addButton.setFont(View.btnFont);
		displayButton.setFont(View.btnFont);

        setLayout(new BorderLayout());
        add(buttons, BorderLayout.NORTH);
		add(new JLabel(""), BorderLayout.CENTER);
		cards.add(displayView, DISPLAY);
		cards.add(addView, ADD);
		add(cards, BorderLayout.SOUTH);

		showAddView();

        addButton.addActionListener(
					new ActionListener ()
	 				{
						public void actionPerformed (ActionEvent e)
						{
							showAddView();
						}
					}
		);

       	displayButton.addActionListener(
					new ActionListener ()
	 				{
						public void actionPerformed (ActionEvent e)
						{
							showDisplayView();
						}
					}
		);
	}

	private void showAddView()
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, ADD);
	}

	private void showDisplayView()
	{
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, DISPLAY);
	}
}

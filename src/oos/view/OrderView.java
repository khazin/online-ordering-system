package oos.view;
import oos.view.View;
import oos.view.OrderAddView;
import oos.view.OrderDisplayView;
import oos.model.OrderList;
import oos.controller.OrderController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView  extends View
{
	//main panel view
    private JButton addButton = new JButton ("Add Panel");
    private JButton displayButton = new JButton ("Display Panel");
    private OrderAddView addView;
    private OrderDisplayView displayView;

    private JPanel cards = new JPanel(new CardLayout());
    private JPanel buttons = new JPanel();
    private static final String ADD = "ADD";
    private static final String DISPLAY = "DISPLAY";

	/**
	 * 
	 * @param model orderList
	 * @param controller orderController
	 * @pre. true
	 * @post. order view is set
	 */
    public OrderView(OrderList model, OrderController controller)
    {
		super (model, controller); 
		addView=new OrderAddView(model,controller);
		displayView=new OrderDisplayView(model,controller);

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

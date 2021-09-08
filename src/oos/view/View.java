package oos.view;

import oos.model.Model;
import oos.controller.Controller;
import oos.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

/**
 * The View class acts as the base class for all views
 * The View class implements oos.util.Observer interface
 * @version 1.0
 * @since   2020-06-14
 */
public class View extends JPanel implements Observer {

    private Model model;
    private Controller controller;
    private JFrame frame;

    /**
    * This attribute is to be used as a defualt font throught the application
    *
    * @pre. True
    * @post. a font with "Courier New", bold, size is 24
    */
    public static Font generalFont = new Font("Courier New", Font.BOLD, 24);

    /**
    * This attribute is to be used as a defualt font for all "Buttons"
    * throught the application
    *
    * @pre. True
    * @post. a font with "Courier New", Italic, size is 24
    */
    public static Font btnFont = new Font("Courier New", Font.ITALIC|Font.BOLD, 24);

    /**
    * This attribute is to be used as a defualt font for all "Labels"
    * throught the application
    *
    * @pre. True
    * @post. a font with "Courier New", Italic, size is 24
    */
    public static Font lblFont = new Font("Courier New", Font.BOLD, 24);

    /**
    * This attribute is to be used as a defualt font for all "TextFields"
    * throught the application
    *
    * @pre. True
    * @post. a font with "Arial", Plain, size is 24
    */
  	public static Font fieldFont = new Font("Arial", Font.PLAIN, 24);

    /**
    * This attribute is to be used as a defualt font for all "Tables"
    * throught the application
    *
    * @pre. True
    * @post. a font with "Arial", Plain, size is 24
    */
  	public static Font tableFont = new Font("Arial", Font.PLAIN, 24);

    /**
	* defaulit constructor
	* @pre. True
	* @post. a new object with null model and controller
	*/
    public View(){}

    /**
	* @param model
	*	the model for this view
    * @param controller. the controller for this view
	* @pre. True
	* @post. the model and controller are initialized
    */
    public View(Model model, Controller controller)
    {
        this.model = model;
        model.register(this);
        this.controller = controller;
        controller.setView(this);
    }

    /**
    * @return the model of this view
	* @post. return the model of this view
	*/
    public Model getModel()
    {
        return model;
    }

    /**
    * @return the frame this view resides
	* @post. return the frame this view resides
	*/
    public JFrame getFrame()
	{
        return frame;
    }

    /**
	* @param frame
	*	The frame this view resides
	* @post. the instance variable frame is updated
	*/
	public void  setFrame(JFrame frame)
	{
        this.frame = frame;
	}

    /**
    * @return the controller of this view
	* @post. return the controller of this view
	*/
    public Controller getController()
    {
        return controller;
    }

    /**
    * This is the call back method from oos.util.Observable
    * subclas handles the event by overriding this method
    * @param messageId
    *	A message id sent from the Observable
    * 		for which the Observer understands
    * @pre. Observable executes notifyObserver() method
    *		after certain event occurs
    * @post. the event is handled
    */
    public void update(String messageId)
  	{
        // Override this method in the subclass
    }
}


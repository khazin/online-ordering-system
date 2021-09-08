package oos.model;
import java.util.ArrayList;
import java.util.List;
import oos.util.Observer;
import oos.util.Observable;

/**
 * This model implements oos.util.Observable
 * It is used as a base class for other concrete models
 *
 * @version 1.0
 * @since   2020-06-14
 */
public abstract class Model implements Observable
{
    private List<Observer> observers = new ArrayList<Observer>();
    private String messageId = null;

    /**
	* Default Constructor
	*
	* @pre. True
	* @post. a new class without any parameter being initalise
	*/
    public Model() { }

    /**
	* @param messageId
	*	Message ID to notify the registered Observers
	* @pre. True
	* @post. the instance variable messageId is updated
	*/
    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    /**
    * This method implements the register method in oos.util.Observable.
    *
    * @param observer
    *	Any object that implements the oos.util.Observer interface
    * @pre. True
    * @post. register the observer. All registered observers will be notified
    * 		when the notifyObserver method is invoked
    */
    public void register(Observer observer)
    {
        observers.add(observer);
    }

    /**
    * This method implements the unregister method in oos.util.Observable.
    *
    * @param observer
    *	A registered observer
    * @pre. True
    * @post. the observer is no longer a registered observer
    */
    public void unregister(Observer observer)
    {
        observers.remove(observer);
    }

    /**
    * This method implements the notifyObserver method in oos.util.Observable.
    *
    * @pre. True
    * @post. calling all registered observers' update method.
    */
    public void notifyObserver()
    {
        for(Observer observer: observers)
        {
            observer.update(this.messageId);
        }
    }

    /**
	* All models are expected to maintain a list of entities
	* This method is used to retrive the number of entities in the list
	*
    * @return The number of entities in the list
	* @post. Return the number of entities in the list
	*/
    public abstract int getCount();
}
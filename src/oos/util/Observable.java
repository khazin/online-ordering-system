package oos.util;
import oos.util.Observer;

/**
* Interface Observable replacing java.util.Observable

* @version 1.0
* @since   2020-06-14
*/
public interface Observable
{
    /**
    * This method is used to register observer to this Observable.
    *
    * @param observer
    *	Any object that implements the oos.util.Observer interface
    * @pre. True
    * @post. register the observer. All registered observers will be notified
    * 		when the notifyObserver method is invoked
    */
    public void register(Observer observer);

    /**
    * This method is used to unregister the observer from this Observable.
    *
    * @param observer
    *	A registered observer
    * @pre. True
    * @post. the observer is no longer a registered observer
    */
    public void unregister(Observer observer);

    /**
    * This method is used to notify all registered observers of an event
    *
    * @pre. True
    * @post. calling all registered observers' update method.
    */
    public void notifyObserver();
}

package oos.util;

/**
* Interface Observer replacing java.util.Observer
*
* @version 1.0
* @since   2020-06-14
*/
public interface Observer
{
    /**
    * This is the call back method from oos.util.Observable
    *
    * @param messageId
    *	A message id sent from the Observable
    * 		for which the Observer understands
    * @pre. Observable executes notifyObserver() method
    *		after certain event occurs
    * @post. Observer handles the event
    */
    public void update(String messageId);
}

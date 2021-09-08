package oos.model;
import java.util.List;
import java.util.ArrayList;


public class OrderList extends Model
{

    private List<Order> orders = new ArrayList<Order>();

    /**
     * 
     * @param o Order
     */
    public void add(Order o)
    {
        orders.add(o);
        notifyObserver();
    }

    /**
     * 
     * @return orders
     */
    public List<Order> getAll()
    {
        return orders;
    }

    public int getCount()
    {
		return orders.size();
	}

	public boolean invariant(){
	    return orders != null;
    }
}

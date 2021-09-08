package oos.model;
import java.util.List;
import java.util.ArrayList;


public class CustomerList extends Model
{

    private List<Customer> customers = new ArrayList<Customer>();

    /**
     * 
     * @param c Customer
     */
    public void add(Customer c)
    {
        customers.add(c);
        notifyObserver();
    }

    /**
     * 
     * @return customers
     */
    public List<Customer> getAll()
    {
        return customers;
    }

    public int getCount()
    {
		return customers.size();
	}

	public boolean invariant(){
	    return customers != null;
    }
}

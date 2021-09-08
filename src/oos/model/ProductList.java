package oos.model;
import java.util.List;
import java.util.ArrayList;


public class ProductList extends Model
{

    private List<Product> products = new ArrayList<Product>();

    /**
     * 
     * @param p Product
     */
    public void add(Product p)
    {
        products.add(p);
        notifyObserver();
    }

    /**
     * 
     * @return products
     */
    public List<Product> getAll()
    {
        return products;
    }

    public int getCount()
    {
		return products.size();
	}

	public boolean invariant(){
	    return products != null;
    }
}

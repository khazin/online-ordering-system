package oos.controller;

import oos.model.Product;
import oos.model.ProductList;

public class ProductController extends Controller
{
    public ProductController (){}

    /**
     * 
     * @param p Product
     * @pre. true
     * @post. product model is added
     */
    public void addProduct(Product p)
    {
        ProductList model = (ProductList)getModel();
        model.add(p);
    }
}

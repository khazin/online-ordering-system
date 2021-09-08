package oos.controller;

import oos.model.Customer;
import oos.model.CustomerList;

public class CustomerController extends Controller
{
    public CustomerController (){}

    /**
     * 
     * @param c Customer model
     * @pre. true
     * @post. customer model is added
     */
    public void addCustomer(Customer c)
    {
        CustomerList model = (CustomerList)getModel();
        model.add(c);
    }
    
}

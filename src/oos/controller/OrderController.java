package oos.controller;

import oos.model.Order;
import oos.model.OrderList;

public class OrderController extends Controller
{
    public OrderController (){}

    /**
     * 
     * @param o Order
     * @pre. true
     * @post. order model is added
     */
    public void addOrder(Order o)
    {
        OrderList model = (OrderList)getModel();
        model.add(o);
    }
}

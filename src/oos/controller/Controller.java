package oos.controller;

import oos.model.Model;
import oos.view.View;


public class Controller
{
    private Model model;
    private View view;

    public Controller (){}

    /**
     * 
     * @param model Model(list)
     */
    public void setModel(Model model)
    {
		this.model=model;
    }

    /**
     * 
     * @param view View
     */
    public void setView(View view)
    {
		this.view=view;
    }

    /**
     * 
     * @return model
     */
    public Model getModel()
    {
		return model;
    }

    /**
     * 
     * @return view
     */
    public View getView()
    {
		return view;
    }

}

package oos.model;
public class Customer
{
    private String custNum;
    private String custName;
    private String custIC;
    private String custAddress;
    private String custContact;

    public Customer(){}

    /**
     * 
     * @param custNum customer number
     */
    public Customer(String custNum)
    {
        this.custNum=custNum;
    }

    /**
     * 
     * @param custNum customer number
     * @pre. true
     * @post. customer number is set
     */
    public void setCustNum(String custNum)
    {
        this.custNum=custNum;
    }

    /**
     * 
     * @return custNum
     */
    public String getCustNum()
    {
        return custNum;
    }

    /**
     * 
     * @param custName customer name
     * @pre. true
     * @post. customer name is set
     */
    public void setCustName(String custName)
    {
        this.custName=custName;
    }

    /**
     * 
     * @return custName
     */
    public String getCustName()
    {
        return custName;
    }

    /**
     * 
     * @param custIC customer IC
     * @pre. true
     * @post. customer IC is set
     */
    public void setCustIC (String custIC )
    {
        this.custIC = custIC ;
    }

    /**
     * 
     * @return custIC
     */
    public String getCustIC()
    {
        return custIC ;
    }

    /**
     * 
     * @param custAddress customer address
     * @pre. true
     * @post. customer address is set
     */
    public void setCustAddress(String custAddress)
    {
        this.custAddress=custAddress;
    }

    /**
     * 
     * @return custAddress
     */
    public String getCustAddress()
    {
        return custAddress;
    }

    /**
     * 
     * @param custContact customer contact
     * @pre. true
     * @post. customer contact is set
     */
    public void setCustContact(String custContact)
    {
        this.custContact=custContact;
    }

    /**
     * 
     * @return custContact
     */
    public String getCustContact()
    {
        return custContact;
    }

    public String toString()
    {
	   String s; 		// should use StringBuffer
	   s = "Customer[";
	   s = s+"Customer Number="+custNum+", ";
	   s = s+"Customer Name="+custName+", ";
	   s = s+"Customer Contact="+custContact+", ";
	   s = s+"Customer IC ="+custIC +", ";
	   s = s+"Cstomer Address="+custAddress+"]";
       return s;
    }

}

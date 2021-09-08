package oos.model;
public class Product
{
    private String prodNum;
    private String prodName;
    private float prodUnitPrice;
    private String prodManufacturer;
    private String prodDateOfManufacturing;

    public Product(){}

    /**
     * 
     * @param prodNum product number
     * @pre. true
     * @post. product number is set
     */
    public Product(String prodNum)
    {
        this.prodNum=prodNum;
    }

    /**
     * 
     * @param prodNum product number
     * @pre. true
     * @post. product number is set
     */
    public void setProdNum(String prodNum)
    {
        this.prodNum=prodNum;
    }

    /**
     * 
     * @return prodNumber
     */
    public String getProdNum()
    {
        return prodNum;
    }

    /**
     * 
     * @param prodName product name
     * @pre. true
     * @post. product name is set
     */
    public void setProdName(String prodName)
    {
        this.prodName=prodName;
    }

    /**
     * 
     * @return prodName
     */
    public String getProdName()
    {
        return prodName;
    }

    /**
     * 
     * @param prodManufacturer product manufacturer
     * @pre. true
     * @post. product manufacturer is set
     */
    public void setProdManufacturer (String prodManufacturer )
    {
        this.prodManufacturer = prodManufacturer ;
    }

    /**
     * 
     * @return product manufacturer
     */
    public String getProdManufacturer ()
    {
        return prodManufacturer ;
    }

    /**
     * 
     * @param prodDateOfManufacturing product date of manufacturing
     * @pre. true
     * @post. product date of manufacturing is set
     */
    public void setProdDateOfManufacturing(
 				String prodDateOfManufacturing)
    {
        this.prodDateOfManufacturing=prodDateOfManufacturing;
    }

    /**
     * 
     * @return prodDateOfManufacturing
     */
    public String getProdDateOfManufacturing()
    {
        return prodDateOfManufacturing;
    }

    /**
     * 
     * @param prodUnitPrice procuct unit price
     * @pre. true
     * @post. product unit price is set
     */
    public void setProdUnitPrice(float prodUnitPrice)
    {
        this.prodUnitPrice=prodUnitPrice;
    }

    /**
     * 
     * @return prodUnitPrice
     */
    public float getProdUnitPrice()
    {
        return prodUnitPrice;
    }

    public String toString()
    {
	   String s; 		// should use StringBuffer
	   s = "Product[";
	   s = s+"Product Number="+prodNum+", ";
	   s = s+"Product Name="+prodName+", ";
	   s = s+"Product Unit Price="+prodUnitPrice+", ";
	   s = s+"Product Manufacturer ="+prodManufacturer +", ";
	   s = s+"Product Date Of Manufacturing="+prodDateOfManufacturing+"]";
       return s;
    }

}

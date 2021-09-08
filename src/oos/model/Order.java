package oos.model;

// import java.util.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.util.regex.Pattern;

public class Order {
    private String ordNum;
    private String custNum;
    private String ordDate;

    public Order() {}

    /**
     * 
     * @param ordNum Order Number
     */
    public Order(String ordNum) {
        this.ordNum = ordNum;
    }
    
    /**
     * 
     * @param ordNum Order Number
     * @pre. true
     * @post. order number is set
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    
    /**
     * 
     * @return ordNum
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 
     * @param custNum Customer Number
     * @pre. true
     * @post. customer number is set
     */
    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    /**
     * 
     * @return custNum
     */
    public String getCustNum() {
        return custNum;
    }

    /**
     * 
     * @param ordDate Order Date
     * @pre. true
     * @post. order date is set
     */
    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }

    /**
     * 
     * @return ordDate
     */
    public String getOrdDate() {
        return ordDate;
    }

    
    public String toString() {
        String s; // should use StringBuffer
        s = "Order[";
        s = s + "Order Number=" + ordNum + ", ";
        s = s + "Customer Number=" + custNum + ", ";
        s = s + "Order Date=" + ordDate + "]";
        return s;
    }
    
}

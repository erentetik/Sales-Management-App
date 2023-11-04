import java.util.Random;

import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;

public class Transaction {

    private int ID;
    public Product[] productArr=new Product[3];
    private float totalPrice;
    private float transactionFee;
    Random rd=new Random(System.currentTimeMillis());

    //non parameterized constructor
    public Transaction(){}

    //parameterized consturctor
    public Transaction(Transaction a){
        ID=a.ID;
        totalPrice=a.totalPrice;
        transactionFee=a.transactionFee;
        for(int i=0;i<3;i++){
            productArr[i]=new Product(a.productArr[i]);
        }
    }

    //getter and setter methods
    public void setID(int ID){
        this.ID=ID;
    }

    public void setProductArr(Product[] productArr){
        this.productArr=productArr;
    }

    public void setTotalPrice(float totalPrice){
        this.totalPrice=totalPrice;
    }

    public void setTransactionFee(float transactionFee ){
        this.transactionFee=transactionFee;
    }

    public int getID(){
        int temp=ID;
        return temp;
    }

    public Product[] getProductArr(){
        Product[] temp=new Product[productArr.length];
        for(int i=0;i<productArr.length;i++){
            temp[i]=new Product(productArr[i]);
        }
        return temp;
    }

    public float getTotalPrice(){
        float temp=totalPrice;
        return temp;
    }

    public float getTransactionFee(){
        float temp=transactionFee;
        return temp;
    }


    //method to calculate total price
    public float calculateTotalPrice(){
        float temp=0;
        for(int i=0;i<productArr.length;i++){
            temp+=(productArr[i].getPrice())*(productArr[i].getQuantity());
        }
        return temp;
    }

    //method to calculate transaction fee
    public float calculateTransactionFee(){
        if (totalPrice<=499){
            transactionFee=(float)(0.01)*totalPrice;
        }
        else if(totalPrice>=500&&totalPrice<=799){
            transactionFee=(float)(0.03)*totalPrice;
        }
        else if(totalPrice>=800&&totalPrice<=999){
            transactionFee=(float)(0.05)*totalPrice;
        }
        else{
            transactionFee=(float)(0.09)*totalPrice;
        }
        return transactionFee;
    }

    //toString method for Transaction class
    public String toString() {
        return "ID=" + ID +
                ", totalPrice=" + TypeConverter.FloatToString(totalPrice) +
                ", transactionFee=" + TypeConverter.FloatToString(transactionFee) +
                '}';
    }
}

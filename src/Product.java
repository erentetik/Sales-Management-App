import java.util.Random;

public class Product {

    //creating random object
    Random rd=new Random(System.currentTimeMillis());

    private int ID;
    private String ProductName;
    private float Price;
    private int Quantity;

    //parameterised constructor
    public Product(int ID, String productName, float price) {
        this.ID = ID;
        this.ProductName = productName;
        this.Price = price;
        Quantity=0;
    }

    //copy constructor
    public Product(Product Product){
        ID=Product.ID;
        ProductName=Product.ProductName;
        Price=Product.Price;
        Quantity=0;
    }

    //toString method for Product class
    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", ProductName='" + ProductName + '\'' +
                ", Price=" + TypeConverter.FloatToString(Price) +
                '}';
    }

    //getter and setter methods
    public int getID() {
        return ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public float getPrice() {
        return Price;
    }

    public int getQuantity(){
        return Quantity;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public void setProductName(String ProductName){
        this.ProductName=ProductName;
    }

    public void setPrice(float Price){
        this.Price=Price;
    }

    public void setQuantity(){
        Quantity=rd.nextInt(10)+1;
    }

}

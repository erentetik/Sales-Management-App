import java.util.Arrays;
import java.util.Random;

public class TransactionManagement {

    Random rd=new Random(System.currentTimeMillis());

    //private
    public Transaction[][] TransactionTracker;


    //getter and setter methods
    public void setTransactionTracker(Transaction[][] TransactionTracker){
        this.TransactionTracker=TransactionTracker;
    }

    public Transaction[][] getTransactionTracker(){
        return TransactionTracker;
    }

    //parameterized constructor
    public TransactionManagement(Product[] Products){
        TransactionTracker=new Transaction[100][15];
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                TransactionTracker[i][j]=new Transaction();
            }
        }
        applyTransaction(Products);

    }

    //method to apply transaction process
    public void applyTransaction(Product[] Products){
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                TransactionTracker[i][j].setID(i*15+j+1);
                TransactionTracker[i][j].setProductArr(chooseTransaction(Products));
                TransactionTracker[i][j].setTotalPrice(TransactionTracker[i][j].calculateTotalPrice());
                TransactionTracker[i][j].setTransactionFee(TransactionTracker[i][j].calculateTransactionFee());
            }
        }
    }

    //method to choose 3 products for a single transaction randomly
    public Product[] chooseTransaction(Product[] Products){
        Product[] randProducts=new Product[3];
        for(int i=0;i<3;i++){
            randProducts[i]=new Product(Products[rd.nextInt(90)]);
            randProducts[i].setQuantity();
        }
        return randProducts;

    }

    //toString method for TransactionManagement class
    public String toString() {
        return "TransactionManagement{" +
                "TransactionTracker=" + Arrays.toString(TransactionTracker) +
                '}';
    }

}

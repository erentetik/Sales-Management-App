import java.io.IOException;

//Authors:
//Eren Tetik 280201013
//Mustafa Mert İnce 310201102
//Hatice Nur Kömürcü 310201106
//Berkay Bilkay 270201067

public class SalesManagementApp {
    public static void main(String[] args) throws IOException {

        //creating product array with loading data from the csv file
        Product[] itemsProduct = FileIO.getProducts("products.csv");

        //creating shop assistant array with loading data from the csv file
        ShopAssistant[]  shopAssistantsProduct = FileIO.getShopAssistant("shopAssistants.csv");

        //creating necessary objects
        TransactionManagement transactionManagement=new TransactionManagement(itemsProduct);
        SalaryManagement salaryManagement=new SalaryManagement(shopAssistantsProduct,transactionManagement.TransactionTracker);
        Query query=new Query(transactionManagement.getTransactionTracker(),salaryManagement.shopAssistant);

        //displaying the values according to homework instructions
        query.displayValues();
    }
}
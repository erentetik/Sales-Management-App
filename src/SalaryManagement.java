import java.util.Random;

public class SalaryManagement {

    //Random object
    Random rd=new Random(System.currentTimeMillis());
    public ShopAssistant[] shopAssistant=new ShopAssistant[100];

    //parameterised consturctor
    public SalaryManagement(ShopAssistant[] shopAssistant,Transaction[][] Transactions){
        for(int i=0;i<this.shopAssistant.length;i++){
            this.shopAssistant[i]=new ShopAssistant(shopAssistant[i]);
            shopAssistant[i].setTotalSalary(1000);
        }
        calculateTotalSalary(Transactions);
    }

    //getter method
    public ShopAssistant[] geShopAssistants(){
        return shopAssistant;
    }

    //method that calculates total salary
    public void calculateTotalSalary(Transaction[][] Transactions){
        float sum=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                sum+=Transactions[i][j].getTotalPrice();
            }
            if (sum>7500){
                shopAssistant[i].setTotalSalary((float)shopAssistant[i].getWeeklySalary()*4+(float)(sum*0.03));
                shopAssistant[i].setComission((float)(sum*0.03));
            }
            else{
                shopAssistant[i].setTotalSalary((float)shopAssistant[i].getWeeklySalary()*4+(float)(sum*0.01));
                shopAssistant[i].setComission((float)(sum*0.01));
            }
        }

    }
}

public class Query{
    public Transaction[][] Transactions=new Transaction[100][15];
    public ShopAssistant[] shopAssistants=new ShopAssistant[100];
    float totalRevenue;
    float profit;

    //parameterised constructor
    public Query(Transaction[][] Transactions, ShopAssistant[] shopAssistant){
        for(int i=0;i<100;i++){
            shopAssistants[i]=new ShopAssistant(shopAssistant[i]);
            for(int j=0;j<15;j++){
                this.Transactions[i][j]=new Transaction(Transactions[i][j]);
            }
        }
    }

    //method that shows highest total price transaction
    public String highestTotPriceTran(){
        int marker1=0;
        int marker2=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                if(Transactions[i][j].getTotalPrice()>Transactions[marker1][marker2].getTotalPrice()){
                    marker1=i;
                    marker2=j;
                }
                else{
                    continue;
                }
            }
        }
        return "The highest total price transaction: " +Transactions[marker1][marker2];
    }


    //method that shows most expensive product in the lowest-price transaction
    public String mostExpInLowest(){
        int marker1=0;
        int marker2=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                if(Transactions[i][j].getTotalPrice()<Transactions[marker1][marker2].getTotalPrice()){
                    marker1=i;
                    marker2=j;
                }
                else{
                    continue;
                }
            }
        }
        int marker3=0;
        for(int i=0;i<3;i++){
            if(Transactions[marker1][marker2].productArr[i].getPrice()>Transactions[marker1][marker2].productArr[marker3].getPrice()){
                marker3=i;
            }
        }
        return "The most expensive product in the lowest-price transaction is: "+  Transactions[marker1][marker2].productArr[marker3];
    }

    //method that shows lowest transaction fee
    public String lowTranFee(){
        int marker1=0;
        int marker2=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                if(Transactions[i][j].getTransactionFee()<Transactions[marker1][marker2].getTransactionFee()){
                    marker1=i;
                    marker2=j;
                }
                else{
                    continue;
                }
            }
        }
        return "The lowest transaction fee is: "+TypeConverter.FloatToString(Transactions[marker1][marker2].getTransactionFee());
    }

    //method that shows highest-salary shop assistant
    public String highestSalShopAss(){
        int marker=0;
        for(int i=0;i<100;i++){
            if(shopAssistants[i].getTotalSalary()>shopAssistants[marker].getTotalSalary()){
                marker=i;
            }
        }
        return "The highest-salary shop assistant is: "+ shopAssistants[marker];
    }


    //method that shows total revenue that is earned from 1500 transactions
    public String totalRevenue(){
        float sum=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<15;j++){
                sum+=Transactions[i][j].getTotalPrice()+Transactions[i][j].getTransactionFee();
            }
        }
        totalRevenue=sum;
        return "The total revenue that is earned from 1500 transactions is: "+ TypeConverter.FloatToString(sum);
    }

    //method that shows total profit that is earned after paying the shop assistant salaries
    public String totalProfit(){
        float sum=0;

        for(int i=0;i<100;i++){
            sum+=shopAssistants[i].getTotalSalary();
        }
        profit=totalRevenue-sum;
        return "Total salary is: "+sum+ "\nThe total profit that is earned after paying the shop assistant salaries: "+TypeConverter.FloatToString(profit);
    }

    //method that prints the values according to homework instructions
    public void displayValues(){
        System.out.println(highestTotPriceTran());
        System.out.println(mostExpInLowest());
        System.out.println(lowTranFee());
        System.out.println(highestSalShopAss());
        System.out.println(totalRevenue());
        System.out.println(totalProfit());
    }
}
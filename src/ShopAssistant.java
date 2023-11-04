import java.util.Random;

public class ShopAssistant {

    //creating Random object
    Random rd=new Random(System.currentTimeMillis());

    private int ID;
    private String Name;
    private String Surname;
    private String phoneNumber;
    private int Seniority;
    private float weeklySalary;
    private float totalSalary;
    private float commission;

    //parameterised constructor
    public ShopAssistant(int ID, String name, String surname, String phoneNumber) {
        this.ID = ID;
        this.Name = name;
        this.Surname = surname;
        this.phoneNumber = phoneNumber;
        this.totalSalary=0;
        Seniority=chooseSeniority();
        weeklySalary=determineWeeklySalary();
    }

    //copy constructor
    public ShopAssistant(ShopAssistant shopAssistant){
        ID=shopAssistant.ID;
        Name=shopAssistant.Name;
        Surname=shopAssistant.Surname;
        phoneNumber=shopAssistant.phoneNumber;
        totalSalary=0;
        this.Seniority=shopAssistant.Seniority;
        this.weeklySalary=shopAssistant.weeklySalary;
        this.commission=shopAssistant.commission;
        this.totalSalary=shopAssistant.totalSalary;
    }

    //toString method for ShopAssistant class
    @Override
    public String toString() {
        return "ShopAssistant{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", seniorty='" + Seniority + '\'' +
                ", weekly basis salary='" + TypeConverter.FloatToString(weeklySalary) + '\'' +
                ", comission='" + TypeConverter.FloatToString(commission) + '\'' +
                ", total salary='" + TypeConverter.FloatToString(totalSalary) + '\'' +
                '}';
    }

    //getter and setter methods
    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSeniority(){
        return Seniority;
    }

    public float getWeeklySalary(){
        float temp=weeklySalary;
        return temp;
    }

    public float getTotalSalary(){
        return totalSalary;
    }

    public float getCommission(){
        return commission;
    }

    public void setID(int ID){
        this.ID=ID;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setSurname(String Surname){
        this.Surname=Surname;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setSeniority(int Seniority){
        this.Seniority=Seniority;
    }

    public void setTotalSalary(float totalSalary){
        this.totalSalary=totalSalary;
    }

    public void setComission(float commission){
        this.commission=commission;
    }

    //method to choose seniority randomly
    public int chooseSeniority(){
        Seniority=rd.nextInt(16);
        return Seniority;
    }

    //method to calculate weekly salary according to seniorty
    public float determineWeeklySalary(){
        if(Seniority<1){
            weeklySalary=1500;
        }
        else if(Seniority>=1&&Seniority<3){
            weeklySalary=2000;
        }
        else if(Seniority>=3&&Seniority<5){
            weeklySalary=2500;
        }
        else{
            weeklySalary=3000;
        }

        return weeklySalary;
    }

}

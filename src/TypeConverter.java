//this class is created for converting java's float type to Turkish float type

public class TypeConverter{

    //this method converts a float to Turkish type float string . example: 5.50 to 5,50
    public static String FloatToString(float Value){
        String temp=Float.toString(Value);
        return temp.replace(".", ",");
    }

    //this method converts a Turkish type float string to a float . example: 5,50 to 5.50
    public static float StringToFloat(String Text){
        float temp=Float.parseFloat(Text.replace(',', '.'));
        return temp;
    }
}
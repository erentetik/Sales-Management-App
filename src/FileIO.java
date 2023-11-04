import java.io.*;
import java.util.StringTokenizer;

public class FileIO {

    // Accessor methods
    private static BufferedReader readTXT(String pathToFile) throws IOException {
        return new BufferedReader(new FileReader(pathToFile));
    }

    // Method to get trash in txt file.
    private static int getTXTlineCount(BufferedReader reader) throws IOException {
        int line = 0;
        while (reader.readLine() != null) {
            line++;
        }
        reader.close();
        return (line); //We find how many lines the text file has

    }

    static Product[] getProducts(String filePath) throws IOException {
        BufferedReader reader = readTXT(filePath);
        String line = "";
        Product[] productsList = new Product[getTXTlineCount(readTXT(filePath))];
        int index = 0;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ";");
            Product product = new Product(Integer.parseInt(tokenizer.nextToken()),tokenizer.nextToken(),TypeConverter.StringToFloat(tokenizer.nextToken()));
            productsList[index] = product;
            index++;        //We process the data in the text file
        }
        reader.close();
        return productsList;
    }
    static ShopAssistant[] getShopAssistant(String filePath) throws IOException {
        BufferedReader reader = readTXT(filePath);
        String line = "";
        ShopAssistant[] shopAssistantsList = new ShopAssistant[getTXTlineCount(readTXT(filePath))];
        int index = 0;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ";");
            ShopAssistant shopAssistants = new ShopAssistant(Integer.parseInt(tokenizer.nextToken()),tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
            shopAssistantsList[index] = shopAssistants;
            index++;        //We process the data in the text file
        }
        reader.close();
        return shopAssistantsList;
    }

}



import java.io.*;
import java.util.*;

public class GeneralFunctions {
    public static void WriteInFile(String filepath , List<?> infoList){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for(Object object : infoList){
                writer.write(object.toString());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            System.out.println(filepath +" => This file is not found\n" +  e.getMessage());
        }
    }
}

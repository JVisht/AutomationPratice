package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

public static void main (String[]args) throws IOException {

    Properties prop = new Properties();
    FileInputStream ip = new FileInputStream("/Users/sanjaysinghgussain/IdeaProjects/comlearnAutomation/src/" +
            "main/java/utility/config.properties");
        prop.load(ip);
    System.out.println(prop.getProperty(""));

}



}

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main2 {

    public static void main(String[] args) throws IOException {
        //读取properties文件的例子
        InputStream inStream = Main2.class.getClassLoader().getResourceAsStream("test2");
        Properties prop = new Properties();
        prop.load(inStream);
        String url = prop.getProperty("URL");

        System.out.println(url);

        inStream.close();
    }
}

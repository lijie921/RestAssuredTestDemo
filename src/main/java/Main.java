import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //读取yaml文件的例子
        try {
            Yaml yaml = new Yaml();
            URL url = Main.class.getClassLoader().getResource("test");
            if (url != null) {
                //获取test.yaml文件中的配置数据，然后转换为obj，
                Object obj =yaml.load(new FileInputStream(url.getFile()));
//                System.out.println(obj);
                //也可以将值转换为Map
                Map map =(Map)yaml.load(new FileInputStream(url.getFile()));
                System.out.println(map.get("unit"));
                //通过map我们取值就可以了.
                System.out.println(map.get("unit.url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

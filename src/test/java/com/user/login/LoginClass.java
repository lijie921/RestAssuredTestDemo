package com.user.login;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//官方建议以上类库需要static引入

//接口返回结构是json要处理时需引用下面的包
import io.restassured.RestAssured;
import io.restassured.response.Response;

//读取配置文件要用的包
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Junit要引入的包
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

//将方法按指定顺序执行需写下面三行代码
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@Category({com.user.login.SmokeLabel.class,com.user.login.TimingLabel.class})
@FixMethodOrder(MethodSorters.JVM)//这一行必须是类名前面一行写
//登录
public class LoginClass {

    //定义token变量，默认为空；然后在登录时将服务器返回的token存起来
    public static String  token="";
    public static String vs="";

    @BeforeClass
    public  static void beforeClass()
    {
        //跳过HTTPS的安全验证
        //RestAssured.useRelaxedHTTPSValidation();

        //设置代理,方便调试
        //RestAssured.proxy("127.0.0.1",8888);

        //加载配置文件
        InputStream inStream = LoginClass.class.getClassLoader().getResourceAsStream("com/user/login/BaseConfig");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取配置文件里面的数值

        //获取待测环境地址
        RestAssured.baseURI=prop.getProperty("SITURL");
        //获取前端版本号
        vs=prop.getProperty("VERSON");


        //关闭文件
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void login()
    {
        //使用given来访问登录接口,并返回接口的整个响应体
        Response response=given().param("account","lijie").param("password","123456")
                .post("/common/login")
                .prettyPeek()
                .then()
                .body("response.token",notNullValue())    //检验返回接口中的token是否为空
                .body("response.user.name",equalTo("李杰"))
                .body("response.salons.salon_id",hasItems(1,22,23,24))
                .extract() //导出数据
                .response()//返回整个响应体内容，便于提取返回值中的数据
                ;

        token =response.path("response.token").toString();


        /* 登录成功后选择店铺<将参数放到hashmap中，再传给接口请求> */
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("brand_id",response.path("response.user.brand_id"));
        map.put("salon_id",response.path("response.salons.salon_id[1]"));
        map.put("token",token);
        given().params(map)
                .post("/common/toggle")
                .prettyPeek()
        ;

        System.out.println("=============================成功登陆店务系统=============================");
    }
}

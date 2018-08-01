package com.member.member;

import com.user.*;

import static io.restassured.RestAssured.*;

import com.user.login.LoginClass;
import org.junit.*;
import org.junit.experimental.categories.Category;

import java.util.HashMap;
import java.util.Random;

//会员
public class MemberClass {
    @Test
    public void CreateMember()
    {
        //随机生成3位数的字符串作为会员姓名
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random randomName=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<3;i++)
        {
            int num=randomName.nextInt(36);
            sb.append(str.charAt(num));
        }

        //随机生成一串数字，与13开头组成手机号码
        String strtel="1234567890";
        Random randomTel=new Random();
        StringBuffer sbtel=new StringBuffer();
        for(int j=0;j<9;j++)
        {
            int numtel= randomTel.nextInt(10);
            sbtel.append(strtel.charAt(numtel));
        }


        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("name",sb.toString());
        map.put("handset","13"+sbtel.toString());
        map.put("gender","2");
        map.put("pay_password","123456");
        map.put("is_sms_notify",1);
        map.put("is_wechat_notify",1);
        map.put("token", LoginClass.token);

        given().params(map)
                .post("/salon/member/member/create")
                .prettyPeek();
    }

    @Category(com.user.login.SmokeLabel.class)
    @Test
    public void getMemberList()
    {
        System.out.println("=============================开始进入会员模块=============================");
        given().param("token", LoginClass.token).param("_yz_version", LoginClass.vs)
                .get("http://salon-client-sit.lite.meimeifa.cn/api/salon/member/member/get")
                .prettyPeek();
        System.out.println("=============================会员列表数据查询正确=============================");
    }
}

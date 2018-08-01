package com.staff.staff;

import com.user.login.LoginClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;


//员工
public class StaffClass
{
    @Category(com.user.login.SmokeLabel.class)
    @Test
    public void getAllStaff()
    {
        //专门弄一个错误的接口校验查看失败的测试报告
        System.out.println("=============================显示当前店铺下所有的员工数据=============================");
        given().param("token",LoginClass.token).param("_yz_version",LoginClass.vs)
                .get("http://salon-client-sit.lite.meimeifa.cn/api/salon/base/staff/getList")
                .prettyPeek();
    }
}

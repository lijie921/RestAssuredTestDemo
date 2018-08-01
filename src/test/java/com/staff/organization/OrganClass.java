package com.staff.organization;

import com.user.login.LoginClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;

//店铺组织结构
public class OrganClass
{
    @Category(com.user.login.TimingLabel.class)
    @Test
    public void getAllDepart()
    {
        System.out.println("=============================显示当前店铺下所有的部门数据=============================");
        given().param("token",LoginClass.token).param("_yz_version",LoginClass.vs)
                .get("http://salon-client-sit.lite.meimeifa.cn/api/salon/base/department/getList")
                .prettyPeek();
    }

    @Test
    public void getAllTitle()
    {
        System.out.println("=============================显示当前店铺下所有的职位数据=============================");
        given().param("token",LoginClass.token).param("_yz_version",LoginClass.vs)
                .get("http://salon-client-sit.lite.meimeifa.cn/api/salon/base/title/getList")
                .prettyPeek();
    }
}

import com.goods.course.CourseClass;
import com.goods.product.ProductClass;
import com.goods.service.ServicesClass;
import com.market.coupon.CouponClass;
import com.member.card.MCardClass;
import com.member.member.MemberClass;
import com.staff.organization.OrganClass;
import com.staff.staff.StaffClass;
import com.user.login.LoginClass;
import com.user.login.LoginClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//所有的Testcase都运行，且按指定顺序运行
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginClass.class,
        MemberClass.class,
        MCardClass.class,
        ServicesClass.class,
        ProductClass.class,
        CourseClass.class,
        CouponClass.class,
        OrganClass.class,
        StaffClass.class
})
public class AllSuiteTest
{

}

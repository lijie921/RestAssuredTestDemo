import com.member.member.MemberClass;
import com.staff.staff.StaffClass;
import com.user.login.LoginClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(com.user.login.SmokeLabel.class)
@Suite.SuiteClasses({
        LoginClass.class,
        MemberClass.class,
        StaffClass.class
})
public class SmokeSuiteTest
{
    
}

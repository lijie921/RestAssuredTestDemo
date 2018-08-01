import com.staff.organization.OrganClass;
import com.user.login.LoginClass;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(com.user.login.TimingLabel.class)
@Suite.SuiteClasses({
        LoginClass.class,
        OrganClass.class
})

public class TimingSuiteTest
{

}

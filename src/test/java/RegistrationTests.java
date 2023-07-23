import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }


    @Test(dataProvider = "userRegDtoCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveDTO(User user){

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("submitLogin invoked");
        logger.info("registrationPositive starts with credentials: login "
                + user.getEmail() + " & password: " + user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
//    @Test(dataProvider = "userDtoCSV", dataProviderClass = ProviderData.class)
//    public void registrationNegativeWrongPassword(User user){
//
//        app.getUser().openRegistrationForm();
//        app.getUser().fillRegistrationForm(user);
//        app.getUser().submitLogin();
//        Assert.assertTrue(app.getUser().isLoggedSuccess());
//    }

    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        app.getUser().clickOkButton();
    }
}

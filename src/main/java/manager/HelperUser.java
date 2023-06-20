package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        wd.findElement(By.xpath("//*[.=' Log in ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
//    public void fillLoginForm(String password, String email){
//        type(By.xpath("//input[@id='email']"), email);
//        type(By.xpath("//input[@id='password']"), password);
//    }

    // overloading
    public void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    // method signature - type + name + parameters types
    public void submitLogin(){

        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public void logout(){

    }

    public boolean isLogged(){

    }


}

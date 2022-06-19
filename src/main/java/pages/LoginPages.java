package pages;

import base.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages extends CommonAPI {

    public LoginPages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="input[id='user-name']")
     private WebElement usernameField;

    @FindBy(css="\"#password\"")
     private WebElement PasswordField;

    @FindBy(css="\"#login-button\")")
     private WebElement loginBtn;

    @FindBy(xpath = "\"//h3[@data-test='error']\"")
     private WebElement errorMessage;
    public boolean checkUserNameFieldPresence(){
        boolean checkUserNameFieldPresence= isPresent(usernameField);
        System.out.println("Login Button presence"+checkUserNameFieldPresence());
        return isPresent(usernameField);
    }
    public boolean checkPasswordFieldPresence(){
        boolean checkPasswordFieldPresence= isPresent(PasswordField);
        System.out.println("Login Button presence"+checkPasswordFieldPresence());
        return isPresent(PasswordField);
    }
    public boolean checkLoginBtnPresence() {
        boolean checkLoginBtnPresence= isPresent(loginBtn);
        System.out.println("Login Btn is presence"+checkLoginBtnPresence);
        return isPresent(loginBtn);

    }
    public void enterUserName(String username) {
        type(usernameField,username);
        System.out.println("username entered");
    }

    public void enterPassword(String password){
     type(PasswordField,password);
        System.out.println("password entered");
    }

    public void clickOnLoginBtn(){
        click(loginBtn);
        System.out.println("Click on the login button success");
    }
    public String errorMessage(){
        String errorMessageText= getElementText(errorMessage);
        System.out.println("errorMessage text"+errorMessage);
        return errorMessageText ;
    }


}







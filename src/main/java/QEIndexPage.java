import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class QEIndexPage {

    public WebDriver driver;

        public QEIndexPage(WebDriver driver){
            this.driver = driver;
        }
    //Elements for Test 1
    By emailInput = By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//input[@type='email']");
    By passwordInput = By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//input[@type='password']");
    By loginButton = By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//button[@type='submit']");

    //Elements for Test 2
    By test2Div = By.xpath("//div[@id='test-2-div']");
    By badge = By.xpath("//div[@id='test-2-div']//ul[@class='list-group']//li[2]//span");

    //Elements for Test 3
    By test3Div = By.xpath("//div[@id='test-3-div']");
    By dropdown = By.xpath("//div[@id='test-3-div']//button[@id='dropdownMenuButton']");
    By option3 =  By.linkText("Option 3");

    //Elements for Test 4
   By test4Div = By.xpath("//div[@id='test-4-div']");

   //methods to get elements
    public WebElement getEmail(){
        return driver.findElement(emailInput);
    }
    public WebElement getPassword(){
        return driver.findElement(passwordInput);
    }
    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement getTest2Div(){
        return driver.findElement(test2Div);
    }

    public WebElement getBadge(){
        return driver.findElement(badge);
    }
    public WebElement getTest3Div(){
        return driver.findElement(test3Div);
    }
    public WebElement getDropdown(){
        return driver.findElement(dropdown);
    }
    public WebElement getOption3(){
        return driver.findElement(option3);
    }
    public WebElement getTest4Div(){
        return driver.findElement(test4Div);
    }

}

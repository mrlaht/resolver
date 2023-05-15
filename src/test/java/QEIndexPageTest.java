import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class QEIndexPageTest extends BasePageTest {



    @BeforeTest
    public void startUp() {
        //Initiate driver
        driver = getDriver();

    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void Test1() {
        //navigating to home page
        navigateTo(homePage);
        QEIndexPage indexPage = new QEIndexPage(driver);
        // Assert email address and password fields and login button are present
        WebElement emailInput = indexPage.getEmail();
        WebElement passwordInput = indexPage.getPassword();
        WebElement loginButton = indexPage.getLoginButton();
        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());

        // Enter email and password combination into the respective fields
        emailInput.sendKeys("casestudy@mail.com");
        passwordInput.sendKeys("Password");
        loginButton.click();


    }


    @Test
    public void Test2()  {

        //Navigating to home page
        navigateTo(homePage);
        QEIndexPage indexPage = new QEIndexPage(driver);
        // Assert there are three values in the listgroup
        WebElement test2Div = indexPage.getTest2Div();
        Assert.assertTrue(test2Div.isDisplayed());
        WebElement listGroup = test2Div.findElement(By.className("list-group"));
        List<WebElement> listItems = listGroup.findElements(By.className("list-group-item"));
        Assert.assertEquals(3, listItems.size());

        // Assert second list item's value is "List Item 2"
        WebElement listItem2 = listItems.get(1);
        String listItem2Value = listItem2.getText();
        Assert.assertTrue(listItem2Value.contains("List Item 2"));


        //Assert that the second list item's badge value is 6
        WebElement badge = indexPage.getBadge();
        Assert.assertEquals("6", badge.getText());


    }

    @Test
    public void Test3() {
        //Navigating to home page
        navigateTo(homePage);
        QEIndexPage indexPage = new QEIndexPage(driver);
        // Assert "Option 1" is the default selected value
        WebElement test3Div = indexPage.getTest3Div();
        Assert.assertTrue(test3Div.isDisplayed());
        WebElement dropdown = indexPage.getDropdown();
        Assert.assertEquals("Option 1", dropdown.getText());

        // Select "Option 3" from the select list
        dropdown.click();
        WebElement option3 = indexPage.getOption3();
        option3.click();

    }
    @Test
   public void Test4()
    {
        //Navigating to home page
        navigateTo(homePage);
        QEIndexPage indexPage = new QEIndexPage(driver);
        // Assert first button is enabled
        WebElement test4Div = indexPage.getTest4Div();
        Assert.assertTrue(test4Div.isDisplayed());
        WebElement firstButton = test4Div.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']"));
        Assert.assertTrue(firstButton.isEnabled());

        // Assert second button is disabled
        WebElement secondButton = test4Div.findElement(By.xpath("//button[@class='btn btn-lg btn-secondary']"));
        Assert.assertFalse(secondButton.isEnabled());

    }
    @Test
    public void Test5()
    {
        //Navigating to home page
        navigateTo(homePage);
        // Wait for button to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='test-5-div']//button[@id='test5-button']")));
        button.click();

        // Assert success message is displayed
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='test-5-div']//div[@id='test5-alert']")));
        Assert.assertTrue(successMessage.isDisplayed());

        // Assert button is disabled
        Assert.assertFalse(button.isEnabled());
    }
       //Method to find the value of any cell on the grid
        public String getGridCellValue(WebDriver driver, int row, int column) {
        WebElement gridCell = driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']/tbody/tr[" + (row +1 ) + "]/td[" + (column + 1) + "]"));
        return gridCell.getText();
    }
    @Test
    public void Test6()
    {
        //Navigating to home page
        navigateTo(homePage);
        //Locating value of the cell at coordinates 2, 2 (staring at 0 in the top
        String cellValue = getGridCellValue(driver, 2, 2);
        Assert.assertEquals("Ventosanzap", cellValue);

    }

}

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HogwartsPage;
import pages.HomePage;
import pages.SignInPage;
import pages.TeamsPage;

import javax.print.attribute.standard.Sides;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClickBanner {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\软件包\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
       // driver = new ChromeDriver();

    }
    @Test
    public void test() throws InterruptedException {
        driver.get("http://testerhome.com");
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.searchKeyWord("selenium");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

    }
    @Test
    public void test2(){
        driver.get("http://testerhome.com");
        HomePage homePage = new HomePage(driver);
        String handle = driver.getWindowHandle();
        Reporter.log(handle,true);
        homePage.clickHref();

        for(String handle1:driver.getWindowHandles()){
            if(!handle.equals(handle1)){
                driver.switchTo().window(handle1);
                Reporter.log(handle1,true);
            }
        }
    }
    @DataProvider(name="getData")
    public Iterator<Object[]> getData()  {
        //return new Object[][]{ {"selenium"},{"testng"} };
        Iterator<Object[]> object =null ;
        try {
           object=readCsvFile("src\\main\\resources","searchWord.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
             return object;
        }
    }
    @Test(dataProvider = "getData")
    public void test3(String value){
        driver.get("https://testerhome.com");
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.searchKeyWord(value);

    }
    public Iterator<Object[]> readCsvFile(String filePath, String fileName) throws IOException {
        List<Object[]> dataList = new ArrayList<Object[]>();
        Reader in = new FileReader(filePath+"\\"+fileName);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord csvRecord:records){
            List<Object> list= new ArrayList<Object>();
            Iterator iterator = csvRecord.iterator();
            while(iterator.hasNext()){
                list.add(iterator.next());
            }
            Object[] row = list.toArray();
            dataList.add(row);
        }
        return dataList.iterator();
    }
    @Test
    public void testTpoic(){
        driver.get("http://testerhome.com");
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        TeamsPage teamsPage =homePage.clickHref();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HogwartsPage hogwartsPage =teamsPage.goTeamPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SignInPage signInPage=hogwartsPage.gotoFirstTopic();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(signInPage.isSignIn().equals("访问被拒绝，你可能没有权限或未登录。"),"访问被拒绝字符串出现");

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}

package Selenium_Web_YDH;


import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class doubleadd {
    public WebDriver driver;
    public String baseUrl;
    boolean acceptNextAlert = true;
    StringBuffer verificationErrors = new StringBuffer();

    public static void main(String[] args) throws  Exception{
        doubleadd add = new doubleadd();
    }

    public doubleadd() throws  Exception{
            this.setUp();

        try {
            this.login("310007707", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // tc.closeBoundMessage();
        // tc.testAgentNewOrder();
            for (int i = 5; i <= 20; i++) {
                try {
                    this.testAddGood3(i);
                    System.out.println("第"+i+"次新增商品成功。。。");
                } catch (Exception e) {
                    System.out.println("第"+i+"次新增商品失败！！！");//sout+tab键 快速打出
                }
            }
        try {
            this.logout1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("用例执行通过。。。。。");
    }

    public void setUp() throws Exception {
        // Firefox浏览器启动
       // System.setProperty("webdriver.chrome.driver","D:\\WebDriverServer\\chromedriver.exe");
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        baseUrl = "https://sso.dinghuo123.com/login?service=ydh-web";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public static boolean switchToWindow(String windowTitle, WebDriver dr) {
        boolean flag = false;
        try {
            // 将页面上所有的windowshandle放在入set集合当中
            String currentHandle = dr.getWindowHandle();
            Set<String> handles = dr.getWindowHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    dr.switchTo().window(s);
                    // 和当前的窗口进行比较如果相同就切换到windowhandle
                    // 判断title是否和handles当前的窗口相同
                    if (dr.getTitle().contains(windowTitle)) {
                        flag = true;
                        System.out.println("Switch to window: " + windowTitle
                                + " successfully!");
                        break;
                    } else
                        continue;
                }
            }
        } catch (Exception e) {
            System.out.printf("Window: " + windowTitle + " cound not found!",
                    e.fillInStackTrace());
            flag = false;
        }
        return flag;
    }

    // 登录方法
    public void login(String username, String password) throws Exception {

        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("btn-submit")).click();
        Thread.sleep(1000);
    }

    // 登录后退出(管理端退出)
    public void logout() throws Exception {
        Thread.sleep(2000);
        WebElement main = driver.findElement(By
                .xpath("/html/body/div[2]/div[1]/div/ul/li[2]"));
        // 鼠标移入事件
        Actions ac = new Actions(driver);
        ac.moveToElement(main).perform();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        // js.executeScript("$('.container','.user').show()",main);
        driver.findElement(By.linkText("退出")).click();
        Thread.sleep(1000);
    }

    public void logout1() throws Exception {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.container','.user').show()");
        driver.findElement(By.linkText("退出")).click();
        Thread.sleep(1000);
    }

    public void logout2() throws Exception {
        driver.findElement(By.xpath("/html/body/div[1]/h1/a")).click();
        driver.findElement(By.linkText("退出")).click();
    }

    public void logout3() throws Exception {
        driver.findElement(By.linkText("退出")).click();
    }

    // 随机生成一个字符串（主要用于新增一些内容时 使用）
    public String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer(
                "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    // 获取当前时间
    public String getDate() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss");// 设置时间格式
        String time = format.format(date);
        return time;
    }

    // 关闭浏览器方法
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    // 新增商品(2)这里添加的商品没有商品介绍
    public void testAddGood2(int i) throws Exception {
        String goodName = "2016年——易" + i;
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon"))
                .click();
        driver.findElement(By.xpath("//a[3]/span[2]")).click();
        driver.findElement(By.name("productName")).clear();
        driver.findElement(By.name("productName")).sendKeys(goodName);
        driver.findElement(By.name("productTypeName")).click();
        driver.findElement(By.linkText("通用")).click();
        driver.findElement(By.name("productUnitName")).click();
        driver.findElement(
                By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div.droplist > div:nth-child(1)"))
                .click();
        driver.findElement(
                By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[2]/label[1]"))
                .click();
        driver.findElement(By.id("marketPriceMain")).clear();
        driver.findElement(By.id("marketPriceMain")).sendKeys("12");
        driver.findElement(By.id("costPriceMain")).clear();
        driver.findElement(By.id("costPriceMain")).sendKeys("1");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(2000);
    }

    public void testAddGood3(int i) throws Exception {
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon"))
                .click();
        driver.findElement(By.xpath("//a[3]/span[2]")).click();
        driver.findElement(By.name("productName")).clear();
        driver.findElement(By.name("productName")).sendKeys("2016年易订货" + i);
        driver.findElement(By.name("productTypeName")).click();
        driver.findElement(By.linkText("通用")).click();
        driver.findElement(By.name("productUnitName")).click();
        driver.findElement(
                By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div.droplist > div:nth-child(1)"))
                .click();
        driver.findElement(
                By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[2]/label[1]"))
                .click();
        Thread.sleep(1000);
        WebElement min = driver.findElement(By.className("product-img"));
        // 鼠标移入事件
        Actions ac = new Actions(driver);
        ac.moveToElement(min).perform();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div/div[3]/table/tbody/tr/td[2]/div/div/div[2]/a")).click();
        driver.findElement(
                By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.product.productadd > div.main-t > div > div.productListBox.table-wrap-lite > table > tbody > tr > td.product-img > div > div > div.op-btn > a"))
                .click();
        driver.switchTo().frame("productImgUpload");
        driver.findElement(
                By.xpath("/html/body/div/div/div[2]/div[2]/span/span")).click();
        // 启动上传图片autoit
        // String path = "C:/Users/Administrator/Desktop/Upload.exe";
        execShell("C:/Upload.exe");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(
                By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]"))
                .click();
        driver.findElement(By.id("marketPriceMain")).clear();
        driver.findElement(By.id("marketPriceMain")).sendKeys("4800");
        driver.findElement(By.id("costPriceMain")).clear();
        driver.findElement(By.id("costPriceMain")).sendKeys("5");
        driver.findElement(By.xpath("//button")).click();
    }

    public static void execShell(String path) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

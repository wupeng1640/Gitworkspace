package Selenium_Web_YDH;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class ChangWebDriver {
public static boolean switchToWindow(String windowTitle,WebDriver dr){  
    boolean flag = false;  
    try { 
//	    	将页面上所有的windowshandle放在入set集合当中
        String currentHandle = dr.getWindowHandle();  
        Set<String> handles = dr.getWindowHandles();  
        for (String s : handles) {  
            if (s.equals(currentHandle))  
                continue;  
            else {  
            	dr.switchTo().window(s);
//	                和当前的窗口进行比较如果相同就切换到windowhandle
//	                判断title是否和handles当前的窗口相同
                if (dr.getTitle().contains(windowTitle)) {  
                    flag = true;  
                    System.out.println("Switch to window: "  
                            + windowTitle + " successfully!");  
                    break;  
                } else  
                    continue;  
            }  
        }  
    } catch (Exception e) {  
        System.out.printf("Window: " + windowTitle  
                + " cound not found!", e.fillInStackTrace());  
        flag = false;  
    }  
    return flag;  
} 
public static void main(String args[]){
System.setProperty("webdriver.chrome.driver", "D:\\WebDriverServer\\chromedriver.exe");
 
WebDriver driver = new ChromeDriver();
driver.get("http://www.bignox.com");
driver.findElement(By.linkText("游戏论坛")).click();
driver.findElement(By.linkText("游戏中心")).click();
try {
Thread.sleep(5000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
ChangWebDriver.switchToWindow("游戏中心_夜神安卓模拟器", driver);
driver.findElement(By.linkText("开发者提交游戏")).click();
try {
Thread.sleep(5000);
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
driver.quit();
}
 
}
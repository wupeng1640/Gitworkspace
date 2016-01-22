package Selenium_Web_YDH;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Get_YHD_Data {
    public WebDriver driver;
    public String baseUrl;
    boolean acceptNextAlert = true;
    StringBuffer verificationErrors = new StringBuffer();

    public static void main(String[] args) throws Exception {
        Get_YHD_Data get_yhd_data = new Get_YHD_Data();
    }

    public Get_YHD_Data() throws Exception {
        while (true) {
            this.setUp(0);
            this.login("310021564", "123456");
//            for (int i = 0; i <= 1; i++) {
//                try {
//                    this.testAddClient(i);
//                    System.out.println("新增第" + i + "个客户");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    this.testDeleteClient();
//                    System.out.println("删除第" + i + "个客户");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            for (int i = 0; i <= 1; i++) {
                try {
                    this.order_replaceAgent();
                    this.orderCheck();
                    this.returnOrder_replaceAgent();
                    this.ruturnOrderCheck();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= 1; i++) {
                try {
                    this.testAddGood2();
                    this.testDeleteGood();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= 1; i++) {
                try {
                    this.fundRecharge();
                    this.backRecharge();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= 1; i++) {
                try {
                    this.testNewNotify();
                    this.testDeleteNotify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <= 1; i++) {
                try {
                    this.addBankAccount();
                    this.deleteBankAccount();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            for (int i = 0; i <= 1; i++) {
//                try {
//                    this.testSaleDiscount();
//                    this.testOrderSaleDiscount();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            try {
                this.logout1();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i <= 1; i++) {
                try {
                    this.login("ku123456", "123456");
                    this.testAgentNewOrder();
                    this.testAgentNewReturnOrder();
                    this.testShopcat();
                    this.backOrder();
                    // this.testAgentFundRecharge();
                    this.logout1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {

                    this.login("310021564", "123456");
                    this.orderCheck();
                    this.orderCheck();
                    this.ruturnOrderCheck();
                    this.ruturnOrderCheck();
                    this.logout1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.tearDown();
//            try {
//                this.setUp(1);
//                this.enroll();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//          this.tearDown();
        }
    }

    public void setUp(int browers) throws Exception {
        if (browers == 0) {
            //Firefox浏览器启动
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browers == 1) {
            //Chrome浏览器启动
            System.setProperty("webdriver.chrome.driver", "D:\\WebDriverServer\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browers == 2) {
            // IE浏览器启动
            System.setProperty("webdriver.ie.driver", "D:\\WebDriverServer\\IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(ieCapabilities);
            driver.manage().window().maximize();
        }
        baseUrl = "https://sso.dinghuo123.com/login?service=ydh-web";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }


    //窗口切换
    public static boolean switchToWindow(String windowTitle, WebDriver dr) {
        boolean flag = false;
        try {
//		    	将页面上所有的windowshandle放在入set集合当中
            String currentHandle = dr.getWindowHandle();
            Set<String> handles = dr.getWindowHandles();
            for (String s : handles) {
                if (s.equals(currentHandle))
                    continue;
                else {
                    dr.switchTo().window(s);
//		                和当前的窗口进行比较如果相同就切换到windowhandle
//		                判断title是否和handles当前的窗口相同
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

    //登录方法
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

    //通过账号助手登录
    public void login_help(String username, String password) throws Exception {


        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("btn-submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[3]/div/a/span")).click();
        Thread.sleep(2000);
    }

    //注册方法
    public void enroll() throws Exception {

        Random_tel aa = new Random_tel();
        String ss = aa.get_Random_Tel();
        driver.findElement(By.linkText("立即注册")).click();

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(ss);
        Thread.sleep(1000);
        driver.findElement(By.id("verfCode")).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
                + "type: 'get',dataType: 'text',success:function(responseText){"
                + "$('#verfCode').val(responseText);" + "}})");
        driver.findElement(By.cssSelector("button.btn-getverfycode")).click();
        Thread.sleep(1000);
        String activecode;
        DBread db = new DBread(ss);
        activecode = db.getActiveCode(ss);
        System.out.println("获取到的手机验证码为:" + activecode);
        driver.findElement(By.id("mobileVerfyCode")).clear();
        driver.findElement(By.id("mobileVerfyCode")).sendKeys(activecode);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("html body div.r1bg.register-bg div#step1.register-banner div.banner-wrap "
                + "div.op-box.registerWrapper div.control-box form#validateCodeForm.animated.nice-validator.n-default "
                + "div.control-group div.control-input.mb10 button#btn-register.ui-btn.ui-btn-theme.btn-register")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("companyName")).clear();
        driver.findElement(By.name("companyName")).sendKeys("依云测试");//这里“依云测试”为公司名称，可以修改
        Thread.sleep(1000);
        driver.findElement(By.name("linkman")).clear();
        driver.findElement(By.name("linkman")).sendKeys("测试");//公司管理员姓名
        Thread.sleep(1000);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");//登录密码
        Thread.sleep(1000);
        //driver.findElement(By.cssSelector("div.icheckbox_flat-blue.hover > ins.iCheck-helper")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("123456789@qq.com");
        Thread.sleep(1000);
        driver.findElement(By.id("btn-register2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("registerToUseBtn")).click();
        Thread.sleep(2000);
        ChangWebDriver.switchToWindow("我的工作台", driver);
        driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
        driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
        driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[2]")).click();
        driver.findElement(By.id("guideBox")).findElement(By.xpath("//*[@id='guideBox']/div[2]/a[3]")).click();
        Thread.sleep(3000);
        System.out.println(ss + "用于被注册了。。。嘿嘿\t 密码：123456");
    }

    //登录后退出(管理端退出)
    public void logout() throws Exception {
        Thread.sleep(2000);
        WebElement main = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[2]"));
        //鼠标移入事件
        Actions ac = new Actions(driver);
        ac.moveToElement(main).perform();


        //JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        //js.executeScript("$('.container','.user').show()",main);
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

    //找回密码    仅仅限制在测试环境做找回密码操作
    public void findPassword() throws Exception {

        driver.findElement(By.linkText("忘记密码？")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("18720091223");
        driver.findElement(By.id("verfCode")).clear();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
                + "type: 'get',dataType: 'text',success:function(responseText){"
                + "$('#verfCode').val(responseText);" + "}})");
        Thread.sleep(1000);
        driver.findElement(By.id("btn-submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("activeCode")).clear();
        String activecode;
        DBread db = new DBread("18720091223");
        activecode = db.getActiveCode("18720091223");
        driver.findElement(By.id("activeCode")).sendKeys(activecode);
        driver.findElement(By.id("btn-submit")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("password1")).clear();
        driver.findElement(By.id("password1")).sendKeys("123456");
        driver.findElement(By.id("btn-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("btn-quickLogin")).click();
        Thread.sleep(2000);
    }

    //找回用户名方法
    public void findUsername(String email) throws Exception {

        driver.findElement(By.linkText("忘记密码？")).click();
        driver.findElement(By.linkText("点击找回")).click();
        // driver.findElement(By.cssSelector("img.auth-image")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.id("verfCode")).clear();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$.ajax({url: 'https://sso.dinghuo123.com/ajaxChecking?action=getVerifyCode',"
                + "type: 'get',dataType: 'text',success:function(responseText){"
                + "$('#verfCode').val(responseText);" + "}})");
        driver.findElement(By.id("btn-submit")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("立即登录邮箱找回用户名")).click();
        Thread.sleep(2000);
    }

    //关闭浏览器方法
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    //订单搜索
    public void orderSearch() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("DH-O-201512");
        driver.findElement(By.id("op-search")).click();
        driver.findElement(By.xpath("//*[@id='searchComboWrap']/i")).click();
        driver.findElement(By.xpath("//div[@id='COMBO_WRAP']/div[2]/div/div[2]")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("DH-R-201512");
        driver.findElement(By.id("op-search")).click();
    }


    //订单高级搜索
    public void advancedSearch() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.cssSelector("#advanceSearchLink")).click();
        driver.findElement(By.name("customerNameLike")).clear();
        driver.findElement(By.name("customerNameLike")).sendKeys("测试");
        driver.findElement(By.xpath("(//input[@name='status'])[3]")).click();
        driver.findElement(By.linkText("搜索")).click();
    }

    //管理端代下单
    public void order_replaceAgent() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("//form[@id='myForm']/div/div/a[2]/span[2]")).click();
        driver.findElement(By.cssSelector("input.input-txt.agentAuto")).click();
        driver.findElement(By.cssSelector("div.list-item.on")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("td.tip1-3")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("(function(){for(var i =0;i<3;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")[Math.round("
                + "Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //管理端代下退货单
    public void returnOrder_replaceAgent() throws Exception {
        Thread.sleep(1000);
        // WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
        String jsp = "$('.side-menu-a').eq(0).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsp);
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.findElement(By.cssSelector("input.input-txt.agentAuto")).click();
        driver.findElement(By.cssSelector("div.list-item.on")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("td.tip1-3")).click();
        Thread.sleep(500);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("(function(){for(var i =0;i<3;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")[Math.round(Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.total-l.chks")).click();
        driver.findElement(By.id("inp-discount-order")).clear();
        driver.findElement(By.id("inp-discount-order")).sendKeys("250");
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("备注，，这一一笔管理端代下退货单。。。" + this.getDate());
        driver.findElement(By.xpath("//button")).click();
    }


    //购物车下单
    public void testShopcat() throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.linkText("商品")).click();
        driver.findElement(By.cssSelector("a.btn-away.btn-away-line")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
                + "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).clear();
        driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
                + "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).sendKeys("8");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("立即下单")).click();
        Thread.sleep(1000);
        // driver.findElement(By.xpath("//label[2]")).click();
        //  driver.findElement(By.id("inp-discount-order")).clear();
        //  driver.findElement(By.id("inp-discount-order")).sendKeys("324.00");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("备注，这是一个订货单货单。。。" + this.getDate());
        Thread.sleep(1000);
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/div[1]/div[1]/div[1]/div/label[2]")).click();
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }


    //购物车下退货单
    public void backOrder() throws Exception {
        // Thread.sleep(1000);
        driver.findElement(By.linkText("商品")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//input[@value='0']")).clear();
        // driver.findElement(By.xpath("//input[@value='0']")).sendKeys("6");
        driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
                + "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).clear();
        driver.findElement(By.cssSelector("html body div.r-wrap div.main-wrap div.agent-product div.main-t div.product-table-wrap "
                + "div.table-wrap.product-table.fitTable table.line-table tbody#productEntries tr td.tl input.ui-input.tr.cartcount")).sendKeys("8");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/ul/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("立即下单")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[2]")).click();
        driver.findElement(By.id("inp-discount-order")).clear();
        driver.findElement(By.id("inp-discount-order")).sendKeys("324.00");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("备注，这是一个退货单。。。" + this.getDate());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }


    //订单审核(订货端下单之后管理端审核订单)
    public void orderCheck() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.id("outStorage")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("发货")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
    }

    //退货单审核(订货单下单之后管理端深刻订单)
    public void ruturnOrderCheck() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
        String jsp = "$('.side-menu-a').eq(0).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);

        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //订货单退回操作
    public void orderBack() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.linkText("审核")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("退回")).click();
        driver.switchTo().frame("iframe-back");
        Thread.sleep(500);
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("这是一笔订货单 ,退货的操作，，，." + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/div[1]/table")).findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //订单的作废与删除
    public void OrderCancelDelete() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("作废")).click();
        driver.switchTo().frame("iframe-cancel");
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("订单作废操作。。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //退货单作废与删除
    public void returnOrderCancelDelete() throws Exception {
        //WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
        String jsp = "$('.side-menu-a').eq(0).trigger('mouseenter')";
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsp);
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("作废")).click();
        driver.switchTo().frame("iframe-cancel");//生产环境是没有上传20151215，过不能再生产环境测试
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("这是一笔作废退货单。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //管理端订单详情页面添加商品备注
    public void goodRemark() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("添加")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("remarkCon")).clear();
        driver.findElement(By.id("remarkCon")).sendKeys("这是一个商品备注。。。。。" + this.getDate());
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.cssSelector("i.icon")).click();
    }

    //管理端添加订单备注
    public void testOrderRemark() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("remarkCon")).clear();
        driver.findElement(By.id("remarkCon")).sendKeys("这是一个订单备注哦。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.cssSelector("i.icon")).click();
    }

    //订单的修改
    public void testOrderModify() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("修改")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("(function(){for(var i =0;i<1;i++){$(\".tip\"+(i+1)+\"-3\").click();$(\".list-item-product\")"
                + "[Math.round(Math.random()*$(\".list-item-product\").length)].click()}$(\"body\").click();})()");//商品的修改
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        // driver.findElement(By.xpath("//*[@id='1']/td[5]")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("3");//商品数量修改
        Thread.sleep(500);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.cssSelector("i.icon")).click();
    }

    //退货单退回操作
    public void testReturnOrderBack() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='order']/a"));
        String jsp = "$('.side-menu-a').eq(0).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("通过")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.linkText("退回")).click();
        driver.switchTo().frame("iframe-back");
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("这是一笔退货单退回操作。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //退货单备注
    public void testReturnOrderRemark() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("remarkCon")).clear();
        driver.findElement(By.id("remarkCon")).sendKeys("这是退货单备注。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.cssSelector("i.icon")).click();
    }

    //管理端修改订单收货地址（添加收货地址在订货单这只这个模块来做，这里只实现收货地址切换）
    public void orderModifyAddress() throws Exception {
        driver.findElement(By.cssSelector("i.icon")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div/a")).click();
        driver.findElement(By.cssSelector("#address-edit > span.ui-btn-txt")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("设为默认")).click();
        Thread.sleep(500);
        driver.findElement(By.name("addressId")).click();
        Thread.sleep(500);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        driver.findElement(By.cssSelector("i.icon")).click();
    }

    //订货端新增订单
    public void testAgentNewOrder() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.linkText("新增")).click();
        driver.findElement(By.cssSelector("td.tip1-3")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[4]/span/span")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[2]/td[1]")).click();
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[3]/td[1]")).click();
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[4]/td[1]")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[2]/div/label")).click();
        driver.findElement(By.id("inp-discount-order")).clear();
        driver.findElement(By.id("inp-discount-order")).sendKeys("250.5");
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("订货端新增订货单。。。。" + this.getDate());
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);

    }

    //订货端新增退货单
    public void testAgentNewReturnOrder() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.linkText("新增")).click();


        driver.findElement(By.cssSelector("td.tip1-3")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[4]/span/span")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[2]/td[1]")).click();
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[3]/td[1]")).click();
        driver.findElement(By.xpath("//*[@id='goodsContainer']/tr[4]/td[1]")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();


        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("3");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("6");//修改第二件商品数量
        driver.findElement(By.id("inp-discount-order")).clear();
        driver.findElement(By.id("inp-discount-order")).sendKeys("38.55");
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("订货端新增退货单。。。。" + this.getDate());
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //订货端订单修改订单地址
    public void testAgentModifyAddress() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.cssSelector("#address-edit > span.ui-btn-txt")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.linkText("设为默认")).click();
        Thread.sleep(500);
        driver.findElement(By.name("addressId")).click();
        Thread.sleep(500);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        driver.findElement(By.linkText("订单")).click();
    }

    //订单备注
    public void testAgentOrderAddNote() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.linkText("添加备注")).click();
        driver.switchTo().frame("iframe-remark");
        driver.findElement(By.id("remarkCon")).clear();
        driver.findElement(By.id("remarkCon")).sendKeys("这是一个订货端订单备注哦。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("订单")).click();
    }

    //订单作废
    public void testAgentOrderCancel() throws Exception {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.linkText("作废")).click();
        driver.switchTo().frame("iframe-cancel");
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("这是一个订货端订单作废操作哦。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("订单")).click();
    }

    //退货单添加备注
    public void testAgentReturnOrderAddNote() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.linkText("添加备注")).click();
        driver.switchTo().frame("iframe-remark");
        driver.findElement(By.id("remarkCon")).clear();
        driver.findElement(By.id("remarkCon")).sendKeys("这是一个订货端退货端订单备注哦。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("订单")).click();

    }

    public void testAgentReturnOrderCancel() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.linkText("退货单")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]/a")).click();
        driver.findElement(By.linkText("作废")).click();
        driver.switchTo().frame("iframe-cancel");
        driver.findElement(By.id("remarkText")).clear();
        driver.findElement(By.id("remarkText")).sendKeys("这是一个订货端退货单作废操作哦。。。。！！！" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        //driver.findElement(By.linkText("订单")).click();

    }

    //新增商品
    public void testAddGood() throws Exception {
        String goodName = "测试商品" + this.getRandomString(5);
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
        driver.findElement(By.xpath("//a[3]/span[2]")).click();
        driver.findElement(By.name("productName")).clear();
        driver.findElement(By.name("productName")).sendKeys(goodName);
        driver.findElement(By.name("productTypeName")).click();
        driver.findElement(By.linkText("通用")).click();
        driver.findElement(By.name("productUnitName")).click();
        driver.findElement(By.cssSelector("div.list-item.on")).click();
        driver.findElement(By.name("keywords")).click();
        driver.findElement(By.name("keywords")).clear();
        driver.findElement(By.name("keywords")).sendKeys("0000");
        driver.findElement(By.name("sortNum")).clear();
        driver.findElement(By.name("sortNum")).sendKeys("1");
        driver.switchTo().frame("ueditor_0");
        driver.findElement(By.xpath("/html/body")).click();
        driver.findElement(By.xpath("/html/body")).clear();
        driver.findElement(By.xpath("/html/body")).sendKeys(this.getDate() + "  这是测试商品0000！！！！的速度与放大师傅IDS风速达\n覅USA大福ISA放大岁大四"
                + "丢哦放大遂发生地方富\ndsajdashddkjsadhsj房价肯定撒京东方第三季开放哈地方\n华大厦佛地方"
                + "哈斯的fdfdasfsadfdjklfkjlhlkjkjdfdkj \n的地方思考考虑啥地方就卡死的 大空间放四大行疯狂金士顿放宽松疯狂金士顿开放 \ngfd尽快发货");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("marketPriceMain")).clear();
        driver.findElement(By.id("marketPriceMain")).sendKeys("20");
        driver.findElement(By.id("costPriceMain")).clear();
        driver.findElement(By.id("costPriceMain")).sendKeys("10");
        Thread.sleep(800);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //新增商品(2)这里添加的商品没有商品介绍
    public void testAddGood2() throws Exception {
        String goodName = "测试商品" + this.getRandomString(5);
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
        driver.findElement(By.xpath("//a[3]/span[2]")).click();
        driver.findElement(By.name("productName")).clear();
        driver.findElement(By.name("productName")).sendKeys(goodName);
        driver.findElement(By.name("productTypeName")).click();
        driver.findElement(By.linkText("通用")).click();
        driver.findElement(By.name("sortNum")).click();
        driver.findElement(By.name("sortNum")).clear();
        driver.findElement(By.name("sortNum")).sendKeys("9999");
        driver.findElement(By.name("productUnitName")).click();
        driver.findElement(By.cssSelector("div.list-item.on")).click();
        driver.findElement(By.name("keywords")).click();
        driver.findElement(By.name("keywords")).clear();
        driver.findElement(By.name("keywords")).sendKeys("shangping01");
        driver.findElement(By.name("sortNum")).clear();
        driver.findElement(By.name("sortNum")).sendKeys("1");
        driver.findElement(By.id("marketPriceMain")).clear();
        driver.findElement(By.id("marketPriceMain")).sendKeys("25");
        driver.findElement(By.id("costPriceMain")).clear();
        driver.findElement(By.id("costPriceMain")).sendKeys("15");
        Thread.sleep(800);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //删除商品
    public void testDeleteGood() {
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //修改商品
    public void testModifyGood() throws Exception {
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
        driver.findElement(By.linkText("修改")).click();
        ChangWebDriver.switchToWindow("修改商品", driver);//用于切换窗口的
        //String goodName1="修改商品"+this.getRandomString(6);
        //driver.findElement(By.className("productaddMain")).findElement(By.name("productName")).clear();
        //driver.findElement(By.className("productaddMain")).findElement(By.name("productName")).sendKeys( goodName1);
        driver.findElement(By.name("productTypeName")).click();
        driver.findElement(By.linkText("测试分类")).click();
        driver.findElement(By.name("keywords")).click();
        driver.findElement(By.name("keywords")).clear();
        driver.findElement(By.name("keywords")).sendKeys("修改商品01");
        driver.findElement(By.name("sortNum")).clear();
        driver.findElement(By.name("sortNum")).sendKeys("8");
        driver.findElement(By.cssSelector("label.productLabelItem")).click();
        driver.findElement(By.xpath("//label[2]")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.id("marketPriceMain")).clear();
        driver.findElement(By.id("marketPriceMain")).sendKeys("99");
        driver.findElement(By.id("costPriceMain")).clear();
        driver.findElement(By.id("costPriceMain")).sendKeys("70");
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
    }

    //商品搜索
    public void testSearchGood() throws Exception {
        driver.findElement(By.cssSelector("a.product.side-menu-a > i.icon")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("苹果");
        driver.findElement(By.id("op-search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("P60942451");
        driver.findElement(By.id("op-search")).click();
    }

    //添加商品计量单位
    public void testAddUnit() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        String goodUnit = this.getRandomString(5);
        driver.findElement(By.linkText("计量单位")).click();
        driver.findElement(By.cssSelector("button.ui-btn.ui-btn-blue")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("productUnitName")).clear();
        driver.findElement(By.id("productUnitName")).sendKeys(goodUnit);
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    public void testShareGood() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        driver.findElement(By.xpath("//*[@id='productEntries']/tr[1]/td[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("btn-product-share")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("i")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a.btn-share.btn-share-weixin > i")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("×")).click();
        driver.findElement(By.linkText("商品")).click();
    }

    public void testSearchWarehouse() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品库存")).click();
        driver.findElement(By.xpath("//*[@id='search']")).click();
        driver.findElement(By.xpath("//*[@id='search']")).clear();
        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("苹果");
        driver.findElement(By.id("op-search")).click();
    }

    //采购入库
    public void testProcurement() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品入库")).click();
        driver.findElement(By.linkText("新增")).click();
        Thread.sleep(500);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("500");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("这是商品备注");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("635");//修改第二件商品数量
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("商品采购入库备注哦哦！！！！！！" + this.getDate());
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("TryMax_WuPeng");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //其他入库
    public void testInWareHouse() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String js1 = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(js1, main);
        driver.findElement(By.linkText("商品入库")).click();
        driver.findElement(By.linkText("新增")).click();
        driver.findElement(By.cssSelector("span.trigger")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
                .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();//下拉选择框里面选内容
        driver.findElement(By.id("inventoryDate")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(500);
        js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("660");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("这是商品备注");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("850");//修改第二件商品数量
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("这是商品其他入库备注！！！！！！" + this.getDate());
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //销售出库
    public void testSellOut() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String js1 = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(js1, main);
        driver.findElement(By.linkText("商品出库")).click();
        driver.findElement(By.linkText("新增")).click();
        driver.findElement(By.cssSelector("span.trigger")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
                .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(1)")).click();//下拉选择框里面选内容
        driver.findElement(By.id("inventoryDate")).click();//时间选择，选择当前时间
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(500);
        js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("10");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("这是商品备注");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("25");//修改第二件商品数量
        driver.findElement(By.xpath("//*[@id='3']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='3']/td[5]")).findElement(By.id("3_count")).sendKeys("15");//修改三件商品数量
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("这是商品销售出库备注！！！！！！" + this.getDate());
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
    }

    //其他出库
    public void testOutWareHouse() throws Exception {
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        String js1 = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(js1, main);
        driver.findElement(By.linkText("商品出库")).click();
        driver.findElement(By.linkText("新增")).click();
        driver.findElement(By.cssSelector("span.trigger")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2)"))
                .findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();//下拉选择框里面选内容
        driver.findElement(By.id("inventoryDate")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(500);
        js.executeScript("(function(){for(var i =0;i<3;i++){$('#'+(i+1)).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[5]")).findElement(By.id("1_count")).sendKeys("500");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).click();
        driver.findElement(By.xpath("//*[@id='1']/td[6]")).sendKeys("这是商品备注");//修改第一件商品数量
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).click();
        driver.findElement(By.xpath("//*[@id='2']/td[5]")).findElement(By.id("2_count")).sendKeys("635");//修改第二件商品数量
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div/textarea")).sendKeys("这是商品出库备注！！！！！！" + this.getDate());
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[4]/div/textarea")).sendKeys("Try_WuPeng");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
    }

    //新增商品促销（打折促销）
    public void testSaleDiscount() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        Thread.sleep(1000);
        js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).sendKeys("85");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div[3]")).click();
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //新增商品促销（直降）
    public void testSalePromotion() throws Exception {
        //driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        Thread.sleep(1000);
        js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label[2]")).click();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionMoney")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionMoney")).sendKeys("5");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();    //中国
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();    //江西
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();    //上饶
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();    //鄱阳
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //新增商品促销（买赠（没有选择赠送商品，这里只赠送自己））
    public void testSalePresent() throws Exception {
        // driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        Thread.sleep(1000);
        js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[4]/div[2]/label[1]")).click();
        driver.findElement(By.cssSelector("input.ui-input-line.meetCount")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.meetCount")).sendKeys("20");
        driver.findElement(By.cssSelector("input.ui-input-line.promotionGiftCount")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionGiftCount")).sendKeys("1");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();    //中国
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();    //江西
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();    //上饶
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();    //鄱阳
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(1000);
    }

    //新增商品促销（阶梯打折促销）
    public void testSaleDiscount2() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("商品促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        Thread.sleep(1000);
        js.executeScript("(function(){for(var i =1;i<3;i++){$('#'+i).find('td').eq(3).click();$(\".list-item\")[Math.round(Math.random()"
                + "*$(\".list-item\").length)].click()}$(\"body\").click();})()");
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetCount")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetCount")).sendKeys("20");
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).sendKeys("98");
        driver.findElement(By.linkText("+添加区间")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("50");
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("90");
        driver.findElement(By.linkText("+添加区间")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("100");
        driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("85");

        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();    //中国
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.province > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();    //江西
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.city > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();    //上饶
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div.promotion.promotion-con > div.main-t > div > "
                + "div:nth-child(6) > div.control-input > div > div.district > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();    //鄱阳
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //订单促销（满折）
    public void testOrderSaleDiscount() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("订单促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.cssSelector("input.ui-input-line.meetMoney")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.meetMoney")).sendKeys("2000");
        driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).clear();
        driver.findElement(By.cssSelector("input.ui-input-line.promotionDiscount")).sendKeys("95");
        driver.findElement(By.xpath("//div[4]/div[2]/label[1]")).click();
        driver.findElement(By.xpath("//div[4]/div[2]/label[2]")).click();
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(3)")).click();    //其他区域
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //订单促销（满减）
    public void testOrderSalePromotion() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("订单促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        //driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label[2]")).click();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).sendKeys("2000");
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minusMoney")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minusMoney")).sendKeys("80");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(1)")).click();    //全部区域
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //订单促销（满赠）
    public void testOrderSalePresent() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("订单促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/label[1]")).click();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.meetMoney")).sendKeys("5000");
        //选择赠送商品
        driver.findElement(By.linkText("选择赠送商品")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("苹果2");
        driver.findElement(By.linkText("搜索")).click();
        driver.findElement(By.id("goodsContainer")).findElement(By.cssSelector("#goodsContainer > tr:nth-child(2)")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();

        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionGiftCount")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionGiftCount")).sendKeys("20");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();    //中国
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.province > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();    //江西
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.city > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();    //上饶
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.district > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();    //鄱阳
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //订单促销（阶梯促销）
    public void testOrderSaleDiscount2() throws Exception {
        driver.findElement(By.linkText("商品")).click();
        String jsp = "$('.side-menu-a').eq(2).trigger('mouseenter')";
        WebElement main = driver.findElement(By.xpath("//*[@id='product']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript(jsp, main);
        driver.findElement(By.linkText("订单促销")).click();
        driver.findElement(By.cssSelector("span.ui-btn-txt")).click();
        driver.findElement(By.name("startTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        driver.findElement(By.name("endTime")).click();
        driver.findElement(By.cssSelector("#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(7) > a")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.control-group.promotionRules")).click();
        driver.findElement(By.xpath("//label")).click();
        driver.findElement(By.xpath("//label[3]")).click();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetMoney")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.minMeetMoney")).sendKeys("1000");
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).clear();
        driver.findElement(By.cssSelector("div.tempLi > input.ui-input-line.promotionDiscount")).sendKeys("98");
        driver.findElement(By.linkText("+添加区间")).click();
        driver.findElement(By.xpath("(//input[@value=''])[9]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[9]")).sendKeys("5000");
        driver.findElement(By.xpath("(//input[@value=''])[10]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[10]")).sendKeys("90");
        driver.findElement(By.linkText("+添加区间")).click();
        driver.findElement(By.xpath("(//input[@value=''])[11]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[11]")).sendKeys("10000");
        driver.findElement(By.xpath("(//input[@value=''])[12]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[12]")).sendKeys("85");
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.country > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(2) > div > div:nth-child(2)")).click();    //中国
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.province > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(3) > div > div:nth-child(15)")).click();    //江西
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.city > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(4) > div > div:nth-child(12)")).click();    //上饶
        driver.findElement(By.cssSelector("body > div.r-wrap > div.main-wrap.main-wrap-crop > div > div.main-t > div > div:nth-child(5) > div.control-input > div > "
                + "div.district > span > input")).click();
        driver.findElement(By.cssSelector("#COMBO_WRAP > div:nth-child(5) > div > div:nth-child(10)")).click();    //鄱阳
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.linkText("商品")).click();
        Thread.sleep(1000);
    }

    //订货端商品操作（商品搜索,进入商品想起，加入意见商品到购物车，加入收藏，进入收藏列表，搜索，进入上详情 ）
    public void testAgentGoods(int k) throws Exception {
        if (k == 0)
            driver.findElement(By.linkText("商品")).click();
        if (k == 1)
            driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("苹果2");
        driver.findElement(By.id("op-search")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id='productEntries']/tr/td[1]/div/a[2]")).click();
        ChangWebDriver.switchToWindow("商品详情", driver);//用于切换窗口的
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[1]/input")).sendKeys("2");
        driver.findElement(By.cssSelector("#addtocart > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#addtofav > span")).click();
        driver.findElement(By.className("shopCart")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("清空购物车")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.linkText("商品")).click();
        driver.findElement(By.linkText("商品收藏夹")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("苹果2");
        driver.findElement(By.id("op-search")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img.product-img")).click();
        ChangWebDriver.switchToWindow("商品详情", driver);//用于切换窗口的
        driver.findElement(By.cssSelector("#addtofav > span")).click();
        Thread.sleep(1000);
    }

    //关闭或开启资金账号
    public void closeOpenFund() throws Exception {

        Thread.sleep(1000);
        WebElement main = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.container','.setting').show()", main);
        Thread.sleep(1000);
        driver.findElement(By.linkText("系统设置")).click();
        Thread.sleep(1000);
        js.executeScript("$('#myForm > div > div > div:nth-child(8) > div > div.control-input > div > span > label').click()");
        driver.findElement(By.xpath("//button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();//回到首页操作
    }

    //资金账号初始化
    public void fundInitialize() {
        driver.findElement(By.linkText("资金")).click();
        driver.findElement(By.name("searchValue")).clear();
        driver.findElement(By.name("searchValue")).sendKeys("测试");
        driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
        driver.findElement(By.linkText("初始化")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();
    }

    //资金账号充值(前期是开启资金账号与初始化)
    public void fundRecharge() {
        driver.findElement(By.linkText("资金")).click();
        driver.findElement(By.name("searchValue")).clear();
        driver.findElement(By.name("searchValue")).sendKeys("测试");
        driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
        driver.findElement(By.linkText("充值")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("payTime")).click();
        driver.findElement(By.linkText("19")).click();
        driver.findElement(By.id("money")).clear();
        driver.findElement(By.id("money")).sendKeys("2000");
        driver.findElement(By.id("remark")).clear();
        driver.findElement(By.id("remark")).sendKeys("预付款账号充值备注。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        driver.findElement(By.xpath("/html/body/div[1]/h1/a/img")).click();
    }

    //资金账号扣款
    public void backRecharge() {
        driver.findElement(By.linkText("资金")).click();
        driver.findElement(By.name("searchValue")).clear();
        driver.findElement(By.name("searchValue")).sendKeys("测试");
        driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
        driver.findElement(By.linkText("扣款")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("payTime")).click();
        driver.findElement(By.linkText("16")).click();
        driver.findElement(By.id("money")).clear();
        driver.findElement(By.id("money")).sendKeys("250");
        driver.findElement(By.id("remark")).clear();
        driver.findElement(By.id("remark")).sendKeys("资金账号扣款备注。。。。" + this.getDate());
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
    }

    //红冲（初始化资金账号、资金充值、资金扣款等资金操作后才可以操作红冲）
    public void hongChong() {
        driver.findElement(By.linkText("资金")).click();
        driver.findElement(By.name("searchValue")).clear();
        driver.findElement(By.name("searchValue")).sendKeys("测试");
        driver.findElement(By.cssSelector("div.ui-btn.ui-btn-default")).click();
        driver.findElement(By.linkText("收支明细")).click();
        driver.findElement(By.linkText("详情")).click();
        driver.findElement(By.linkText("红冲")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
    }

    //订单付款（基于订单完成的货端付款）
    public void orderPay() throws Exception {
        driver.findElement(By.linkText("订单")).click();
        driver.findElement(By.linkText("付款")).click();
        this.switchToWindow("订单付款", driver);
        driver.findElement(By.linkText("线下支付")).click();
        driver.findElement(By.id("payTime")).click();
        driver.findElement(By.linkText("18")).click();
        driver.findElement(By.id("remark")).clear();
        driver.findElement(By.id("remark")).sendKeys("这是订单付款的备注。。。。" + this.getDate());
        Thread.sleep(1000);
        driver.findElement(By.linkText("立即支付")).click();
        // driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        this.switchToWindow("订货单列表", driver);
    }

    //订单付款后的收款确认
    public void confirmPay() throws Exception {
        driver.findElement(By.linkText("资金")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        driver.findElement(By.linkText("收款确认")).click();
        driver.findElement(By.linkText("确认收款")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();

    }

    //添加银行账号
    public void addBankAccount() throws Exception {
        //  driver.findElement(By.linkText("资金")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        Thread.sleep(1000);
        driver.findElement(By.linkText("银行账号")).click();
        driver.findElement(By.id("addBank")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("bankAccountName")).clear();
        driver.findElement(By.id("bankAccountName")).sendKeys("自动化测试银行账号");
        driver.findElement(By.id("bankName")).clear();
        driver.findElement(By.id("bankName")).sendKeys("易订货银行");
        driver.findElement(By.id("bankAccount")).clear();
        driver.findElement(By.id("bankAccount")).sendKeys("7896564546545877978");
        driver.findElement(By.id("saveBank")).click();
    }

    //删除银行账号
    public void deleteBankAccount() throws Exception {
        driver.findElement(By.linkText("资金")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        driver.findElement(By.linkText("银行账号")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[3]/table/tbody/tr[2]/td[4]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
    }

    //发货统计（这里面包含了收支明细、订单收款统计显示查看操作）
    public void statisticsDeliverGoods() throws Exception {
        driver.findElement(By.linkText("资金")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        driver.findElement(By.linkText("收支明细")).click();
        Thread.sleep(2000);
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        driver.findElement(By.linkText("订单收款统计")).click();
        Thread.sleep(2000);
        js.executeScript("$('.side-menu-a').eq(3).trigger('mouseenter')");
        driver.findElement(By.linkText("发货统计")).click();
        driver.findElement(By.id("report_dateFrom")).click();
        driver.findElement(By.linkText("1")).click();
        driver.findElement(By.id("report_dateTo")).click();
        driver.findElement(By.linkText("30")).click();
        driver.findElement(By.id("queryContent")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("更多查询条件")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[2]/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[2]/div/div[2]/input")).sendKeys("测试");
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[5]/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[4]/div[5]/div/div[2]/input")).sendKeys("牛排");
        driver.findElement(By.id("queryContent")).click();
        Thread.sleep(2000);
    }

    //订货端资金账号充值
    public void testAgentFundRecharge() throws Exception {
        driver.findElement(By.linkText("资金")).click();
        driver.findElement(By.linkText("充值")).click();
        this.switchToWindow("账号充值", driver);
        driver.findElement(By.linkText("线下支付")).click();
        driver.findElement(By.name("txtOfflineRechargeMoney")).clear();
        driver.findElement(By.name("txtOfflineRechargeMoney")).sendKeys("888");
        driver.findElement(By.id("payTime")).click();
        driver.findElement(By.linkText("17")).click();
        driver.findElement(By.id("remark")).clear();
        driver.findElement(By.id("remark")).sendKeys("订货端资金账号充值。。。。" + this.getDate());
        Thread.sleep(1000);
        driver.findElement(By.linkText("立即充值")).click();
    }

    //客户级别设置
    public void testClientlevel() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("客户级别设置")).click();
        driver.findElement(By.cssSelector("button.ui-btn.ui-btn-theme")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("newName")).clear();
        driver.findElement(By.id("newName")).sendKeys(this.getRandomString(3) + "级别");
        driver.findElement(By.id("discountrate")).clear();
        driver.findElement(By.id("discountrate")).sendKeys("85");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        Thread.sleep(1000);
    }

    //客户级别修改
    public void testModifyClientlevel() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("客户级别设置")).click();
        driver.findElement(By.linkText("修改")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("newName")).clear();
        driver.findElement(By.id("newName")).sendKeys("修改" + this.getRandomString(3));
        driver.findElement(By.id("discountrate")).clear();
        driver.findElement(By.id("discountrate")).sendKeys("82");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input.ui_state_highlight")).click();
        Thread.sleep(1000);
    }

    //删除客户级别
    public void testDeleteClientlevel() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("客户级别设置")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody[2]/tr[1]/td[3]/span/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(1000);
    }

    //客户级别置顶
    public void testTopClientlevel() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("客户级别设置")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/table/tbody[2]/tr[1]/td[3]/span/a[3]")).click();
        Thread.sleep(1000);
    }

    //客户加盟信息查看
    public void testSeeClientMessage() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("加盟信息")).click();
        driver.findElement(By.linkText("详情")).click();
        driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    }

    //新增/删除归属区域(不做二级级二级以下的新增归属区域)
    public void testAddArea() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(1).trigger('mouseenter')");
        driver.findElement(By.linkText("归属区域设置")).click();
        driver.findElement(By.className("icon-plus")).click();
        driver.findElement(By.name("typeName")).clear();
        driver.findElement(By.name("typeName")).sendKeys("测试区域");
        driver.findElement(By.linkText("保存")).click();
        driver.findElement(By.cssSelector("#typeManage > div:nth-child(1) > span > a.deleteType")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(1000);
    }

    //新增客户
    public void testAddClient(int i) throws Exception {
        driver.findElement(By.linkText("客户")).click();
        driver.findElement(By.linkText("新增")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(this.getRandomString(4) + "客户" + i);
        driver.findElement(By.id("code")).clear();
        driver.findElement(By.id("code")).sendKeys(this.getRandomString(8));
        driver.findElement(By.name("countryName")).click();
        driver.findElement(By.cssSelector("div.list-item.on")).click();//中国
        driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[3]/span/i")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[3]/div/div[14]")).click();//江西
        driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[4]/span/i")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[4]/div/div[11]")).click();//上饶
        driver.findElement(By.xpath("//div[@id='sel-city']/div[2]/div/div[5]/span/i")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[5]/div/div[9]")).click();//鄱阳
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("油墩街镇松甫村66号");
        driver.findElement(By.xpath("//*[@id='customRegion']/i")).click();
        driver.findElement(By.xpath("//*[@id='form1']/div[1]/div/div[1]/div[5]/div[2]/div/div/div[1]")).click();
        driver.findElement(By.name("zipcode")).clear();
        driver.findElement(By.name("zipcode")).sendKeys("333119");
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("18607099149");
        driver.findElement(By.xpath("//*[@id='customerTypeName']/i")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[6]/div[1]/div[2]")).click();//普通客户级别位于第二个
        driver.findElement(By.id("contactor")).clear();
        driver.findElement(By.id("contactor")).sendKeys("测试");
        driver.findElement(By.name("position")).clear();
        driver.findElement(By.name("position")).sendKeys("测试工程师");
        driver.findElement(By.id("mobileNum")).clear();
        driver.findElement(By.id("mobileNum")).sendKeys("18607099149");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("164553538@qq.com");
        driver.findElement(By.name("qq")).clear();
        driver.findElement(By.name("qq")).sendKeys("164553538");
        driver.findElement(By.xpath("//*[@id='activeCustomer']")).click();
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("cskh" + this.getRandomString(4));
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmpwd")).clear();
        driver.findElement(By.id("confirmpwd")).sendKeys("123456");
        driver.findElement(By.id("bank")).clear();
        driver.findElement(By.id("bank")).sendKeys("招商银行测试支行");
        driver.findElement(By.id("bankAccount")).clear();
        driver.findElement(By.id("bankAccount")).sendKeys("555555555555666");
        driver.findElement(By.id("taxNum")).clear();
        driver.findElement(By.id("taxNum")).sendKeys("78977");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='form1']/div[2]/button[1]")).click();
        Thread.sleep(2000);
    }

    //修改客户
    public void testModifyClient(int i) throws Exception {
        driver.findElement(By.linkText("客户")).click();
        driver.findElement(By.linkText("修改")).click();
        this.switchToWindow("修改客户", driver);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("测试修改代理商" + i);
        driver.findElement(By.id("code")).clear();
        driver.findElement(By.id("code")).sendKeys("haha4" + i);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='form1']/div[2]/button[1]")).click();
        Thread.sleep(2000);
    }

    //删除客户
    public void testDeleteClient() throws Exception {
        driver.findElement(By.linkText("客户")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(2000);
    }

    //新增通知分类
    public void testAddNotifyClass() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("通知分类管理")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div/a")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("noticeTypeName")).clear();
        driver.findElement(By.id("noticeTypeName")).sendKeys("分类" + this.getRandomString(4));
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(3000);
    }

    //通知置顶
    public void testTopNotifyClass() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("通知分类管理")).click();
        //三个分类置顶三次，回复初始顺序
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[3]")).click();//置顶第三个分类
        Thread.sleep(2000);
    }

    //通知修改(修改第三个分类)
    public void testModifyNotifyClass() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("通知分类管理")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[1]")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.id("noticeTypeName")).clear();
        driver.findElement(By.id("noticeTypeName")).sendKeys("修改通知分类");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(3000);
    }

    //删除通知分类(删除第三个分类)
    public void testDeleteNotifyClass() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("通知分类管理")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[3]/td[2]/a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(2000);
    }

    //新增通知公告(富文本内容)
    public void testNewNotify() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/div[1]/a")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("测试通知" + this.getRandomString(3));
        driver.findElement(By.xpath("//*[@id='noticeTypeCombo']/span")).click();
        driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[3]/div[1]/div[1]")).click();
        driver.switchTo().frame("ueditor_0");
        driver.findElement(By.xpath("/html/body")).clear();
        driver.findElement(By.xpath("/html/body")).sendKeys(this.getDate() + "\t  测试通知公告的内容\n    \t" + this.getRandomString(115));
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id='myForm']/div[1]/div[2]/div/div[5]/div[2]/label[1]")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div[1]/div[2]/div/div[5]/div[2]/label[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='myForm']/div[2]/button[1]")).click();
        Thread.sleep(2000);
    }

    //删除通知
    public void testDeleteNotify() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[5]/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(2000);
    }

    //管理端订单其他操作
    public void testMakeNotify() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[1]/a")).click();//查看详情
        Thread.sleep(2000);
        driver.findElement(By.linkText("返回")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();//查看已读
        Thread.sleep(2000);
    }

    //订货端订单查看操作
    public void testAgentMakeNotify() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();//查看详情
        Thread.sleep(2000);
        driver.findElement(By.linkText("返回")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id='myForm']/div/div[2]/table/tfoot/tr/td[1]/label/input")).click();
        driver.findElement(By.linkText("标为已读")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        driver.findElement(By.linkText("通知")).click();
        Thread.sleep(1000);
    }

    //订货端向管理端提交反馈意见（所有操作）
    public void testAgentToAdminSuggest(int i) throws Exception {//这里设置参数是为了区分是首次登陆还是再次登录弹出的绑定信息和弹出系统公告
        if (i == 0) {
            this.login("ku123456", "123456");
            this.closeBoundMessage();
            this.closeSystemInform();
        }
        if (i == 1) {
            this.login("autotest1", "123456");
            this.closeBoundMessage();
        }
        if (i == 3) {
            this.login("ku123456", "123456");
        }
        if (i == 4) {
            this.login("autotest1", "123456");
        }
        driver.findElement(By.linkText("反馈")).click();
        driver.findElement(By.name("sendContentYdh")).clear();
        driver.findElement(By.name("sendContentYdh")).sendKeys(this.getDate() + "自动化测试反馈意见。。。。。。" + this.getRandomString(24));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[1]/a")).click();
        this.logout2();
        if (i == 0 || i == 3)
            this.login("310007707", "123456");
        if (i == 1 || i == 4)
            this.login("310021564", "123456");
        driver.findElement(By.linkText("通知")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("客户反馈")).click();
        driver.findElement(By.linkText("立即回复")).click();
        driver.findElement(By.name("replyContent")).clear();
        driver.findElement(By.name("replyContent")).sendKeys(this.getDate() + "管理端回复订货单反馈意见。。。。。。" + this.getRandomString(26));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/dd/div[2]/button")).click();
        Thread.sleep(2000);
        this.logout();
        if (i == 0 || i == 3) {
            this.login("ku123456", "123456");
            //this.closeBoundMessage();
            //this.closeSystemInform();
        }
        if (i == 1 || i == 4) {
            this.login("autotest1", "123456");
            // this.closeBoundMessage();
        }
        driver.findElement(By.linkText("反馈")).click();
        driver.findElement(By.linkText("未解决，继续提问")).click();
        driver.findElement(By.name("replyContent")).clear();
        driver.findElement(By.name("replyContent")).sendKeys(this.getDate() + "订货端向管理端继续提问。。。。。。。 ");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/dd/div[2]/button")).click();
        this.logout2();
        if (i == 0 || i == 3)
            this.login("310007707", "123456");
        if (i == 1 || i == 4)
            this.login("310021564", "123456");
        driver.findElement(By.linkText("通知")).click();
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("客户反馈")).click();
        driver.findElement(By.linkText("立即回复")).click();
        driver.findElement(By.name("replyContent")).clear();
        driver.findElement(By.name("replyContent")).sendKeys(this.getDate() + "管理端再次回复订货端继续提问反馈意见。。。。。。");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[1]/dd/div[2]/button")).click();
        Thread.sleep(2000);
        this.logout();
        if (i == 0 || i == 3) {
            this.login("ku123456", "123456");
            //this.closeBoundMessage();
            //this.closeSystemInform();
        }
        if (i == 1 || i == 4) {
            this.login("autotest1", "123456");
            // this.closeBoundMessage();
        }
        driver.findElement(By.linkText("反馈")).click();
        driver.findElement(By.linkText("已解决")).click();
        Thread.sleep(5000);
    }

    //管理端删除订货端反馈意见
    public void testDeleteSuggest() throws Exception {
        driver.findElement(By.linkText("通知")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.side-menu-a').eq(4).trigger('mouseenter')");
        driver.findElement(By.linkText("客户反馈")).click();
        driver.findElement(By.linkText("删除")).click();
        driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/div/input[1]")).click();
        Thread.sleep(2000);

    }

    //管理端向铱云系统反馈意见
    public void testToSystemSuggest() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("$('.container','.headerService').show()");
        Thread.sleep(1000);
        driver.findElement(By.linkText("意见反馈")).click();
        driver.findElement(By.name("sendContent")).clear();
        driver.findElement(By.name("sendContent")).sendKeys(this.getDate() + "管理端向铱云系统返回意见测试。。。");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/button")).click();
        Thread.sleep(2000);
    }

    //订货端向铱云系统反馈意见
    public void testAgentToSystemSuggest() throws Exception {
        driver.findElement(By.linkText("反馈")).click();
        driver.findElement(By.linkText("我要反馈")).click();
        driver.findElement(By.name("sendContentAdmin")).clear();
        driver.findElement(By.name("sendContentAdmin")).sendKeys(this.getDate() + "订货端向铱云系统反馈意见测试。。。。。。\n" + this.getRandomString(24));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
    }


    //关闭弹出绑定手机号码提示
    public void closeBoundMessage() {
        driver.findElement(By.linkText("取消")).click();
    }

    //关闭系统通知
    public void closeSystemInform() {
        driver.findElement(By.linkText("×")).click();
    }

    //随机生成一个字符串（主要用于新增一些内容时 使用）
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

    //获取当前时间
    public String getDate() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss");//设置时间格式
        String time = format.format(date);
        return time;
    }

    //方法说明：查找页面上的元素，轻易不要使用会很影响效率，使用方法     isElementPresent(By.xpath(String))
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

package Selenium_Web_YDH;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
/**
 * @author  铱云测试组
 * @time    2015年12月7日
 * @see     易订货自动化测试图形化用户界面（一个测试用例一个按钮）
 * @version V1.0
 * @since   预期实现一套完整的系统，捕获异常截图和生产测试报告 
 */ 

public class YDH_Admin_Panel extends JFrame implements ActionListener {
	JButton an,an1, an2, an3, an4,an5, an_login,an_logout,buttton_logo;
	
	JButton //浏览器启动与关闭
	         button_startBrower,button_endBrower,
	         //登录注册模块
	         button_mob_login,button_help_login,button_id_login,button_agent_login,button_staff_login,
	         button_enroll,button_find_password,button_find_username,
	         //管理端订货单
	         button_order_replaceAgent,//代下单   增
	         button_order_check,button_order_finance_check,button_order_warehouseOut_check,button_order_diliverGoods_check,//订单审核
	         button_order_back,button_order_cancelDelete,button_order_delete,//删除
	         button_order_goodRemark,//商品备注
	         button_order_modify,button_order_addNote,button_order_modifyAddress,//修改
	         //管理端退货单
	         button_return_order_replaceAgent,//  增  代下单
	         button_return_order_check,button_return_order_defind,button_return_order_refund,  //退货单审核
	         button_return_order_back,button_return_order_cancelDelete,button_return_order_delete,   //删除
	         button_return_order_addNote,    //修改
	         //订货单订货单
	         button_order_new,button_order_shopCat, button_orderPay, //新增
	         button_order_agentModifyAddress,button_order_agentAddNote,button_order_agentCancel,//修改 与作废
	         //订货端退货单
	         button_return_order_new,button_return_order_agentShopCat,
	         button_return_order_agentAddNote,button_return_order_agentCancel,
	         //订单的搜索（这里主要是管理端测试搜索功能，后期完善订货端 的功能）
	         button_order_search,button_order_advancedSearch,
	         //商品按钮
	         button_newGood,button_showGood,button_deleteGood,button_modifyGood,button_shareGood,button_searchGood,button_AddUnit,
	         //商品分类
	         button_newRootSort,button_newNextsort,button_deleteSort,button_seeNextSort,button_modifySort,
	         //商品库存
	         button_SearchWareHouse,button_Procurement,//采购入库
	         button_inWareHouse,button_sellOut,button_outWareHouse,
	         //商品促销
	         button_addSaleDiscount,button_addSaleDiscount2,button_addSalePromotion,button_addSalePresent,
	         //订单促销
	         button_addOrderSaleDiscount,button_addOrderSaleDiscount2,button_addOrderSalePromotion,button_addOrderSalePresent,
	         //订货端商品操作       
	         button_agentGoods,
	         //资金模块
	         button_fundOpen,button_fundInitialize,button_fundRecharge,button_backRecharge,button_hongchong,button_confirmPay,
	         button_addBankAccount,button_deleteBankAccount,button_statisticsDeliverGoods,button_agentFundRecharge,
	         //系统反馈意见
	         button_toSystemSuggest,button_agentToSystemSuggest,
	         //订货端向管理段反馈意见
	         button_agentToAdminSuggest,button_deleteSuggent,	         
	         //客户
	         button_addClient,button_modifyClient,Button_deleteClient,button_addClientlevel,button_modifyClientlevel,
	         button_deleteClientlevel,button_topClientlevel,button_seeClientMessage,button_addOrdeleteArea,
	         //通知模块
	         button_newNotify,button_deleteNotify,button_makeNotify,button_agentMakeNotify,button_addNotifyClass,
	         button_topNotifyClass,button_modifyNotifyClass,button_deletrNotifyClass,
	         //一键操作
	         button_testAll,button_productAll,
	         button_allGoods,button_allOrder,button_allClient,button_allSuggest,button_allfund,button_allNotify,
	         button_allGoodSale,button_allOrderSala,button_allGroupSale
	         ;
	JPanel panel_logo,panel_order,panel_goods,panel_fund,panel_notify,
	       panel_seting,panel_sala,panel_report,panel_agent,panel_oneKeyRun,panel_orther,
	       panel_login_enroll,panel_order_product,panel_order_agent;
	JLabel label_logo,label_chooseBrower,label_firefox,label_chrome,label_IE,label_choose_environment,
	       label_dinghuoduan,label_guanliduan;
    JTabbedPane xxk;//建立一个选项卡
    JRadioButton g1,g2,g3,en1,en2;//单选按钮
    ButtonGroup gg,ee;//单选按钮放入一个组，默认一个组里面只能选一个按钮
    int  browser=0;//用于记录选择的浏览器
    int  setting=0;//测试与生产环境选择
	public static void main(String[] args) {
		YDH_Admin_Panel lx = new YDH_Admin_Panel();
	}

	public YDH_Admin_Panel() {
		
		
		
	  //面板设置
	
		panel_logo=new JPanel();
	
		panel_order=new JPanel();
		panel_order.setLayout(new  GridLayout(1,2));
	
		panel_agent=new JPanel();
		panel_fund=new JPanel();
		panel_notify=new JPanel();
		panel_goods=new JPanel();
		panel_sala=new JPanel();
		panel_report=new JPanel();
		panel_seting=new JPanel();
		panel_oneKeyRun=new JPanel();
		panel_orther=new JPanel();
		
	    //Image im1= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/管理端01.jpg"));
	    //Image im2= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/订货端01.jpg"));
	    //Image im3= Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/denglu.png"));
	    panel_login_enroll=new JPanel();
		panel_order_product=new JPanel();
		//panel_order_product.repaint();
		panel_order_agent=new JPanel();
		//panel_order_agent.repaint();
		panel_order.add(panel_order_product);
		panel_order.add(panel_order_agent);
		
		//标签设置
		label_logo=new JLabel(new ImageIcon("image/yidinghuo_head4.gif"));		
		label_chooseBrower=new JLabel("  选择浏览器:",JLabel.RIGHT);
		label_chooseBrower.setForeground(Color.red);
		label_chooseBrower.setFont(new Font("幼圆",Font.BOLD,24));
		label_firefox=new JLabel(new ImageIcon("image/firefox_logo.png"));
		label_chrome=new JLabel(new ImageIcon("image/chrome_logo.png"));
		label_IE=new JLabel(new ImageIcon("image/IE_logo.png"));
		label_choose_environment=new JLabel("选择环境:",JLabel.RIGHT);
		label_choose_environment.setForeground(Color.red);
		label_choose_environment.setFont(new Font("幼圆",Font.BOLD,24));
		label_guanliduan=new JLabel(new ImageIcon("image/guanliduan.gif"));
		label_dinghuoduan=new JLabel(new ImageIcon("image/dinghuoduan.gif"));
		
		//浏览器选择复选框设置
		g1=new JRadioButton("FireFox",true);//默认选择FireFox浏览器
		g2=new JRadioButton("Chrome");
		g3=new JRadioButton("IE 11");
		gg=new ButtonGroup();
		gg.add(g1);
		gg.add(g2);
		gg.add(g3);
		g1.setFont(new Font("幼圆",Font.BOLD,15));
		g2.setFont(new Font("幼圆",Font.BOLD,15));
		g3.setFont(new Font("幼圆",Font.BOLD,15));
		
		
		
		//环境选择复选框设置
		en1=new JRadioButton("生产");
		en2=new JRadioButton("测试   ",true);
		ee=new ButtonGroup();
		ee.add(en1);
		ee.add(en2);
		en1.setFont(new Font("幼圆",Font.BOLD,20));
		en2.setFont(new Font("幼圆",Font.BOLD,20));
		
		//浏览器启动与关闭
		button_startBrower=new JButton("START");
		button_endBrower=new JButton("END");
		button_startBrower .setFont(new Font("宋体", 1, 10));
	    button_startBrower.setBackground(Color.red);
	    button_endBrower .setFont(new Font("宋体", 1, 10));
	    button_endBrower.setBackground(Color.red);
	    
	    
	    //一键操作
	    button_allGoods=new JButton("一键商品");
	    button_allGoods.setFont(new Font("幼圆", 1, 18));
	    button_allGoods.setBackground(Color.cyan);	    
	    button_allOrder=new JButton("一键订单");
	    button_allOrder.setFont(new Font("幼圆", 1, 18));
	    button_allOrder.setBackground(Color.cyan);
	    button_allClient=new JButton("一键客户");
	    button_allClient.setFont(new Font("幼圆", 1, 18));
	    button_allClient.setBackground(Color.cyan); 
	    button_allSuggest=new JButton("一键反馈意见");
	    button_allSuggest.setFont(new Font("幼圆", 1, 12));
	    button_allSuggest.setBackground(Color.cyan);
	    button_allfund=new JButton("一键资金账号");
	    button_allfund.setFont(new Font("幼圆", 1, 12));
	    button_allfund.setBackground(Color.cyan);
	    button_allNotify=new JButton("一键通知公告");
	    button_allNotify.setFont(new Font("幼圆", 1, 12));
	    button_allNotify.setBackground(Color.cyan);
	    button_allGoodSale=new JButton("一键商品促销");
	    button_allGoodSale.setFont(new Font("幼圆", 1, 12));
	    button_allGoodSale.setBackground(Color.cyan);
	    button_allOrderSala=new JButton("一键订单促销");
	    button_allOrderSala.setFont(new Font("幼圆", 1, 12));
	    button_allOrderSala.setBackground(Color.cyan);
	    button_allGroupSale=new JButton("一键组合促销");
	    button_allGroupSale.setFont(new Font("幼圆", 1, 12));
	    button_allGroupSale.setBackground(Color.cyan);
		
		//注册登录模块
		button_enroll=new JButton("注册");
		button_agent_login=new JButton("代理商登录");
		button_help_login=new JButton("账号助手登录");
		button_id_login=new JButton("管理端ID登录");
		button_mob_login=new JButton("手机号码登录");
		button_staff_login=new JButton("员工登录");
		button_find_password=new JButton("找回密码");
		button_find_username=new JButton("找回用户名");
		
		//管理端订货单按钮设置		
		button_order_replaceAgent=new JButton("管理端代下订单");
		button_order_check=new JButton("订单审核");
		button_order_finance_check=new JButton("财务审核");
		button_order_warehouseOut_check=new JButton("出库审核");
		button_order_diliverGoods_check=new JButton("发货确认");
		button_order_back=new JButton("订单退回");
		button_order_cancelDelete=new JButton("管理端订单作废删除");
		button_order_delete=new JButton("订单删除");
		button_order_modify=new JButton("订单修改");
		button_order_addNote=new JButton("管理端订单备注");
		button_order_modifyAddress=new JButton("管理端修改订单地址");
		button_order_goodRemark=new JButton("订单商品备注");
		
		
		
        //管理端实现订单搜索测试
		button_order_advancedSearch=new JButton("订单高级搜索");
		button_order_search=new JButton("订单搜索");//这里要实现‘搜索订货单’，‘搜索退或单’，‘搜客户搜’，‘搜商品’，‘搜库存’
		
		button_return_order_replaceAgent=new JButton("管理端代下退单");  
		button_return_order_check=new JButton("退单审核");
		button_return_order_defind=new JButton("退货确认");
		button_return_order_refund=new JButton("退款确认");
		button_return_order_back=new JButton("退货单退回");
		button_return_order_cancelDelete=new JButton("退单作废删除");	
		//button_return_order_delete=new JButton("退单删除");
		button_return_order_addNote=new JButton("管理端退单添加备注");
		
		//订货端订单按钮设置		
		button_order_shopCat=new JButton("购物车下单");
		button_order_new=new JButton("新增订单");
		button_order_agentModifyAddress=new JButton("订货端修改订单地址");
		button_order_agentAddNote=new JButton("添加订单备注");
		button_order_agentCancel=new JButton("订货单订单作废");
		button_orderPay=new JButton("订单付款");
		//订货端订单按钮设置
		button_return_order_new=new JButton("新增退货单");
		button_return_order_agentShopCat=new JButton("购物车下退货单");
        button_return_order_agentAddNote=new JButton("退货单添加备注");
        button_return_order_agentCancel=new JButton("退货单作废");
        
        //商品按钮设置
        button_newGood=new JButton("新增商品");
        button_deleteGood=new JButton("删除商品");
        button_modifyGood=new JButton("修改商品");
        button_searchGood=new JButton("商品搜索");
        button_AddUnit=new JButton("新增商品单位");
        button_shareGood=new JButton("商品分享");
        button_SearchWareHouse=new JButton("搜商品库存");
        button_Procurement=new JButton("采购入库");
        button_outWareHouse=new JButton("其他出库");
        button_inWareHouse=new JButton("其他入库");
        button_sellOut=new JButton("销售出库");
        button_addSaleDiscount=new JButton("商品打折促销");
        button_addSalePromotion=new JButton("商品降价促销");
        button_addSalePresent=new JButton("商品买赠促销");
        button_addSaleDiscount2=new JButton("商品阶梯促销");
        button_addOrderSaleDiscount=new JButton("订单满折促销");
        button_addOrderSaleDiscount2=new JButton("订单阶梯促销");
        button_addOrderSalePromotion=new JButton("订单满减促销");
        button_addOrderSalePresent=new JButton("订单满赠促销");
        button_agentGoods=new JButton("订货端商品操作");
        
        //资金相关按钮
        button_fundOpen=new JButton("资金账号开关");
        button_fundInitialize=new JButton("初始化资金账号");
        button_fundRecharge=new JButton("资金充值");
        button_backRecharge=new JButton("资金扣款");
        button_hongchong=new JButton("红冲");
        button_confirmPay=new JButton("收款确认");
        button_addBankAccount=new JButton("新增银行账号");
        button_deleteBankAccount=new JButton("删除银行账号");
        button_statisticsDeliverGoods=new JButton("发货统计");
        button_agentFundRecharge=new JButton("订货端资金充值");
        //反馈意见
        button_agentToAdminSuggest=new JButton("订货端向管理段反馈意见");
        button_deleteSuggent=new JButton("删除反馈意见");
        button_toSystemSuggest=new JButton("管理端向系统反馈意见");
        button_agentToSystemSuggest=new JButton("订货端向系统反馈意见");
        //客户
        button_addClient=new JButton("新增客户");
        button_modifyClient=new JButton("修改客户");
        Button_deleteClient=new JButton("删除客户");
        button_addClientlevel=new JButton("添加客户级别");
        button_modifyClientlevel=new JButton("修改客户级别");
        button_deleteClientlevel=new JButton("删除客户级别");
        button_topClientlevel=new JButton("置顶客户级别");
        button_seeClientMessage=new JButton("查看加盟信息");
        button_addOrdeleteArea=new JButton("增/删客户区域");
        //通知
        button_newNotify=new JButton("新增通知公告");
        button_deleteNotify=new JButton("删除通知公告");
        button_makeNotify=new JButton("管理端查看通知");
        button_agentMakeNotify=new JButton("订货端查看通知");
        button_addNotifyClass=new JButton("添加通知分类");
        button_topNotifyClass=new JButton("置顶通知分类");
        button_modifyNotifyClass=new JButton("修改通知分类");
        button_deletrNotifyClass=new JButton("删除通知分类");
        //一键操作
        button_testAll=new JButton("测试环境一键所有操作");
        button_productAll=new JButton("生产环境一键所有操作");
        
		
		//选项卡设置
		xxk=new JTabbedPane();
		xxk.setBackground(Color.CYAN);
		xxk.setFont(new Font("幼圆",Font.BOLD,21));
		xxk.add("注册登录",panel_login_enroll);
		xxk.add("订单",panel_order);
		xxk.add("商品",panel_goods);
		xxk.add("资金",panel_fund);
		xxk.add("客户",panel_agent);	
		xxk.add("通知/报表/设置",panel_notify);
		//xxk.add("报表",panel_report);
		//xxk.add("设置",panel_seting);
		//xxk.add("促销",panel_sala);		
		//xxk.add("一键操作",panel_oneKeyRun);
		
		
		//注册登录面板设置
		//panel_login_enroll.setLayout(new GridLayout(5,5));//调整布局
		panel_login_enroll.add(button_enroll);
		panel_login_enroll.add(button_mob_login);
		panel_login_enroll.add(button_help_login);
		panel_login_enroll.add(button_id_login);
		panel_login_enroll.add(button_agent_login);
		panel_login_enroll.add(button_staff_login);
		panel_login_enroll.add(button_find_password);
		panel_login_enroll.add(button_find_username);
		
		
		//管理端订单面板设置
		//panel_order_product.setLayout(new GridLayout(5,5,8,8));//调整布局
		//panel_order_product.add(label_guanliduan);
		panel_order_product.add(button_order_search);
		panel_order_product.add(button_order_advancedSearch);
		//代下单
		panel_order_product.add(button_order_replaceAgent);
		panel_order_product.add(button_return_order_replaceAgent);
        //订货单审核
		panel_order_product.add(button_order_check);
		//panel_order_product.add(button_order_finance_check);
		//panel_order_product.add(button_order_diliverGoods_check);
		//panel_order_product.add(button_order_warehouseOut_check);
		//退货单审核
		panel_order_product.add(button_return_order_check);
		//panel_order_product.add(button_return_order_defind);
		//panel_order_product.add(button_return_order_refund);
		//订单改  删	
		panel_order_product.add(button_order_back);
		panel_order_product.add(button_order_cancelDelete);
		//panel_order_product.add(button_order_delete);
		panel_order_product.add(button_order_goodRemark);
		panel_order_product.add(button_order_modify);
		panel_order_product.add(button_order_addNote);
		panel_order_product.add(button_order_modifyAddress);
		panel_order_product.add(button_return_order_back);
		panel_order_product.add(button_return_order_cancelDelete);
		//panel_order_product.add(button_return_order_delete);
		panel_order_product.add(button_return_order_addNote);
		panel_order_product.add(button_allOrder);
		//订货端订单面板设置
		//panel_order_agent.setLayout(new GridLayout(5,5,8,8));//调整布局
		//panel_order_agent.add(label_dinghuoduan);
		panel_order_agent.add(button_order_shopCat);
		panel_order_agent.add(button_return_order_agentShopCat);
		panel_order_agent.add(button_order_new);
		panel_order_agent.add(button_return_order_new);
		panel_order_agent.add(button_order_agentModifyAddress);
		panel_order_agent.add(button_order_agentAddNote);
		panel_order_agent.add(button_order_agentCancel);
		panel_order_agent.add(button_return_order_agentAddNote);
		panel_order_agent.add(button_return_order_agentCancel);	
		panel_order_agent.add(button_orderPay);
		
		
		//orther面板设置
		//panel_orther.setLayout(new GridLayout(1,10));//调整布局
		panel_orther.add(label_choose_environment);
		panel_orther.add(en2);
		panel_orther.add(en1);
		panel_orther.add(label_chooseBrower);
		panel_orther.add(label_firefox);
		panel_orther.add(g1);
		panel_orther.add(label_chrome);
		panel_orther.add(g2);
		panel_orther.add(label_IE);
		panel_orther.add(g3);
		//panel_orther.add(button_startBrower);
		//panel_orther.add(button_endBrower);
		
		//商品面板设置
		panel_goods.add(button_newGood);
		panel_goods.add(button_deleteGood);
		panel_goods.add(button_modifyGood);
		panel_goods.add(button_searchGood);
		panel_goods.add(button_AddUnit);
		panel_goods.add(button_shareGood);
		panel_goods.add(button_SearchWareHouse);
		panel_goods.add(button_Procurement);		
		panel_goods.add(button_inWareHouse);
		panel_goods.add(button_sellOut);
		panel_goods.add(button_outWareHouse);
		panel_goods.add(button_addSaleDiscount);
		panel_goods.add(button_addSalePromotion);
		panel_goods.add(button_addSalePresent);
		panel_goods.add(button_addSaleDiscount2);
		panel_goods.add(button_addOrderSaleDiscount);
		panel_goods.add(button_addOrderSaleDiscount2);
		panel_goods.add(button_addOrderSalePresent);
		panel_goods.add(button_addOrderSalePromotion);
		panel_goods.add(button_agentGoods);
		panel_goods.add(button_allGoods);
		panel_goods.add(button_allGoodSale);
		panel_goods.add(button_allOrderSala);
		panel_goods.add(button_allGroupSale);
		//资金管理面板设置
		panel_fund.add(button_fundOpen);
		panel_fund.add(button_fundInitialize);
		panel_fund.add(button_fundRecharge);
		panel_fund.add(button_backRecharge);
		panel_fund.add(button_hongchong);
		panel_fund.add(button_confirmPay);
		panel_fund.add(button_addBankAccount);
		panel_fund.add(button_deleteBankAccount);
		panel_fund.add(button_statisticsDeliverGoods);
		panel_fund.add(button_agentFundRecharge);
		panel_fund.add(button_allfund);
		//反馈意见
		panel_notify.add(button_agentToAdminSuggest);
		panel_notify.add(button_deleteSuggent);
		panel_notify.add(button_toSystemSuggest);
        panel_notify.add(button_agentToSystemSuggest);
		
		//客户
		panel_agent.add(button_addClient);
		panel_agent.add(button_modifyClient);
		panel_agent.add(Button_deleteClient);
		panel_agent.add(button_addClientlevel);
		panel_agent.add(button_modifyClientlevel);
		panel_agent.add(button_deleteClientlevel);
		panel_agent.add(button_topClientlevel);
		panel_agent.add(button_seeClientMessage);
		panel_agent.add(button_addOrdeleteArea);
		panel_agent.add(button_allClient);
		//通知
		panel_notify.add(button_newNotify);
		panel_notify.add(button_deleteNotify);
		panel_notify.add(button_makeNotify);
		panel_notify.add(button_agentMakeNotify);
		panel_notify.add(button_addNotifyClass);
		panel_notify.add(button_topNotifyClass);
		panel_notify.add(button_modifyNotifyClass);
		panel_notify.add(button_deletrNotifyClass);
		panel_notify.add(button_allNotify);
		panel_notify.add(button_allSuggest);
        //一键操作
		panel_oneKeyRun.add(button_testAll);
		panel_oneKeyRun.add(button_productAll);
		
		
		
		//容器设置
		this.add(label_logo,BorderLayout.NORTH);
		this.add(xxk,BorderLayout.CENTER);
		this.add(panel_orther,BorderLayout.SOUTH);
		
		
        //按钮监控处理
		//浏览器启动关闭
		button_startBrower.addActionListener(this);
		button_startBrower.setActionCommand("启动浏览器");
		button_endBrower.addActionListener(this);
		button_endBrower.setActionCommand("关闭浏览器");			
		//登录注册模块
		button_enroll.addActionListener(this);//this 是指一个类
		button_enroll.setActionCommand("注册");// 按钮标示区别按钮
		button_help_login.addActionListener(this);
		button_help_login.setActionCommand("账号助手登录");
		button_mob_login.addActionListener(this);
		button_mob_login.setActionCommand("手机号码登录");
		button_id_login.addActionListener(this);
		button_id_login.setActionCommand("管理端ID登录");
		button_agent_login.addActionListener(this);
		button_agent_login.setActionCommand("代理商登录");
		button_staff_login.addActionListener(this);
		button_staff_login.setActionCommand("员工登录");
		button_find_password.addActionListener(this);
		button_find_password.setActionCommand("找回密码");
		button_find_username.addActionListener(this);
		button_find_username.setActionCommand("找回用户名");
		//订单模块
		button_order_search.addActionListener(this);
		button_order_search.setActionCommand("订单搜索");
		button_order_advancedSearch.addActionListener(this);
		button_order_advancedSearch.setActionCommand("订单高级搜索");
		
		button_order_replaceAgent.addActionListener(this);
		button_order_replaceAgent.setActionCommand("管理端代下订单");
		button_order_shopCat.addActionListener(this);
		button_order_shopCat.setActionCommand("购物车下单");
		button_return_order_agentShopCat.addActionListener(this);
		button_return_order_agentShopCat.setActionCommand("购物车下退货单");
		button_order_check.addActionListener(this);
		button_order_check.setActionCommand("订单审核");
		button_return_order_check.addActionListener(this);
		button_return_order_check.setActionCommand("退单审核");
		button_return_order_replaceAgent.addActionListener(this);
		button_return_order_replaceAgent.setActionCommand("管理端代下退货单");	
		button_order_back.addActionListener(this);
		button_order_back.setActionCommand("订单退回");
		button_order_cancelDelete.addActionListener(this);
		button_order_cancelDelete.setActionCommand("管理端订单作废删除");
		button_return_order_cancelDelete.addActionListener(this);
		button_return_order_cancelDelete.setActionCommand("退单作废删除");
		button_order_goodRemark.addActionListener(this);
		button_order_goodRemark.setActionCommand("订单商品备注");
		button_order_addNote.addActionListener(this);
		button_order_addNote.setActionCommand("管理端订单备注");
		button_order_modify.addActionListener(this);
		button_order_modify.setActionCommand("订单修改");
		button_return_order_back.addActionListener(this);
		button_return_order_back.setActionCommand("退货单退回");
		button_return_order_addNote.addActionListener(this);
		button_return_order_addNote.setActionCommand("退货单备注");
		button_order_modifyAddress.addActionListener(this);
		button_order_modifyAddress.setActionCommand("管理端修改订单地址");
		button_order_new.addActionListener(this);
		button_order_new.setActionCommand("订货端新增订单");
		button_return_order_new.addActionListener(this);
		button_return_order_new.setActionCommand("订货端新增退货单");
		button_order_agentModifyAddress.addActionListener(this);
		button_order_agentModifyAddress.setActionCommand("订货端修改订单地址");
		button_order_agentAddNote.addActionListener(this);
		button_order_agentAddNote.setActionCommand("订货端添加订单备注");
		button_order_agentCancel.addActionListener(this);
		button_order_agentCancel.setActionCommand("订货端订单作废");
		button_return_order_agentAddNote.addActionListener(this);
		button_return_order_agentAddNote.setActionCommand("订货端退货单添加备注");
		button_return_order_agentCancel.addActionListener(this);
		button_return_order_agentCancel.setActionCommand("订货端退货单作废");
	    //button_return_order_agentCancel.setContentAreaFilled(false);//按钮设置透明操作
		//button_return_order_agentCancel.setPreferredSize(new Dimension(120,30));//按钮大小设置
		button_newGood.addActionListener(this);
		button_newGood.setActionCommand("商品新增");
		button_deleteGood.addActionListener(this);
		button_deleteGood.setActionCommand("删除商品");
		button_modifyGood.addActionListener(this);
		button_modifyGood.setActionCommand("修改商品");
		button_searchGood.addActionListener(this);
		button_searchGood.setActionCommand("商品搜索");
		button_AddUnit.addActionListener(this);
		button_AddUnit.setActionCommand("新增商品单位");
		button_shareGood.addActionListener(this);
		button_shareGood.setActionCommand("商品分享");
		button_SearchWareHouse.addActionListener(this);
		button_SearchWareHouse.setActionCommand("搜商品库存");
		button_Procurement.addActionListener(this);
		button_Procurement.setActionCommand("采购入库");
		button_outWareHouse.addActionListener(this);
		button_outWareHouse.setActionCommand("其他出库");
		button_sellOut.addActionListener(this);
		button_sellOut.setActionCommand("销售出库");
		button_inWareHouse.addActionListener(this);
		button_inWareHouse.setActionCommand("其他入库");
		button_addSaleDiscount.addActionListener(this);
		button_addSaleDiscount.setActionCommand("商品打折促销");
		button_addSalePromotion.addActionListener(this);
		button_addSalePromotion.setActionCommand("商品降价促销");
		button_addSalePresent.addActionListener(this);
		button_addSalePresent.setActionCommand("商品买赠促销");
		button_addSaleDiscount2.addActionListener(this);
		button_addSaleDiscount2.setActionCommand("商品阶梯促销");
		button_addOrderSaleDiscount.addActionListener(this);
		button_addOrderSaleDiscount.setActionCommand("订单满折促销");
		button_addOrderSaleDiscount2.addActionListener(this);
		button_addOrderSaleDiscount2.setActionCommand("订单阶梯促销");
		button_addOrderSalePresent.addActionListener(this);
		button_addOrderSalePresent.setActionCommand("订单满赠促销");
		button_addOrderSalePromotion.addActionListener(this);
		button_addOrderSalePromotion.setActionCommand("订单满减促销");
		button_agentGoods.addActionListener(this);
		button_agentGoods.setActionCommand("订货端商品操作");
		button_orderPay.addActionListener(this);
		button_orderPay.setActionCommand("订单付款");
		button_toSystemSuggest.addActionListener(this);
		button_toSystemSuggest.setActionCommand("管理端向系统反馈意见");
		button_agentToSystemSuggest.addActionListener(this);
		button_agentToSystemSuggest.setActionCommand("订货端向系统反馈意见");
		 button_fundOpen.addActionListener(this);
		 button_fundInitialize.addActionListener(this);
		 button_fundRecharge.addActionListener(this);
		 button_backRecharge.addActionListener(this);
		 button_hongchong.addActionListener(this);
		 button_confirmPay.addActionListener(this);
         button_addBankAccount.addActionListener(this);
         button_deleteBankAccount.addActionListener(this);
         button_statisticsDeliverGoods.addActionListener(this);
         button_fundOpen.setActionCommand("资金账号开关");
		 button_fundInitialize.setActionCommand("初始化资金账号");
		 button_fundRecharge.setActionCommand("资金账号充值");
		 button_backRecharge.setActionCommand("资金账号扣款");
		 button_hongchong.setActionCommand("红冲");
		 button_confirmPay.setActionCommand("收款确认");
         button_addBankAccount.setActionCommand("新增收款银行");
         button_deleteBankAccount.setActionCommand("删除收款银行");
         button_statisticsDeliverGoods.setActionCommand("发货统计");
         button_agentFundRecharge.addActionListener(this);
         button_agentFundRecharge.setActionCommand("订货端资金充值");
         button_agentToAdminSuggest.addActionListener(this);
         button_agentToAdminSuggest.setActionCommand("订货端向管理端反馈意见");
         button_deleteSuggent.addActionListener(this);
         button_addClient.addActionListener(this);
         button_modifyClient.addActionListener(this);
         Button_deleteClient.addActionListener(this);
         button_addClientlevel.addActionListener(this);
         button_modifyClientlevel.addActionListener(this);
         button_deleteClientlevel.addActionListener(this);
         button_topClientlevel.addActionListener(this);
         button_seeClientMessage.addActionListener(this);
         button_addOrdeleteArea.addActionListener(this);
         button_newNotify.addActionListener(this);
         button_deleteNotify.addActionListener(this);
         button_makeNotify.addActionListener(this);
         button_agentMakeNotify.addActionListener(this);
         button_addNotifyClass.addActionListener(this);
         button_topNotifyClass.addActionListener(this);
         button_modifyNotifyClass.addActionListener(this);
         button_deletrNotifyClass.addActionListener(this);
         button_deleteSuggent.setActionCommand("删除反馈意见");
         button_addClient.setActionCommand("新增客户");
         button_modifyClient.setActionCommand("修改客户");
         Button_deleteClient.setActionCommand("删除客户");
         button_addClientlevel.setActionCommand("添加客户级别");
         button_modifyClientlevel.setActionCommand("修改客户级别");
         button_deleteClientlevel.setActionCommand("删除客户级别");
         button_topClientlevel.setActionCommand("置顶客户级别");
         button_seeClientMessage.setActionCommand("查看加盟信息");
         button_addOrdeleteArea.setActionCommand("增/删客户区域");
         button_newNotify.setActionCommand("新增通知公告");
         button_deleteNotify.setActionCommand("删除通知公告");
         button_makeNotify.setActionCommand("管理端查看通知");
         button_agentMakeNotify.setActionCommand("订货端查看通知");
         button_addNotifyClass.setActionCommand("添加通知分类");
         button_topNotifyClass.setActionCommand("置顶通知分类");
         button_modifyNotifyClass.setActionCommand("修改通知分类");
         button_deletrNotifyClass.setActionCommand("删除通知分类");
		 button_testAll.addActionListener(this);
		 button_testAll.setActionCommand("测试环境一键所有操作");
		 button_productAll.addActionListener(this);
		 button_productAll.setActionCommand("生产环境一键所有操作");
		 button_allClient.addActionListener(this);
		 button_allfund.addActionListener(this);
		 button_allGoods.addActionListener(this);
		 button_allNotify.addActionListener(this);
		 button_allOrder.addActionListener(this);
		 button_allSuggest.addActionListener(this);
		 button_allGoods.setActionCommand("一键商品");
		 button_allOrder.setActionCommand("一键订单");
		 button_allClient.setActionCommand("一键客户");
		 button_allSuggest.setActionCommand("一键反馈意见");
		 button_allfund.setActionCommand("一键资金账号");
		 button_allNotify.setActionCommand("一键通知公告");	 	
		 button_allGoodSale.addActionListener(this);
		 button_allGroupSale.addActionListener(this);
		 button_allOrderSala.addActionListener(this);
		 button_allGoodSale.setActionCommand("一键商品促销");
		 button_allGroupSale.setActionCommand("一键组合促销");
		 button_allOrderSala.setActionCommand("一键订单促销");
		//按钮大小设置      
		button_mob_login.setPreferredSize(new Dimension(120,30));
		button_help_login.setPreferredSize(new Dimension(120,30));
		button_id_login.setPreferredSize(new Dimension(120,30));
		button_agent_login.setPreferredSize(new Dimension(120,30));
		button_staff_login.setPreferredSize(new Dimension(120,30));
		button_enroll.setPreferredSize(new Dimension(120,30));
		button_find_password.setPreferredSize(new Dimension(120,30));
		button_find_username.setPreferredSize(new Dimension(120,30));
		button_order_replaceAgent.setPreferredSize(new Dimension(120,30));	         
		button_order_check.setPreferredSize(new Dimension(120,30));
		button_order_finance_check.setPreferredSize(new Dimension(120,30));
		button_order_warehouseOut_check.setPreferredSize(new Dimension(120,30));
		button_order_diliverGoods_check.setPreferredSize(new Dimension(120,30));	         
		button_order_back.setPreferredSize(new Dimension(120,30));
		button_order_cancelDelete.setPreferredSize(new Dimension(120,30));
		button_order_delete.setPreferredSize(new Dimension(120,30));
		button_order_goodRemark.setPreferredSize(new Dimension(120,30));	         
		button_order_modify.setPreferredSize(new Dimension(120,30));
		button_order_addNote.setPreferredSize(new Dimension(120,30));
		button_order_modifyAddress.setPreferredSize(new Dimension(120,30));
		button_return_order_replaceAgent.setPreferredSize(new Dimension(120,30));
		button_return_order_check.setPreferredSize(new Dimension(120,30));
		button_return_order_defind.setPreferredSize(new Dimension(120,30));
		button_return_order_refund.setPreferredSize(new Dimension(120,30));
		button_return_order_back.setPreferredSize(new Dimension(120,30));
		button_return_order_cancelDelete.setPreferredSize(new Dimension(120,30));
		button_return_order_addNote.setPreferredSize(new Dimension(120,30));  
		button_order_new.setPreferredSize(new Dimension(120,30));
		button_order_shopCat.setPreferredSize(new Dimension(120,30));  
		button_order_agentModifyAddress.setPreferredSize(new Dimension(120,30));
		button_order_agentAddNote.setPreferredSize(new Dimension(120,30));
		button_order_agentCancel.setPreferredSize(new Dimension(120,30));	     	         
		button_return_order_new.setPreferredSize(new Dimension(120,30));
		button_return_order_agentShopCat.setPreferredSize(new Dimension(120,30));
		button_return_order_agentAddNote.setPreferredSize(new Dimension(120,30));
		button_return_order_agentCancel.setPreferredSize(new Dimension(120,30));
		button_order_search.setPreferredSize(new Dimension(120,30));
		button_order_advancedSearch.setPreferredSize(new Dimension(120,30));
		button_orderPay.setPreferredSize(new Dimension(120,30));
		button_allGoods.setPreferredSize(new Dimension(120,30));
		button_allOrder.setPreferredSize(new Dimension(120,30));
		button_allNotify.setPreferredSize(new Dimension(120,30));
		button_allClient.setPreferredSize(new Dimension(120,30));
		button_allSuggest.setPreferredSize(new Dimension(120,30));
		button_allfund.setPreferredSize(new Dimension(120,30));
		button_newGood.setPreferredSize(new Dimension(120,30));
		button_deleteGood.setPreferredSize(new Dimension(120,30));
		button_modifyGood.setPreferredSize(new Dimension(120,30));
		button_shareGood.setPreferredSize(new Dimension(120,30));
		button_searchGood.setPreferredSize(new Dimension(120,30));
		button_AddUnit.setPreferredSize(new Dimension(120,30));	        
		button_allGoodSale.setPreferredSize(new Dimension(120,30));	 
		button_allGroupSale.setPreferredSize(new Dimension(120,30));	 
		button_allOrderSala.setPreferredSize(new Dimension(120,30));	 

		button_SearchWareHouse.setPreferredSize(new Dimension(120,30));
		button_Procurement.setPreferredSize(new Dimension(120,30));
		button_inWareHouse.setPreferredSize(new Dimension(120,30));
		button_sellOut.setPreferredSize(new Dimension(120,30));
		button_outWareHouse.setPreferredSize(new Dimension(120,30));	         
		button_addSaleDiscount.setPreferredSize(new Dimension(120,30));
		button_addSaleDiscount2.setPreferredSize(new Dimension(120,30));
		button_addSalePromotion.setPreferredSize(new Dimension(120,30));
		button_addSalePresent.setPreferredSize(new Dimension(120,30));	         
		button_addOrderSaleDiscount.setPreferredSize(new Dimension(120,30));
		button_addOrderSaleDiscount2.setPreferredSize(new Dimension(120,30));
		button_addOrderSalePromotion.setPreferredSize(new Dimension(120,30));
		button_addOrderSalePresent.setPreferredSize(new Dimension(120,30));
		button_agentGoods.setPreferredSize(new Dimension(120,30));	         
		button_fundOpen.setPreferredSize(new Dimension(120,30));
		button_fundInitialize.setPreferredSize(new Dimension(120,30));
		button_fundRecharge.setPreferredSize(new Dimension(120,30));
		button_backRecharge.setPreferredSize(new Dimension(120,30));
		button_hongchong.setPreferredSize(new Dimension(120,30));
		button_confirmPay.setPreferredSize(new Dimension(120,30));
		button_addBankAccount.setPreferredSize(new Dimension(120,30));
		button_deleteBankAccount.setPreferredSize(new Dimension(120,30));
		button_statisticsDeliverGoods.setPreferredSize(new Dimension(120,30));
		button_agentFundRecharge.setPreferredSize(new Dimension(120,30));
		button_toSystemSuggest.setPreferredSize(new Dimension(120,30));
		button_agentToSystemSuggest.setPreferredSize(new Dimension(120,30));
		button_agentToAdminSuggest.setPreferredSize(new Dimension(120,30));
		button_deleteSuggent.setPreferredSize(new Dimension(120,30));	         	         
		button_addClient.setPreferredSize(new Dimension(120,30));
		button_modifyClient.setPreferredSize(new Dimension(120,30));
		Button_deleteClient.setPreferredSize(new Dimension(120,30));
		button_addClientlevel.setPreferredSize(new Dimension(120,30));
		button_modifyClientlevel.setPreferredSize(new Dimension(120,30));	         
		button_deleteClientlevel.setPreferredSize(new Dimension(120,30));
		button_topClientlevel.setPreferredSize(new Dimension(120,30));
		button_seeClientMessage.setPreferredSize(new Dimension(120,30));
		button_addOrdeleteArea.setPreferredSize(new Dimension(120,30));	             
		button_newNotify.setPreferredSize(new Dimension(120,30));
		button_deleteNotify.setPreferredSize(new Dimension(120,30));
		button_makeNotify.setPreferredSize(new Dimension(120,30));
		button_agentMakeNotify.setPreferredSize(new Dimension(120,30));
		button_addNotifyClass.setPreferredSize(new Dimension(120,30));	         
		button_topNotifyClass.setPreferredSize(new Dimension(120,30));
		button_modifyNotifyClass.setPreferredSize(new Dimension(120,30));
		button_deletrNotifyClass.setPreferredSize(new Dimension(120,30));
		
		
		//按钮光标移动上去文字提示
		button_mob_login.setToolTipText(button_mob_login.getText());
		button_help_login.setToolTipText(button_help_login.getText());
		button_id_login.setToolTipText(button_id_login.getText());
		button_agent_login.setToolTipText(button_agent_login.getText());
		button_staff_login.setToolTipText(button_staff_login.getText());
		button_enroll.setToolTipText(button_enroll.getText());
		button_find_password.setToolTipText(button_find_password.getText());
		button_find_username.setToolTipText(button_find_username.getText());
		button_order_replaceAgent.setToolTipText(button_order_replaceAgent.getText());
		button_order_check.setToolTipText(button_order_check.getText());
		button_order_finance_check.setToolTipText(button_order_finance_check.getText());
		button_order_warehouseOut_check.setToolTipText(button_order_warehouseOut_check.getText());
		button_order_diliverGoods_check.setToolTipText(button_order_diliverGoods_check.getText());
		button_order_back.setToolTipText(button_order_back.getText());
		button_order_cancelDelete.setToolTipText(button_order_cancelDelete.getText());
		button_order_delete.setToolTipText(button_order_delete.getText());
		button_order_goodRemark.setToolTipText(button_order_goodRemark.getText());
		button_order_modify.setToolTipText(button_order_modify.getText());
		button_order_addNote.setToolTipText(button_order_addNote.getText());
		button_order_modifyAddress.setToolTipText(button_order_modifyAddress.getText());
		button_return_order_replaceAgent.setToolTipText(button_return_order_replaceAgent.getText());
		button_return_order_check.setToolTipText(button_return_order_check.getText());
		button_return_order_defind.setToolTipText(button_return_order_defind.getText());
		button_return_order_refund.setToolTipText(button_return_order_refund.getText());
		button_return_order_back.setToolTipText(button_return_order_back.getText());
		button_return_order_cancelDelete.setToolTipText(button_return_order_cancelDelete.getText());
		button_return_order_addNote  .setToolTipText(button_return_order_addNote  .getText());
		button_order_new.setToolTipText(button_order_new.getText());
		button_order_shopCat  .setToolTipText(button_order_shopCat  .getText());
		button_order_agentModifyAddress.setToolTipText(button_order_agentModifyAddress.getText());
		button_order_agentAddNote.setToolTipText(button_order_agentAddNote.getText());
		button_order_agentCancel.setToolTipText(button_order_agentCancel.getText());
		button_return_order_new.setToolTipText(button_return_order_new.getText());
		button_return_order_agentShopCat.setToolTipText(button_return_order_agentShopCat.getText());
		button_return_order_agentAddNote.setToolTipText(button_return_order_agentAddNote.getText());
		button_return_order_agentCancel.setToolTipText(button_return_order_agentCancel.getText());
		button_order_search.setToolTipText(button_order_search.getText());
		button_order_advancedSearch.setToolTipText(button_order_advancedSearch.getText());  		
		button_SearchWareHouse.setToolTipText(button_SearchWareHouse.getText());
		button_Procurement.setToolTipText(button_Procurement.getText());
		button_inWareHouse.setToolTipText(button_inWareHouse.getText());
		button_sellOut.setToolTipText(button_sellOut.getText());
		button_outWareHouse.setToolTipText(button_outWareHouse.getText());
		button_addSaleDiscount.setToolTipText(button_addSaleDiscount.getText());
		button_addSaleDiscount2.setToolTipText(button_addSaleDiscount2.getText());
		button_addSalePromotion.setToolTipText(button_addSalePromotion.getText());
		button_addSalePresent.setToolTipText(button_addSalePresent.getText());
		button_addOrderSaleDiscount.setToolTipText(button_addOrderSaleDiscount.getText());
		button_addOrderSaleDiscount2.setToolTipText(button_addOrderSaleDiscount2.getText());
		button_addOrderSalePromotion.setToolTipText(button_addOrderSalePromotion.getText());
		button_addOrderSalePresent.setToolTipText(button_addOrderSalePresent.getText());
		button_agentGoods.setToolTipText(button_agentGoods.getText());
		button_fundOpen.setToolTipText(button_fundOpen.getText());
		button_fundInitialize.setToolTipText(button_fundInitialize.getText());
		button_fundRecharge.setToolTipText(button_fundRecharge.getText());
		button_backRecharge.setToolTipText(button_backRecharge.getText());
		button_hongchong.setToolTipText(button_hongchong.getText());
		button_confirmPay.setToolTipText(button_confirmPay.getText());
		button_addBankAccount.setToolTipText(button_addBankAccount.getText());
		button_deleteBankAccount.setToolTipText(button_deleteBankAccount.getText());
		button_statisticsDeliverGoods.setToolTipText(button_statisticsDeliverGoods.getText());
		button_agentFundRecharge.setToolTipText(button_agentFundRecharge.getText());
		button_toSystemSuggest.setToolTipText(button_toSystemSuggest.getText());
		button_agentToSystemSuggest.setToolTipText(button_agentToSystemSuggest.getText());
		button_agentToAdminSuggest.setToolTipText(button_agentToAdminSuggest.getText());
		button_deleteSuggent.setToolTipText(button_deleteSuggent.getText());
		button_addClient.setToolTipText(button_addClient.getText());
		button_modifyClient.setToolTipText(button_modifyClient.getText());
		Button_deleteClient.setToolTipText(Button_deleteClient.getText());
		button_addClientlevel.setToolTipText(button_addClientlevel.getText());
		button_modifyClientlevel.setToolTipText(button_modifyClientlevel.getText());
		button_deleteClientlevel.setToolTipText(button_deleteClientlevel.getText());
		button_topClientlevel.setToolTipText(button_topClientlevel.getText());
		button_seeClientMessage.setToolTipText(button_seeClientMessage.getText());
		button_addOrdeleteArea.setToolTipText(button_addOrdeleteArea.getText());
		button_newNotify.setToolTipText(button_newNotify.getText());
		button_deleteNotify.setToolTipText(button_deleteNotify.getText());
		button_makeNotify.setToolTipText(button_makeNotify.getText());
		button_agentMakeNotify.setToolTipText(button_agentMakeNotify.getText());
		button_addNotifyClass.setToolTipText(button_addNotifyClass.getText());
		button_topNotifyClass.setToolTipText(button_topNotifyClass.getText());
		button_modifyNotifyClass.setToolTipText(button_modifyNotifyClass.getText());
		button_deletrNotifyClass.setToolTipText(button_deletrNotifyClass.getText());


		//按钮点击手型设置（是光标移动上去变为小手形状）
		button_mob_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_help_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_id_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_agent_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_staff_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_enroll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_find_password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_find_username.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_replaceAgent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_finance_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_warehouseOut_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_diliverGoods_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_cancelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_goodRemark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_modify.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_addNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_modifyAddress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_replaceAgent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_check.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_defind.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_refund.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_cancelDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_addNote  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_new.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_shopCat  .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentModifyAddress.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentAddNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_agentCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_new.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentShopCat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentAddNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_return_order_agentCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_order_advancedSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		en1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		en2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		g3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
      //浏览器选择复选框监控
	class Listener1 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (g1.isSelected()) browser=0;
                 else if (g2.isSelected()) browser=1;
                 else if (g3.isSelected()) browser=2;       
            }
        }
		g1.addActionListener(new Listener1());
		g2.addActionListener(new Listener1());
		g3.addActionListener(new Listener1());
		if(g1.isSelected()) browser=0;
		else if(g2.isSelected()) browser=1;
		else if(g3.isSelected()) browser=2;
		
		
	 //环境选择复选框监控
		class Listener2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (en2.isSelected()) setting=0;
                 else if (en1.isSelected())setting=1;     
            }
        }
		en1.addActionListener(new Listener2());
		en2.addActionListener(new Listener2());
		if(en2.isSelected()) setting=0;
	    else if(en1.isSelected())setting=1;
				
		
		//窗体设置
		this.setSize(1042, 700);
		this.setLocation(100, 20);
		this.setTitle("易订货自动化测试系统");
		this.setIconImage(new ImageIcon("image/yi_logo.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
       // 事件触发设置
	
	   //注册登录模块事件监听触发的事件
      public void actionPerformed(ActionEvent e) {
		TestCase testCase=new TestCase();
		if (e.getActionCommand().equals("注册")) { 
			if(setting==1)
				JOptionPane.showMessageDialog(null, "Sorry,生产环境暂不支持“注册”自动化测试。。。", "错误提示", JOptionPane.ERROR_MESSAGE);
			else if(setting==0){
			try {
				testCase.setUp(browser);
				testCase.enroll();
				testCase.logout();
				testCase.tearDown();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		} else if (e.getActionCommand().equals("手机号码登录")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("18720091223","123456");
				else if(setting==1)
				testCase.login("18633333333","123456");
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("账号助手登录")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login_help("13607099149","123456");
				else if(setting==1)
				testCase.login_help("18607099149","123456");
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("管理端ID登录")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}	else if (e.getActionCommand().equals("代理商登录")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}	else if (e.getActionCommand().equals("员工登录")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("ku123","123456");
				else if(setting==1)
				testCase.login("autostaff","123456");
				//testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}   else if (e.getActionCommand().equals("找回密码")) { 
			if(setting==1)
				JOptionPane.showMessageDialog(null, "Sorry,生产环境暂不支持“找回密码”自动化测试。。。", "错误提示", JOptionPane.ERROR_MESSAGE);
		  else if(setting==0){
			try {
				testCase.setUp(browser);
				testCase.findPassword();
				testCase.tearDown();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			}
		}else if (e.getActionCommand().equals("找回用户名")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.findUsername("3123512624@qq.com");//测试环境账号绑定邮箱
				else if(setting==1)
			    testCase.findUsername("1533985604@qq.com");//生产环境账号绑定邮箱
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或系统异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}   else if (e.getActionCommand().equals("订单搜索")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderSearch();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}  else if (e.getActionCommand().equals("订单高级搜索")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.advancedSearch();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}  else if (e.getActionCommand().equals("管理端代下订单")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.order_replaceAgent();
				testCase.logout();
				testCase.tearDown();	
				//JOptionPane.showMessageDialog(null, "Sorry,管理端代下单暂时不做！！！！！", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("管理端代下退货单")) {
				try {
					testCase.setUp(browser);
					if(setting==0)
					testCase.login("310007707","123456");
					else if(setting==1)
					testCase.login("310021564","123456");
					testCase.returnOrder_replaceAgent();
					testCase.logout();
					testCase.tearDown();	
					//JOptionPane.showMessageDialog(null, "Sorry,管理端代下单暂时不做！！！！！", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			} else if (e.getActionCommand().equals("购物车下单")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					//testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testShopcat();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("购物车下退货单")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("订单审核")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");				
				testCase.orderCheck();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("退单审核")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.ruturnOrderCheck();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("订单退回")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderBack();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("管理端订单作废删除")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.OrderCancelDelete();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("退单作废删除")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				testCase.logout3();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.returnOrderCancelDelete();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单商品备注")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.goodRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("管理端订单备注")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testOrderRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单修改")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testOrderModify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("退货单退回")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testReturnOrderBack();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("退货单备注")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.backOrder();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.testReturnOrderRemark();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("管理端修改订单地址")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.orderModifyAddress();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端新增订单")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端新增退货单")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewReturnOrder();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端修改订单地址")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.testAgentModifyAddress();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端添加订单备注")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewOrder();
				testCase.testAgentOrderAddNote();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端订单作废")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testAgentNewOrder();
				testCase.testAgentOrderCancel();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端退货单添加备注")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}	
				testCase.testAgentNewReturnOrder();
				testCase.testAgentReturnOrderAddNote();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端退货单作废")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				testCase.testAgentNewReturnOrder();
				testCase.testAgentReturnOrderCancel();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品新增")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除商品")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testDeleteGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("修改商品")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310013008","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testModifyGood();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品搜索")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSearchGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("新增商品单位")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddUnit();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品分享")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddGood2();
				testCase.testShareGood();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("搜商品库存")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSearchWarehouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("采购入库")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testProcurement();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("其他出库")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOutWareHouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("其他入库")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testInWareHouse();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("销售出库")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSellOut();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品打折促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSaleDiscount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品降价促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSalePromotion();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品买赠促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSalePresent();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("商品阶梯促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSaleDiscount2();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}			
		}else if (e.getActionCommand().equals("订单满折促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSaleDiscount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单满减促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSalePromotion();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单满赠促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSalePresent();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单阶梯促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testOrderSaleDiscount2();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端商品操作")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentGoods(0);
				testCase.logout3();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订单付款")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testShopcat();
				testCase.orderPay();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("资金账号开关")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.closeOpenFund();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("初始化资金账号")) {
			try {
				testCase.setUp(browser);
				if(setting==0)					
				testCase.login("310007707","123456");				
				else if(setting==1)
				testCase.login("310021564","123456");				
				testCase.fundInitialize();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认资金账号是否开启，或是资金账号已被初始化", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("资金账号充值")) {
			try {
				testCase.setUp(browser);
				if(setting==0)				
				testCase.login("310007707","123456");								
				else if(setting==1)
				testCase.login("310021564","123456");
				testCase.fundRecharge();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请确认是否开启资金账号和初始化资金账号！！！", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("资金账号扣款")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.backRecharge();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请确认是否开启资金账号和初始化资金账号！！！或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("红冲")) {
			try {
				testCase.setUp(browser);
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}
				testCase.hongChong();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请确认是否开启资金账号和初始化资金账号！！！，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("收款确认")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
			   else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
					}
				testCase.testShopcat();
				testCase.orderPay();
				testCase.logout1();
				if(setting==0){					
				testCase.login("310007707","123456");				
				}
				else if(setting==1){
				testCase.login("310021564","123456");
				}				
				testCase.confirmPay();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("新增收款银行")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.addBankAccount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致，或网络异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除收款银行")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.deleteBankAccount();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认是否存在收款银行！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("发货统计")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.statisticsDeliverGoods();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端资金充值")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentFundRecharge();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端向管理端反馈意见")) {
			try {
				testCase.setUp(browser);
				testCase.testAgentToAdminSuggest(setting);
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除反馈意见")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteSuggest();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "请确认账号310007707/310021564是否有克删除的订货端反馈意见，或存在其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("新增客户")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认该账号310007707/310021564是否达到客户上线，或存在其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("修改客户")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除客户")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteClient();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("添加客户级别")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("修改客户级别")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除客户级别")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("置顶客户级别")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testTopClientlevel();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("查看加盟信息")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testSeeClientMessage();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("增/删客户区域")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddArea();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("新增通知公告")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testNewNotify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除通知公告")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteNotify();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("管理端查看通知")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testMakeNotify();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端查看通知")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}
				testCase.testAgentMakeNotify();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("添加通知分类")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testAddNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("置顶通知分类")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testTopNotifyClass();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("修改通知分类")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testModifyNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("删除通知分类")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testDeleteNotifyClass();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("管理端向系统反馈意见")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				testCase.testToSystemSuggest();
				testCase.logout();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("订货端向系统反馈意见")) {
			try {
				testCase.setUp(browser);
				if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){			
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}	
				testCase.testAgentToSystemSuggest();
				testCase.logout1();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键商品")) {
			try {
				testCase.setUp(browser);			
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行新增商品！");
				testCase.testAddGood2();
		        System.out.println("新增商品用例通过！！！");
		        System.out.println("开始执行修改商品！");
		        testCase.testModifyGood();
		        System.out.println("修改商品用例通过！！！");
		        System.out.println("开始执行新增商品计量单位！");
				testCase.testAddUnit();
		        System.out.println("新增商品计量单位用例通过！！！");
		        System.out.println("开始执行搜索商品！");
		        testCase.testSearchGood();
		        System.out.println("搜索商品用例通过！！！");		        
		        System.out.println("开始执行商品采购入库！");
		        testCase.testProcurement();
		        System.out.println("商品采购入库用例执行通过！！！");
		        System.out.println("开始执行商品其他入库！");
		        testCase.testInWareHouse();
		        System.out.println("商品其他入库用例执行通过！！！");
		        System.out.println("开始执行商品销售出库！");
		        testCase.testSellOut();
		        System.out.println("商品销售出库用例执行通过！！！");
		        System.out.println("开始执行商品其他出库！");
		        testCase.testOutWareHouse();
		        System.out.println("商品其他出库用例执行通过！！！");
		        System.out.println("开始执行商品分享！");
		        testCase.testShareGood();
		        System.out.println("商品分享用例执行通过！！！");
		        System.out.println("开始执行搜索商品库存！");
		        testCase.testSearchWarehouse();
		        System.out.println("搜索商品库存用例执行通过！！！");
		        System.out.println("开始执行搜索商品库存！");
		        testCase.testSearchWarehouse();
		        System.out.println("搜索商品库存用例执行通过！！！");
		        testCase.logout();
		        System.out.println("管理端商品用例完成，开始执行订货单商品用例。。。。");
		        System.out.println("商品一键操作内容执行完成。。。。注意执行过程中的异常问题。");
		        if(setting==0){									
				testCase.login("ku123456","123456");				
				testCase.closeBoundMessage();
				testCase.closeSystemInform();
				}
				else if(setting==1){			
				testCase.login("autotest1","123456");
				testCase.closeBoundMessage();
				}	
		        System.out.println("开始执行订货端商品一系列操作！");
		        testCase.testAgentGoods(0);
		        System.out.println("订货单商品系列操作用例执行通过！！！");
		        testCase.logout3();
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！\n或再次执行一次，或单独执行没有通过的用例。", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键订单")) {
			try {
				testCase.setUp(browser);	
				if(setting==0){					
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
					}
				System.out.println("开始执行订货端购车车下单！");
				testCase.testShopcat();
				System.out.println("购物车下单用例执行通过！！！");
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				System.out.println("开始执行订货单审核！");
				testCase.orderCheck();
				System.out.println("订货单审核通过！！！");
				testCase.logout();
				if(setting==0){					
					testCase.login("ku123456","123456");				
					//testCase.closeBoundMessage();
					//testCase.closeSystemInform();
					}
				else if(setting==1){
					testCase.login("autotest1","123456");
					//testCase.closeBoundMessage();
					}
				System.out.println("开始执行购物车下退货单！");
				testCase.backOrder();
				System.out.println("购物车下退货单用例执行通过！！！");
				testCase.logout1();
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行退货单审核！");
				testCase.ruturnOrderCheck();
				System.out.println("退货单审核用例执行通过！！！");
				testCase.logout();
				System.out.println("意见订单操作包含的内容仅有购物车下单、购物车下退货单、订单审核和退单审核，其他用例若有需要请分别单独执行。。。");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键客户")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
			    testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");	
				System.out.println("开始执行新增客户!");				
				testCase.testAddClient();
				System.out.println("新增客户用例执行通过！！！");
				System.out.println("开始执行修改客户！");
				testCase.testModifyClient();
				System.out.println("修改客户用例执行通过！！！");
				System.out.println("开始执行删除客户！");
				testCase.testDeleteClient();
				System.out.println("删除客户用例执行完成！！！");
				System.out.println("开始执行新增客户级别！");
				testCase.testClientlevel();
				System.out.println("新增客户级别用例执行通过！！！");
				System.out.println("开始执行修改客户级别！");
				testCase.testModifyClientlevel();
				System.out.println("修改客户级别用例执行通过！！！");
				System.out.println("开始执行删除客户级别！");
				testCase.testDeleteClientlevel();
				System.out.println("删除客户级别用例执行通过！！！");
				System.out.println("开始执行新增和删除客户区域！");
				testCase.testAddArea();
				System.out.println("新增和删除客户区域用例执行通过！！！");
				System.out.println("一键客户执行通过，还有部分用例没有执行，若有需要请单步执行！！！");
				testCase.logout();			
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键反馈意见")) {
			try {
				testCase.setUp(browser);	
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
					}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				System.out.println("开始执行订货端向系统反馈意见！");
				testCase.testAgentToSystemSuggest();
				System.out.println("订货端向系统反馈意见用例执行通过！！！");
				testCase.logout1();
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行管理端端向系统反馈意见！");
				testCase.testToSystemSuggest();
				System.out.println("管理端端向系统反馈意见用例执行通过！！！");
				testCase.logout();
				System.out.println("开始执行订货端向系统反馈意见的相关操作！");
				testCase.testAgentToAdminSuggest(setting+3);
				System.out.println("订货端向管理端提交反馈意见相关用例执行通过！！！");
				testCase.logout1();
				System.out.println("一键反馈意见用例执行完成，，跟踪执行过程，注意其中的异常问题。。。。");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键资金账号")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行关闭资金账号！");
				testCase.closeOpenFund();
				System.out.println("关闭资金账号用例执行通过！！！");
				System.out.println("开始执行开启资金账号！");
				testCase.closeOpenFund();
				System.out.println("开启资金账号用例执行通过！！！");
				System.out.println("开始初始化资金账号！");
				testCase.fundInitialize();
				System.out.println("初始化用例执行通过！！！");
				System.out.println("开始执行资金充值！");
				testCase.fundRecharge();
				System.out.println("资金充值用例通过！！！");
				System.out.println("开始执行资金账号扣款！");
				testCase.backRecharge();
				System.out.println("资金扣款用例执行通过！！！");
				System.out.println("开始执行添加收款银行！");
				testCase.addBankAccount();
				System.out.println("添加收款银行用例执行通过！！！");
				System.out.println("开始删除收款银行！");
				testCase.deleteBankAccount();
				System.out.println("删除收款银行执行通过！！！");
				testCase.logout();
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
				}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				System.out.println("开始执行订货端资金充值！");
				testCase.testAgentFundRecharge();
				System.out.println("订货端资金充值执行通过！！！");
				testCase.logout1();			
				System.out.println("一键资金账号内容执行通过，还有部分用例没有执行，若有需要请单步执行！！！");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键通知公告")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行新增通知公告");
				testCase.testNewNotify();
				//testCase.testNewNotify();
				System.out.println("新增通知公告执行通过！！！");
				System.out.println("开始执行管理端查看通知公告！");
				testCase.testMakeNotify();
				System.out.println("管理端查看通知公告执行通过！！！");
				System.out.println("开始执行删除通知公告！");
				testCase.testDeleteNotify();
				System.out.println("删除通知公告执行通过！！！");
//				System.out.println("开始执行添加通知分类！");
//				testCase.testAddNotifyClass();
//				System.out.println("添加通知分类执行通过！！！");
//				System.out.println("开始执行修改通知分类！");
//				testCase.testModifyClientlevel();
//				System.out.println("修改通知分类执行通过！！！");
//				System.out.println("开始执行删除通知分类！");
//				testCase.testDeleteNotifyClass();
//				System.out.println("删除通知分类执行通过！！！");
				System.out.println("开始执行订货端查看通知公告！");
				testCase.logout1();
				if(setting==0){									
					testCase.login("ku123456","123456");				
					testCase.closeBoundMessage();
					testCase.closeSystemInform();
				}
				else if(setting==1){			
					testCase.login("autotest1","123456");
					testCase.closeBoundMessage();
				}
				testCase.testAgentMakeNotify();
				System.out.println("订货端操作查看通知公告执行通过！！！");			
				testCase.logout1();
				System.out.println("一键通知公告执行完成，部分功能未加入一键操作中，跟踪执行过程，注意其中的异常问题。。。。");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "错误提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键商品促销")) {
			try {
				testCase.setUp(browser);	
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");			
				System.out.println("开始执行商品打折促销！");
				testCase.testSaleDiscount();
				System.out.println("商品打折促销用例执行通过！！！");
				System.out.println("开始执行商品买赠促销！");
				testCase.testSalePresent();
				System.out.println("商品买赠促销用例执行通过！！！");
				System.out.println("开始执行商品满减促销！");
				testCase.testSalePromotion();
				System.out.println("商品满减促销用例执行通过！！！");
				System.out.println("开始执行商品阶梯打折促销！");
				testCase.testSaleDiscount2();
				System.out.println("商品阶梯打折促销用例执行通过！！！");
				System.out.println("一键商品促销通过，跟踪执行过程，注意其中的异常问题。。。。");
				testCase.tearDown();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！\n或再次执行一次，或单独执行没有通过的用例。", "异常提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键订单促销")) {
			try {
				testCase.setUp(browser);
				if(setting==0)
				testCase.login("310007707","123456");
				else if(setting==1)
				testCase.login("310021564","123456");
				System.out.println("开始执行订单满折促销！");
				testCase.testOrderSaleDiscount();
				System.out.println("订单满折促销用例执行通过！！！");
				System.out.println("开始执行订单满赠促销！");
				testCase.testOrderSalePresent();
				System.out.println("订单满赠促销用例执行通过！！！");
				System.out.println("开始执行订单满减促销！");
				testCase.testOrderSalePromotion();
				System.out.println("订单满减促销用例执行通过！！！");
				System.out.println("开始执行订单阶梯满折促销！");
				testCase.testOrderSaleDiscount2();
				System.out.println("订单阶梯满折促销用例执行通过！！！");
				System.out.println("一键订单促销通过，跟踪执行过程，注意其中的异常问题。。。。");
				testCase.tearDown();	
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！\n或再次执行一次，或单独执行没有通过的用例。", "异常提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("一键组合促销")) {
			try {
				JOptionPane.showMessageDialog(null, "组合促销还在开发过程，不能实现操作。。。", "温馨提示：", JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "确认选择系统环境与电脑实际环境是否一致！！！或其他异常", "异常提示", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
       
	}
}

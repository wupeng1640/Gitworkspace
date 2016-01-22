package Selenium_Web_YDH;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * @author  铱云测试组
 * @time    2015年12月3日
 * @see     实现从200测试环境数据库获取到随机手机号码的手机短信验证码
 */  
   class DBread {
	public static final String url = "jdbc:mysql://192.168.1.200/platform";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "ydh20130815";
	String tel=null;
	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBread(String tel) {
		this.tel=tel;
		 String sql = "SELECT t.factiveCode FROM platform.t_active_code t "
				+ "WHERE fmobile = "
				+ "'"+tel+"'"              //在sql中引入变量查询
				+ " and  t.factiveStatus=0 ";;
		try {
			Class.forName(name);// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);// 获取连接
			pst = conn.prepareStatement(sql);// 准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getActiveCode(String tel) {
		String code = null;
		DBread db1 = null;
		ResultSet ret = null;
		db1  = new DBread(tel);
		//System.out.println(this.sql);
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				code = ret.getString(1); // 获取第一列数据
			}// 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;

	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package Selenium_Web_YDH;

import java.util.Random;
/**
 * @author  铱云测试组
 * @time    2015年12月3日
 * @see     实现随机生成一个以1350000开头的电话号码
 */
public class Random_tel {

	String tel_back_4 = null;
    String tel="1350000";
	public String get_Random_Tel() {
		Random getTel = new Random();
		int j;
		String s = null;
		for (int i = 0; i < 4; i++) {//添加数字到字符串的限制
			j = (int) getTel.nextInt(9);//随机生成一个0-9的整数
			s = Integer.toString(j);//数字转化为字符串
			if (i == 0)
				tel_back_4 = s;
			else
				tel_back_4 =tel_back_4+s;
		}
		tel=tel+tel_back_4;
		return tel;
	}
}
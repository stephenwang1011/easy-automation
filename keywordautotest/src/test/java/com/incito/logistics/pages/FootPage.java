package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 找货源页面所有元素定位
 * */
public class FootPage {
	//****************主页面上面的6个tab***************************************
	/** tab首页 */
	public static final By FP_LINK_HOME = By.id("link_standard_index");
	/** tab找车源 */
	public static final By FP_LINK_FINDCARS = By.id("link_cars");
	/** tab找货源 */
	public static final By FP_LINK_FINDGOODS = By.id("link_standard_goods");
	/** tab我的订单 */
	public static final By FP_LINK_MYORDER = By.id("link_standard_myorder");
	/** 我的货源 */
	public static final By FP_LINK_MYGOODS = By.id("link_standard_mygoods");
	/** 个人中心 */
	public static final By FP_LINK_CENTER = By.id("link_standard_ucenter");
	
	//****************主页面底部的3个信息***************************************
	/** 联系我们链接 */
	public static final By FP_LINK_CONTACTUS = By.linkText("联系我们");
	/** 关于我们链接*/
	public static final By FP_LINK_ABOUTUS = By.linkText("关于我们");
	/** 联系我们链接 */
	public static final By FP_LINK_HELP = By.linkText("帮助中心");
	
	//****************主页面主体的4个信息***************************************
	/** 联系我们 */
	public static final By FP_HOST_LINK_CONTACTUS = By.id("footer-info1");
	/** 关于我们 */
	public static final By FP_HOST_LINK_ABOUTUS = By.id("footer-info2");
	/** 帮助中心 */
	public static final By FP_HOST_LINK_HELP = By.id("footer-info3");
	/** 运营活动 */
	public static final By FP_HOST_LINK_COA = By.id("footer-info4");
}

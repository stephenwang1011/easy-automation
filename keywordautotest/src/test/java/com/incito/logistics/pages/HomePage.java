package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义首页页面元素
 * 
 * */
public class HomePage {
	/** 首页登陆按钮 */
	public static final By HP_BUTTON_LOGIN = By.id("login");
	/** 首页注册按钮 */
	public static final By HP_BUTTON_REG = By.linkText("注册");
	/** 首页登陆上的退出按钮 */
	public static final By HP_BUTTON_EXIT = By.linkText("退出");
	/** tab首页 */
	public static final By HP_LINK_HOME = By.linkText("首页");
	/** tab找车源 */
	public static final By HP_LINK_FINDCARS = By.linkText("找车源");
	/** tab找货源 */
	public static final By HP_LINK_FINDGOODS = By.id("link_standard_goods");
	/** tab我的订单 */
	public static final By HP_LINK_MYORDER = By.id("link_standard_myorder");
	/** 我的货源 */
	public static final By HP_LINK_MYGOODS = By.linkText("我的货源");
	/** 个人中心 */
	public static final By HP_LINK_CENTER = By.id("link_standard_ucenter");

	/** 首页上的 免费发布货源 按钮 */
	public static final By HP_BUTTON_FREESEND = By.xpath("//*[@id='freepub_']");
	/** 首页上：物流跟踪 tab */
	public static final By HP_TAB_TRACKGOODS = By.linkText("物流跟踪");
	/** 首页上：找车源 tab */
	public static final By HP_TAB_FINDCARS = By.linkText("找车源");
	/** 首页上的《物流跟踪》中的订单号输入框 */
	public static final By HP_INPUT_ORDERNO = By.id("orderno");
	/**首页上不正确的订单号提示信息*/
	public static final By HP_TEXT_ORDERPROMPT = By.xpath("//*[text()='请输入正确的订单号']");
	/** 首页上的《物流跟踪》上的查询按钮 */
	public static final By HP_BUTTON_SEARCH1 = By.xpath("//*[@id='findOrderForm']/div[2]/button");
	/** 首页上的《物流跟踪》tab */
	public static final By HP_TABS_TRACK = By.linkText("物流跟踪");
	/** 首页上的《找车源》上的出发地 */
	public static final By HP_INPUT_FROMCITY = By.id("carcity");
	/** 首页上的《找车源》上的出发地 */
	public static final By HP_INPUT_TOCITY = By.id("targetcity");
	/** 首页上的《找车源》上的查询按钮 */
	public static final By HP_BUTTON_SEARCH2 = By.id("Fcar");
	/** 首页上的《找货源》上的查询按钮 */
	public static final By HP_BUTTON_SEARCH3 = By.id("Fgoods");
	/** 登陆成功之后 用户名 区域 */
	public static final By HP_TEXT_USERINFO = By.cssSelector("a.dropdown-toggle");
	/** 左上角的商标文字 */
	public static final By HP_LEFT_TITLE = By.className("navbar-left");
	/** 底部footer文字 */
	public static final By HP_TEXT_FOOTER = By.className("in-footer");
	/**
	 * 公共车源和公共和货源 每个小模块<br>
	 * 通过findByElements 拆分:<br>
	 * 前8个是 公共货源的 数据，后八个是公共车源的数据<br>
	 * */
	public static final By HP_ARERA_ITEMS = By.className("index-infobox");
	/** 公共车源或者公共货源 上的收藏按钮 */
	public static final By HP_BUTTON_FAV = By.xpath("//*[text()='收藏']");
	/** 公共车源或者公共货源 上的取消收藏按钮 */
	public static final By HP_BUTTON_CFAV = By.xpath("//*[text()='取消收藏']");
	/** 公共货源上的定位按钮 */
	public static final By HP_BUTTON_LOC = By.xpath("//*[text()='定位']");
	/** 首页顶部日期 */
	public static final By HP_TEXT_DATE = By.id("currentTimeDiv");
	/** 首页中的frame */
	public static final By HP_FRAME = By.xpath("//iframe");
	/** 首页顶部城市 */
	public static final By HP_TEXT_CITY = By.id("city");
	/** 首页顶部天气 */
	public static final By HP_TEXT_WEATHER = By.id("wea-items");
	/** 关于我们链接，不推荐使用这个 */
	public static final By HP_LINK_ABOUT = By.xpath("//[text()='关于我们']");
	/** 关于我们链接 ，推荐使用这个*/
	public static final By HP_LINK_ABOUTUS = By.linkText("关于我们");
	/** 联系我们链接 */
	public static final By HP_LINK_CONTACTUS = By.linkText("联系我们");
	/** 联系我们链接 */
	public static final By HP_LINK_HELP = By.linkText("帮助中心");
	/** 两个 更多>> */
	public static final By HP_LINK_MORE = By.xpath("	//*[text()='更多>>']");
	
	/**公共货源和公共车源2大部分的定位:使用findbyelements进行取值，第一个是车源，第二个是货源*/
	public static final By HP_ARERA_GOODSANDCARS = By.cssSelector("div.index-infolist-content");
	/**公共车源中的第二行信息：驾驶证车辆信息等*/
	public static final By HP_CARS_INFO2= By.className("index-infobox-row2");
	/**返回顶部*/
	public static final By HP_BUTTON_BACK = By.className("back-top");
	
	/**首页上，公共车源和货源2大区域定位*/
	public static final By HP_ARERA_CARSANDGOODS = By.cssSelector("div.index-infolist-content");
	
	/**首页上公共车源和公共货源信息上的  第二行信息*/
	public static final By HP_TEXT_SECONDINFO = By.className("index-infobox-row2");
	
	/**首页上公共车源和公共货源信息上的  第三行信息*/
	public static final By HP_TEXT_THIRDINFO = By.cssSelector("p.index-infobox-row3");
	
	/**车源上的收藏和取消收藏按钮，单数是收藏 基数是取消收藏*/
	public static final By HP_BUTTON_CARSBUTTON = By.cssSelector("button.index_cars_btn");
	
	/**货源上的收藏和取消收藏按钮，单数是收藏 基数是取消收藏*/
	public static final By HP_BUTTON_GOODSBUTTON = By.cssSelector("button.index_goods_btn");
	
	/**公共车源和公共货源 第一行信息*/
	public static final By HP_TEXT_FIRST = By.className("index-infobox-row1");
	/**公共车源和公共货源 第二行信息*/
	public static final By HP_TEXT_SECOND = By.className("index-infobox-row2");
	
	/**首页快速查询tab - 找车源*/
	public static final By HP_QUICK_FINDCARS = By.xpath("//*[@href='#profile']");
	
	/**首页快速查询tab - 找货源*/
	public static final By HP_QUICK_FINDGOODS = By.xpath("//*[@href='#goods']");
}

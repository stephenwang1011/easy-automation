package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义首页页面元素
 * 
 * */
public class MyOrdersPage {
	//以下是搜索及高级搜索的条件****************************************************
	/**我的订单页面 - 发货地输入框*/
	public static final By MOP_INPUT_FROM = By.name("originalcity");
	/**我的订单页面 - 收货地输入框*/
	public static final By MOP_INPUT_TO = By.name("receiptcity");
	/**我的订单页面 - 订单开始时间*/
	public static final By MOP_INPUT_STARTTIME = By.name("startime");
	/**我的订单页面 - 订单结束时间*/
	public static final By MOP_INPUT_ENDTIME = By.name("endtime");
	/**我的订单页面 高级搜索条件输入框 - 订单编号*/
	public static final By MOP_INPUT_ORDERNO = By.name("orderNo");
	/**我的订单页面 高级搜索条件输入框 - 承运司机*/
	public static final By MOP_INPUT_DRIVER = By.name("drivername");
	/**我的订单页面 高级搜索条件输入框 - 收货人*/
	public static final By MOP_INPUT_RECEIVER = By.name("consigneename");
	/**我的订单页面 高级搜索条件输入框 - 收获公司*/
	public static final By MOP_INPUT_HARVESTCOMPANY = By.name("company");
	/**我的订单页面 - 搜索*/
	public static final By MOP_BUTTON_SEARCH = By.id("search_submit_btn");
	/**我的订单页面 - 高级搜索*/
	public static final By MOP_BUTTON_ADSEARCH = By.id("advanced_search_btn");
	/**我的订单页面 - 导航区*/
	public static final By MOP_SPAN_TABS = By.cssSelector("div.in-sortbox");
	/**我的订单页面 - 导航区：近三个月的订单*/
	public static final By MOP_SPAN_TABS_THREEORDERS = By.xpath("//*[@class='in-sortbox order-sortbox']/span[1]");
	/**我的订单页面 - 导航区：已预订*/
	public static final By MOP_SPAN_TABS_BOOKEDORDERS = By.xpath("//*[@class='in-sortbox order-sortbox']/span[2]");
	/**我的订单页面 - 导航区：待收款*/
	public static final By MOP_SPAN_TABS_PENDINGPAYMENT = By.xpath("//*[@class='in-sortbox order-sortbox']/span[3]");
	/**我的订单页面 - 导航区：配货中*/
	public static final By MOP_SPAN_TABS_PICKINGIN = By.xpath("//*[@class='in-sortbox order-sortbox']/span[4]");
	/**我的订单页面 - 导航区：运输中*/
	public static final By MOP_SPAN_TABS_TRANSPORTATION = By.xpath("//*[@class='in-sortbox order-sortbox']/span[5]");
	/**我的订单页面 - 导航区：到达收货地*/
	public static final By MOP_SPAN_TABS_ARRIVALOFRECEIPT = By.xpath("//*[@class='in-sortbox order-sortbox']/span[6]");
	/**我的订单页面 - 导航区：待评价*/
	public static final By MOP_SPAN_TABS_TOBEEVALUATED = By.xpath("//*[@class='in-sortbox order-sortbox']/span[7]");
	/**我的订单页面 - 导航区：交易成功*/
	public static final By MOP_SPAN_TABS_TRADINGSUCCESS = By.xpath("//*[@class='in-sortbox order-sortbox']/span[8]");
	/**我的订单页面 - 导航区：交易关闭*/
	public static final By MOP_SPAN_TABS_TRADINGCLOSED = By.xpath("//*[@class='in-sortbox order-sortbox']/span[9]");
	/**我的订单页面 - 导航区：三个月前订单*/
	public static final By MOP_SPAN_TABS_THREEAGEORDERS = By.xpath("//*[@class='in-sortbox order-sortbox']/span[10]");
	
	//以下是我的订单中详情****************************************************
	/**我的订单页面没有搜到到相关的数据*/
	public static final By MOP_TEXT_NOINFO = By.cssSelector("b");
	/**我的订单页面 订单的数目：只含有货物信息*/
	public static final By MOP_TEXT_ORDERSINFOES = By.className("order-info");
	/**我的订单页面 订单的详情的订单编号*/
	public static final By MOP_TEXT_ORDERNO = By.className("order-no");
	/**我的订单页面 订单收货地址*/
	public static final By MOP_TEXT_ADDRESS = By.cssSelector("span.in-city-highlight");
	/**我的订单页面 订单的详情的订单时间*/
	public static final By MOP_TEXT_ORDERDATE = By.cssSelector("span.order-time");
	/**我的订单页面 隐藏司机的姓名*/
	public static final By MOP_TEXT_ORDERDRIVERNAME = By.className("order-detail-row");
	/**我的订单页面 隐藏收货人的姓名*/
	public static final By MOP_TEXT_ORDERRECEIVERNAME = By.className("order-info-sr");
	
	//以下是企业版本的我的订单中的新增加的页面元素********************************************
	/**我的订单页面"自有车队的订单"*/
	public static final By MOP_TAB_MYCARS = By.xpath("//*[@role='tab' and text()='自有车队的订单']");
	/**我的订单页面"社会车辆的订单"*/
	public static final By MOP_TAB_SOCIETYCARS = By.xpath("//*[@role='tab' and text()='社会车辆的订单']");
	/**我的订单页面"社会车辆的订单-货源自己发布"*/
	public static final By MOP_RADIO_MYGOODS = By.cssSelector("input[type='radio'][value='0']"); //By.xpath("//*[@type='radio' and @value='0']")
	/**我的订单页面"社会车辆的订单-货源从平台发送"*/
	public static final By MOP_RADIO_PLATFORMGOODS = By.cssSelector("input[type='radio'][value='1']");
	/**我的订单页面 订单的数目：只含有货物信息*/
	public static final By MOP_EP_TEXT_ORDERSINFOES = By.className("order-infobox");
	/**我的订单页面 订单收货地址*/
	public static final By MOP_EP_TEXT_ADDRESS = By.cssSelector("p.in-city-highlight");

}

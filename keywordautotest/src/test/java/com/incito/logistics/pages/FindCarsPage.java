package com.incito.logistics.pages;


import org.openqa.selenium.By;
/**
 * @author wangyang
 *  @description 找车源的页面元素声明
 * */
public class FindCarsPage {
	/**星级*/
	public static final By FCP_TEXT_STAR = By.className("rateit-range");
	/** 线路方向 出发地 */
	public static final By FCP_INPUT_FROM = By.id("carcity");
	/** 线路方向 目的地 */
	public static final By FCP_INPUT_TO = By.id("targetcity");
	/** 基本搜索按钮 */
	public static final By FCP_BUTTON_SEARCH = By.id("search_submit_btn");
	/**高级搜索按钮 */
	public static final By FCP_BUTTON_ADVSEARCH = By.xpath("//button[2]");  
	/** 开始车长 */
	public static final By FCP_INPUT_STARTCARLEN = By.name("startcarlong");
	/** 结束车长*/
	public static final By FCP_INPUT_ENDCARLEN = By.name("endcarlong");
	/** 开始重量 */
	public static final By FCP_INPUT_STARTWEIGHT = By.name("startload");
	/** 结束重量 */
	public static final By FCP_INPUT_ENDWEIGHT = By.name("endload");
	/**开始容积*/
	public static final By FCP_INPUT_STARTVOLUME = By.name("startvolume");
	/**结束容积*/
	public static final By FCP_INPUT_ENDVOLUME = By.name("endvolume");
	/**车型输入框*/
	public static final By FCP_INPUT_CARTYPE = By.id("cartype");
	
	/************排序按钮*************/
	/**默认排序*/
	public static final By FCP_BUTTON_DEFAULT = By.id("li_order_default");
	/** 按照信用等级排序 */
	public static final By FCP_BUTTON_CREDIT = By.id("li_order_carcredit");
	/** 按照车长排序 */
	public static final By FCP_BUTTON_CARLEN = By.id("li_order_carlength");
	/** 按照载重排序 */
	public static final By FCP_BUTTON_WEIGHT = By.id("li_order_totalload");
	/** 按照容积排序 */
	public static final By FCP_BUTTON_VOLUME = By.id("li_order_volume");
	
	/**排序箭头- 上*/
	public static final By FCP_IMG_UPARROW = By.cssSelector("i.icon-arrow-up");
	/**排序箭头-下*/
	public static final By FCP_IMG_DOWNARROW = By.cssSelector("i.icon-arrow-down");
	
	/************排序按钮*************/
	
	/***2个tabs****/
	/**公共车源*/
	public static final By FCP_TAB_PUBLIC = By.id("findcarsTab0");
	/**我的收藏*/
	public static final By FCP_TAB_FAV = By.id("findcarsTab1");
	
	/**每个车源中的 车辆城市 */
	public static final By FCP_SPAN_LOCATOR = By.xpath("//*[@class='text-major']");
	
	/**没有数据的提示语*/
	public static final By FCP_DIV_MENTION = By.cssSelector("b");
	/**每个车源中的第二行 信息 车牌号，车长，吨位以及体积等信息*/
	public static final By FCP_DIV_CARINFO2 = By.xpath("//*/div[2]/p[2]");
	/**每个车源中的第三行 信息 驾驶员*/
	public static final By FCP_DIV_CARINFO3 = By.xpath("//*/div[2]/p[3]");
	/**每个车源的第一行数据*/
	public static final By FCP_DIV_CARINFO1 = By.className("cars-p-first");
	/**收藏车源按钮*/
	public  static final By FCP_BUTTON_FAV = By.xpath("//*[text()='收藏']");
	/**取消收藏车源按钮*/
	public  static final By FCP_BUTTON_CFAV = By.xpath("//*[text()='取消收藏']");
	/**单独的一个车源信息*/
	public static final By FCP_ITEM_INFOS = By.xpath("//*[@class='col-xs-8 ']");
}

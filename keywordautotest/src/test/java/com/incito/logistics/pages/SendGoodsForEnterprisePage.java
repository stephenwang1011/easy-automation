package com.incito.logistics.pages;
import org.openqa.selenium.By;

/**
 * @Description 发布货源页面上的元素声明
 * @author xy-incito-wy
 * */
public class SendGoodsForEnterprisePage {
	/** 发布货源界面上的货源出发地 */
	public final static By SGP_INPUT_GOODSORIGINALCITY = By.name("originalcity");
	/** 发布货源上的收货地 */
	public final static By SGP_INPUT_GOODSRECEIPTCITY = By.name("receiptcity");
	/** 发布货源界面山的货物名称输入框 */
	public final static By SGP_INPUT_GOODSNAME = By.id("goodsname");
	/**详细货物名称*/
	public final static By SGP_INPUT_GOODSDETAILS = By.id("goodsnamedetail");
	/** 重量输入框 */
	public final static By SGP_INPUT_WEIGHT = By.id("weight");
	/** 体积输入框 */
	public final static By SGP_INPUT_VOLUME = By.id("volume");
	/** 车长要求 */
	public final static By SGP_INPUT_CARLENGTH = By.name("carlength");
	/**车型要求*/
	public final static By SGP_INPUT_CARTYPE = By.name("fitcartype");
	/** 件数 */
	public final static By SGP_INPUT_COUNT = By.id("count");
	/** 运费 */
	public final static By SGP_INPUT_FARE = By.id("fare");
	/** 声明价值 */
	public final static By SGP_INPUT_DECLAREVALUE = By.id("declaredvalue");
	/** 信息费 */
	public final static By SGP_INPUT_INFOFARE = By.id("infofare");
	/** 有效期3天 */
	public final static By SGP_BUTTON_GOODSDATE3 = By.xpath("//*[@name='fetchdate' and @value='3']");
	/** 有效期5天 */
	public final static By SGP_BUTTON_GOODSDATE5 = By.xpath("//*[@name='fetchdate' and @value='5']");
	/** 有效期7天 */
	public final static By SGP_BUTTON_GOODSDATE7 = By.xpath("//*[@name='fetchdate' and @value='7']");
	
	/** 发布按钮 */
	public final static By SGP_BUTTON_SEND = By.xpath("//*[text()='发布']");
	/** 清空按钮 */
	public final static By SGP_BUTTON_RESET = By.xpath("//*[text()='清空']");
	/**货源说明输入框*/
	public final static By SGP_INPUT_INSTRUCTION = By.name("memo");	
	
	
	/**发布货源失败以后 发货地的的标示：必填字段*/
	public final static By SGP_TEXT_ORIGINALCITYERROR = By.xpath("//label[@class='error' and @for='originalcity']");
	/**发布货源失败以后 收货地的的标示：必填字段*/
	public final static By SGP_TEXT_RECEIPTCITYERROR = By.xpath("//label[@class='error' and @for='receiptcity']");
	/**发布货源失败以后 货物名称的的标示：必填字段*/
	public final static By SGP_TEXT_GOODSNAMEERROR = By.xpath("//label[@class='error' and @for='goodsname']");
	/**发布货源失败以后 重量的标示：必填字段*/
	public final static By SGP_TEXT_WEIGHTERROR = By.xpath("//label[@class='error' and @for='weight']");
	/**发布货源失败以后 体积的标示：必填字段*/
	public final static By SGP_TEXT_VOLUMEERROR = By.xpath("//label[@class='error' and @for='volume']");
	/**货物的预留的几十个名称*/
	public final static By SGP_TEXT_GOODSNAMECHOICE = By.id("goodsnamechoice");
	/**车型的预留的几十个名称*/
	public final static By SGP_TEXT_CARTYPE = By.xpath("//*[@id='publishForm']/div[4]/div[2]/table");
	/**车长的预留的几十个名称*/
	public final static By SGP_TEXT_CARLENGTH = By.xpath("//*[@id='publishForm']/div[4]/div[1]/table");
	
	/**货物说明 输入框的 统计字符区域*/
	public final static By SGP_TEXT_MEMEOCOUNT = By.className("publishInfo-memo");
	/**货物说明数字统计*/
	public final static By SGP_TEXT_MEMOREMAIN = By.id("leftChars");
	/**货物重量，超过重量提示语*/
	public final static By SGP_TEXT_WEIGHTPROMPT = By.xpath("//*[@id='input_weight']/label");
	/**货物体积，超过体积提示语*/
	public final static By SGP_TEXT_VOLUMEPROMPT = By.xpath("//*[@id='input_volume']/label");
	/**货物重量，超过重量提示语*/
	public final static By SGP_TEXT_COUNTPROMPT = By.xpath("//*[@for='count']");
	
	
	/**发布到平台*/
	public static final By SGP_LINK_SENDPLATAM = By.linkText("发布到平台");
	/**发布到车队*/
	public static final By SGP_LINK_SENDCARS = By.linkText("发布到车队");
	
	/******************************下面是企业版的发布货源界面 - 发布到车队***************************/
	/**发货人的街道信息*/
	public static final By SGP_INPUT_SENDERSTREET =  By.name("originalstreet");
	/**添加发货人的按钮*/
	public static final By SGP_BUTTON_ADDSENDER = By.id("addShipperBtn");
	/**收货人的街道信息*/
	public static final By SGP_INPUT_RECEIPTSTREET =  By.name("receiptstreet");
	/**添加收货人的按钮*/
	public static final By SGP_BUTTON_ADDRECEIPT = By.id("addReceiptBtn");
	/**货物类型 - 重货*/
	public static final By SGP_RADIOBOX_HEAVYGOODS = By.xpath("//*[@name='goodstype' and @value='1']");
	/**货物类型-抛货*/
	public static final By SGP_RADIOBOX_LIGHTGOODS = By.xpath("//*[@name='goodstype' and @value='2']");
	/**货物类型-设备*/
	public static final By SGP_RADIOBOX_DEVICEGOODS = By.xpath("//*[@name='goodstype' and @value='3']");
	
	/**是否允许司机抢单 - 是*/
	public static final By SGP_RADIOBOX_YES = By.xpath("//*[@name='grabswitch' and @value='1']");
	/**是否允许司机抢单 - 否*/
	public static final By SGP_RADIOBOX_NO = By.xpath("//*[@name='grabswitch' and @value='0']");
	
	
	//点开添加发货人按钮出现的元素
	/**发货人姓名*/
	public static final By SGP_INPUT_SENDERNAME = By.id("shipper_name");
	/**发货人电话*/
	public static final By SGP_INPUT_SENDERTEL = By.name("shipper.mobile");
	/**发货人公司*/
	public static final By SGP_INPUT_SENDERCOMPANY= By.name("shipper.company");
	
	//点击添加收货人按钮出现的元素
	/**收货人姓名*/
	public static final By SGP_INPUT_RECEIPTNAME = By.id("consigne_name");
	/**收货人电话*/
	public static final By SGP_INPUT_RECEIPTTEL = By.name("consigne.mobile");
	/**收货人公司*/
	public static final By SGP_INPUT_RECEIPTCOMPANY= By.name("consigne.company");
	
	
	/**定义一个空BY*/
	public static final By SGP_NUKNOW_BY = By.name("");
	
	
	
}

package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.incito.logistics.pages.SendGoodsForEnterprisePage;
import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

public class SendGoodsPageHelper {
	public static Logger logger = Logger.getLogger(SendGoodsPageHelper.class.getName());

	
	
	
	/** 等待发布货源页面上某个重要元素显示出来 */
	public static void waitSendGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {

		logger.info("Start checking SendGoods Page elements");
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSORIGINALCITY);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSRECEIPTCITY);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSNAME);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_GOODSDETAILS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_HEAVYGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_DEVICEGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_LIGHTGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_CARLENGTH);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_CARTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_COUNT);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_FARE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_DECLAREVALUE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_INFOFARE);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_GOODSDATE3);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_GOODSDATE5);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_GOODSDATE7);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_SEND);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_BUTTON_RESET);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsPage.SGP_INPUT_INSTRUCTION);
		logger.info("Checking SendGoods Page elements completed");
	}
	/** 检查发布货源页面页面上的文本 */
	public static void checkSendGoodsPageText(SeleniumUtil seleniumUtil) {
		logger.info("Starting checking sendgoods page text");
		// seleniumUtil.isTextCorrect(seleniumUtil.getTitle(),
		// "logistics - 物流管理");

		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Checking sendgoods page text completed");
	}

	/**
	 * 在发布货源界面上输入相关信息<br>
	 * 
	 * 
	 * 
	 * */
	public static void typeGoodsInfo(SeleniumUtil seleniumUtil, By goodsType, By goodsDate, String... info) {
		// 填充发货地
		String jsFrom = "document.getElementsByName('originalcity')[0].setAttribute('value','" + info[0].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('receiptcity')[0].setAttribute('value','" + info[1].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsTo);
		// 选择货物类型
		if (seleniumUtil.findElementBy(goodsType).isSelected() == false) {
			seleniumUtil.click(seleniumUtil.findElementBy(goodsType));
		}
		// 货物名称
		String goodsName = "document.getElementsByName('goodsname')[0].setAttribute('value','" + info[2].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(goodsName);
		// 货物详细名称
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_GOODSDETAILS), info[3].toString());
		// 货物重量 or 体积
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_DEVICEGOODS).isSelected() || seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_HEAVYGOODS).isSelected()) {
			seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_WEIGHT), info[4].toString());
		} else if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_LIGHTGOODS).isSelected()) {
			seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_VOLUME), info[4].toString());
		}
		// 货物件数
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_COUNT), info[5].toString());
		// 车长要求
		String carLen = "document.getElementsByName('carlength')[0].setAttribute('value','" + info[6].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(carLen);
		// 车型要求
		String carType = "document.getElementsByName('fitcartype')[0].setAttribute('value','" + info[7].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(carType);
		// 信息费
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_INFOFARE), info[8].toString());
		// 运费
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_FARE), info[9].toString());
		// 声明价值
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_DECLAREVALUE), info[10].toString());
		// 信息有效期
		if (seleniumUtil.findElementBy(goodsDate).isSelected() == false) {
			seleniumUtil.click(seleniumUtil.findElementBy(goodsDate));
		}
		// 货源说明
		seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_INSTRUCTION), info[11].toString());

	}
	
	

	/** 从发布货源界面上点击按钮或者链接进入相关页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}

	/** 检查发布货源失败-全部必填 不填写时 */
	public static void checkSendGoodsAllEmptyFailedStatus(SeleniumUtil seleniumUtil) {
		logger.info("Starting checking sendgoods page error text");
		seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_ORIGINALCITYERROR);
		seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_GOODSNAMEERROR);
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_DEVICEGOODS).isSelected() || seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_HEAVYGOODS).isSelected()) {
			seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_WEIGHTERROR);
		}
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_LIGHTGOODS).isSelected()) {
			seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_VOLUMEERROR);
		}
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_ORIGINALCITYERROR).getText(), "必填信息");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_GOODSNAMEERROR).getText(), "必填信息");
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_DEVICEGOODS).isSelected() || seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_HEAVYGOODS).isSelected()) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_WEIGHTERROR).getText(), "必填信息");
		}
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_LIGHTGOODS).isSelected()) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_VOLUMEERROR).getText(), "必填信息");
		}

		logger.info("Checking sendgoods page error text complete");

	}

	/** 检查发布货源失败-其中某一个或者某个必填项没有填写，我们只用检查，发布按钮是不是还存在，来判断是不是发布成功 */
	public static void checkSendStatus(SeleniumUtil seleniumUtil) {
		logger.info("开始检查发布货源是否成功");
		seleniumUtil.isDisplayed(seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_SEND));
		seleniumUtil.isDisplayed(seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_RESET));
		logger.info("找到了发布和清空按钮，证明货源没有发布出出去");
	}
	
	/**检查货物名称、车型、车长所有的文本*/
	public static void checkReserveText(SeleniumUtil seleniumUtil,int timeOut,By elementLocator,String expect){
		logger.info("Start checking reserve text ");
		seleniumUtil.waitForElementToLoad(timeOut, elementLocator);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(elementLocator).getText(),expect);
		logger.info("Checking reserve text complete");

	}
	
	/**检查货物说明字数统计是不是正确*/
	public static void checkRemainText(SeleniumUtil seleniumUtil,String comment){
		char ch[] = comment.toCharArray();
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_MEMOREMAIN).getText(),"50");
		for (int i = 0; i < ch.length; i++) {
			seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_INSTRUCTION), String.valueOf(ch[i]));
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsPage.SGP_TEXT_MEMOREMAIN).getText(),String.valueOf(ch.length-i-1));
	
		}
	
	}
	/**企业版发布货源 货物详情字数统计*/
	public static void checkRemainTextForEnterprise(SeleniumUtil seleniumUtil,String comment){
		char ch[] = comment.toCharArray();
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsForEnterprisePage.SGP_TEXT_MEMOREMAIN).getText(),"50");
		for (int i = 0; i < ch.length; i++) {
			seleniumUtil.type(seleniumUtil.findElementBy(SendGoodsPage.SGP_INPUT_INSTRUCTION), String.valueOf(ch[i]));
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsForEnterprisePage.SGP_TEXT_MEMOREMAIN).getText(),String.valueOf(ch.length-i-1));
	
		}
	
	}
	
	
	/**检查输入框的输入信息-编辑的时候会用到*/
	public static void checkInput(SeleniumUtil seleniumUtil,By goodsType, By goodsDate,String ...inputs){
		logger.info("Checking the goods infos when try to edit it");
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_GOODSORIGINALCITY, "value"), inputs[0]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_GOODSRECEIPTCITY, "value"), inputs[1]);
		try{
		Assert.assertTrue(seleniumUtil.findElementBy(goodsType).isSelected());
		}catch(AssertionError ae){
			logger.error("["+seleniumUtil.getLocatorByElement(seleniumUtil.findElementBy(goodsType), ">")+"] : is not selected when edit this goods infos");
			Assert.fail("["+seleniumUtil.getLocatorByElement(seleniumUtil.findElementBy(goodsType), ">")+"] : is not selected when edit this goods infos");
			
		}
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_GOODSNAME, "value"), inputs[2]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_GOODSDETAILS, "value"), inputs[3]);
		if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_DEVICEGOODS).isSelected() || seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_HEAVYGOODS).isSelected()) {
			seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_WEIGHT, "value"), inputs[4]);
		} else if (seleniumUtil.findElementBy(SendGoodsPage.SGP_BUTTON_LIGHTGOODS).isSelected()) {
			seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_VOLUME, "value"), inputs[4]);
		}

		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_COUNT, "value"), inputs[5]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_CARLENGTH, "value"), inputs[6]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_CARTYPE, "value"), inputs[7]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_INFOFARE, "value"), inputs[8]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_FARE, "value"), inputs[9]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(SendGoodsPage.SGP_INPUT_DECLAREVALUE, "value"), inputs[10]);
		try{
		Assert.assertTrue(seleniumUtil.findElementBy(goodsDate).isSelected());
		}catch(AssertionError ae){
			logger.error("["+seleniumUtil.getLocatorByElement(seleniumUtil.findElementBy(goodsDate), ">")+"] : is not selected when edit this goods infos");
			Assert.fail("["+seleniumUtil.getLocatorByElement(seleniumUtil.findElementBy(goodsDate), ">")+"] : is not selected when edit this goods infos");	

		}
		seleniumUtil.isTextCorrect(seleniumUtil.getText(SendGoodsPage.SGP_INPUT_INSTRUCTION),inputs[11]);
		logger.info("All infos for this goods are correct when try to edit it");
		
	}

}

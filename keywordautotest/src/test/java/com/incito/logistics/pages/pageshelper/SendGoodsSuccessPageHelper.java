package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.SendGoodsSuccessPage;
import com.incito.logistics.util.SeleniumUtil;

public class SendGoodsSuccessPageHelper {
	public static Logger logger = Logger.getLogger(SendGoodsSuccessPageHelper.class.getName());

	/** 等待发布货源成功页面上某个重要元素显示出来 */
	public static void waitSendGoodsSuccessPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		
		logger.info("Start checking SendGoods Page elements");
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_TEXT_SUCCESS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_BUTTON_SENDAGAIN);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_BUTTON_CHECK);
		logger.info("Checking SendGoods Page elements completed");
	}
	

	/** 等待发布货源成功页面上某个重要元素显示出来 */
	public static void waitSendGoodsSuccessPageToLoadForEnterprise(int timeOut, SeleniumUtil seleniumUtil) {
		
		logger.info("Start checking SendGoods Page elements");
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_TEXT_SUCCESS);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_BUTTON_SENDAGAIN);
		seleniumUtil.waitForElementToLoad(timeOut, SendGoodsSuccessPage.SGSP_BUTTON_CHECK1);
		logger.info("Checking SendGoods Page elements completed");
	}

	/** 检查发布货源页面页面上的文本 */
	public static void checkSendGoodsPageText(SeleniumUtil seleniumUtil) {
		logger.info("Starting checking sendgoods page text");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_TEXT_SUCCESS).getText(), "货源发布成功！");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_BUTTON_SENDAGAIN).getText(), "再发布一条");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_BUTTON_CHECK).getText(), "查看发布的货源");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Checking sendgoods page text completed");
	}
	
	/** 检查发布货源页面页面上的文本 */
	public static void checkSendGoodsPageTextForEnterprise(SeleniumUtil seleniumUtil) {
		logger.info("Starting checking sendgoods page text");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_TEXT_SUCCESS).getText(), "货源发布成功！");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_BUTTON_SENDAGAIN).getText(), "再发布一条");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(SendGoodsSuccessPage.SGSP_BUTTON_CHECK1).getText(), "查看已发货源");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Checking sendgoods page text completed");
	}
	
	/**从发布货源成功页面上点击相应的按钮进入相应的页面*/
	public static void enterPage(SeleniumUtil seleniumUtil,By elementLocator,int timeOut){
		seleniumUtil.waitForElementToLoad(timeOut, elementLocator);
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

}

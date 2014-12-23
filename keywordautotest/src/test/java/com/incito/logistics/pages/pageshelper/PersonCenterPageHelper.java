package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.PersonCenterPage;
import com.incito.logistics.util.SeleniumUtil;

public class PersonCenterPageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());
	// 等待页面上某个重要元素显示出来
	public static void waitPensonCenterPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking my order page web element");
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_CONTANTS);
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_TEL);
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_ADDRESS);
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_MYGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_MYORDERS);
		seleniumUtil.waitForElementToLoad(timeOut, PersonCenterPage.PCP_TEXT_MYFAVO);
		logger.info("Checking my order page web element complete");
	}
	
	/** 检查个人中心页面上的文本 */
	public static void checkPersonCenterPageText(SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(PersonCenterPage.PCP_TEXT_MYGOODS).getText().trim(), "我的货源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(PersonCenterPage.PCP_TEXT_MYORDERS).getText().trim(), "我的订单");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(PersonCenterPage.PCP_TEXT_MYFAVO).getText().trim(), "我的收藏");
	}
	
	/** 从当前页面进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}
}

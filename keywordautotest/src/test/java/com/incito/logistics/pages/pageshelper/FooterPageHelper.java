package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.incito.logistics.pages.FootPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.util.SeleniumUtil;

public class FooterPageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());

	/** 根据元素定位来确定进入什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	/** 检查底部相关信息：关于我们，联系我们，帮助中心等 */
	public static void checkFooterPageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking footer page elements");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_FOOTER).getText(), "联系我们 | 关于我们 | 帮助中心" + "\n" + "Incito Information Technology Co.,Ltd 2014 Incito Co.,Ltd." + "\n" + "©2014 Incito Co.,Ltd.All rights reserved." + "\n" + "鄂ICP备13016476号 公司邮箱：wuliu@incito.com.cn 客服热线：400-860-3060(周一至周日 9：00——18：00)");
		logger.info("Checking footer page elements completed");
	}

	/** 等待顶部TAB元素和底部相关信息显示出来 */
	public static void waitTAB_Foot_FourInfoToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking home page elements");
		// 顶部的6个大tab检查
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_HOME);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_FINDGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_MYORDER);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_MYGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_CENTER);
		// 底部的3个相关信息:联系我们，关于我们，帮助中心
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_ABOUTUS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_CONTACTUS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_LINK_HELP);
		// 中间四条信息：联系我们、关于我们、帮助中心、运营活动
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_HOST_LINK_CONTACTUS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_HOST_LINK_ABOUTUS);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_HOST_LINK_HELP);
		seleniumUtil.waitForElementToLoad(timeOut, FootPage.FP_HOST_LINK_COA);
		logger.info("Check home page elements completed");
	}

	public static void checkFootPageText(SeleniumUtil seleniumUtil, By by) {
		String temp = seleniumUtil.findElementBy(by).getText();
		temp = temp.replaceAll(" ", "");
		try {
			Assert.assertTrue(seleniumUtil.findElementBy(by).getAttribute("class").equals("active"));
		} catch (AssertionError e) {
			logger.error("你查找的的页面【" + temp + "】不能正常显示");
			Assert.fail("你查找的的页面【" + temp + "】不能正常显示");
		}
		switch (temp) {
		case "联系我们":
			logger.info("你查看的页面【联系我们】能够正常显示");
			break;
		case "关于我们":
			logger.info("你查看的页面【关于我们】能够正常显示");
			break;
		case "帮助中心":
			logger.info("你查看的页面【帮助中心】能够正常显示");
			break;
		case "运营活动":
			logger.info("你查看的页面【运营活动】能够正常显示");
			break;
		default:
			logger.info("你查看的页面【" + temp + "】不能正常显示");
			return;
		}
	}
}

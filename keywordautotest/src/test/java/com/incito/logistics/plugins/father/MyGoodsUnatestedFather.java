package com.incito.logistics.plugins.father;

import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wk
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class MyGoodsUnatestedFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/** 首页上未认证用户的登录操作以及相关数据准备 **/
	public static void UnattestedMyOrdersParpare(ITestContext context, SeleniumUtil seleniumUtil) {
		String userInfoPath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String unattestedUsername = PropertiesDataProvider.getTestData(userInfoPath, "unauthusername");
		String unattestedPassword = PropertiesDataProvider.getTestData(userInfoPath, "unauthpassword");
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, unattestedUsername, unattestedPassword);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, unattestedUsername);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYGOODS);
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
	}
}

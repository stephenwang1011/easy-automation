package com.incito.logistics.plugins.father;
import org.testng.ITestContext;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;
/**
 * @author wangyang
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * 
 * */
public class OrderFlowFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;
/**
 * 订单流程的登录继承登录操作
 * */
	public static void flowParpare(ITestContext context, SeleniumUtil seleniumUtil) {

		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "password");
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);

	}

}

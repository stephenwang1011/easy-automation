package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

/**
 * @author xy-incito-wy
 * @Description 主页未登录的情况下 点击“找车源” 应该弹出登陆界面
 * 
 * */
public class HomePage_001_NotLogin_FindCars_Test extends BaseParpare {
	@Test
	public void findCars(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDCARS);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_CLOSE);

	}
}

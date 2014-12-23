package com.incito.logistics.plugins.father;

import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author wangyang
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * 
 * */
public class HomeNotLoginFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/**
	 * 未登录时，在首页上的相关准备工作
	 * */
	public static void homeNotLoginParpare(ITestContext context, SeleniumUtil seleniumUtil) {

		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
	
	}

}

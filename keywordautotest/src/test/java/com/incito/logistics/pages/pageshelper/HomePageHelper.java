package com.incito.logistics.pages.pageshelper;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.util.SeleniumUtil;

public class HomePageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());

	/** 等待首页上元素显示出来 */
	public static void waitHomePageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking home page elements");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_LOGIN);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_REG);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FREESEND);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_HOME);
		// seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_PERSONCEN);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_FINDGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYORDER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYGOODS);
		// seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYCARDS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_TRACKGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_INPUT_ORDERNO);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LEFT_TITLE);
		// seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_CHANGEANOTHER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_FOOTER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_ARERA_ITEMS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MORE);
		logger.info("Check home page elements completed");
	}

	/** 检查首页上的文本 */
	public static void checkHomePageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking home page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN).getText(), "登录");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_BUTTON_REG).getText(), "注册");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TAB_FINDCARS).getText(), "找车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TAB_TRACKGOODS).getText(), "物流跟踪");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LEFT_TITLE).getText(), "智慧物流" + "\n" + "全球领先的物流信息平台");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_HOME).getText(), "首页");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_PERSONCEN).getText(),"个人中心");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDCARS).getText(), "找车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDGOODS).getText(), "找货源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYORDER).getText(), "我的订单");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYGOODS).getText(), "我的货源");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYCARDS).getText(),
		// "我的车队");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Check home page text completed");

	}

	/** 从首页进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}

	/** 从首页进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator, int index) {
		seleniumUtil.click(seleniumUtil.findElementsBy(elementLocator).get(index));

	}

	/** 从首页进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By bys, By by, int index) {
		seleniumUtil.click(seleniumUtil.getOneElement(bys, by, index));
	}

	/** 在首页暂停一会儿 */
	public static void holdOn(SeleniumUtil seleniumUtil, int sleepTime) {
		seleniumUtil.pause(sleepTime);
	}

	/** 检查首页的相关UI界面 */
	// public static void checkUI(SeleniumUtil seleniumUtil){
	// Screen s = new Screen();
	// String screenWidth = String.valueOf(SeleniumUtil.getScreenWidth());
	// logger.info("当前屏幕的宽度是："+screenWidth);
	// if(screenWidth.equals("1366.0")){
	// logger.info("开始检查首页的UI");
	// seleniumUtil.isImgExist(s, "/res/img/home/1366_768/logo.png");
	// seleniumUtil.isImgExist(s, "/res/img/home/1366_768/tabs.png");
	// logger.info("检查首页的UI完成");
	// }
	// if(screenWidth.equals("1024.0")){
	// logger.info("开始检查首页的UI");
	// seleniumUtil.isImgExist(s, "/res/img/home/1024_768/logo.png");
	// seleniumUtil.isImgExist(s, "/res/img/home/1024_768/tabs.png");
	// logger.info("检查首页的UI完成");
	// }
	// }

	/** 未登录的情况下，检查车源中的驾驶证信息 */
	public static void checkLicenseInNotLoginStatus(SeleniumUtil seleniumUtil) {
		int size = seleniumUtil.findElementsBy(HomePage.HP_ARERA_GOODSANDCARS).get(0).findElements(HomePage.HP_CARS_INFO2).size(); // 公共车源有多少
		for (int i = 0; i < size; i++) {
			seleniumUtil.isContains(seleniumUtil.findElementsBy(HomePage.HP_ARERA_GOODSANDCARS).get(0).findElements(HomePage.HP_CARS_INFO2).get(i).getText(), "***");
		}
	}

	/** 未登录情况下，鼠标滑动页面到底部，并点击返回顶部按钮 */
	public static void backToTopCheck(SeleniumUtil seleniumUtil, int timeOut) {
		seleniumUtil.mouseMoveToElement(HomePage.HP_TEXT_FOOTER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_BACK);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_BACK));
		if (seleniumUtil.findElementBy(HomePage.HP_BUTTON_BACK).isDisplayed() == false) {
			logger.info("Back to top function works well - PASSED");
		} else {
			backToTopCheck(seleniumUtil, timeOut);
		}
	}

	/** 首页快速查找车源，订单和货源的方法 整合 */
	public static void typeQuickSearchInfo(SeleniumUtil seleniumUtil, String... quickSearchInfos) {
		switch (quickSearchInfos[3]) {
		case "找车源":
			if (quickSearchInfos[0] != "") {
				String jsFrom = "document.getElementsByName('carcity')[0].setAttribute('value','" + quickSearchInfos[0].toString() + "');";
				seleniumUtil.executeJS(jsFrom);
			}
			if (quickSearchInfos[1] != "") {
				String jsTo = "document.getElementsByName('targetcity')[1].setAttribute('value','" + quickSearchInfos[1].toString() + "');";
				seleniumUtil.executeJS(jsTo);
			}
			break;

		case "找货源":
			if (quickSearchInfos[0] != "") {
				String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + quickSearchInfos[0].toString() + "');";
				seleniumUtil.executeJS(jsFrom);
			}
			if (quickSearchInfos[1] != "") {
				String jsTo = "document.getElementById('targetcity1').setAttribute('value','" + quickSearchInfos[1].toString() + "');";
//				String jsTo = "document.getElementsByName('targetcity')[2].setAttribute('value','" + quickSearchInfos[1].toString() + "');";
				seleniumUtil.executeJS(jsTo);
			}
			break;

		case "货物跟踪":
			seleniumUtil.type(seleniumUtil.findElementBy(HomePage.HP_INPUT_ORDERNO), quickSearchInfos[2].toString());
			break;
		default:
			return;
		}
	}
	
	/**快速搜索我的订单，输入不合法的订单编号提示信息*/
	public static void checkIncorrectOrderInfo(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_ORDERPROMPT).getText().trim(),"请输入正确的订单号");
		
	}
	
	/**未完成用户信息的用户在登录之后，首页上查看车源信息 驾驶证号打上了 *号*/
	public static void checkUnauthenticationUserHomeCars(SeleniumUtil seleniumUtil){
		int size = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(HomePage.HP_TEXT_SECONDINFO).size();
		for (int i = 0; i < size; i++) {
			seleniumUtil.isContains(seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(HomePage.HP_TEXT_SECONDINFO).get(i).getText(), "***");
		}

	}
	
	/**未认证的用户点击我的车源上的定位按钮，弹出alert*/
	public static void checkUnauthenticationUserLoc(SeleniumUtil seleniumUtil,int sleepTime){
		Alert alert = seleniumUtil.switchToPromptedAlertAfterWait(sleepTime);
		seleniumUtil.isTextCorrect(alert.getText(), "您还未通过认证，暂时不能查看司机当前位置");
		alert.accept();
	}

	/**检查首页上收藏（货源或车源）按钮点击之后是不是变成了取消收藏按钮*/
	public static void checkFavButton(SeleniumUtil seleniumUtil,By bys, By by, int index){
		seleniumUtil.isTextCorrect(seleniumUtil.getOneElement(bys, by, index).getText(), "取消收藏");
		
	}
	
	/**根据车牌号和驾驶者来点击 收藏或者定位按钮*/
	public static void clickFavButtonByLicenseAndDriver(String license, String driver,SeleniumUtil seleniumUtil,By favOrCfavButton){
		List<WebElement> cars_secondinfo = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(HomePage.HP_TEXT_SECONDINFO);
		List<WebElement> cars_thirdinfo = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(HomePage.HP_TEXT_THIRDINFO);
		List<WebElement> cars_fav = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(favOrCfavButton);
		int size =  cars_secondinfo.size();

		for (int i = 0; i < size; i++) {
			if(cars_secondinfo.get(i).getText().contains(license)&&cars_thirdinfo.get(i).getText().contains(driver)){
				seleniumUtil.click(cars_fav.get(i));
			}
		}

	}
	/**
	 * 点击公共货源上的第一个货源的收藏按钮
	 * */
	public static void favOnPubGoods(SeleniumUtil seleniumUtil,int timeOut,int sleepTime){
		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_BUTTON_GOODSBUTTON).get(0));//点击第一个收藏
		seleniumUtil.pause(sleepTime);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(HomePage.HP_BUTTON_GOODSBUTTON).get(1).getText(), "取消收藏");
		String address =  seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_FIRST).getText();
					address = address.replaceAll("到", "");
		String detail =  seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_SECOND).getText();
					detail = detail.replaceAll(" ", "");
		String memo = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_THIRDINFO).getText(); 
		String homeGoodsInfo[] ={address,detail,memo}; 

		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDGOODS);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		seleniumUtil.pause(sleepTime);
		
		int goodsInMyFavNum = seleniumUtil.findElementsBy(FindGoodsPage.FGP_FIRST_INFOADDRESS).size();
		for (int i = 0; i < goodsInMyFavNum; i++) {
			String addFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_TEXT_CITY).get(i).getText();
						addFav = addFav.replaceAll("至", "");
			String detailFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(i).getText();
						detailFav = detailFav.replaceAll(" ", "");
			String memoFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_TEXT_MEMO).get(i).getText();
			String favGoodsInfo[] = {addFav,detailFav,memoFav};

			if(favGoodsInfo[0].equals(homeGoodsInfo[0])&&favGoodsInfo[1].equals(homeGoodsInfo[1])&&favGoodsInfo[2].equals(homeGoodsInfo[2])){				
				logger.info("您刚才在首页收藏的货源，在找货源-我的收藏模块中存在！");
				return;
			}else{
				logger.info("第"+(i+1)+"条货源，不是您刚才收藏的货源，程序会继续检查下一条数据...");
				if(i==goodsInMyFavNum-1){
					
					logger.error("您在首页收藏的货源，在找货源-我的收藏模块中不存在！");
					Assert.fail("您在首页收藏的货源，在找货源-我的收藏模块中不存在！");
				}
				
			}
			
		}
		
	}
	
	/**
	 * 点击公共货源上的第一个货源的取消收藏按钮
	 * */
	public static void cancelFavOnPubGoods(SeleniumUtil seleniumUtil,int timeOut,int sleepTime){
		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_BUTTON_GOODSBUTTON).get(1));//点击第一个收藏
		seleniumUtil.pause(sleepTime);
		seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(HomePage.HP_BUTTON_GOODSBUTTON).get(0).getText(), "收藏");
		String address =  seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_FIRST).getText();
					address = address.replaceAll("到", "");
		String detail =  seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_SECOND).getText();
					detail = detail.replaceAll(" ", "");
		String memo = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).get(0).findElement(HomePage.HP_TEXT_THIRDINFO).getText(); 
		String homeGoodsInfo[] ={address,detail,memo}; 

		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDGOODS);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		seleniumUtil.pause(sleepTime);
		
		int goodsInMyFavNum = seleniumUtil.findElementsBy(FindGoodsPage.FGP_FIRST_INFOADDRESS).size();
		for (int i = 0; i < goodsInMyFavNum; i++) {
			String addFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_TEXT_CITY).get(i).getText();
						addFav = addFav.replaceAll("至", "");
			String detailFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(i).getText();
						detailFav = detailFav.replaceAll(" ", "");
			String memoFav = seleniumUtil.findElementsBy(FindGoodsPage.FGP_TEXT_MEMO).get(i).getText();
			String favGoodsInfo[] = {addFav,detailFav,memoFav};

			if(favGoodsInfo[0].equals(homeGoodsInfo[0])&&favGoodsInfo[1].equals(homeGoodsInfo[1])&&favGoodsInfo[2].equals(homeGoodsInfo[2])){				
				logger.error("您刚才在首页收藏的货源没有取消收藏成功！");
				Assert.fail("您刚才在首页收藏的货源没有取消收藏成功！");
		
			}else{
				logger.info("第"+(i+1)+"条货源，不是您刚才收藏的货源，程序会继续检查下一条数据...");
				if(i==goodsInMyFavNum-1){
					
					logger.info("您在首页收藏的货源，在找货源-我的收藏模块中不存在,取消收藏成功！！");
				}
				
			}
			
		}
		
	}
	
	/**检查首页公共车源和公共货源的条数*/
	public static void checkCarsGoodsItems(SeleniumUtil seleniumUtil){
		int carsssize = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(0).findElements(HomePage.HP_ARERA_ITEMS).size();
		int goodssize = seleniumUtil.findElementsBy(HomePage.HP_ARERA_CARSANDGOODS).get(1).findElements(HomePage.HP_ARERA_ITEMS).size();
		if(carsssize<=8&goodssize<=8){
			logger.info("首页上的公共车源和公共货源 条数符合需求规范（小于等于8条）");
		}else{
			
			logger.equals("首页上的公共车源和公共货源 条数不符合需求规范（大于等于8条），其中车源有："+carsssize+"条,货源有："+goodssize+"条");
			Assert.fail("首页上的公共车源和公共货源 条数不符合需求规范（大于等于8条），其中车源有："+carsssize+"条,货源有："+goodssize+"条");
		}
		
	}
	
	
	
	
	
	
	
	
	
}

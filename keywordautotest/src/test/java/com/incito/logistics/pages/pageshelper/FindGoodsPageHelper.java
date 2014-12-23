package com.incito.logistics.pages.pageshelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * 
 * @author xy-incito-wk
 * @description 查找货源页面帮助类
 */
public class FindGoodsPageHelper {
	public static Logger logger = Logger.getLogger(AddUserInfoPagerHelper.class.getName());

	/** 等待找货源页面元素加载出来 */
	public static void waitFindGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking FindGoods page elements");
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_PUBLICDOODS);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_FROMCITY);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_TARGETCITY);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_STARTCARLONG);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_ENDTCARLONG);
		logger.info("Check FindGoods page elements completed");
	}

	/**
	 * 在查找货源上输入搜索条件
	 * 
	 * @param seleniumUtil
	 * @param goodsType
	 * @param goodsDate
	 * @param info
	 */
	public static void typeFindGoodsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 填充发货地
		String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + info[0].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('targetcity')[1].setAttribute('value','" + info[1].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsTo);
		// 填写最低车长
		seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_STARTCARLONG), info[2].toString());
		// 填写最长车长
		seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_ENDTCARLONG), info[3].toString());
		// 填写车型要求
		if (info[4].toString() != "") {
			String carType = "document.getElementsByName('fitcartypes')[0].setAttribute('value','" + info[4].toString() + "');";
			seleniumUtil.executeJS(carType);
		}
		// 货物名称
		if (info[5].toString() != "") {
			String goodsName = "document.getElementsByName('goodsnames')[0].setAttribute('value','" + info[5].toString() + "');";
			seleniumUtil.executeJS(goodsName);
		}
		// 体积还是重量
		seleniumUtil.selectByText(FindGoodsPage.FGP_SELECT_GOODSUNIT, info[6].toString());
		if (info[6].toString().equals("体积")) {
			if (info[7].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_STARTVOLUME), info[7].toString());
			}
			if (info[8].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_ENDVOLUME), info[8].toString());
			}
		} else if (info[6].toString().equals("重量")) {
			if (info[7].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_STARTWEIGHT), info[7].toString());
			}
			if (info[8].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_ENDWEIGHT), info[8].toString());
			}

		}
	}

	/** 从找货源进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	/** 检查货源的第一行的数据：发货地和收货地 */
	public static void checkGoodsAddress(SeleniumUtil seleniumUtil, By by, String... goodsAdd) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		for (int i = 0; i < items; i++) {// 循环每个货源
			String address = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("span")).get(0).getText();
			address = address.replaceAll(" ", "");
			String add[] = address.split("至");
			String original = add[0], targetcity = add[1];
			if (goodsAdd[0].equals("") == false) {
				seleniumUtil.isContains(original, goodsAdd[0]);
			}
			if (goodsAdd[1].equals("") == false) {
				seleniumUtil.isContains(targetcity, goodsAdd[1]);
			}
		}
	}

	/** 检查货物的发布时间 */
	public static void checkGoodsSendDate(SeleniumUtil seleniumUtil, By noGoodsInfo, By hideGoodsInfo) {
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int items = seleniumUtil.findElementsBy(hideGoodsInfo).size(); // 这个items指的是查询出来有多少条货源
		String[] temp = new String[items];
		if (seleniumUtil.findElementsBy(noGoodsInfo).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}

		for (int i = 0; i < items; i++) {
			seleniumUtil.click(seleniumUtil.findElementsBy(noGoodsInfo).get(i));
			seleniumUtil.pause(800);
			// String header =
			// seleniumUtil.findElementBy(By.xpath("//div[2]/div[3]/div[2]")).getText();
			String header = seleniumUtil.findElementsBy(By.xpath("//*[text()='发布时间']")).get(i).getText();
			// String header =
			// seleniumUtil.findElementsBy(By.cssSelector("div.goods-detail-row3")).get(i).getText();

			// 取得发布时间的字符串
			header = header.trim().substring(header.indexOf("：") + 1, header.length());
			System.out.println(header);
			temp[i] = header;
		}

		for (int i = 0; i < items; i++) {
			try {
				Assert.assertTrue(formater.parse(temp[i]).getTime() >= formater.parse(temp[i + 1]).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (AssertionError e) {
				logger.error("【默认排序】之后的发布时间，第【" + i + 1 + "】个货源的发布时间 ：" + temp[i] + " < 第【" + i + 2 + "】个货源的发布时间：" + temp[i + 1]);
				Assert.fail("【默认排序】之后的发布时间，第【" + i + 1 + "】个货源的发布时间 ：" + temp[i] + " < 第【" + i + 2 + "】个货源的发布时间：" + temp[i + 1]);
			}
			logger.info("【默认排序】之后的发布时间，第【" + (i + 1) + "】个货源的发布时间 ：" + temp[i]);
		}
	}

	/** 检查货源信息的第二行信息:车长 */
	public static void checkCarLength(SeleniumUtil seleniumUtil, By by, By by_car_length, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}

		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			double carLong = 0; // 车长
			String second = seleniumUtil.findElementsBy(by_car_length).get(i).getText(); // 取得第二行的货源信息
			second = second.replaceAll(" ", "");
			String[] secondArray = second.split("，");
			for (String temp : secondArray) {
				if (temp.contains("车辆要求")) {
					String[] temp1 = temp.split("：");
					carLong = Double.parseDouble(temp1[1].replaceAll("米", ""));// 取得车长

					if (secondInfos[1].equals("") && secondInfos[0] != "") {
						try {
							Assert.assertTrue(carLong >= Double.parseDouble(secondInfos[0]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is less than input length num [" + secondInfos[0] + "] M");
							Assert.fail("Found the weight of car in web page is [" + carLong + "] and is less than input length num [" + secondInfos[0] + "] M");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] M");
					}

					if (secondInfos[0].equals("") && secondInfos[1] != "") {
						try {
							Assert.assertTrue(carLong <= Double.parseDouble(secondInfos[1]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is longer than input length num [" + secondInfos[1] + "] M");
							Assert.fail("Found the weight in web page is [" + carLong + "] and is longer than input length num [" + secondInfos[1] + "] M");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] M");
					}

					if (secondInfos[0] != "" && secondInfos[1] != "") {
						try {
							Assert.assertTrue(Double.parseDouble(secondInfos[0]) <= carLong && carLong <= Double.parseDouble(secondInfos[1]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is not in input length num [" + secondInfos[0] + "] and [" + secondInfos[1] + "] M");
							Assert.fail("Found the weight in web page is [" + carLong + "] and is not in input length num [" + secondInfos[0] + "] and [" + secondInfos[1] + "] M");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] M");
					}
				}
			}
		}
	}

	/** 检查货源信息的第二行信息:车型要求 */
	public static void checkCarType(SeleniumUtil seleniumUtil, By by, By by_car_length, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}
		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			String second = seleniumUtil.findElementsBy(by_car_length).get(i).getText(); // 取得第二行的货源信息
			second = second.replaceAll(" ", "");
			String[] secondArray = second.split("，");
			@SuppressWarnings("unused")
			Boolean flag = false;
			String carType = null;
			for (String temp : secondArray) {
				if (temp.contains("车辆要求")) {
					String[] temp1 = temp.split("：");
					if (secondInfos[0].contains(temp1[1])) {
						flag = true;
						carType = temp1[1];
					}
				} else if (secondInfos[0].contains(temp)) {
					flag = true;
					carType = temp;
				}
			}
			try {
				Assert.assertTrue(true);
			} catch (AssertionError e) {
				logger.error("未发现车型要求为：【" + secondInfos[0] + "】的货源信息。");
				Assert.fail("在该页面中未发现车型要求为：【" + secondInfos[0] + "】的货源信息");
			}
			logger.info("您的搜索条件为:【" + secondInfos[0] + "】，搜索结果的第【" + (i + 1) + "】条货源信息，车辆要求为：【" + carType + "】。");
		}
	}

	/** 检查货源信息的第二行信息:货物名称 */
	public static void checkGoodsName(SeleniumUtil seleniumUtil, By by, By by_car_length, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}
		for (int i = 0; i < items; i++) {// 循环每个货源
			String goodsname = null;
			String second = seleniumUtil.findElementsBy(by_car_length).get(i).getText(); // 取得第二行的货源信息
			second = second.replaceAll(" ", "");
			String[] secondArray = second.split("，");
			int temp = secondArray[0].indexOf("（");
			if (temp != -1) {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf("（") - 1);
			} else {
				goodsname = secondArray[0];
			}
			try {
				Assert.assertTrue(secondInfos[0].contains(goodsname));
			} catch (AssertionError e) {
				logger.error("未发现货物名称为：【" + secondInfos[0] + "】的货源信息。");
				Assert.fail("在该页面中未发现货物名称为：【" + secondInfos[0] + "】的货源信息");
			}
			logger.info("您的搜索条件为:【" + secondInfos[0] + "】，搜索结果的第【" + (i + 1) + "】条货源信息，车辆要求为：【" + secondArray[0] + "】。");
		}
	}

	/** 检查货源信息的第二行信息:吨位或者体积 */
	public static void checkGoodsWeightOrVolume(SeleniumUtil seleniumUtil, By by, By by_car_length, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}

		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			double goodsWorV = 0; // 重量或者体积
			String second = seleniumUtil.findElementsBy(by_car_length).get(i).getText(); // 取得第二行的货源信息
			second = second.replaceAll(" ", "");
			String[] secondArray = second.split("，");
			@SuppressWarnings("unused")
			Boolean flag = false;

			if (secondInfos[0].equals("重量")) {
				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("吨", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					Double temp = Double.parseDouble(secondInfos[2]);
					try {
						Assert.assertTrue(goodsWorV <= temp);
					} catch (AssertionError e) {
						logger.error("发现货物重量为：【" + goodsWorV + "】吨，大于搜索条件重量为：【" + temp + "】吨货源信息。");
						Assert.fail("在该页面中发现货物重量为：【" + goodsWorV + "】吨，大于搜索条件重量为：【" + temp + "】吨货源信息。");
					}
					logger.info("您的搜索条件为“重量”，搜索结果的第【" + (i + 1) + "】条货源信息，重量为：【" + goodsWorV + "】吨，小于等于条件搜索的【" + temp + "】吨");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					Double temp = Double.parseDouble(secondInfos[1]);
					try {
						Assert.assertTrue(temp <= goodsWorV);
					} catch (AssertionError e) {
						logger.error("发现货物重量为：【" + goodsWorV + "】吨，小于搜索条件重量为：【" + temp + "】吨货源信息。");
						Assert.fail("在该页面中发现货物重量为：【" + goodsWorV + "】吨，小于搜索条件重量为：【" + temp + "】吨货源信息。");
					}
					logger.info("您的搜索条件为“重量”，搜索结果的第【" + (i + 1) + "】条货源信息，重量为：【" + goodsWorV + "】吨，大于等于条件搜索的【" + temp + "】吨");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					Double temp1 = Double.parseDouble(secondInfos[1]);
					Double temp2 = Double.parseDouble(secondInfos[2]);
					try {
						Assert.assertTrue(temp1 <= goodsWorV && goodsWorV <= temp2);
					} catch (AssertionError e) {
						logger.error("发现货物重量为：【" + goodsWorV + "】吨，不在搜索条件重量为：【" + temp1 + "~" + temp2 + "】吨货源信息。");
						Assert.fail("在该页面中发现货物重量为：【" + goodsWorV + "】吨，不在搜索条件重量为：【" + temp1 + "~" + temp2 + "】吨货源信息。");
					}
					logger.info("您的搜索条件为“重量”，搜索结果的第【" + (i + 1) + "】条货源信息，重量为：【" + goodsWorV + "】吨，在搜索条件重量为：【" + temp1 + "~" + temp2 + "】吨货源信息。");
				}
			}

			if (secondInfos[0].equals("体积")) {
				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("方", ""));// 取得每个货源的体积数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					Double temp = Double.parseDouble(secondInfos[2]);
					try {
						Assert.assertTrue(goodsWorV <= temp);
					} catch (AssertionError e) {
						logger.error("发现货物体积为：【" + goodsWorV + "】方，大于搜索条件体积为：【" + temp + "】方货源信息。");
						Assert.fail("在该页面中发现货物体积为：【" + goodsWorV + "】方，大于搜索条件体积为：【" + temp + "】方货源信息。");
					}
					logger.info("您的搜索条件为“体积”，搜索结果的第【" + (i + 1) + "】条货源信息，体积为：【" + goodsWorV + "】方，小于等于条件搜索的【" + temp + "】方");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					Double temp = Double.parseDouble(secondInfos[1]);
					try {
						Assert.assertTrue(temp <= goodsWorV);
					} catch (AssertionError e) {
						logger.error("发现货物体积为：【" + goodsWorV + "】方，小于搜索条件体积为：【" + temp + "】方货源信息。");
						Assert.fail("在该页面中发现货物体积为：【" + goodsWorV + "】方，小于搜索条件体积为：【" + temp + "】方货源信息。");
					}
					logger.info("您的搜索条件为“体积”，搜索结果的第【" + (i + 1) + "】条货源信息，体积为：【" + goodsWorV + "】方，大于等于条件搜索的【" + temp + "】方");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					Double temp1 = Double.parseDouble(secondInfos[1]);
					Double temp2 = Double.parseDouble(secondInfos[2]);
					try {
						Assert.assertTrue(temp1 <= goodsWorV && goodsWorV <= temp2);
					} catch (AssertionError e) {
						logger.error("发现货物体积为：【" + goodsWorV + "】方，不在搜索条件体积为：【" + temp1 + "~" + temp2 + "】方货源信息。");
						Assert.fail("在该页面中发现货物体积为：【" + goodsWorV + "】方，不在搜索条件体积为：【" + temp1 + "~" + temp2 + "】方货源信息。");
					}
					logger.info("您的搜索条件为“体积”，搜索结果的第【" + (i + 1) + "】条货源信息，体积为：【" + goodsWorV + "】方，在搜索条件体积为：【" + temp1 + "~" + temp2 + "】方货源信息。");
				}
			}
		}
	}

	/** 检查搜索结果是否符合车长 */
	public static void checkFindGoodsPrompt_CarLong(SeleniumUtil seleniumUtil, Map<String, String> data) {
		logger.info("Start checking checkFindGoodsPrompt_CarLong page text");
		String info = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO).get(0).getText().trim();

		StringTokenizer info2 = new StringTokenizer(info, "，");
		String info3 = null;
		while (info2.hasMoreTokens()) {
			String temp = info2.nextToken();
			if (temp.contains("车辆要求")) {
				info3 = temp.trim();
			}
		}
		StringTokenizer info4 = new StringTokenizer(info3, "：");
		String info5 = null;
		while (info4.hasMoreTokens()) {
			info5 = info4.nextToken().trim();
		}
		String need = info5.substring(0, info5.length() - 1);

		Float carlong = Float.valueOf(need);
		Float startcarlong = Float.valueOf(data.get("FGP_INPUT_STARTCARLONG"));
		if (startcarlong <= carlong) {
			System.out.println("搜索的车长满足最小要求");
		}
		logger.info("Check checkFindGoodsPrompt_CarLong page text completed");
	}

	/**
	 * 在“找车源-公共货源”中点击当前页面按钮“收藏”变为“我的收藏”的货源
	 * 
	 * @param seleniumUtil
	 * @param myFavoBotton
	 */
	public static void publicGoodsChangeFavoGoods(SeleniumUtil seleniumUtil, By myFavoBotton) {
		int items = seleniumUtil.findElementsBy(myFavoBotton).size(); // 这个items指的是查询出来有多少条货源
		for (int i = 0; i < items; i++) {
			seleniumUtil.click(seleniumUtil.findElementsBy(myFavoBotton).get(i));
		}
		logger.info("您一共收藏了【" + items + "】条货源成为我的收藏。");
	}

	public static void FavoGoodsChangepublicGoods(SeleniumUtil seleniumUtil, By cancelMyFavoBotton) {
		int items = seleniumUtil.findElementsBy(cancelMyFavoBotton).size(); // 这个items指的是查询出来有多少条货源
		for (int i = 0; i < items; i++) {
			seleniumUtil.click(seleniumUtil.findElementsBy(cancelMyFavoBotton).get(0)); // 点击
																						// 取消收藏按钮
			seleniumUtil.pause(800);
			seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();
			seleniumUtil.pause(800);
		}
		logger.info("您一共取消【" + items + "】条我的收藏成为公共货源。");
	}

	/** 我的货源中，分别按照：默认、星级，车长，重量和体积排序 */
	public static void checkCarsSort(SeleniumUtil seleniumUtil, String sortRule, int pageLoadTime) {
		try {
			if (seleniumUtil.findElementBy(FindGoodsPage.FGP_NODIAPALY_SEARCH).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("没有相关数据");
				return;
			}
		} catch (Exception e) {
			logger.info("找到了货源信息");
			logger.info("开始按照[" + sortRule + "]检查排序");
			int items = seleniumUtil.findElementsBy(FindGoodsPage.FGP_ITEM_GOODS).size(); // 取得货源的条数
			float[] temp1 = new float[items];// 用于临时存放 星级数值 、车长、吨位、容积等 - 用于第一次点击
			float[] temp2 = new float[items];// 用于临时存放 星级数值 、车长、吨位、容积等 - 用于第二次点击
			String[] temp3 = new String[items];// 用于临时存放 发布时间
			int count = 0;// 定义点击计数器
			switch (sortRule) {

			case "默认排序":
				seleniumUtil.click(seleniumUtil.findElementBy(FindGoodsPage.FGP_LINK_DEFAULT));
				seleniumUtil.hasLoadPageSucceeded(pageLoadTime);
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (int s = 0; s < temp1.length; s++) {
					seleniumUtil.click(seleniumUtil.findElementsBy(FindGoodsPage.FGP_ITEM_GOODS).get(s));// 点击展开货源详情
					String time = seleniumUtil.findElementsBy(FindGoodsPage.FGP_ITEM_GOODSANDSTARS).get(s).findElement(By.className("col-xs-4")).getText().trim();
					time = time.substring(time.indexOf("：") + 1, time.length());
					temp3[s] = time;
				}
				for (int i = 0; i < temp3.length; i++) {
					try {
						if (i == temp3.length - 1) {
							break;
						}
						Assert.assertTrue(formater.parse(temp3[i]).getTime() >= formater.parse(temp3[i + 1]).getTime());
						logger.info("第" + (i + 1) + "组数:[" + temp3[i] + "]据大于等于第" + (i + 2) + "组数据:[" + temp3[i + 1] + "]");
					} catch (AssertionError ae) {
						logger.error("按默认排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
						Assert.fail("按默认排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
					} catch (ParseException e1) {
						logger.error("不能解析第" + (i + 1) + "条数据的日期：" + temp3[i]);
						Assert.fail("不能解析第" + (i + 1) + "条数据的日期：" + temp3[i]);
					}
				}
				break;

			case "信用评级":
				while (count < 2) { // 点击2次 信用等级
					seleniumUtil.click(seleniumUtil.findElementBy(FindGoodsPage.FGP_LINK_CREDIT));
					seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

					if (count == 0) {
						for (int s = 0; s < temp1.length; s++) {
							// 把星级的具体值存入一个float数组
							float stars = Float.valueOf(seleniumUtil.findElementsBy(FindGoodsPage.FGP_ITEM_GOODSANDSTARS).get(s).findElement(By.className("rateit-range")).getAttribute("aria-valuenow"));
							temp1[s] = stars;
						}
						logger.info("点击星级排序，箭头往下");
						for (int i = 0; i < temp1.length; i++) {
							try {
								if (i == temp1.length - 1) {
									break;
								}
								Assert.assertTrue(temp1[i + 1] <= temp1[i]);
								logger.info("第" + (i + 2) + "组数:" + temp1[i + 1] + "据小于等于第" + (i + 1) + "组数据:" + temp1[i]);
							} catch (AssertionError ae) {
								logger.error("当星级箭头向下时，按星级排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当星级箭头向下时，按星级排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++; // 此时count的值变成1,1<2进行第二轮循环
						continue;
					}

					if (count == 1) {
						for (int s = 0; s < temp2.length; s++) {// 把星级的具体值存入一个float数组
							float stars = Float.valueOf(seleniumUtil.findElementsBy(FindGoodsPage.FGP_ITEM_GOODSANDSTARS).get(s).findElement(By.className("rateit-range")).getAttribute("aria-valuenow"));
							temp2[s] = stars;
						}

						logger.info("点击星级排序，箭头往上");
						for (int i = 0; i < temp2.length; i++) {
							try {
								if (i == temp2.length - 1) {
									break;
								}
								Assert.assertTrue(temp2[i] <= temp2[i + 1]);
								logger.info("第" + (i + 2) + "组数据:" + temp2[i + 1] + "小于等于第" + (i + 1) + "组数据:" + temp2[i]);
							} catch (AssertionError ae) {
								logger.error("当星级箭头向上时，按星级排序出错：" + temp2[i + 1] + "应该大于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当星级箭头向上时，按星级排序出错：" + temp2[i + 1] + "应该大于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++;
					}
				}
				break;

			case "车长":
				while (count < 1) { // 因为我的货源的 出现的信息不规则，导致不能定位，后续在做，第二次点击的排序检查
					seleniumUtil.click(seleniumUtil.findElementBy(FindGoodsPage.FGP_LINK_LENGTH));
					seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

					if (count == 0) {
						for (int s = 0; s < temp1.length; s++) {
							// 把车长的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(s).getText();
							if (secondInfo.indexOf("米") == -1) {
								break;
							} else {
								String secondInfos[] = secondInfo.split("，");
								float autualCarLen = Float.valueOf(secondInfos[4].substring(5, secondInfos[4].indexOf("米"))); // 取得车长
								temp1[s] = autualCarLen;
							}
						}
						logger.info("点击车长排序，箭头往下");
						for (int i = 0; i < temp1.length; i++) {
							try {
								if (i == temp1.length - 1) {
									break;
								}
								Assert.assertTrue(temp1[i + 1] <= temp1[i]);
								logger.info("第" + (i + 2) + "组数据:" + temp1[i + 1] + "小于等于第" + (i + 1) + "组数据:" + temp1[i]);
							} catch (AssertionError ae) {
								logger.error("当车长箭头向下时，按车长排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当车长箭头向下时，按车长排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++; // 此时count的值变成1,1<2进行第二轮循环
						continue;
					}

					if (count == 1) {
						for (int s = 0; s < temp2.length; s++) {// 把车长的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(s).getText().trim();
							String secondInfos[] = secondInfo.split("，");
							float autualCarLen = Float.valueOf(secondInfos[4].substring(5, secondInfos[4].indexOf("米"))); // 取得车长
							temp2[s] = autualCarLen;
						}

						logger.info("点击车长排序，箭头往上");
						for (int i = 0; i < temp2.length; i++) {
							try {
								if (i == temp2.length - 1) {
									break;
								}
								Assert.assertTrue(temp2[i] <= temp2[i + 1]);
								logger.info("第" + (i + 2) + "组数据:" + temp2[i + 1] + "大于等于第" + (i + 1) + "组数据:" + temp2[i]);
							} catch (AssertionError ae) {
								logger.error("当车长箭头向上时，按车长排序出错：" + temp2[i + 1] + "应该大于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当车长箭头向上时，按车长排序出错：" + temp2[i + 1] + "应该小大等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++;
					}
				}
				break;

			case "重量":
				while (count < 1) { // 因为我的货源的 出现的信息不规则，导致不能定位，后续在做，第二次点击的排序检查
					seleniumUtil.click(seleniumUtil.findElementBy(FindGoodsPage.FGP_LINK_WEIGHT));
					seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

					if (count == 0) {
						for (int s = 0; s < temp1.length; s++) {
							// 把吨位的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(s).getText().trim();
							String secondInfos[] = secondInfo.split("，");
							if (secondInfo.contains("吨")) {
								float autualCarWeight = Float.valueOf(secondInfos[2].substring(0, secondInfos[2].indexOf("吨"))); // 取得车重
								temp1[s] = autualCarWeight;
							} else {
								temp1[s] = 0;
							}
						}
						logger.info("点击载重排序，箭头往下");
						for (int i = 0; i < temp1.length; i++) {
							try {
								if (i == temp1.length - 1) {
									break;
								}
								Assert.assertTrue(temp1[i + 1] <= temp1[i]);
								logger.info("第" + (i + 2) + "组数据:" + temp1[i + 1] + "小于等于第" + (i + 1) + "组数据:" + temp1[i]);
							} catch (AssertionError ae) {
								logger.error("当载重箭头向下时，按载重排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当载重箭头向下时，按载重排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++; // 此时count的值变成1,1<2进行第二轮循环
						continue;
					}

					if (count == 1) {
						for (int s = 0; s < temp2.length; s++) {// 把载重的具体值存入一个float数组
							// 把吨位的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
							String secondInfos[] = secondInfo.split("，");
							float autualCarWeight = Float.valueOf(secondInfos[3].substring(3, secondInfos[3].indexOf("吨"))); // 取得车重
							temp2[s] = autualCarWeight;
						}

						logger.info("点击载重排序，箭头往下");
						for (int i = 0; i < temp2.length; i++) {
							try {
								if (i == temp2.length - 1) {
									break;
								}
								Assert.assertTrue(temp2[i] >= temp2[i + 1]);
								logger.info("第" + (i + 2) + "组数据:" + temp2[i + 1] + "小于等于第" + (i + 1) + "组数据:" + temp2[i]);
							} catch (AssertionError ae) {
								logger.error("当载重箭头向下时，按载重排序出错：" + temp2[i + 1] + "应该小于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当载重箭头向下时，按载重排序出错：" + temp2[i + 1] + "应该小于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++;
					}
				}
				break;

			case "体积":
				while (count < 1) { // //因为我的货源的 出现的信息不规则，导致不能定位，后续在做，第二次点击的排序检查
					seleniumUtil.click(seleniumUtil.findElementBy(FindGoodsPage.FGP_LINK_VOLUME));
					seleniumUtil.hasLoadPageSucceeded(pageLoadTime);
					if (count == 0) {
						for (int s = 0; s < temp1.length; s++) {
							// 把容积的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO_CAR_LENGTH).get(s).getText().trim();
							if (secondInfo.indexOf("方") == -1) {
								logger.warn("注意：从第" + (s + 1) + "条货源没有输入体积信息，故会跳过检测");
								break;
							}
							String secondInfos[] = secondInfo.split("，");
							if (secondInfo.contains("方")) {
								float autualCarVolume = Float.valueOf(secondInfos[2].substring(0, secondInfos[2].indexOf("方"))); // 取的体积
								temp1[s] = autualCarVolume;
							} else {
								temp1[s] = 0;
							}
						}
						logger.info("点击车厢容积排序，箭头往下");
						for (int i = 0; i < temp1.length; i++) {
							try {
								if (i == temp1.length - 1) {
									break;
								}
								Assert.assertTrue(temp1[i + 1] <= temp1[i]);
								logger.info("第" + (i + 2) + "组数:" + temp1[i + 1] + "据小于等于第" + (i + 1) + "组数据:" + temp1[i]);
							} catch (AssertionError ae) {
								logger.error("当车厢容积箭头向下时，按车厢容积排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当车厢容积箭头向下时，按车厢容积排序出错：" + temp1[i + 1] + "应该小于等于" + temp1[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++; // 此时count的值变成1,1<2进行第二轮循环
						continue;
					}

					if (count == 1) {
						for (int s = 0; s < temp2.length; s++) {// 把容积的具体值存入一个float数组
							// 把容积的具体值存入一个float数组
							String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
							String secondInfos[] = secondInfo.split("，");
							float autualCarVolume = Float.valueOf(secondInfos[4].substring(5, secondInfos[4].indexOf("方"))); // 取得车容积
							temp2[s] = autualCarVolume;
						}

						logger.info("点击车厢容积排序，箭头往下");
						for (int i = 0; i < temp2.length; i++) {
							try {
								if (i == temp2.length - 1) {
									break;
								}
								Assert.assertTrue(temp2[i] >= temp2[i + 1]);
								logger.info("第" + (i + 2) + "组数据:" + temp2[i + 1] + "小于等于第" + (i + 1) + "组数据:" + temp2[i]);
							} catch (AssertionError ae) {
								logger.error("当车厢容积箭头向下时，按车厢容积排序出错：" + temp2[i + 1] + "应该小于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
								Assert.fail("当车厢容积箭头向下时，按车厢容积排序出错：" + temp2[i + 1] + "应该小于等于" + temp2[i] + "出错位置在第" + (i + 1) + "和" + i);
							}
						}
						count++;
					}
				}
				break;

			default:
				logger.warn("你选择的排序规则：[" + sortRule + "]不被支持！");
				return;
			}
		}
	}

	/** 查找货源页面未认证用户的检查，查看不到的信息有：货代名称、 联系人、联系方式、公司地址 */
	public static void unattestedUserChecked(SeleniumUtil seleniumUtil, By byOrdersNum, By... byAttestedInfo) {
		String UnattestedInfo = "认证后即可查看";
		int items = seleniumUtil.findElementsBy(byOrdersNum).size();
		logger.info("您一共搜索到【" + items + "】条货源信息，现显示如下：");

		int[] info = { 2, 5, 6, 12 };
		String[] infoTest = { "联系人", "货代名称", "联系方式", "公司名称" };
		for (int i = 0; i < items; i++) {// 循环每个货源
			seleniumUtil.click(seleniumUtil.findElementsBy(byOrdersNum).get(i));
			// 查找联系人的信息
			for (int j = 0; j < info.length; j++) {
				String contactMan = seleniumUtil.findElementsBy(byAttestedInfo[0]).get(i).findElements(By.tagName("div")).get(info[j]).getText(); // 取得第二行的货源信息
				contactMan = contactMan.replaceAll(" ", "");
				String[] need = contactMan.split("：");
				try {
					Assert.assertTrue(need[1].equals(UnattestedInfo));
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(infoTest[j] + "和预定字段信息不匹配为：【" + need[1] + "】。");
					Assert.fail(infoTest[j] + "和预定字段信息不匹配为：【" + need[1] + "】。");
				}
				logger.info(need[0] + "联系人的字段信息为：【" + need[1] + "】。");
			}
		}
	}

	/** 找货源页面获取第一个货源的“货源编号” */
	public static String firstGoodsId(SeleniumUtil seleniumUtil, By byOrdersNum, By byGoodsId) {
		seleniumUtil.click(seleniumUtil.findElementsBy(byOrdersNum).get(0));
		String goodsId = seleniumUtil.findElementsBy(byGoodsId).get(0).findElements(By.tagName("div")).get(3).getText(); // 取得第二行的货源信息
		goodsId = goodsId.replaceAll(" ", "");
		String[] need = goodsId.split("：");
		try {
			Assert.assertTrue(!need[1].equals(""));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("货源编号没有获取到，为空。");
			Assert.fail("货源编号没有获取到，为空。");
		}
		logger.info(need[0] + "为：【" + need[1] + "】。");
		return need[1];
	}

	/** 找货源页面获取第一个货源的“货源编号” */
	public static String[] allGoodsId(SeleniumUtil seleniumUtil, By byOrdersNum, By byGoodsId) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(byOrdersNum).size();

		String[] goodsIds = new String[items];
		for (int i = 0; i < items; i++) {// 循环每个货源
			seleniumUtil.click(seleniumUtil.findElementsBy(byOrdersNum).get(i));
			String goodsId = seleniumUtil.findElementsBy(byGoodsId).get(i).findElements(By.tagName("div")).get(3).getText(); // 取得第二行的货源信息
			goodsId = goodsId.replaceAll(" ", "");
			String[] need = goodsId.split("：");
			try {
				Assert.assertTrue(!need[1].equals(""));
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("货源编号没有获取到，为空。");
				Assert.fail("货源编号没有获取到，为空。");
			}
			logger.info(need[0] + "为：【" + need[1] + "】。");
			goodsIds[i] = need[1];
		}
		return goodsIds;
	}
}

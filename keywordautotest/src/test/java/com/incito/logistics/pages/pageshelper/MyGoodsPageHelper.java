package com.incito.logistics.pages.pageshelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 我的货源页面帮助类
 * */
public class MyGoodsPageHelper {
	public static Logger logger = Logger.getLogger(MyGoodsPageHelper.class.getName());

	/** 等待页面上元素显示出来 */
	public static void waitMyGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {

		logger.info("Start checking my goods page elements");
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_BUTTON_ADSEARCH);

		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_GOODSNO);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_ORIGINALCITY);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_TARGETCITY);
		// seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH));
		// if
		// (seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH_ARROW).getAttribute("class").equals("icon-sort-down"))
		// {
		// seleniumUtil.waitForElementToLoad(timeOut,
		// MyGoodsPage.MGP_INPUT_STARTDATE);
		// seleniumUtil.waitForElementToLoad(timeOut,
		// MyGoodsPage.MGP_INPUT_ENDDATE);
		// seleniumUtil.waitForElementToLoad(timeOut,
		// MyGoodsPage.MGP_INPUT_GOODSNAME);
		// seleniumUtil.waitForElementToLoad(timeOut,
		// MyGoodsPage.MGP_SELECT_GOODSUNIT);
		// }
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_RADIOBOX_GOODSTYPE);
		logger.info("Check my goods page elements completed");

	}

	/** 在找货源界面输入相关货源信息以便查询 */
	public static void typeGoodsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 货源编号
		if (info[0].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_GOODSNO), info[0].toString());
		}
		// 填充发货地
		if (info[1].toString() != "") {
			String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + info[1].toString() + "');";
			seleniumUtil.executeJS(jsFrom);
		}
		// 填充收货地
		if (info[2].toString() != "") {
			String jsTo = "document.getElementsByName('targetcity')[1].setAttribute('value','" + info[2].toString() + "');";
			seleniumUtil.executeJS(jsTo);
		}
		// 点击高级搜索
		// if
		// (seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH_ARROW).getAttribute("class").equals("icon-sort-up"))
		// {
		// seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH));
		// waitMyGoodsPageToLoad(15, seleniumUtil);
		// }
		// 货物名称
		if (info[3].toString() != "") {
			String goodsName = "document.getElementsByName('goodsnames')[0].setAttribute('value','" + info[3].toString() + "');";
			seleniumUtil.executeJS(goodsName);
		}
		// 体积还是重量
		seleniumUtil.selectByText(MyGoodsPage.MGP_SELECT_GOODSUNIT, info[4].toString());
		if (info[4].toString().equals("体积")) {
			if (info[5].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[5].toString());
			}
			if (info[6].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDVOLUME), info[6].toString());
			}
		} else if (info[4].toString().equals("重量")) {
			if (info[5].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTWEIGHT), info[5].toString());
			}
			if (info[6].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDWEIGHT), info[6].toString());
			}

		}
		// 开始时间
		if (info[7].toString() != "") {
			String startDate = "document.getElementsByName('startgoodstime')[0].setAttribute('value','" + info[7].toString().substring(0, info[7].toString().indexOf(" ")) + "');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(startDate);
		}
		// 结束时间
		if (info[8] != "") {
			String endDate = "document.getElementsByName('endgoodstime')[0].setAttribute('value','" + info[8].toString().substring(0, info[8].toString().indexOf(" ")) + "');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(endDate);
		}
		// 点击搜索
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_SEARCH));
	}

	/** 从我的货源界面点击相关按钮 */
	public static void enterPage(SeleniumUtil seleniumUtil, By by) {
		seleniumUtil.click(seleniumUtil.findElementBy(by));
	}

	/** 检查货源的第一行的数据：发货地和收货地 */
	public static void checkGoodsAddress(SeleniumUtil seleniumUtil, By by, String... goodsAdd) {
		if (seleniumUtil.findElementsBy(MyGoodsPage.MGP_ITEM_GOODS).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		String address = seleniumUtil.findElementBy(by).getAttribute("title");
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

	/** 检查货源信息的第二行信息:货物名称 */
	public static void checkGoodsName(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		for (int i = 0; i < items; i++) {// 循环每个货源
			String goodsname = null;
			String second = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("p")).get(1).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			int temp = secondArray[0].indexOf("（");
			if (temp != -1) {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf("（") - 1);
			} else {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf(" "));
			}
			seleniumUtil.isContains(secondInfos[0], goodsname);
		}
	}

	/** 检查货源信息的第二行信息:货物名称 */
	public static void checkGoodsName_EP(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		if (!seleniumUtil.doesElementExist(by)) {
			logger.warn("No data found with this filters!");
			return;
		}
		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		for (int i = 0; i < items; i++) {// 循环每个货源
			String goodsname = null;
			String second = seleniumUtil.findElementsBy(by).get(i).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			int temp = secondArray[0].indexOf("（");
			if (temp != -1) {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf("（") - 1);
			} else {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf(" "));
			}
			seleniumUtil.isContains(secondInfos[0], goodsname);
		}
	}

	/** 检查货源信息的第二行信息:吨位或者体积 */
	public static void checkGoodsWeightOrVolume(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}

		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			double goodsWorV = 0; // 重量或者体积
			String second = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("p")).get(1).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			if (secondInfos[0].equals("重量")) {
				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("吨", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is not in the  input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

			}

			if (secondInfos[0].equals("体积")) {

				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("方", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Integer.valueOf(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is not in the  input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

			}

		}

	}

	/** 检查货源信息的第二行信息:吨位或者体积 */
	public static void checkGoodsWeightOrVolume_EP(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		if (!seleniumUtil.doesElementExist(by)) {
			logger.warn("No data found with this filters!");
			return;
		}
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();

		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			double goodsWorV = 0; // 重量或者体积
			String second = seleniumUtil.findElementsBy(by).get(i).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			if (secondInfos[0].equals("重量")) {
				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("吨", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is not in the  input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

			}

			if (secondInfos[0].equals("体积")) {

				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("方", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Integer.valueOf(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is not in the  input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

			}

		}

	}

	/**
	 * 检查货物的发布时间
	 * 
	 * @throws ParseException
	 */
	public static void checkGoodsSendDate(SeleniumUtil seleniumUtil, By by, String... headInfos) {
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		if (seleniumUtil.findElementsBy(MyGoodsPage.MGP_ITEM_GOODS).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		else{

			for (int j = 0; j < items; j++) {
				
	

			String 	header = seleniumUtil.findElementsBy(by).get(j).findElements(By.tagName("div")).get(2).getText();
	
			// 取得发布时间的 字符串
			header = header.substring(header.indexOf("：") + 1, header.length());
			if (headInfos[0].equals("") && headInfos[1] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[1]).getTime() >= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的货源发布的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间不在您的筛选条件时间内");
					Assert.fail("您选择的货源发布的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间不在您的筛选条件时间内");
				}
				logger.info("您选择的货源发布的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间符合筛选条件");
			}
			if (headInfos[1].equals("") && headInfos[0] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[0]).getTime() <= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的货源发布的开始时间是：" + headInfos[0] + " 该货源的详情中的时间是：[" + header + "] ，该时间小于您的筛选条件时间");
					Assert.fail("您选择的货源发布的开始时间是：" + headInfos[0] + " 该货源的详情中的时间是：[" + header + "] ，该时间小于您的筛选条件时间");
				}
				logger.info("您选择的货源发布的开始时间是：" + headInfos[0] + " 该货源的详情中的时间是：[" + header + "] ，该时间符合筛选条件");
			}
			if (headInfos[0] != "" && headInfos[1] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[0]).getTime() <= formater.parse(header).getTime() && formater.parse(headInfos[1]).getTime() >= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的货源发布的开始时间是：" + headInfos[0] + ",您选择的货源的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间不在开始和结束时间之间");
					Assert.fail("您选择的货源发布的开始时间是：" + headInfos[0] + ",您选择的货源的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间不在开始和结束时间之间");
				}
				logger.info("您选择的货源发布的开始时间是：" + headInfos[0] + ",您选择的货源的结束时间是：" + headInfos[1] + " 该货源的详情中的时间是：[" + header + "] ，该时间在开始和结束时间之间");
			}
			}
		}
	}

	/*** 编辑指定的货源 */
	public static void editTargetGoods(SeleniumUtil seleniumUtil, String instration) {
		logger.info("Start editting goods");
		List<WebElement> instrations = seleniumUtil.findElementsBy(MyGoodsPage.MGP_TEXT_INSTRUCTION);
		int items = instrations.size();
		for (int i = 0; i < items; i++) {

			if (instrations.get(i).getText().trim().equals(instration)) {
				logger.info("Find the " + instration + " in " + (i + 1) + " th goods,no longer to look for");
				seleniumUtil.click(seleniumUtil.findElementsBy(MyGoodsPage.MGP_BUTTON_EDIT).get(i));
				break;
			}

		}

	}

	/*** 删除指定的货源 */
	public static void deleteTargetGoods(SeleniumUtil seleniumUtil, String instration, Boolean flag) {

		logger.info("Start deleting goods");
		List<WebElement> instrations = seleniumUtil.findElementsBy(MyGoodsPage.MGP_TEXT_INSTRUCTION);
		int items = instrations.size();
		for (int i = 0; i < items; i++) {

			if (instrations.get(i).getText().trim().equals(instration)) {
				// 点击删除按钮
				seleniumUtil.click(seleniumUtil.findElementsBy(MyGoodsPage.MGP_BUTTON_DELETE).get(i));
				if (flag == true) {
					seleniumUtil.pause(800);
					seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();
					seleniumUtil.pause(800);
					seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();
					seleniumUtil.pause(800);
					break;
				}
				if (flag == false) {
					seleniumUtil.pause(800);
					seleniumUtil.switchToPromptedAlertAfterWait(1000).dismiss();
					seleniumUtil.pause(800);
					break;
				}

			}

		}

	}

	/** 检查指定的货源是不是被删除成功 */
	public static void checkGoodsExistAfterDelete(SeleniumUtil seleniumUtil, String instration, Boolean flag) {
		logger.info("Start to check the goods is delete or not");
		List<WebElement> instrations = seleniumUtil.findElementsBy(MyGoodsPage.MGP_TEXT_INSTRUCTION);
		int items = instrations.size();
		for (int i = 0; i < items; i++) {
			if (flag == true) {
				if (instrations.get(i).getText().trim().equals(instration) == false) {

					logger.info("Didn't find the target goods which goods instration is " + instration + " and the tagrget goods has been deleted - " + i);

				} else {
					logger.error("The target goods didn't delete");
					Assert.fail("The target goods didn't delete");
				}
			}
			if (flag == false) {
				if (instrations.get(i).getText().trim().equals(instration) == true) {
					logger.info("Goods delete operation has been cancled");
				}

			}
		}
	}
	
	//获取指定货源的货源编号
	public static String getGoodsNo(SeleniumUtil seleniumUtil,String from,String to, String memo){
		String no = null;
		int itmes = seleniumUtil.findElementsBy(MyGoodsPage.MGP_ITEM_GOODS).size();
		for (int i = 0; i < itmes; i++) {
			String address = seleniumUtil.findElementsBy(By.xpath("//*[@class='span-addr']")).get(i).getAttribute("title");
			String instraction =seleniumUtil.findElementsBy(MyGoodsPage.MGP_TEXT_INSTRUCTION).get(i).getText();
			address = address.replaceAll(" ", "");
			String add[] = address.split("至");
			String original = add[0], targetcity = add[1];
			if(from.equals(original)&&to.equals(targetcity)&&memo.equals(instraction)){
				seleniumUtil.click( seleniumUtil.findElementsBy(By.xpath("//*[@class='span-addr']")).get(i));//点击展开货源
					no = seleniumUtil.findElementBy(By.xpath("//*[@class='mygoods-center-detail']/p[1]/span[1]")).getText();
					no = no.substring(5);
					break;
			}
		}
		return no;
	}
	
	/**检查已经被预定的货源的状态*/
	public static void checkGoodsStatus(SeleniumUtil seleniumUtil,String goodsno,int timeOut){
		int itmes = seleniumUtil.findElementsBy(MyGoodsPage.MGP_ITEM_GOODS).size();
		for (int i = 0; i < itmes; i++) {
			seleniumUtil.click( seleniumUtil.findElementsBy(By.xpath("//*[@class='span-addr']")).get(i));//点击展开货源
			String no = seleniumUtil.findElementBy(By.xpath("//*[@class='mygoods-center-detail']/p[1]/span[1]")).getText();
			if(no.substring(5).equals(goodsno)){
				logger.info("找到了期望的货源编号："+goodsno);
				seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(MyGoodsPage.MGP_DIV_GOODSSTAUS).get(i).getText().trim(), "已交易");
				seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(MyGoodsPage.MGP_LINK_CHECKORDER).get(i).getText().trim(), "查看订单");
				seleniumUtil.click(seleniumUtil.findElementsBy(MyGoodsPage.MGP_LINK_CHECKORDER).get(i));
				MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
				break;
			}
		}
	}
	
	/** 我的订单页面中没有搜索到相关的数据 */
	public static void myGoodsNoInfo(SeleniumUtil seleniumUtil, By byMyGoodsNum) {
		String info = seleniumUtil.findElementBy(byMyGoodsNum).getText();
		String provideInfo = "没有搜索到相应的数据";
		try {
			Assert.assertTrue(info.equals(provideInfo));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("未查找到提示信息为：【" + provideInfo + "】的提示语。");
			Assert.fail("未查找到提示信息为：【" + provideInfo + "】的提示语。");
		}
		logger.info("提示信息为：【" + info + "】的提示语。");
	}
}

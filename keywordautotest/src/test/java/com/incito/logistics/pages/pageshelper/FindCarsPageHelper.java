package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.util.SeleniumUtil;

public class FindCarsPageHelper {
	public static Logger logger = Logger.getLogger(FindCarsPageHelper.class.getName());

	// 页面上某个重要元素显示出来
	public static void waitFindCarsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("开始检查[找车源]页面元素");
		seleniumUtil.pause(800);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_FROM);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_TO);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_STARTCARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_ENDCARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CREDIT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_ADVSEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_DEFAULT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CREDIT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_VOLUME);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_TAB_PUBLIC);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_TAB_FAV);
		logger.info("[找车源]页面元素，检查完毕！");
	}

	/** 检查文本是不是正确 */
	public static void checkFindCarsPageText(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("开始检查[找车源]文本");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_PUBLIC).getText().trim(), "公共车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_FAV).getText().trim(), "我的收藏");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_SEARCH).getText().trim(), "搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_ADVSEARCH).getText().trim(), "高级搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_DEFAULT).getText().trim(), "默认排序");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CREDIT).getText().trim(), "信用等级");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CARLEN).getText().trim(), "车长");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_WEIGHT).getText().trim(), "载重");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_VOLUME).getText().trim(), "车厢容积");
		logger.info("[找车源]页面文本，检查完毕");
	}

	/** 在找车源输入相关信息以便查询 */
	public static void typeCarsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 车辆出发地
		if (info[0].toString() != "") {
			String jsFrom = "document.getElementsByName('carcity')[0].setAttribute('value','" + info[0].toString() + "');";
			seleniumUtil.executeJS(jsFrom);
		}
		// 车辆目的地
		if (info[1].toString() != "") {
			String jsTo = "document.getElementsByName('targetcity')[1].setAttribute('value','" + info[1].toString() + "');";
			seleniumUtil.executeJS(jsTo);
		}
		// 车长 -开始
		if (info[2].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTCARLEN), info[2].toString());
		}
		// 车长 - 结束
		if (info[3].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDCARLEN), info[3].toString());
		}

		// 点击高级搜索
		if (info[4].toString() != "" || info[5].toString() != "" || info[6].toString() != "" || info[7].toString() != "" || info[8].toString() != "") {
			seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_ADVSEARCH));

			// 车型
			if (info[4].toString() != "") {
				String carType = "document.getElementsByName('cartype')[0].setAttribute('value','" + info[4].toString() + "');";
				seleniumUtil.executeJS(carType);
			}
			// 载重 - 开始
			if (info[5].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTWEIGHT), info[5].toString());
			}
			// 载重 - 结束
			if (info[6].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDWEIGHT), info[6].toString());
			}
			// 容积 - 开始
			if (info[7].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTVOLUME), info[7].toString());
			}
			// 容积 - 开始
			if (info[8].toString() != "") {
				seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDVOLUME), info[8].toString());
			}
		}
		// 点击搜索
		seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_SEARCH));
	}

	/** 检查查找出来的车源的 车辆当前城市也就是出发地 */
	public static void checkCurrentCarLocation(SeleniumUtil seleniumUtil, String carFrom) {
		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_SPAN_LOCATOR).size();
			for (int i = 0; i < size; i++) {
				seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_SPAN_LOCATOR).get(i).getText().trim(), carFrom);
			}

		}

	}

	/** 检测车源中的车长是不是符合条件 */
	public static void checkCarLength(SeleniumUtil seleniumUtil, String... lenInfos) {

		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("没有搜索到相应的数据");
				return;
			}
		} catch (Exception e) {
			logger.info("找到车源信息了");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();

			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarLen = Double.parseDouble(secondInfos[2].substring(3, secondInfos[2].length() - 1)); // 取得车长
				// 开始车长空 结束车长不空
				if (lenInfos[0].equals("") && lenInfos[1] != "") {
					try {
						Assert.assertTrue(autualCarLen <= Double.parseDouble(lenInfos[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is bigger than input length num [" + lenInfos[1] + "] m");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is bigger than input length num [" + lenInfos[1] + "] m");
					}
					logger.info("The car length of the " + (i + 1) + "th goods info is [" + autualCarLen + "] m, smaller than " + lenInfos[1] + " m - Passed");
				}
				// 开始车长不为空 结束车长空
				if (lenInfos[0] != "" && lenInfos[1].equals("")) {
					try {
						Assert.assertTrue(autualCarLen >= Double.parseDouble(lenInfos[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is smaller than input lengthnum [" + lenInfos[0] + "] m");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is smaller than input length num [" + lenInfos[0] + "] m");
					}
					logger.info("The car length of the " + (i + 1) + "th cars info is [" + autualCarLen + "] m,bigger than " + lenInfos[0] + " m - Passed");
				}
				// 都不为空
				if (lenInfos[0] != "" && lenInfos[1] != "") {
					try {
						Assert.assertTrue(autualCarLen >= Double.parseDouble(lenInfos[0]) && autualCarLen <= Double.parseDouble(lenInfos[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is not in the  input car length num [" + lenInfos[0] + "] and [" + lenInfos[1] + "] ");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is not in the  input car length num [" + lenInfos[0] + "] and [" + lenInfos[1] + "] ");
					}
					logger.info("The car length of the " + (i + 1) + "th cars info is [" + autualCarLen + "] m ,between " + lenInfos[0] + "and " + lenInfos[1] + " m - Passed");
				}

			}

		}

	}

	/** 检查车型 */
	public static void checkCarType(SeleniumUtil seleniumUtil, String... carTypes) {
		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();

			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String acutalCarType = secondInfos[1];
				seleniumUtil.isContains(carTypes[0], acutalCarType);

			}

		}

	}

	/** 检查车源中的吨位 */
	public static void checkCarWeight(SeleniumUtil seleniumUtil, String... carWeights) {
		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();

			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarWeight = Double.parseDouble(secondInfos[3].substring(3, secondInfos[3].length() - 1)); // 取得车重
				// 开始车长空 结束车长不空
				if (carWeights[0].equals("") && carWeights[1] != "") {
					try {
						Assert.assertTrue(autualCarWeight <= Double.parseDouble(carWeights[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is bigger than input weight num [" + carWeights[1] + "] T");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is bigger than input weight num [" + carWeights[1] + "] T");
					}
					logger.info("The car weight of the " + (i + 1) + "th goods info is [" + autualCarWeight + "] T, smaller than " + carWeights[1] + " T - Passed");
				}
				// 开始车长不为空 结束车长空
				if (carWeights[0] != "" && carWeights[1].equals("")) {
					try {
						Assert.assertTrue(autualCarWeight >= Double.parseDouble(carWeights[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is smaller than input weight num [" + carWeights[0] + "] T");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is smaller than input weight num [" + carWeights[0] + "] T");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarWeight + "] T,bigger than " + carWeights[0] + " T - Passed");
				}
				// 都不为空
				if (carWeights[0] != "" && carWeights[1] != "") {
					try {
						Assert.assertTrue(autualCarWeight >= Double.parseDouble(carWeights[0]) && autualCarWeight <= Double.parseDouble(carWeights[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is not in the  input car weight num [" + carWeights[0] + "] and [" + carWeights[1] + "] ");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is not in the  input car weight num [" + carWeights[0] + "] and [" + carWeights[1] + "] ");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarWeight + "] T ,between " + carWeights[0] + "and " + carWeights[1] + " T - Passed");
				}

			}

		}

	}

	/** 检查体积的方法 */
	public static void checkCarVolume(SeleniumUtil seleniumUtil, String... carVolumes) {
		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();

			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarVolume = Double.parseDouble(secondInfos[4].substring(5, secondInfos[4].length() - 1)); // 取得车容积
				// 开始车长空 结束车长不空
				if (carVolumes[0].equals("") && carVolumes[1] != "") {
					try {
						Assert.assertTrue(autualCarVolume <= Double.parseDouble(carVolumes[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is bigger than input volume num [" + carVolumes[1] + "] L");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is bigger than input volume num [" + carVolumes[1] + "] L");
					}
					logger.info("The car volume of the " + (i + 1) + "th goods info is [" + autualCarVolume + "] L, smaller than " + carVolumes[1] + " L - Passed");
				}
				// 开始车长不为空 结束车长空
				if (carVolumes[0] != "" && carVolumes[1].equals("")) {
					try {
						Assert.assertTrue(autualCarVolume >= Double.parseDouble(carVolumes[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is smaller than input volume num [" + carVolumes[0] + "] L");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is smaller than input volume num [" + carVolumes[0] + "] L");
					}
					logger.info("The car volume of the " + (i + 1) + "th cars info is [" + autualCarVolume + "] L,bigger than " + carVolumes[0] + " L - Passed");
				}
				// 都不为空
				if (carVolumes[0] != "" && carVolumes[1] != "") {
					try {
						Assert.assertTrue(autualCarVolume >= Double.parseDouble(carVolumes[0]) && autualCarVolume <= Double.parseDouble(carVolumes[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is not in the  input car volume num [" + carVolumes[0] + "] and [" + carVolumes[1] + "] ");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is not in the  input car volume num [" + carVolumes[0] + "] and [" + carVolumes[1] + "] ");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarVolume + "] L ,between " + carVolumes[0] + "and " + carVolumes[1] + " L - Passed");
				}

			}

		}

	}

	/** 检查目的地城市 */
	public static void checkTargetCity(SeleniumUtil seleniumUtil, String... targetCities) {

		seleniumUtil.pause(800);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO1).size();
			for (int i = 0; i < size; i++) {
				String firstInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO1).get(i).getText();
				String firstInfos[] = firstInfo.split(" ");
				String actualTargetCity = firstInfos[1];
				if (actualTargetCity.equals("全国")) {
					logger.info("Current target city is [全国] and contains expect city:" + targetCities[0] + " - OK");
				} else
					seleniumUtil.isContains(actualTargetCity, targetCities[0]);
			}

		}
	}

	/** 从车源上点击某个按钮触发下一个事件 */
	public static void enterPage(SeleniumUtil seleniumUtil, By byElement) {
		seleniumUtil.click(seleniumUtil.findElementBy(byElement));
	}

	/** 根据驾驶证 去收藏车源 */
	public static void favCarsByLicense(SeleniumUtil seleniumUtil, By byElement, String license) {
		logger.info("Start favoriting cars");
		seleniumUtil.pause(500);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String autualLicense = secondInfos[0].trim();
				if (autualLicense.equals(license)) {

					seleniumUtil.click(seleniumUtil.findElementsBy(byElement).get(i)); // 点击收藏按钮																
					seleniumUtil.waitForElementToLoad(5, FindCarsPage.FCP_BUTTON_CFAV);
					seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_BUTTON_CFAV).get(i).getText(), "取消收藏");
					seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_FAV));
					break;
				}
			}
			logger.info("Favoriting cars complete");
		}

	}

	/** 取消收藏操作 */
	public static void cancelFavCarsByLicense(SeleniumUtil seleniumUtil, By byElement, String license) {
		logger.info("开始执行取消收藏车源的操作...");
		seleniumUtil.pause(500);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("没有搜索到相应的数据");
				return;
			}
		} catch (Exception e) {
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();

			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String autualLicense = secondInfos[0].trim();

				if (autualLicense.equals(license)) {

					if(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_FAV).getAttribute("class").equals("active")){
					seleniumUtil.click(seleniumUtil.findElementsBy(byElement).get(i)); // 点击 取消收藏按钮	
					seleniumUtil.switchToPromptedAlertAfterWait(1000).accept();//接受弹窗
					seleniumUtil.waitForElementToLoad(2, FindCarsPage.FCP_DIV_CARINFO2);
					seleniumUtil.pause(800);
					int insize = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
					for (int j = 0; j < insize; j++) {
						String insecondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(j).getText();
						String insecondInfos[] = insecondInfo.split("，");
						String inautualLicense = insecondInfos[0].trim();
						if(inautualLicense!=license){
							logger.info("剩下车源的第"+(j+1)+"条车源信息中车牌号不为"+license);
							if(j==(insize-1)){
								logger.info("取消收藏车牌号："+license+" 车源成功");
							}
				
							continue;
						}
						if(inautualLicense.endsWith(license)){
							logger.error("车牌号为："+license+"的车源没有被取消收藏成功");
							Assert.fail("车牌号为："+license+"的车源没有被取消收藏成功");
						}
						
					}
					
					}
					
					if(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_PUBLIC).getAttribute("class").equals("active")){
						seleniumUtil.click(seleniumUtil.findElementsBy(byElement).get(i)); // 点击 取消收藏按钮
						seleniumUtil.waitForElementToLoad(2, FindCarsPage.FCP_BUTTON_FAV);
						seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_BUTTON_FAV).get(i).getText(), "收藏");
						
					}
					
					break;
				}
				if(autualLicense!=(license)){
					logger.warn("你要取消的车辆：["+license+"]在我的我的车辆收藏中已经不存在，也许之前被手动取消收藏过，请检查！");
					Assert.fail("你要取消的车辆：["+license+"]在我的我的车辆收藏中已经不存在，也许之前被手动取消收藏过，请检查！");
				}
			}

		}

	}

	/** 取消收藏操作针对有弹出操作： 弹出2次弹窗 上点击取消按钮 */
	public static void dismissCancelCarsByLicense(SeleniumUtil seleniumUtil, By byElement, String license) {
		logger.info("Start cancling favorite cars");
		seleniumUtil.pause(500);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String autualLicense = secondInfos[0].trim();
				if (autualLicense.equals(license)) {
					seleniumUtil.click(seleniumUtil.findElementsBy(byElement).get(i)); // 点击"	 取消收藏"按钮															
					seleniumUtil.pause(800);
					seleniumUtil.switchToPromptedAlertAfterWait(1000).dismiss();
					try{
					Assert.assertTrue(autualLicense.equals(license));
					}catch(AssertionError ae){
						logger.error("The expect license is not :"+license);
						Assert.fail("The expect license is not :"+license);
						
					}
					seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_BUTTON_CFAV).get(i).getText(), "取消收藏");
					break;
				}
			}

		}
		logger.info("Favoriting cars complete");
	}

	/** 根据驾驶证号，检查该车源是否被收藏 */
	public static void isFavCarExistByLicense(SeleniumUtil seleniumUtil, String license) {
		logger.info("checking  cars is faved or not");
		seleniumUtil.pause(500);
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("No datas displayed with thes fitters");
				return;
			}
		} catch (Exception e) {
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
			for (int i = 0; i < size; i++) {
				String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String autualLicense = secondInfos[0].trim();
				if (autualLicense.equals(license)) {
					seleniumUtil.pause(500);
					seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_BUTTON_CFAV).get(i).getText(), "取消收藏");
					break;

				}
			}

		}
		logger.info("check  cars is faved or not complete");
	}
	
	/**检查快速查询的 输入框文本  目的和出发地*/
	public  static void  checkCityName(SeleniumUtil seleniumUtil, String ...cites){
		logger.info("Start checking qucik search for cars cites");
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(FindCarsPage.FCP_INPUT_FROM, "value"), cites[0]);
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(FindCarsPage.FCP_INPUT_TO, "value"), cites[1]);
		logger.info("Checking qucik search for cars cites complete");
		
	}
	
	/**我的车源中，分别按照：星级，车长，重量和体积排序*/
	public static void checkCarsSort(SeleniumUtil seleniumUtil,String sortRule,int pageLoadTime) {
		try {
			if (seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")) {
				logger.warn("没有相关数据");
				return;
			}
		} catch (Exception e) {
			logger.info("找到了车源信息");
			logger.info("开始按照"+sortRule+"检查排序");
			int items = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size(); //取得车源的条数
			float[] temp1 = new float[items];//用于临时存放 星级数值 、车长、吨位、容积等 - 用于第一次点击
			float[] temp2 = new float[items];//用于临时存放 星级数值 、车长、吨位、容积等 - 用于第二次点击
			int count = 0;//定义点击计数器
			switch(sortRule){
			case "信用等级":
				while(count<2){ //点击2次 信用等级
				seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CREDIT));
				seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

				if(count==0){
					for (int s = 0; s < temp1.length; s++) {					
						//把星级的具体值存入一个float数组
						float stars = Float.valueOf(seleniumUtil.findElementsBy(FindCarsPage.FCP_TEXT_STAR).get(s).getAttribute("aria-valuenow"));
						temp1[s] = stars;
					}	
					logger.info("点击星级排序，箭头往上");
					for (int i = 0; i < temp1.length; i++) {
						try{
							if(i==temp1.length-1){
								break;
							}
						Assert.assertTrue(temp1[i+1]>=temp1[i]);
						logger.info("第"+(i+2)+"组数:"+temp1[i+1]+"据大于等于第"+(i+1)+"组数据:"+temp1[i]);
						}catch(AssertionError ae){
							logger.error("当星级箭头向上时，按星级排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当星级箭头向上时，按星级排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
						}
		
					}
					count++; //此时count的值变成1,1<2进行第二轮循环
					continue;
				}
				
				if(count==1){
					for (int s = 0; s < temp2.length; s++) {//把星级的具体值存入一个float数组
						float stars = Float.valueOf(seleniumUtil.findElementsBy(FindCarsPage.FCP_TEXT_STAR).get(s).getAttribute("aria-valuenow"));
						temp2[s] = stars;
					}	

					logger.info("点击星级排序，箭头往下");
					for (int i = 0; i < temp2.length; i++) {
						try{
							if(i==temp2.length-1){
								break;
							}
						Assert.assertTrue(temp2[i]>=temp2[i+1]);
						logger.info("第"+(i+2)+"组数据:"+temp2[i+1]+"小于等于第"+(i+1)+"组数据:"+temp2[i]);
						}catch(AssertionError ae){
							logger.error("当星级箭头向下时，按星级排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当星级箭头向下时，按星级排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
						}
					}
					count++;			
		
				}
				
			}
				break;
				
			case "车长":
				while(count<2){ //点击2次 、车长
				seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CARLEN));
				seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

				if(count==0){
					for (int s = 0; s < temp1.length; s++) {					
						//把车长的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarLen = Float.valueOf(secondInfos[2].substring(3, secondInfos[2].length() - 1)); // 取得车长
						temp1[s] = autualCarLen;
					}	
					logger.info("点击车长排序，箭头往上");
					for (int i = 0; i < temp1.length; i++) {
						try{
							if(i==temp1.length-1){
								break;
							}
						Assert.assertTrue(temp1[i+1]>=temp1[i]);
						logger.info("第"+(i+2)+"组数:"+temp1[i+1]+"据大于等于第"+(i+1)+"组数据:"+temp1[i]);
						}catch(AssertionError ae){
							logger.error("当车长箭头向上时，按车长排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当车长箭头向上时，按车长排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
						}
		
					}
					count++; //此时count的值变成1,1<2进行第二轮循环
					continue;
				}
				
				if(count==1){
					for (int s = 0; s < temp2.length; s++) {//把车长的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarLen = Float.valueOf(secondInfos[2].substring(3, secondInfos[2].length() - 1)); // 取得车长
						temp2[s] = autualCarLen;
					}	

					logger.info("点击车长排序，箭头往下");
					for (int i = 0; i < temp2.length; i++) {
						try{
							if(i==temp2.length-1){
								break;
							}
						Assert.assertTrue(temp2[i]>=temp2[i+1]);
						logger.info("第"+(i+2)+"组数据:"+temp2[i+1]+"小于等于第"+(i+1)+"组数据:"+temp2[i]);
						}catch(AssertionError ae){
							logger.error("当车长箭头向下时，按车长排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当车长箭头向下时，按车长排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
						}
					}
					count++;			
		
				}
				
			}
				
				break;
			case "载重":
				while(count<2){ //点击2次 载重
				seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_WEIGHT));
				seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

				if(count==0){
					for (int s = 0; s < temp1.length; s++) {					
						//把吨位的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarWeight = Float.valueOf(secondInfos[3].substring(3, secondInfos[3].length() - 1)); // 取得车重
						temp1[s] = autualCarWeight;
					}	
					logger.info("点击载重排序，箭头往上");
					for (int i = 0; i < temp1.length; i++) {
						try{
							if(i==temp1.length-1){
								break;
							}
						Assert.assertTrue(temp1[i+1]>=temp1[i]);
						logger.info("第"+(i+2)+"组数:"+temp1[i+1]+"据大于等于第"+(i+1)+"组数据:"+temp1[i]);
						}catch(AssertionError ae){
							logger.error("当载重箭头向上时，按载重排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当载重箭头向上时，按载重排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
						}
		
					}
					count++; //此时count的值变成1,1<2进行第二轮循环
					continue;
				}
				
				if(count==1){
					for (int s = 0; s < temp2.length; s++) {//把载重的具体值存入一个float数组
						//把吨位的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarWeight = Float.valueOf(secondInfos[3].substring(3, secondInfos[3].length() - 1)); // 取得车重
						temp2[s] = autualCarWeight;
					}	

					logger.info("点击载重排序，箭头往下");
					for (int i = 0; i < temp2.length; i++) {
						try{
							if(i==temp2.length-1){
								break;
							}
						Assert.assertTrue(temp2[i]>=temp2[i+1]);
						logger.info("第"+(i+2)+"组数据:"+temp2[i+1]+"小于等于第"+(i+1)+"组数据:"+temp2[i]);
						}catch(AssertionError ae){
							logger.error("当载重箭头向下时，按载重排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当载重箭头向下时，按载重排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
						}
					}
					count++;			
		
				}
				
			}
				
				break;
			case "车厢容积":
				while(count<2){ //点击2次 容积
				seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_VOLUME));
				seleniumUtil.hasLoadPageSucceeded(pageLoadTime);

				if(count==0){
					for (int s = 0; s < temp1.length; s++) {					
						//把容积的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarVolume = Float.valueOf(secondInfos[4].substring(5, secondInfos[4].length() - 1)); // 取得车容积
						temp1[s] = autualCarVolume;
					}	
					logger.info("点击车厢容积排序，箭头往上");
					for (int i = 0; i < temp1.length; i++) {
						try{
							if(i==temp1.length-1){
								break;
							}
						Assert.assertTrue(temp1[i+1]>=temp1[i]);
						logger.info("第"+(i+2)+"组数:"+temp1[i+1]+"据大于等于第"+(i+1)+"组数据:"+temp1[i]);
						}catch(AssertionError ae){
							logger.error("当车厢容积箭头向上时，按车厢容积排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当车厢容积箭头向上时，按车厢容积排序出错："+temp1[i+1]+"应该大于等于"+temp1[i]+"出错位置在第"+(i+1)+"和"+i);
						}
		
					}
					count++; //此时count的值变成1,1<2进行第二轮循环
					continue;
				}
				
				if(count==1){
					for (int s = 0; s < temp2.length; s++) {//把容积的具体值存入一个float数组
						//把容积的具体值存入一个float数组
						String secondInfo = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(s).getText();
						String secondInfos[] = secondInfo.split("，");
						float autualCarVolume = Float.valueOf(secondInfos[4].substring(5, secondInfos[4].length() - 1)); // 取得车容积
						temp2[s] = autualCarVolume;
					}	

					logger.info("点击车厢容积排序，箭头往下");
					for (int i = 0; i < temp2.length; i++) {
						try{
							if(i==temp2.length-1){
								break;
							}
						Assert.assertTrue(temp2[i]>=temp2[i+1]);
						logger.info("第"+(i+2)+"组数据:"+temp2[i+1]+"小于等于第"+(i+1)+"组数据:"+temp2[i]);
						}catch(AssertionError ae){
							logger.error("当车厢容积箭头向下时，按车厢容积排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
							Assert.fail("当车厢容积箭头向下时，按车厢容积排序出错："+temp2[i+1]+"应该小于等于"+temp2[i]+"出错位置在第"+(i+1)+"和"+i);
						}
					}
					count++;			
		
				}
				
			}
				
				break;
				
			default:
			return;
				
			
			}
			
			
			}

		}
	/**在首页收藏的车源，到找车源 我的收藏中验证是不是收藏成功的方法*/
	public static  void doesCarsFavInMyFav(SeleniumUtil seleniumUtil,String license,String driver){
		int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_ITEM_INFOS).size();

		for (int i = 0; i < size; i++) {
			String second = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
			String third = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO3).get(i).getText();
			if(second.contains(license)&&third.contains(driver)){
				logger.info("在找车源-我的收藏模块找到了刚刚在首页收藏的车源，车牌号："+license+" 司机："+driver);
				break;
				
			}else{
				logger.info("第"+(i+1)+"条车源不是刚刚在首页收藏的车源");
				if(i==size-1){
					logger.warn("没有找到你要的车源"+license+"你可能没有收藏成功或者已经取消收藏了");

				}	
			}	
		}
	}

/**验证找车源中的，未认证的用户信息*/
	public static void checkCarsInfoForUnattestedUser(SeleniumUtil seleniumUtil,int sleepTime){
		By bys[] =  {FindCarsPage.FCP_BUTTON_DEFAULT,FindCarsPage.FCP_BUTTON_CREDIT,FindCarsPage.FCP_BUTTON_CARLEN,FindCarsPage.FCP_BUTTON_WEIGHT,FindCarsPage.FCP_BUTTON_VOLUME};

		for (int i = 0; i < bys.length; i++) {
			seleniumUtil.click(seleniumUtil.findElementBy(bys[i]));
			seleniumUtil.pause(sleepTime);
			int carsNum = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
			for (int j = 0; j < carsNum; j++) {
				String second = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(j).getText();
				String  secondInfos[] = second.split("，");
				String license = secondInfos[0].trim();
				String third = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO3).get(j).getText();
				if(license.contains("***")&&third.contains("电话：认证后即可查看")&&third.contains("所属公司：认证后即可查看")){
					
					logger.info("未认证的用户看到的司机信息都被隐藏 - PASSED");
				}else{
					
					logger.error("未认证的用户可以看到相关被隐藏的信息，具体请看："+license +" "+third);
					Assert.fail("未认证的用户可以看到相关被隐藏的信息，具体请看："+license +" "+third);
				}
				
				
			}
			
			
			
			
			
		}
		
	}
	

}

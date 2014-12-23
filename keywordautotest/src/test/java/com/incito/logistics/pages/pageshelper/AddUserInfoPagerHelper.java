package com.incito.logistics.pages.pageshelper;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.AddUserInfoPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 完善用户信息页面帮助类
 * */
public class AddUserInfoPagerHelper {
	public static Logger logger = Logger.getLogger(AddUserInfoPagerHelper.class.getName());

	/** 等待完善信息页面元素加载出来 */
	public static void waitAddUserInfoPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page elements");
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_TEXT_TITLE);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_ADDRESS);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_SELECT_CITY);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_COMPANY);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_IDCARD);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_NAME);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_SELECT_REGION);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_TEL);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_SELECT_PROVINCE);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_INPUT_UPLOAD);


		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_BUTTON_BACK);
		seleniumUtil.waitForElementToLoad(timeOut, AddUserInfoPage.AUIP_BUTTON_SUBMIT);
		logger.info("Check addUserInfo page elements completed");

	}

	/** 检查完善信息页面上的文本 */
	public static void checkAddUserInfoPageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_TITLE).getText(), "请完善您的个人信息");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_ADDRESS).getText(), "公司地址：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS).getAttribute("placeholder"), "街道地址");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_COMPANY).getText(), "公司名称：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_IDCARD).getText(), "身份证号：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_NAME).getText(), "姓名：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_TEL).getText(), "联系电话：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_PHOTO).getText(), "证件照片：");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_BUTTON_SUBMIT).getText(), "提交");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_BUTTON_BACK).getText(), "返回");

		logger.info("Check addUserInfo page text completed");
	}

	/** 完善信息页面上点击“提交”或者“返回”按钮 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	/** 检查完善信息页面:全为空的提示语 */
	// 公司名称提示语没有，待修改之后在修复该自动化脚本，因为不知道该提示语为什么！
	public static void checkAddUserInfoPrompt(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_TEXT_TITLE).getText(), "请完善您的个人信息");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}
	

	/** 检查完善信息页面：只填写姓名的提示语 */
	public static void checkAddUserInfoPrompt_Name(int timeOut, SeleniumUtil seleniumUtil, Map<String, String> data) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
//		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(), "");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写联系方式的提示语 */
	public static void checkAddUserInfoPrompt_Tel(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写身份证号的提示语 */
	public static void checkAddUserInfoPrompt_Idcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写公司名称的提示语 */
	// 是个bug现在还没有修复
	public static void checkAddUserInfoPrompt_Company(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：只填写公司地址的提示语 */
	public static void checkAddUserInfoPrompt_Address(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和联系方式的提示语 */
	public static void checkAddUserInfoPrompt_NameTel(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和身份证号的提示语 */
	public static void checkAddUserInfoPrompt_NameIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和公司名称的提示语 */
	public static void checkAddUserInfoPrompt_NameCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名和公司地址的提示语 */
	public static void checkAddUserInfoPrompt_NameAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和身份证号的提示语 */
	public static void checkAddUserInfoPrompt_TelIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和公司名称的提示语 */
	public static void checkAddUserInfoPrompt_TelCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式和公司地址的提示语 */
	public static void checkAddUserInfoPrompt_TelAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号和公司名称的提示语 */
	public static void checkAddUserInfoPrompt_IdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号和公司地址的提示语 */
	public static void checkAddUserInfoPrompt_IdcardAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了公司名称和公司地址的提示语 */
	public static void checkAddUserInfoPrompt_CompanyAdress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，身份证号的提示语 */
	public static void checkAddUserInfoPrompt_NameTelIdcard(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，公司名称的提示语 */
	public static void checkAddUserInfoPrompt_NameTelCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，联系方式，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_NameTelAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，身份证号，公司名称的提示语 */
	public static void checkAddUserInfoPrompt_NameIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，身份证号，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_NameIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了姓名，公司名称，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_NameCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，身份证号，公司名称的提示语 */
	public static void checkAddUserInfoPrompt_TelIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，身份证号，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_TelIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了联系方式，公司名称，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_TelCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写了身份证号，公司名称，公司地址的提示语 */
	public static void checkAddUserInfoPrompt_IdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面：填写姓名，电话，身份证号，公司名称的提示语 */
	public static void checkAddUserInfoPrompt_NameTelIdcardCompany(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，电话，身份证号，公司地址提示语 */
	public static void checkAddUserInfoPrompt_NameTelIdcardAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，电话，公司名称，公司地址提示语 */
	public static void checkAddUserInfoPrompt_NameTelCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写姓名，身份证号，公司名称，公司地址提示语 */
	public static void checkAddUserInfoPrompt_NameIdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:填写电话，身份证号，公司名称，公司地址提示语 */
	public static void checkAddUserInfoPrompt_TelIdcardCompanyAddress(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_NAME_PROMPT).getText(), "请输入2-8个中文字符");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_TEL_PROMPT).getText(), "请输入正确的电话号码");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_COMPANY_PROMPT).getText(),"");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_IDCARD_PROMPT).getText(), "请输入正确的身份证号码");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_INPUT_ADDRESS_PROMPT).getText(), "省 不能为空");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}

	/** 检查完善信息页面:必填项全部填写 */
	public static void checkAddUserInfoPrompt_All(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking checkAddUserInfoPrompt page text");

		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(AddUserInfoPage.AUIP_POPUP_TRUE).getText(), "您已成功提交个人信息，我们将在24小时内完成审核，您可以先发货了！如需优先认证，请致电");

		logger.info("Check checkAddUserInfoPrompt page text completed");
	}
}

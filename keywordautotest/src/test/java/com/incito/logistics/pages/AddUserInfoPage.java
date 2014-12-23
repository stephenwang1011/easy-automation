package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 定义完善用户信息页面元素
 * 
 * */
public class AddUserInfoPage {
	/** 姓名输入框 */
	public static final By AUIP_INPUT_NAME = By.name("name");
	/** 联系电话输入框 */
	public static final By AUIP_INPUT_TEL = By.name("tel");
	/** 公司名称输入框 */
	public static final By AUIP_INPUT_COMPANY = By.name("company");
	/** 身份证输入框 */
	public static final By AUIP_INPUT_IDCARD = By.name("icard");
	/** 公司地址：“省”下拉列表 */
	public static final By AUIP_SELECT_PROVINCE = By.id("province");
	/** 公司地址：“市”下拉列表 */
	public static final By AUIP_SELECT_CITY = By.id("city");
	/** 公司地址：“区/县”下拉列表 */
	public static final By AUIP_SELECT_REGION = By.id("region");
	/** 公司地址：“街道地址”文本框 */
	public static final By AUIP_INPUT_ADDRESS = By.id("address");
	/** 上传图片按钮 */
	public static final By AUIP_INPUT_UPLOAD = By.className("fileinput-new");
	/** 提交按钮 */
	public static final By AUIP_BUTTON_SUBMIT = By.xpath("//button[text()='提交']");
	/** 返回按钮 */
	public static final By AUIP_BUTTON_BACK = By.xpath("//button[text()='返回']");
	/** 顶部title */
	public static final By AUIP_TEXT_TITLE = By.xpath("//span[text()='请完善您的个人信息']");
	/** 姓名文本 */
	public static final By AUIP_TEXT_NAME = By.xpath("//label[text()='姓名：']");
	/** 联系电话文本 */
	public static final By AUIP_TEXT_TEL = By.xpath("//label[text()='联系电话：']");
	/** 身份证号码文本 */
	public static final By AUIP_TEXT_IDCARD = By.xpath("//label[text()='身份证号：']");
	/** 公司地址文本 */
	public static final By AUIP_TEXT_ADDRESS = By.xpath("//label[text()='公司地址：']");
	/** 公司名称文本 */
	public static final By AUIP_TEXT_COMPANY = By.xpath("//label[text()='公司名称：']");
	/** 证件照片文本 */
	public static final By AUIP_TEXT_PHOTO = By.xpath("//label[text()='证件照片：']");
	/** 姓名错误提示语： */
	public static final By AUIP_INPUT_NAME_PROMPT = By.id("name_tip");
	/** 联系电话错误提示语： */
	public static final By AUIP_INPUT_TEL_PROMPT = By.id("tel_tip");
	/** 身份证错误提示语： */
	public static final By AUIP_INPUT_IDCARD_PROMPT = By.id("idcard_tip");
	/** 公司名称错误提示语： */
	public static final By AUIP_INPUT_COMPANY_PROMPT = By.id("");// 公司名称提示语没有
	/** 公司地址错误提示语： */
	public static final By AUIP_INPUT_ADDRESS_PROMPT = By.id("address_tip");
	/** 完成信息成功弹出框提示语 */
	public static final By AUIP_POPUP_TRUE = By.xpath("//label[text()='您已成功提交个人信息，我们将在24小时内完成审核，您可以先发货了！如需优先认证，请致电']");
	/** 完成信息成功弹出框下方确定按钮 */
	public static final By AUIP_BUTTON_CONFIRM = By.xpath("//*[@id='authenticating']/div/div/div/div/button");
}

package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * 声明登陆界面页面元素
 * 
 * */
public class LoginPage {
	/** 登陆页面上的：用户名输入框 */
	public static final By LP_INPUT_USERNAME = By.id("u");
	/** 登陆页面上的：密码输入框 */
	public static final By LP_INPUT_PASSCODE = By.id("p");
	/** 登陆页面上的：登陆按钮 */
	public static final By LP_BUTTON_LOGIN = By.id("loginBtn");
	/** 登陆页面上的：自动登陆label */
	public static final By LP_LABEL_AUTO = By.xpath("//*[@id='loginform']/*/label");
	/** 登陆页面上的：自动登陆checkbox */
	public static final By LP_CHECKBOX_AUTO = By.id("autoLogin");
	/** 登陆页面上的：关闭按钮 */
	public static final By LP_BUTTON_CLOSE = By.className("close");
	/** 登陆页面上的验证码输入框 */
	public static final By LP_INPUT_CODE = By.id("checkcode");
	/** 登陆页面上的验证码显示区域 */
	public static final By LP_LINK_NOTCLEAR = By.linkText("看不清？");

}

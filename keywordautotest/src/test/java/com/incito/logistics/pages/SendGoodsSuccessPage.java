	package com.incito.logistics.pages;

import org.openqa.selenium.By;
	
	/**
	 * @Description 发布货源成功页面上的元素声明
	 * @author xy-incito-wy
	 * */
	public class SendGoodsSuccessPage {
	/**发布成功的提示语*/
	public final static  By SGSP_TEXT_SUCCESS = By.xpath("//span[text()='货源发布成功！']");
	/**再发一个 按钮*/
	public final static  By SGSP_BUTTON_SENDAGAIN = By.xpath("//button[text()='再发布一条']");
	/**查看发布的货源 按钮*/
	public final static  By SGSP_BUTTON_CHECK = By.xpath("//button[text()='查看发布的货源']");
	/**查看发布的货源 按钮*/
	public final static  By SGSP_BUTTON_CHECK1 = By.xpath("//button[text()='查看已发货源']");
	
	}

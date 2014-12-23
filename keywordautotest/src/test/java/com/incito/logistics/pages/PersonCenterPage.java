package com.incito.logistics.pages;

import org.openqa.selenium.By;

/**
 * @author xy-incito-wk
 * @desprition 个人中心页面元素声明
 */
public class PersonCenterPage {
	/** 个人中心中联系人 */
	public static final By PCP_TEXT_CONTANTS = By.xpath("//*[@class='personal-info-content']/span[1]");
	/** 个人中心中联系电话 */
	public static final By PCP_TEXT_TEL = By.xpath("//*[@class='personal-info-content']/span[2]");
	/** 个人中心中联系电话 */
	public static final By PCP_TEXT_ADDRESS = By.xpath("//*[@class='personal-info-content']/span[3]");
	/** 个人中心中我的货源 */
	public static final By PCP_TEXT_MYGOODS = By.xpath("//*[@class='personal-stat-title'][text()='我的货源']");
	/** 个人中心中我的订单 */
	public static final By PCP_TEXT_MYORDERS = By.xpath("//*[@class='personal-stat-title'][text()='我的订单']");
	/** 个人中心中我的收藏 */
	public static final By PCP_TEXT_MYFAVO = By.xpath("//*[@class='personal-stat-title'][text()='我的收藏']");
	/** 个人中心中我的货源，新货源（或者我的订单，新订单） */
	public static final By PCP_LINK_MYGOODSNEWGOODS = By.cssSelector("div.personal-area3.personal-blue._pointer");
	/** 个人中心中我的货源，已失效货源（或者我的订单，待付款） */
	public static final By PCP_LINK_MYGOODSINVALIDGOODS = By.cssSelector("div.personal-area3.personal-pink._pointer");
	/** 个人中心中我的货源，累计发布（或者我的订单，待评价） */
	public static final By PCP_LINK_MYGOODSALLGOODS = By.cssSelector("div.personal-area3.personal-lightblue._pointer");
	/** 个人中心中我的收藏，车辆 */
	public static final By PCP_LINK_MYFAVOCARS_CARS = By.cssSelector("div.personal-area2.personal-blue._pointer");
	/** 个人中心中我的收藏，货源 */
	public static final By PCP_LINK_MYFAVOCARS_GOODS = By.cssSelector("div.personal-area2.personal-pink._pointer");
}

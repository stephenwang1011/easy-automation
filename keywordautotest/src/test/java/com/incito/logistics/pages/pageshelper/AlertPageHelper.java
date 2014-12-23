package com.incito.logistics.pages.pageshelper;

import com.incito.logistics.util.SeleniumUtil;

public class AlertPageHelper {

	/** 登录出错的提示信息 */
	public static void checkAlertInfo(SeleniumUtil seleniumUtil, int waitMillisecondsForAlert) {
		seleniumUtil.isTextCorrect(seleniumUtil.switchToPromptedAlertAfterWait(waitMillisecondsForAlert).getText(), "用户名或密码错误,请重新登录!");
	}

}

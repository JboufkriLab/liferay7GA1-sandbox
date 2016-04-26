/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.mvcportlet.action;

import org.osgi.service.component.annotations.Component;

import com.liferay.docs.mvcportlet.MyMvcPortletPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

/**
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + MyMvcPortletPortletKeys.MY_ACCOUNT,
		"mvc.command.name=updateUser"
	},
	service = MVCActionCommand.class
)
public class EditUserMVCActionCommand extends
	com.liferay.my.account.web.portlet.action.EditUserMVCActionCommand {


}
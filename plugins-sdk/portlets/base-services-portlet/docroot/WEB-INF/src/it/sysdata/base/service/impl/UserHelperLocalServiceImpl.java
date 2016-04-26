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

package it.sysdata.base.service.impl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import it.sysdata.base.service.base.UserHelperLocalServiceBaseImpl;
import it.sysdata.base.util.PortletPropsValues;

/**
 * The implementation of the user helper_1_0 local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the {@link
 * it.sysdata.base.service.UserHelper_1_0LocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM.
 * </p>
 *
 * @author @baxtheman
 * @see    it.sysdata.base.service.base.UserHelper_1_0LocalServiceBaseImpl
 * @see    it.sysdata.base.service.UserHelper_1_0LocalServiceUtil
 */
public class UserHelperLocalServiceImpl
	extends UserHelperLocalServiceBaseImpl {

	public User addUserEmail(
		String emailAddress, String password, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return addUserEmail(
			emailAddress, password, "--", "--", serviceContext);
	}

	public User addUserEmail(
		String emailAddress, String password, String firstName,
		String lastName, ServiceContext serviceContext)
		throws PortalException, SystemException {

		HttpServletRequest httpServletRequest = serviceContext.getRequest();
		Locale locale = PortalUtil.getLocale(httpServletRequest);

		String userAgent = httpServletRequest.getHeader("User-Agent");

		_validateUser(emailAddress, password, serviceContext);

		long companyId = serviceContext.getCompanyId();

		long[] groupIds = new long[1];
		long[] roleIds = null;
		long[] userGroupIds = null;
		long[] organizationIds = null;

		if (Validator.isNotNull(PortletPropsValues.API_NEWUSER_USERGROUP_MEMBER)) {

			UserGroup userGroup =
				UserGroupLocalServiceUtil.getUserGroup(
					companyId, PortletPropsValues.API_NEWUSER_USERGROUP_MEMBER);

			userGroupIds = new long[]{userGroup.getUserGroupId()};
		}

		if (Validator.isNotNull(PortletPropsValues.API_NEWUSER_GROUPNAME_MEMBER)) {

			Group group =
				GroupLocalServiceUtil.getGroup(
					companyId, PortletPropsValues.API_NEWUSER_GROUPNAME_MEMBER);

			if (group.getGroupId() > 0) {
				groupIds[0] = group.getGroupId();
			}
			else {
				groupIds = null;
			}
		}

//		Role role = RoleLocalServiceUtil.getRole(companyId, "roleName");

//		if (role.getRoleId() > 0) {
//			roleIds[0] = role.getRoleId();
//		}
//		else {
//			roleIds = null;
//		}

		User user =
			UserLocalServiceUtil.addUser(
				0, companyId, false, password, password, true, null,
				emailAddress, 0, null, locale, firstName, null, lastName, 0, 0,
				true, 1, 1, 1970, null, groupIds, organizationIds, roleIds,
				userGroupIds, PortletPropsValues.API_NEWUSER_SENDEMAIL,
				serviceContext);

		_log.info(String.format(
			"addUserEmail %s, %s, %s > %s",
			emailAddress, password,
			userAgent, user.getUserId()));

		return user;
	}

	public User updateUserInfo(
		String emailAddress, String password, String firstName,
		String lastName, ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = UserLocalServiceUtil.getUserByEmailAddress(
			serviceContext.getCompanyId(), emailAddress);

		long userId = user.getUserId();
		String oldPassword = password;
		String newPassword1 = password;
		String newPassword2 = password;
		boolean passwordReset = false;

		String reminderQueryQuestion = null;
		String reminderQueryAnswer = null;
		String screenName = user.getScreenName();

		long facebookId = user.getFacebookId();
		String openId = user.getOpenId();
		String languageId = user.getLanguageId();
		String timeZoneId = user.getTimeZoneId();
		String greeting = user.getGreeting();
		String comments = null;
		String middleName = user.getMiddleName();

		int prefixId = 0;
		int suffixId = 0;
		boolean male = user.getMale();
		int birthdayMonth = 0;
		int birthdayDay = 0;
		int birthdayYear = 0;

		String smsSn = null;
		String aimSn= null;
		String facebookSn= null;
		String icqSn= null;
		String jabberSn= null;
		String msnSn= null;
		String mySpaceSn= null;
		String skypeSn= null;
		String twitterSn= null;
		String ymSn= null;
		String jobTitle = user.getJobTitle();

		long[] groupIds = user.getGroupIds();
		long[] organizationIds = user.getOrganizationIds();
		long[] roleIds = user.getRoleIds();
		List<UserGroupRole> userGroupRoles = null;
		long[] userGroupIds = user.getUserGroupIds();

		return UserLocalServiceUtil.updateUser(
			userId, oldPassword, newPassword1, newPassword2, passwordReset,
			reminderQueryQuestion, reminderQueryAnswer, screenName,
			emailAddress, facebookId, openId, true, null, languageId,
			timeZoneId, greeting, comments, firstName, middleName, lastName,
			prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
			smsSn, facebookSn, jabberSn, skypeSn, twitterSn, jobTitle, groupIds,
			organizationIds, roleIds, userGroupRoles, userGroupIds,
			serviceContext);
	}

	private void _validateUser(
		String emailAddress, String password, ServiceContext serviceContext) {



	}

	private static Log _log = LogFactoryUtil.getLog(
		UserHelperLocalServiceImpl.class);
}
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;

import it.sysdata.base.hook.autologin.TokenAutoLogin;
import it.sysdata.base.service.base.UserHelper_1_1ServiceBaseImpl;
import it.sysdata.base.util.SecretKeyUtil;

/**
 * The implementation of the user helper_1_1 remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the {@link
 * it.sysdata.base.service.UserHelper_1_1Service} interface.  <p> This is a
 * remote service. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely.
 * </p>
 *
 * @author @baxtheman
 * @see    it.sysdata.base.service.base.UserHelper_1_1ServiceBaseImpl
 * @see    it.sysdata.base.service.UserHelper_1_1ServiceUtil
 */
public class UserHelper_1_1ServiceImpl extends UserHelper_1_1ServiceBaseImpl {

	@Override
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "add-user-email", method = "POST")
	public User addUserEmail(
		String emailAddress, String password, String secretKey)
		throws PortalException, SystemException {

		SecretKeyUtil.check(secretKey);

		ServiceContext servicecontext =
			ServiceContextThreadLocal.getServiceContext();

		return userHelperLocalService.addUserEmail(
			emailAddress, password, servicecontext);
	}

	@Override
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "add-user-email", method = "POST")
	public User addUserEmail(
		String emailAddress, String password, String firstName,
		String lastName, String secretKey)
		throws PortalException, SystemException {

		SecretKeyUtil.check(secretKey);

		ServiceContext servicecontext =
			ServiceContextThreadLocal.getServiceContext();

		return userHelperLocalService.addUserEmail(
			emailAddress, password, firstName, lastName, servicecontext);
	}

	@Override
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "send-new-password", method = "POST")
	public User sendNewPassword(String emailAddress)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		String adminEmailFromName =
			PrefsPropsUtil.getString(
				serviceContext.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String adminEmailFromAddress =
			PrefsPropsUtil.getString(
				serviceContext.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		String adminEmailPasswordResetSubject =
			PrefsPropsUtil.getContent(
				serviceContext.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT);
		String adminEmailPasswordResetBody =
			PrefsPropsUtil.getContent(
				serviceContext.getCompanyId(),
				PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY);

		UserLocalServiceUtil.sendPassword(
			serviceContext.getCompanyId(), emailAddress, adminEmailFromName,
			adminEmailFromAddress, adminEmailPasswordResetSubject,
			adminEmailPasswordResetBody, serviceContext);

		User user =
			UserLocalServiceUtil.getUserByEmailAddress(
				serviceContext.getCompanyId(), emailAddress);

		return user;
	}


	@Override
	public User updateUserInfo(
		String emailAddress, String password, String firstName, String lastName)
			throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		User realUser = UserLocalServiceUtil.getUserByEmailAddress(
			serviceContext.getCompanyId(), emailAddress);

		if (realUser.getUserId() != getUserId()) {

			throw new SecurityException();
		}

		return userHelperLocalService.updateUserInfo(
			emailAddress, password, firstName, lastName, serviceContext);
	}

	@Override
	@AccessControlled(guestAccessEnabled = false)
	public String getUserProfilePage() throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		User realUser = UserLocalServiceUtil.getUser(getUserId());

		return TokenAutoLogin.getUserProfilePage(
			serviceContext.getRequest(), realUser.getUserId());
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserHelper_1_1ServiceImpl.class);
}
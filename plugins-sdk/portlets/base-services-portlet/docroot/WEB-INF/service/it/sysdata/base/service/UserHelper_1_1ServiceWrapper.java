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

package it.sysdata.base.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserHelper_1_1Service}.
 *
 * @author @baxtheman
 * @see UserHelper_1_1Service
 * @generated
 */
@ProviderType
public class UserHelper_1_1ServiceWrapper implements UserHelper_1_1Service,
	ServiceWrapper<UserHelper_1_1Service> {
	public UserHelper_1_1ServiceWrapper(
		UserHelper_1_1Service userHelper_1_1Service) {
		_userHelper_1_1Service = userHelper_1_1Service;
	}

	@Override
	public com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String secretKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelper_1_1Service.addUserEmail(emailAddress, password,
			firstName, lastName, secretKey);
	}

	@Override
	public com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String secretKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelper_1_1Service.addUserEmail(emailAddress, password,
			secretKey);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userHelper_1_1Service.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getUserProfilePage()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelper_1_1Service.getUserProfilePage();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userHelper_1_1Service.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.model.User sendNewPassword(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelper_1_1Service.sendNewPassword(emailAddress);
	}

	@Override
	public com.liferay.portal.kernel.model.User updateUserInfo(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelper_1_1Service.updateUserInfo(emailAddress, password,
			firstName, lastName);
	}

	@Override
	public UserHelper_1_1Service getWrappedService() {
		return _userHelper_1_1Service;
	}

	@Override
	public void setWrappedService(UserHelper_1_1Service userHelper_1_1Service) {
		_userHelper_1_1Service = userHelper_1_1Service;
	}

	private UserHelper_1_1Service _userHelper_1_1Service;
}
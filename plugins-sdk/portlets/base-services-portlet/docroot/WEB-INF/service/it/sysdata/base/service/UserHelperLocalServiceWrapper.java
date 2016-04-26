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
 * Provides a wrapper for {@link UserHelperLocalService}.
 *
 * @author @baxtheman
 * @see UserHelperLocalService
 * @generated
 */
@ProviderType
public class UserHelperLocalServiceWrapper implements UserHelperLocalService,
	ServiceWrapper<UserHelperLocalService> {
	public UserHelperLocalServiceWrapper(
		UserHelperLocalService userHelperLocalService) {
		_userHelperLocalService = userHelperLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelperLocalService.addUserEmail(emailAddress, password,
			firstName, lastName, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelperLocalService.addUserEmail(emailAddress, password,
			serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userHelperLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userHelperLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.model.User updateUserInfo(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userHelperLocalService.updateUserInfo(emailAddress, password,
			firstName, lastName, serviceContext);
	}

	@Override
	public UserHelperLocalService getWrappedService() {
		return _userHelperLocalService;
	}

	@Override
	public void setWrappedService(UserHelperLocalService userHelperLocalService) {
		_userHelperLocalService = userHelperLocalService;
	}

	private UserHelperLocalService _userHelperLocalService;
}
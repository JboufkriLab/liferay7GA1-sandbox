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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for UserHelper. This utility wraps
 * {@link it.sysdata.base.service.impl.UserHelperLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @baxtheman
 * @see UserHelperLocalService
 * @see it.sysdata.base.service.base.UserHelperLocalServiceBaseImpl
 * @see it.sysdata.base.service.impl.UserHelperLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserHelperLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.sysdata.base.service.impl.UserHelperLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addUserEmail(emailAddress, password, firstName, lastName,
			serviceContext);
	}

	public static com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserEmail(emailAddress, password, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.model.User updateUserInfo(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateUserInfo(emailAddress, password, firstName, lastName,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserHelperLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserHelperLocalService.class.getName());

			if (invokableLocalService instanceof UserHelperLocalService) {
				_service = (UserHelperLocalService)invokableLocalService;
			}
			else {
				_service = new UserHelperLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserHelperLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static UserHelperLocalService _service;
}
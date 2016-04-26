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

package it.sysdata.base.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.sysdata.base.service.UserHelper_1_1ServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link UserHelper_1_1ServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author @baxtheman
 * @see UserHelper_1_1ServiceHttp
 * @see UserHelper_1_1ServiceUtil
 * @generated
 */
@ProviderType
public class UserHelper_1_1ServiceSoap {
	public static com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String secretKey) throws RemoteException {
		try {
			com.liferay.portal.kernel.model.User returnValue = UserHelper_1_1ServiceUtil.addUserEmail(emailAddress,
					password, secretKey);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.User addUserEmail(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String secretKey) throws RemoteException {
		try {
			com.liferay.portal.kernel.model.User returnValue = UserHelper_1_1ServiceUtil.addUserEmail(emailAddress,
					password, firstName, lastName, secretKey);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.User sendNewPassword(
		java.lang.String emailAddress) throws RemoteException {
		try {
			com.liferay.portal.kernel.model.User returnValue = UserHelper_1_1ServiceUtil.sendNewPassword(emailAddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.User updateUserInfo(
		java.lang.String emailAddress, java.lang.String password,
		java.lang.String firstName, java.lang.String lastName)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.model.User returnValue = UserHelper_1_1ServiceUtil.updateUserInfo(emailAddress,
					password, firstName, lastName);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getUserProfilePage()
		throws RemoteException {
		try {
			java.lang.String returnValue = UserHelper_1_1ServiceUtil.getUserProfilePage();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserHelper_1_1ServiceSoap.class);
}
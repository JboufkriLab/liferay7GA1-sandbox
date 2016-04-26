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

package it.sysdata.base.service.base;

import aQute.bnd.annotation.ProviderType;

import it.sysdata.base.service.UserHelperLocalServiceUtil;

import java.util.Arrays;

/**
 * @author @baxtheman
 * @generated
 */
@ProviderType
public class UserHelperLocalServiceClpInvoker {
	public UserHelperLocalServiceClpInvoker() {
		_methodName16 = "getOSGiServiceIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName19 = "addUserEmail";

		_methodParameterTypes19 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.kernel.service.ServiceContext"
			};

		_methodName20 = "addUserEmail";

		_methodParameterTypes20 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String",
				"com.liferay.portal.kernel.service.ServiceContext"
			};

		_methodName21 = "updateUserInfo";

		_methodParameterTypes21 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String",
				"com.liferay.portal.kernel.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return UserHelperLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return UserHelperLocalServiceUtil.addUserEmail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[2]);
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return UserHelperLocalServiceUtil.addUserEmail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[4]);
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return UserHelperLocalServiceUtil.updateUserInfo((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[4]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
}
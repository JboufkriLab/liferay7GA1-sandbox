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

import it.sysdata.base.service.UserHelper_1_1ServiceUtil;

import java.util.Arrays;

/**
 * @author @baxtheman
 * @generated
 */
@ProviderType
public class UserHelper_1_1ServiceClpInvoker {
	public UserHelper_1_1ServiceClpInvoker() {
		_methodName22 = "getOSGiServiceIdentifier";

		_methodParameterTypes22 = new String[] {  };

		_methodName25 = "addUserEmail";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName26 = "addUserEmail";

		_methodParameterTypes26 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName27 = "sendNewPassword";

		_methodParameterTypes27 = new String[] { "java.lang.String" };

		_methodName28 = "updateUserInfo";

		_methodParameterTypes28 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName29 = "getUserProfilePage";

		_methodParameterTypes29 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.addUserEmail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.addUserEmail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.sendNewPassword((java.lang.String)arguments[0]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.updateUserInfo((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return UserHelper_1_1ServiceUtil.getUserProfilePage();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
}
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the remote service interface for UserHelper_1_1. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author @baxtheman
 * @see UserHelper_1_1ServiceUtil
 * @see it.sysdata.base.service.base.UserHelper_1_1ServiceBaseImpl
 * @see it.sysdata.base.service.impl.UserHelper_1_1ServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserHelper_1_1Service extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserHelper_1_1ServiceUtil} to access the user helper_1_1 remote service. Add custom service methods to {@link it.sysdata.base.service.impl.UserHelper_1_1ServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "add-user-email", method = "POST")
	public User addUserEmail(java.lang.String emailAddress,
		java.lang.String password, java.lang.String firstName,
		java.lang.String lastName, java.lang.String secretKey)
		throws PortalException, SystemException;

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "add-user-email", method = "POST")
	public User addUserEmail(java.lang.String emailAddress,
		java.lang.String password, java.lang.String secretKey)
		throws PortalException, SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@AccessControlled(guestAccessEnabled = false)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUserProfilePage()
		throws PortalException, SystemException;

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(value = "send-new-password", method = "POST")
	public User sendNewPassword(java.lang.String emailAddress)
		throws PortalException, SystemException;

	public User updateUserInfo(java.lang.String emailAddress,
		java.lang.String password, java.lang.String firstName,
		java.lang.String lastName) throws PortalException, SystemException;
}
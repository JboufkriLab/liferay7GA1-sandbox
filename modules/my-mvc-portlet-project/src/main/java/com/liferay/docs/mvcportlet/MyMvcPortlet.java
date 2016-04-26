package com.liferay.docs.mvcportlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.name=" + MyMvcPortletPortletKeys.MY_ACCOUNT,
		"javax.portlet.display-name=my-mvc-portlet-project Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/edit_user.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MyMvcPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(MyMvcPortlet.class);
}
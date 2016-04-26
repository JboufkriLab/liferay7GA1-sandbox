package it.sysdata.base.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * @author @baxtheman
 */
/**
 * @author @baxtheman
 */
public class PortletPropsValues {

	public static final boolean API_1_0_ENABLED =
		GetterUtil.getBoolean((PortletProps.get(PortletPropsKeys.API_1_0_ENABLED)));

	public static final String API_SECRETKEY_PREFIX =
		PortletProps.get(PortletPropsKeys.API_SECRETKEY_PREFIX);

	public static final String API_NEWUSER_GROUPNAME_MEMBER =
		PortletProps.get(PortletPropsKeys.API_NEWUSER_GROUPNAME_MEMBER);

	public static final String API_NEWUSER_USERGROUP_MEMBER =
		PortletProps.get(PortletPropsKeys.API_NEWUSER_USERGROUP_MEMBER);

	public static final String[] API_NEWUSER_ROLE_NAMES =
		GetterUtil.getStringValues((PortletProps.get(PortletPropsKeys.API_NEWUSER_ROLE_NAMES)));

	public static final boolean API_NEWUSER_SENDEMAIL =
		GetterUtil.getBoolean((PortletProps.get(PortletPropsKeys.API_NEWUSER_SENDEMAIL)));
}
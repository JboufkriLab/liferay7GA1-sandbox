package it.sysdata.base.util;

import com.liferay.portal.kernel.util.Validator;

import it.sysdata.base.exception.SecretKeyException;


/**
 * @author Brian Wing Shun Chan
 */
public class SecretKeyUtil {

	static public void check(String secretKey) throws SecretKeyException {

		if (Validator.isNull(secretKey)) {
			throw new SecretKeyException();
		}

		if (Validator.isNotNull(PortletPropsValues.API_SECRETKEY_PREFIX)) {

			if (!secretKey.startsWith(PortletPropsValues.API_SECRETKEY_PREFIX)) {

				throw new SecretKeyException();
			}
		}
	}
}
package it.sysdata.base.hook.autologin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.AutoLoginException;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.Encryptor;
import com.liferay.util.EncryptorException;

import it.sysdata.base.util.PortletKeys;
import it.sysdata.base.util.PortletPropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class TokenAutoLogin implements AutoLogin {

	@Override
	public String[] handleException(
		HttpServletRequest arg0, HttpServletResponse arg1, Exception arg2)
			throws AutoLoginException {

		return null;
	}

	@Override
	public String[] login(HttpServletRequest request, HttpServletResponse arg1)
		throws AutoLoginException {

		try {

			String token = ParamUtil.getString(request, "token");
			String userId = ParamUtil.getString(request, "userId");

			Company company = PortalUtil.getCompany(request);

			long realUserId = GetterUtil.getLong(
				Encryptor.decrypt(company.getKeyObj(), userId));

			if (Validator.isNull(token)) {
				return null;
			}

			if (Validator.isNull(realUserId)) {
				return null;
			}

			String valid = generateToken(request, realUserId);

			if (!token.equals(valid)) {
				return null;
			}

			User user = UserLocalServiceUtil.getUserById(realUserId);

			return new String[] {
				String.valueOf(user.getUserId()), user.getPassword(),
				String.valueOf(user.isPasswordEncrypted())
			};
		}
		catch (Exception e) {
			return null;
		}
	}

	public static String getLandingPage(HttpServletRequest request, long userId)
		throws SystemException {

		return null;
	}

	public static String getUserProfilePage(
		HttpServletRequest request, long userId)
			throws SystemException, PortalException {

		Company company = PortalUtil.getCompany(request);

		Group group = null;

		if (Validator.isNotNull(
			PortletPropsValues.API_NEWUSER_GROUPNAME_MEMBER)) {

			group = GroupLocalServiceUtil.getGroup(
				company.getCompanyId(),
				PortletPropsValues.API_NEWUSER_GROUPNAME_MEMBER);
		}

		if (group == null) {
			return null;
		}

		String layoutUrl = PortalUtil.getLayoutFullURL(group.getGroupId(),
			PortletKeys.USER_ACCOUNT);

		try {
			String encDoAsUserId =
				Encryptor.encrypt(company.getKeyObj(), String.valueOf(userId));

			layoutUrl = HttpUtil.addParameter(layoutUrl, "userId", encDoAsUserId);

			layoutUrl = HttpUtil.addParameter(
				layoutUrl, "token", TokenAutoLogin.generateToken(request, userId));

			return layoutUrl;
		}
		catch (EncryptorException e) {

			throw new SystemException(e);
		}
	}

	public static String generateToken(HttpServletRequest request, long userId)
		throws SystemException {

		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			long time = CalendarFactoryUtil.getCalendar().getTimeInMillis() /
				(1000 * 60 * 5);

			String plaintext = "" + userId + time;

			String sha = Base64.encode(digest.digest(plaintext.getBytes()));

			sha = HttpUtil.encodeParameters(sha);

			return sha;

		}
		catch (NoSuchAlgorithmException e) {

			throw new SystemException(e);
		}
	}

}
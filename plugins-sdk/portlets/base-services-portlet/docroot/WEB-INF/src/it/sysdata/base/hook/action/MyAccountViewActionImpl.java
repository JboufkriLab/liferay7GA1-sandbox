package it.sysdata.base.hook.action;

import java.beans.Statement;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

/**
 * @author Brian Wing Shun Chan
 */
public class MyAccountViewActionImpl extends BaseStrutsPortletAction {

	@Override
	public String render(
		StrutsPortletAction originalStrutsPortletAction,
		PortletConfig portletConfig, RenderRequest renderRequest,
		RenderResponse renderResponse)
			throws Exception {

		Statement setter = new Statement(
			renderRequest, "setWindowState", new Object[]{
				WindowState.MAXIMIZED
			});

		setter.execute();

		return originalStrutsPortletAction.render(
			portletConfig, renderRequest,
			renderResponse);
	}
}
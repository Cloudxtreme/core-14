package com.dotmarketing.portlets.workflows.action;

import com.dotcms.repackage.javax.portlet.PortletConfig;
import com.dotcms.repackage.javax.portlet.RenderRequest;
import com.dotcms.repackage.javax.portlet.RenderResponse;
import com.dotmarketing.portal.struts.DotPortletAction;
import com.dotmarketing.util.Logger;
import javax.servlet.jsp.PageContext;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * @author David Torres
 * @version $Revision: 1.0 $ $Revision: 1.5 $
 * 
 */
public class ViewWorkflowTasksAction extends DotPortletAction {

	/*
	 * @see com.liferay.portal.struts.PortletAction#render(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm, com.dotcms.repackage.javax.portlet.PortletConfig,
	 *      com.dotcms.repackage.javax.portlet.RenderRequest, com.dotcms.repackage.javax.portlet.RenderResponse)
	 */
	public ActionForward render(ActionMapping mapping, ActionForm form, PortletConfig config, RenderRequest req,
			RenderResponse res) throws Exception {

		Logger.debug(this, "Running ViewWorkflowTasksAction!!!!=" + req.getWindowState());

		try {

			return mapping.findForward("portlet.ext.workflows.view_workflow_tasks");

		} catch (Exception e) {
			req.setAttribute(PageContext.EXCEPTION, e);
			return mapping.findForward(com.liferay.portal.util.Constants.COMMON_ERROR);
		}
	}



}
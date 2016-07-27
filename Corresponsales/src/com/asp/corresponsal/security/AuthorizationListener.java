package com.asp.corresponsal.security;

import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener, Serializable{
	private static final long serialVersionUID = 1L;
	public void afterPhase(PhaseEvent event) {

		FacesContext facesContext = event.getFacesContext();
		String currentPage = facesContext.getViewRoot().getViewId();

		boolean isLoginPage = (currentPage.indexOf("login.xhtml") > -1);
		boolean isLogoutPage = (currentPage.indexOf("logout.xhtml") > -1);
		boolean isValidPage = isLoginPage || isLogoutPage;
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);

		if (!isValidPage && session == null) {
			NavigationHandler nh = facesContext.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(facesContext, null, "loginPage");
		} else if (session != null){
			Object currentUser = session.getAttribute("username");
			if (!isValidPage && (currentUser == null || currentUser == "")) {
				NavigationHandler nh = facesContext.getApplication()
						.getNavigationHandler();
				nh.handleNavigation(facesContext, null, "loginPage");
			}
		}
	}

	public void beforePhase(PhaseEvent event) {

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
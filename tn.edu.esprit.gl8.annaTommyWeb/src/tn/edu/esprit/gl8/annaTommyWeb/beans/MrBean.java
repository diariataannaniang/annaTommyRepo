package tn.edu.esprit.gl8.annaTommyWeb.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.gl8.annaTommyEJB.domain.User;
import tn.edu.esprit.gl8.annaTommyEJB.services.interfaces.UserServicesLocal;

@ManagedBean(name = "beanbean")
@SessionScoped
public class MrBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// the model
	private User user = new User();

	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// the methods
	public String doAddUser() {
		userServicesLocal.addUser(user);
		return "";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

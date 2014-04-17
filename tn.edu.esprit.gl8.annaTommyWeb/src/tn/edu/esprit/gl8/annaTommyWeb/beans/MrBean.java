package tn.edu.esprit.gl8.annaTommyWeb.beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.gl8.annaTommyEJB.domain.Admin;
import tn.edu.esprit.gl8.annaTommyEJB.domain.Player;
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
	private Player player=new Player();
	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// the methods
	public String doAddUser() {
		userServicesLocal.addUser(player);
		return "";

	}

	public String doLogin() {
		User userFound = userServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userFound != null) {
			if (userFound instanceof Admin) {
				user = userFound;
				return "/pages/admin/admin.jsf";

			} else {
				user = userFound;
				return "/pages/player/room.jsf";
			}

		} else {
			return "error.jsf";
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}

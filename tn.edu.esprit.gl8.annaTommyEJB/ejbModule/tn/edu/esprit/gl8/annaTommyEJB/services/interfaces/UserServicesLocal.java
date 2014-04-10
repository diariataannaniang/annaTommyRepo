package tn.edu.esprit.gl8.annaTommyEJB.services.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.gl8.annaTommyEJB.domain.User;

@Local
public interface UserServicesLocal {
	boolean addUser(User user);

	User login(String login, String password);

}

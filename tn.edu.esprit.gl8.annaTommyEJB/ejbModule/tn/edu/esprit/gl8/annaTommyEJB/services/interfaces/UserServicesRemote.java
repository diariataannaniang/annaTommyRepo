package tn.edu.esprit.gl8.annaTommyEJB.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.annaTommyEJB.domain.User;

@Remote
public interface UserServicesRemote {
	boolean addUser(User user);

	User login(String login, String password);

}

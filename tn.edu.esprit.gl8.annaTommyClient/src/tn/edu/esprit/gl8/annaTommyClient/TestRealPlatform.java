package tn.edu.esprit.gl8.annaTommyClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tn.edu.esprit.gl8.annaTommyEJB.domain.Admin;
import tn.edu.esprit.gl8.annaTommyEJB.domain.Player;
import tn.edu.esprit.gl8.annaTommyEJB.services.interfaces.UserServicesRemote;

public class TestRealPlatform {

	private Context context;
	private UserServicesRemote userServicesRemote;

	@Before
	public void init() {
		try {
			context = new InitialContext();
			String jndiName = "ejb:tn.edu.esprit.gl8.annaTommy/tn.edu.esprit.gl8.annaTommyEJB/UserServices!"
					+ UserServicesRemote.class.getCanonicalName();
			userServicesRemote = (UserServicesRemote) context.lookup(jndiName);
		} catch (NamingException e) {
		}
	}

	@Test
	public void itShouldAddUser() {
		Admin admin = new Admin("kids");
		Admin admin2 = new Admin("adults");

		Player player = new Player(100);
		Player player2 = new Player(10);

		Assert.assertTrue(userServicesRemote.addUser(admin));
		Assert.assertTrue(userServicesRemote.addUser(admin2));
		Assert.assertTrue(userServicesRemote.addUser(player));
		Assert.assertTrue(userServicesRemote.addUser(player2));
	}

}

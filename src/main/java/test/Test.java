package test;

import java.util.ArrayList;
import java.util.List;

import sn.isi.dao.IRoles;
import sn.isi.dao.IUser;
import sn.isi.dao.RolesImpl;
import sn.isi.dao.UserImpl;
import sn.isi.entities.Roles;
import sn.isi.entities.User;

public class Test {
	
	public static void main(String[] args) {
		/*
		IRoles roledoa = new RolesImpl();
		
		Roles roles = new Roles();
		roles.setNom("ROLE_AMDIN");
		
		int result = roledoa.add(roles);
		System.out.println(result);*/
		
		
		IUser userdao = new UserImpl();
		User user = new User();
		user.setNom("Simbou");
		user.setPrenom("Ris");
		user.setEmail("ris@gmail.com");
		user.setPassword("passer123");
		user.setEtat(1);
		
		List<Roles> rolesL = new ArrayList<Roles>();
		IRoles roledoa = new RolesImpl();
		Roles role1 = roledoa.get(1);
		rolesL.add(role1);
		user.setRoles(rolesL);
		
		int result =  userdao.add(user);
		System.out.println(result);
		
	} 

}

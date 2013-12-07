package Profile;

import Server.ManageProfile;

public class TestProfile {
	public static void main (String[] args){
		ManageProfile mp = new ManageProfile();
		mp.init_list();
		mp.displayList();
		System.out.println("----------------------");
		mp.new_profile("toto", "pass");
		mp.displayList();
		System.out.println("----------------------");
		mp.delete_profile("toto", "pass");
		mp.displayList();
		System.out.println("----------------------");
		mp.edit_login_profile("SVera", "steph");
		mp.displayList();
		System.out.println("----------------------");
		mp.edit_pass_profile("steph", "pass", "123456");
		mp.displayList();
		System.out.println("----------------------");
		boolean b = mp.isValid(new Profile("steph", "123456"));
		System.out.println(b);
		
		/*String[] str = new String[3];
		str[0] = "login";
		str[1] = "password";
		str[2] = "state";
		Profile p = new Profile(str);
		System.out.println(p.getLogin());
		System.out.println(p.getPass());
		System.out.println(p.getStatut());*/
	}
}

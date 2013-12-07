package Server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Profile.Profile;

public class ManageProfile extends Profile {
	
	//Declarartion of the Profile list
	protected static ArrayList<Profile> m_ListProfile;
	//Path to the CVS file who store the profiles
	protected static String fileName="conf\\listProfile.csv";
	
	//Getter
	public static ArrayList<Profile> getListProfile(){
		return m_ListProfile;
	}
	
	//List initialization, retrieve and store in arraylist every user store in the CVS file
	public static void init_list(){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			m_ListProfile = new ArrayList<Profile>();
			String[] str = new String[3];
			StringTokenizer strToken = null;
			int lineNumber=0, tokenNumber=0;
			
			//For each line
			while((fileName = br.readLine()) != null){
				strToken = new StringTokenizer(fileName, ",");
				
				//Each line is divided using the comma separator and then each element is stored in a tab
				while(strToken.hasMoreTokens()){
					 tokenNumber++;
					 str[tokenNumber-1]=strToken.nextToken();
				}
				//Then it adds a new Profile, constructed by the tab, in the list 
				Profile p1 = new Profile(str);
				m_ListProfile.add(p1);
				tokenNumber = 0;
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//Create a new profile and add it in the database
	public static void new_profile(String login, String pass){
		m_ListProfile.add(new Profile(login, pass));
	}
	
	//Delete a profile
	public static void delete_profile(String login, String pass){
		int index =0;
		index=returnIndex(login); //find the index related to the login
		if(m_ListProfile.get(index).getPass().equals(pass)){ // if the pass of the present login is good the user is deleted
			m_ListProfile.remove(returnIndex(login));
		}
	}
	
	//Change a profile name
	public static void edit_login_profile(String oldLogin, String newLogin){
		int index =0;
		System.out.println(oldLogin);
		index=returnIndex(oldLogin);//find the index related to the login
		m_ListProfile.get(index).setLogin(newLogin);
	}
	
	public static void edit_pass_profile(String login, String oldPass, String newPass){
		int index =0;
		index=returnIndex(login);//find the index related to the login
		if(m_ListProfile.get(index).getPass().equals(oldPass)){// if the oldpass equals to the stored pass
			m_ListProfile.get(index).setPass(newPass); // set the new pass
		}
	}
	
	public static int returnIndex (String login){
		int index = 0;
		
		for(int i=0;i<m_ListProfile.size();i++){
			System.out.println("Obtenu :"+m_ListProfile.get(i).getLogin()+" Attendu:"+login);
			if(m_ListProfile.get(i).getLogin().equals(login)){
				index=i;
				break;
			}else{
				index=-1;
			}
		}
		return index; // return -1 if the login is not found
	}
	
	public static void displayList (){
		for(int i =0;i<m_ListProfile.size();i++){
			System.out.println(returnIndex(m_ListProfile.get(i).getLogin())+">"+m_ListProfile.get(i).getLogin()+"-"+m_ListProfile.get(i).getPass());
		}
	}
	
	// test if both login and password is equals to the real one in the arraylist
	public static boolean isValid(Profile p){
		boolean isValid;
		int index=0;
		System.out.println("ManageProfile.isValid p.getLogin="+p.getLogin());
		index=returnIndex(p.getLogin());
		System.out.println(index);
		if(index !=-1){
			if(m_ListProfile.get(index).getPass().equals(p.getPass())){
				System.out.println("pouet 1");
				isValid=true;
			}else{
				isValid=false;
				System.out.println("pouet 2");
			}
		}else{
			isValid=false;
			System.out.println("pouet 3");
		}
		return isValid;
	}
	
	
}

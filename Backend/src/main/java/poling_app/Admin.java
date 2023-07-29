package poling_app;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Admin {
	@Id
	private String email;
	private String password;
	//private ArrayList<String> mypoles=new ArrayList<>();
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public ArrayList<String> getMypoles() {
//		return mypoles;
//	}
//	public void setMypoles(ArrayList<String> mypoles) {
//		this.mypoles = mypoles;
//	}
//	
	
}

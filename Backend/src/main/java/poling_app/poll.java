package poling_app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class poll {
	@Id
	private String name;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	private String adminname;
	private ArrayList<String> candidates;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCandidates() {
		return candidates;
	}
	public void setCandidates(ArrayList<String> candidates) {
		this.candidates = candidates;
	}
	
}

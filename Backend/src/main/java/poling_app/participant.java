package poling_app;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class participant {
	@Id
	public String name;
	public String election;
	public int votes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElection() {
		return election;
	}
	public void setElection(String election) {
		this.election = election;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	

}

package poling_app;

import javax.persistence.Embeddable;


public class man {
		private String Name;
		private int votes;
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getVotes() {
			return votes;
		}
		public void setVotes(int votes) {
			this.votes = votes;
		}
		
}

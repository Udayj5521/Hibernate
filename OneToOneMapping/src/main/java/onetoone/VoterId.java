package onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VoterId {
	@Id
	private int vid;
	private String address;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}

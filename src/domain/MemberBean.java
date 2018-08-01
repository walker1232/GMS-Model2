package domain;

import lombok.Data;

@Data
public class MemberBean {
	public String memID, teamID, name, ssn, age ,roll, password, subject, gender;


	@Override
	public String toString() {
		return "MemberBean [memID=" + memID + ", teamID=" + teamID + ", name=" + name + ", ssn=" + ssn + ", age=" + age
				+ ", roll=" + roll + ", gender=" + gender + ", password=" + password + "]";
	}

	

	

	

	

	

	
	
}

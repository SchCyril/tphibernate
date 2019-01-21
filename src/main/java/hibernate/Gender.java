package hibernate;

public enum Gender {
	M("Male"), F("FEMALE");

	private String gender;

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

package hibernate;

public enum Gender {
	M("Male"), F("FEMALE");

	private String genderType;

	private Gender(String gender) {
		this.genderType = gender;
	}

	public String getGender() {
		return genderType;
	}

	public void setGender(String gender) {
		this.genderType = gender;
	}

}

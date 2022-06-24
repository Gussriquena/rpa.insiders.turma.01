package people.registry.model;

public class Person {

	private String fullName;
	private String email;
	private String gender;
	private String address;
	private String country;
	private String uf;
	private String city;
	private String zipCode;
	private String status;
	private String statusMessage;
	
	public Person() {
		
	}
	
	public Person(String fullName, String email, String gender, String address, String country, String uf, String city,
			String zipCode, String status, String statusMessage) {
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.country = country;
		this.uf = uf;
		this.city = city;
		this.zipCode = zipCode;
		this.status = status;
		this.statusMessage = statusMessage;
	}
	
	
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return " { \"fullName\": \"" + fullName 
				+ "\", \"email\": \"" + email 
				+ "\", \"gender\": \"" + gender 
				+ "\", \"address\": \"" + address
				+ "\", \"country\": \"" + country 
				+ "\", \"uf\": \"" + uf 
				+ "\", \"city\": \"" + city 
				+ "\", \"zipCode\": \"" + zipCode 
				+ "\", \"status\": \"" + status 
				+ "\", \"statusMessage\": \"" + statusMessage
				+ "\"}, ";
	}
	 
}

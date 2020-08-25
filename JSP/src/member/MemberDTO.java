package member;

import java.util.Arrays;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String birthday;
	private String email;
	private String zipcode;
	private String address;
	private String[] hobby;
	private String job;
	private String newhobby;		// String[] hobby -> String
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHobby(String[] hobby) {
		String str = "";
		for (int i = 0; i < hobby.length; i++) {
			str += hobby[i] + ",";
		}
		this.newhobby = str;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getNewhobby() {
		return newhobby;
	}
	public void setNewhobby(String newhobby) {
		this.newhobby = newhobby;
	}
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birthday="
				+ birthday + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address + ", hobby="
				+ Arrays.toString(hobby) + ", job=" + job + ", newhobby=" + newhobby + "]";
	}
}

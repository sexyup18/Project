package vo;

import org.springframework.web.multipart.MultipartFile;

public class BasicVO {
	private int studentId;
	private String name;
	private String password;
	private String acaYear;
	private int birth;
	private int regNum;
	private String gender;
	private String email;
	private String nation;
	private String address;
	private int phone;
	private String image;
	private MultipartFile imagef;
	private String mainMajor;
	private String doubleMajor;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAcaYear() {
		return acaYear;
	}
	public void setAcaYear(String acaYear) {
		this.acaYear = acaYear;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getRegNum() {
		return regNum;
	}
	public void setRegNum(int regNum) {
		this.regNum = regNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImagef() {
		return imagef;
	}
	public void setImagef(MultipartFile imagef) {
		this.imagef = imagef;
	}
	public String getMainMajor() {
		return mainMajor;
	}
	public void setMainMajor(String mainMajor) {
		this.mainMajor = mainMajor;
	}
	public String getDoubleMajor() {
		return doubleMajor;
	}
	public void setDoubleMajor(String doubleMajor) {
		this.doubleMajor = doubleMajor;
	}
	
	@Override
	public String toString() {
		return "BasicVO [studentId=" + studentId + ", name=" + name + ", password=" + password + ", acaYear=" + acaYear
				+ ", birth=" + birth + ", regNum=" + regNum + ", gender=" + gender + ", email=" + email + ", nation="
				+ nation + ", address=" + address + ", phone=" + phone + ", image=" + image + ", imagef=" + imagef
				+ ", mainMajor=" + mainMajor + ", doubleMajor=" + doubleMajor + "]";
	}
	
}//BasicVO

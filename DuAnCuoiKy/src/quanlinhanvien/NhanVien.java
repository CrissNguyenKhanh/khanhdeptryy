package quanlinhanvien;

import java.util.Date;

public class NhanVien {
public String usernmae , password , name ,gioitinh , phonenumber , email,addres;
public Date dob;
public NhanVien(String usernmae, String password, String name,Date dob, String gioitinh, String phonenumber, String email,
		String addres) {
	super();
	this.usernmae = usernmae;
	this.password = password;
	this.name = name;
	this.gioitinh = gioitinh;
	this.phonenumber = phonenumber;
	this.email = email;
	this.addres = addres;
	this.dob = dob;
}
public String getUsernmae() {
	return usernmae;
}
public void setUsernmae(String usernmae) {
	this.usernmae = usernmae;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGioitinh() {
	return gioitinh;
}
public void setGioitinh(String gioitinh) {
	this.gioitinh = gioitinh;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddres() {
	return addres;
}
public void setAddres(String addres) {
	this.addres = addres;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
	
	
	
}

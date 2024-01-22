package quanlidouong;

public class douong {
public String nuoc;
public double giatien , thanhtien;
public int soluong;
public douong(String nuoc, double giatien, int soluong, double thanhtien) {
	super();
	this.nuoc = nuoc;
	this.giatien = giatien;
	this.soluong = soluong;
	this.thanhtien = thanhtien;
}
public String getNuoc() {
	return nuoc;
}
public void setNuoc(String nuoc) {
	this.nuoc = nuoc;
}
public double getGiatien() {
	return giatien;
}
public void setGiatien(double giatien) {
	this.giatien = giatien;
}
public double getThanhtien() {
	return thanhtien;
}
public void setThanhtien(double thanhtien) {
	this.thanhtien = thanhtien;
}
public int getSoluong() {
	return soluong;
}
public void setSoluong(int soluong) {
	this.soluong = soluong;
}


}

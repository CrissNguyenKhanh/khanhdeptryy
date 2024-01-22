package daoquanlithucan;

public class loaicafe {
public loaicafe(String id, String name, String kind, float money, String size) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.size = size;
		this.money = money;
	}
public String id;
private String name;
private String kind;
private String size;
private float money;
public loaicafe() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public float getMoney() {
	return money;
}
public void setMoney(float money) {
	this.money = money;
}

}

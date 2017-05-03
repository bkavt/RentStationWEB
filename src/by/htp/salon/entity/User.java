package by.htp.salon.entity;

public class User {
 private String login;
 private String password;
 private boolean role;
public boolean isRole() {
	return role;
}
public void setRole(boolean role) {
	this.role = role;
}
public User(String login, String password, boolean role) {
	super();
	this.login = login;
	this.password = password;
	this.role = role;
}
public User(String login, String password) {
	super();
	this.login = login;
	this.password = password;
}
public User() {
	super();
	
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 
 
}

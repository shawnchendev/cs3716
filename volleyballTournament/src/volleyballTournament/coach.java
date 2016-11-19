package volleyballTournament;

public class coach {
private String name;
private String phone;
private String email;
private team team;
public String getName() {
	return name;
}
public coach(String name, String phone, String email, volleyballTournament.team team) {
	super();
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.team = team;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public team getTeam() {
	return team;
}
public void setTeam(team team) {
	this.team = team;
}
}

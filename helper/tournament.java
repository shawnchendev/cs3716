package volleyballTournament;

import java.util.ArrayList;
import java.util.Date;

public class tournament {
private tournamentType type;
private String location;
private Date deadline;
private ArrayList<team> teams = new ArrayList<team>();

public tournament(tournamentType type, String location, Date deadline, ArrayList<team> teams) {
	super();
	this.type = type;
	this.location = location;
	this.deadline = deadline;
	this.teams = teams;
}

public tournamentType getType() {
	return type;
}
public void setType(tournamentType type) {
	this.type = type;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getDeadline() {
	return deadline;
}
public void setDeadline(Date deadline) {
	this.deadline = deadline;
}
public ArrayList<team> getTeams() {
	return teams;
}
public void setTeams(ArrayList<team> teams) {
	this.teams = teams;
} 
//Change publish for whatever the system needs
public void publishDeadline(){
	System.out.println("deadline" + deadline);
}

public void register(team x){
	this.teams.add(x);
}
}
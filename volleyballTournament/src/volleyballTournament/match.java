package volleyballTournament;

import java.util.Date;

public class match {
private team A;
private team B;
private int scoreA;
private int scoreB;
private Date date;
private String location;

public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public match(team a, team b, Date date, String location) {
	super();
	A = a;
	B = b;
	this.date = date;
	this.location = location;
}
public match(team a, team b) { //temp constructor for schedule class
	super();
	A = a;
	B = b;
	
}
public team getA() {
	return A;
}
public void setA(team a) {
	A = a;
}
public team getB() {
	return B;
}
public void setB(team b) {
	B = b;
}
public int getScoreA() {
	return scoreA;
}
public void setScoreA(int scoreA) {
	this.scoreA = scoreA;
}
public int getScoreB() {
	return scoreB;
}
public void setScoreB(int scoreB) {
	this.scoreB = scoreB;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String publishResult(){
	return A.getTeamName()+ ":" +scoreA + B.getTeamName()+ ":" + scoreB ;
}
}

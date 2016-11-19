package volleyballTournament;

import java.util.ArrayList;

public class team {
private String teamName;
private coach coach;
private ArrayList<player> players  = new ArrayList<player>();
private String stats;
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public coach getCoach() {
	return coach;
}
public void setCoach(coach coach) {
	this.coach = coach;
}
public ArrayList<player> getPlayers() {
	return players;
}
public void setPlayers(ArrayList<player> players) {
	this.players = players;
}
public String getStats() {
	return stats;
}
public void setStats(String stats) {
	this.stats = stats;
}
public team(String teamName, volleyballTournament.coach coach, ArrayList<player> players, String stats) {
	super();
	this.teamName = teamName;
	this.coach = coach;
	this.players = players;
	this.stats = stats;
}
public void addPlayer(player p){
	this.players.add(p);
}
}

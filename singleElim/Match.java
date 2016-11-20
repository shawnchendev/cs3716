package cs3716;

public class Match{
	team team1,team2;
	int score1,score2;
	team winner;
	//sets a winner if the other team is null
	public Match(team team,team team3){
		if(team == null) winner = team3;
		if(team3 == null) winner = team;
		
		team1=team;
		team2=team3;
	}
	public team getTeam1(){
		return team1;
	}
	public team getTeam2(){
		return team2;
	}
	public void setTeam1(team t1){
		team1 = t1;
	}
	public void setTeam2(team t2){
		team2 = t2;
	}
	public void setScore1(int s1){
		score1=s1;
	}
	public void setScore2(int s2){
		score2=s2;
	}
	public int getScore1(){
		return score1;
	}
	public int getScore2(){
		return score2;
	}
	//sets a winner based on scores if there isn't one set already
	public team getWinner(){
		if(winner != null){
			return winner;
		}
		else {
			if(score1>score2){
				winner = team1;
				return winner;
			}
			else {
				winner = team2;
				return winner;
			}
		}
	}

}

package volleyballTournament;

import java.util.ArrayList;

public class schedule {
ArrayList <match> current = new ArrayList<match>();
ArrayList <match> previous = new ArrayList<match>();
public void addMatch(team a, team b){
	match x = new match(a,b);
	current.add(x);
}
}

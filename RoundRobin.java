import java.util.LinkedList;
import java.util.Queue;


public class RoundRobin {
	static int[][] matchTracker;
	
	public static void main(String[]args){
		//Step 1: Create a collection of teams
		int teamQuantity = 4;
		//Step 2: Create a team stat tracker array
		matchTracker = new int[teamQuantity-1][teamQuantity-1];
		//Step 3: create a queue of teams that aren't playing
		Queue<Integer> idleTeams = new LinkedList<Integer>();
		for(int i = 0;i<teamQuantity;i++){
			idleTeams.add(i);
		}
		//Step 4: Create a linkedlist to contain all the created match objects
		LinkedList<Match> matches = new LinkedList<Match>();
		//Step 5: Create match objects from the idleTeams Queue
		while(idleTeams.size()>1){
			//Change team ints to team objects during the switch!
			int t1=idleTeams.remove();
			int t2=idleTeams.remove();
			Match m=matchTeam(t1,t2);
			matches.add(m);
		}
		
		//Play matches---------------------------------------------
		//Create a linkedlist to contain ongoing matches
		LinkedList<Match> currentMatches = new LinkedList<Match>();
		LinkedList<Match> oldMatches = new LinkedList<Match>();
		
		System.out.println("Old Matches");
		printList(oldMatches);
		
		System.out.println("New Matches");
		printList(matches);
		
		System.out.println("Current Matches");
		printList(currentMatches);
		
		System.out.println("----------------");
		
		playMatch(matches,currentMatches);
		
		System.out.println("Old Matches");
		printList(oldMatches);
		
		System.out.println("New Matches");
		printList(matches);
		
		System.out.println("Current Matches");
		printList(currentMatches);
		
		
		endMatch(oldMatches,currentMatches,0);
		
		System.out.println("----------------");
		
		playMatch(matches,currentMatches);
		
		System.out.println("Old Matches");
		printList(oldMatches);
		
		System.out.println("New Matches");
		printList(matches);
		
		System.out.println("Current Matches");
		printList(currentMatches);
	}
	public static void printList(LinkedList<Match> mat){
		if(mat.size()==0){
			System.out.println("NO MATCHES");
		}
		else{
			for(int i=0;i<mat.size();i++){
				Match m = mat.get(i);
				int t1 = m.getTeam1();
				int t2 = m.getTeam2();
				System.out.println("Match "+i+": "+t1+" "+t2);
			}
		}
	}
	public void queueTeams(Queue<Integer> tq,int[][] mt){
		
	}
	public static void playMatch(LinkedList<Match> mat,LinkedList<Match> currMat){
		currMat.add(mat.remove());
	}
	public static void endMatch(LinkedList<Match> oldMat,LinkedList<Match> currMat,int i){
		oldMat.add(currMat.remove(i));
	}
	
	public static Match matchTeam(int team1,int team2){
		Match m = new Match(team1,team2);
		return m;
	}
}
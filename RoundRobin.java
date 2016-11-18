import java.util.Arrays;
import java.lang.Math.*;
import java.util.LinkedList;
import java.util.Queue;
/*
 * Step 1: Create a collection of teams
 * Step 2: Create a team stat tracker array
 * Step 3: Create a queue of teams that aren't playing 
 * Step 4: Create a linkedlist to contain all the created match objects
 * Step 5: Create match objects from the idleTeams Queue
 * Step 6: Put teams that have just finished a match back into the idle teams queue
 * Step 6a: Ensure that teams aren't matched up again immediately
 * Step 6b: Put the scores of finished matches into stat tracker 
 * Step 7: Continue matchplay by pairing teams up into new matches 
*/
public class RoundRobin {
	//This is all temporarily static. 
	static int[][] matchTracker;
	static LinkedList<Match> currentMatches = new LinkedList<Match>();
	static LinkedList<Match> oldMatches = new LinkedList<Match>();
	static LinkedList<Match> matches = new LinkedList<Match>();
	static int teamQuantity;
	static LinkedList<Integer> idleTeams = new LinkedList<Integer>();
	
	public static void main(String[]args){
		teamQuantity = 10;
		matchTracker = new int[teamQuantity][teamQuantity];
		for(int i = 0;i<teamQuantity;i++){
			idleTeams.add(i);
		}
		for(int i=0;i<teamQuantity;i++){
			Arrays.fill(matchTracker[i], -1);
			matchTracker[i][i]=0;
		}
		//printMatchTracker();
		printIdleTeamList();
		checkMatchup();
		//printMatchTracker();
		printIdleTeamList();
		playMatch(matches,currentMatches);
		endMatch(oldMatches,currentMatches,0);
		playMatch(matches,currentMatches);
		printIdleTeamList();
		//printMatchTracker();
		
	}
	public static void printIdleTeamList(){
		System.out.println("IDLE TEAM LIST-------");
		for(int i=0;i<idleTeams.size();i++){
			System.out.print(idleTeams.get(i)+" ");
		}
		System.out.println("");
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
	public static void printMatchTracker(){
		for(int j=0;j<teamQuantity;j++){
			for(int i=0;i<teamQuantity;i++){
				System.out.print(matchTracker[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void queueTeams(Queue<Integer> tq,int[][] mt){
		
	}
	public static void playMatch(LinkedList<Match> mat,LinkedList<Match> currMat){
		if(mat.size()>0){
			currMat.add(mat.remove());
		}
	}
	public static void endMatch(LinkedList<Match> oldMat,LinkedList<Match> currMat,int i){
		//Ask for the scores here? Or have it added elsewhere and have it stored in object for 
		//future use?
		if(currMat.size()>0){
			Match finishedMat = currMat.remove(i);
			oldMat.add(finishedMat);
			int t1ID = finishedMat.getTeam1();
			int t2ID = finishedMat.getTeam2();
			int score1 = finishedMat.getScore1();
			int score2 = finishedMat.getScore2();
			matchTracker[t1ID][t2ID]=score1;
			matchTracker[t2ID][t1ID]=score2;

//			double halfwayPt = Math.floor((idleTeams.size()-1)/2);//Use this for inserting idle teams
				if(t1ID>t2ID){
					idleTeams.offerFirst(t1ID);//Change this in the future. 
					idleTeams.offerLast(t2ID);
				}
				else{
					idleTeams.offerFirst(t2ID);//Change this in the future. 
					idleTeams.offerLast(t1ID);					
				}
		}
	}
	public static Match matchTeam(int team1,int team2){
		Match m = new Match(team1,team2);
		return m;
	}
	public static void testMatchPlay(){
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
	public static void matchup(){
		int t1ID=idleTeams.get(0);
		int t2ID=idleTeams.get(1);
		if(matchTracker[t1ID][t2ID]>=0 && matchTracker[t2ID][t1ID]>=0){
			Match m=matchTeam(t1ID,t2ID);
			idleTeams.pop();
			idleTeams.pop();
			matches.add(m);	
		}
	}
	public static void checkMatchup(){
		
		for(int i=0;i<idleTeams.size();i++){
			int t1ID=idleTeams.get(i);
			for(int j=i;j<idleTeams.size();j++){
				int t2ID=idleTeams.get(j);
				if(matchTracker[t1ID][t2ID] == -1 || matchTracker[t2ID][t1ID] == -1){
					if(j==idleTeams.size()-1){
						i=i-1;
					}
					matchTracker[t1ID][t2ID]=0;
					matchTracker[t2ID][t1ID]=0;
					matchup();
				}
			}
		}
	}
}
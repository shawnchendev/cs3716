package cs3716;

import java.util.ArrayList;
import java.util.Collections;

public class brackets {
	private treeS schedule;
	private static ArrayList<team> teams = new ArrayList<team>();
	private static int t = 0;
	
	public treeS seed(ArrayList<team> t){
		int n = 0;
		while (Math.pow(2, n)<t.size()){
			n++;	
		}
		while (Math.pow(2, n)<t.size()){
			t.add(null);
		}
		Collections.shuffle(t);
		int depth = (int) (Math.floor((Math.log(t.size()))/ (Math.log(2))));
		schedule = createTree(depth);
		return schedule;
	}
	
	public static treeS createTree (int depth){
		//if depth is negative, stop
		if (depth < 0) return null;
		//create a node in the current position
		treeS current = new treeS();
		//if the depth is 0, then it's a leave where a team needs to be placed
		//from the array of teams with t to iterate through it
		if( depth == 0){
			current.data = teams.get(t);
			System.out.println(current.data.getName());
			t++;
			return current;
		}
		//if not, then continue expanding the tree
		if(depth > 0){
			current.left = createTree(depth-1);
			current.right = createTree(depth-1);
		}
		//create a match with the leaves
		Match game = new Match(current.left.data,current.right.data);
		//creates the match and sends it to the schedule class, one at a time
		//not implemented yet
		scheduleItem.send(game);
		//the data of the current node is the winner of the match
		current.data = game.getWinner();
		
		return current;
	}
	
	
}

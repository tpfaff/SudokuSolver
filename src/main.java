import java.util.ArrayList;
import java.util.Collections;


public class main {
static long startTime=0,endTime=0,totalTime=0;
	public static void main(String[] args) {
		ArrayList<Integer> initialSet=new ArrayList<Integer>();
		Collections.addAll(initialSet,
				 2,0,0,0,5,7,3,8,9,
				 0,3,0,8,9,1,0,0,0,
				 7,0,9,0,0,3,0,1,6,
				 0,7,3,0,8,9,2,6,0,
				 0,0,2,5,0,6,0,0,0,
				 0,9,0,3,0,4,0,5,7,
				 0,5,0,9,0,8,0,2,0,
				 9,2,8,7,0,5,6,0,0,
				 0,0,0,0,3,0,0,0,0
				///easy puzzle
				/*0,9,0,6,0,1,0,0,0,
				0,0,0,0,3,0,9,0,1,
				0,3,0,2,0,8,0,0,0,
				7,0,9,0,0,0,0,0,4,
				0,4,0,3,0,7,0,9,0,
				8,0,3,0,1,0,5,0,7,
				0,5,0,7,0,2,4,1,9,
				9,0,4,0,5,0,7,0,6,
				0,1,0,9,0,6,0,5,8*/
				//medium puzzle
				
				/*0,0,0,8,0,1,0,0,3,
				0,0,9,0,0,0,2,1,0,
				5,0,0,0,0,3,8,0,0,
				0,7,3,1,0,0,5,8,0,
				1,0,0,0,0,0,0,0,6,
				0,9,5,0,0,7,1,3,0,
				0,0,7,9,0,0,0,0,5,
				0,1,6,0,0,0,7,0,0,
				2,0,0,7,0,6,0,0,0
				 */
				///extreme puzzle
				
			/*	0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,5,2,3,
				0,0,0,0,0,0,0,1,8,
				0,0,0,0,0,0,0,0,0,
				0,0,9,0,7,4,0,6,0,
				0,0,4,6,1,0,0,0,7,
				0,5,8,0,4,3,0,0,0,
				0,4,0,0,2,0,0,3,0,
				0,6,7,0,8,1,0,9,4*/
				//Evil puzzle
				
				); //-1 represents an empty cell. addall fills the arrraylist with the board values
			GameBoard gb=new GameBoard(initialSet);
			AI intelligence=new AI(gb.getBoard());
			intelligence.findInvalidMoves();
			System.out.println("Thinking...");
			startTime=System.currentTimeMillis();
			if(intelligence.run()){
				endTime=System.currentTimeMillis();
				totalTime=endTime-startTime;
				System.out.println("Solved in " +totalTime+ "ms");
				gb.printBoard();
			}else{
				endTime=System.currentTimeMillis();
				totalTime=endTime-startTime;
				System.out.println("No Solutions!" +" Thought for "+totalTime+" ms");
			}

	}

}
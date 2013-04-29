import java.util.ArrayList;
import java.util.Collections;


public class main {

	public static void main(String[] args) {
		ArrayList<Integer> initialSet=new ArrayList<Integer>();
		Collections.addAll(initialSet,
				3,0,8,0,0,0,2,0,0,
				0,4,0,2,0,0,0,0,0,
				7,0,0,0,6,8,0,0,0,
				0,6,0,0,0,1,0,3,5,
				9,0,0,4,0,6,0,0,2,
				1,7,0,9,0,0,0,4,0,
				0,0,0,8,5,0,0,0,3,
				0,0,0,0,0,2,0,6,0,
				0,0,5,0,0,0,4,0,7
				); //-1 represents an empty cell. addall fills the arrraylist with the board values
			GameBoard gb=new GameBoard(initialSet);
			AI intelligence=new AI(gb.getBoard());
			intelligence.findInvalidMoves();
			if(intelligence.run()){
			System.out.println("Solved!");
			gb.printBoard();
			}else{
				System.out.println("No Solutions!");
			}
	}

}
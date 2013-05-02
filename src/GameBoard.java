import java.util.ArrayList;

public class GameBoard {
	Cell Board[][] = new Cell[9][9];

	public GameBoard(ArrayList<Integer> initialSet) {
		if (initialSet.size() != 81) {
			System.out.println("Invalid data set");
		} else {

			int listIndex = 0;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					int what = initialSet.get(listIndex);
					Board[i][j] = new Cell();
					Board[i][j].setValue(initialSet.get(listIndex));
					Board[i][j].setCoordinates(i,j);
					listIndex++;
				}

			}

		}
		printBoard();
	}

	public void printBoard() {
		for (int i = 0; i < 9; i++) {
			if (i == 3 || i == 6 || i == 9) {
				System.out.println("- - - - - - - - - - - - - - - - - - -");
			}
			for (int j = 0; j < 9; j++) {

				if (j == 2 || j == 5 || j == 8) {
					System.out.print(Board[i][j].getValue() + " || ");
				} else {
					System.out.print(Board[i][j].getValue() + " | ");
				}
			}
			System.out.println();
		}
	}

	public Cell[][] getBoard() {
		return Board;
	}

	public boolean solved() {

		boolean solved = true;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Board[i][j].getValue() == 0) {
					solved = false;
				}
			}
		}
		return solved;
	}

}

import java.util.ArrayList;

public class AI {

	Cell[][] Board = new Cell[9][9];

	public AI(Cell Board[][]) {
		this.Board = Board;
	}

	public void findInvalidMoves() {

		for (int i = 0; i < 9; i++) { //for each row
			for (int j = 0; j < 9; j++) { //for each column
				ArrayList<Integer> invalidMoves = new ArrayList<Integer>();
				Cell c = Board[i][j];
				final int row = i;
				final int column = j;
				for (int k = 0; k < 9; k++) { // for all the values in the same
												// row
					int val = Board[row][k].getValue();
					if (val != 0 && !invalidMoves.contains(val)) {
						invalidMoves.add(val);
					}
				}
				for (int m = 0; m < 9; m++) { // for all the values in the same
												// column
					int val = Board[m][column].getValue();
					if (val != 0 && !invalidMoves.contains(val)) { // if the
																	// value
																	// hasnt
																	// already
																	// been
																	// added to
																	// the list
																	// of bad
																	// moves
						invalidMoves.add(val);
					}
				}

				checkSubGrid(row, column, invalidMoves);
				c.setInvalidOptions(invalidMoves);
			}
		}

	}

	public void checkSubGrid(int row, int column,
			ArrayList<Integer> invalidMoves) {
		if (row <= 2 && column <= 2) // top left corner
		{
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row <= 5 && row > 2 && column <= 2) // middle left
		{
			for (int i = 3; i <= 5; i++) {
				for (int j = 0; j <= 2; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row > 5 && column <= 2) // bottom left corner
		{
			for (int i = 6; i <= 8; i++) {
				for (int j = 0; j <= 2; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (column > 2 && column <= 5 && row <= 2) // top center
		{
			for (int i = 0; i <= 2; i++) {
				for (int j = 3; j <= 5; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row > 2 && row <= 5 && column > 2 && column <= 5) // center
		{
			for (int i = 3; i <= 5; i++) {
				for (int j = 3; j <= 5; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row > 5 && column > 2 && column <= 5) // bottom center
		{
			for (int i = 6; i <= 8; i++) {
				for (int j = 3; j <= 5; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row <= 2 && column > 5) // top right corner
		{
			for (int i = 0; i <= 2; i++) {
				for (int j = 6; j <= 8; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row >= 3 && row <= 5 && column > 5) // right center
		{
			for (int i = 3; i <= 5; i++) {
				for (int j = 6; j <= 8; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}

		if (row > 5 && column > 5) // bottom right
		{
			for (int i = 6; i <= 8; i++) {
				for (int j = 6; j <= 8; j++) {
					Cell c = Board[i][j];
					if (!invalidMoves.contains(c.getValue())
							&& c.getValue() != 0) {
						invalidMoves.add(c.getValue());
					}
				}
			}
		}
	}

	public boolean run() {
		boolean done = true;
		for (int i = 0; i <= 8; i++) {
			for (int j = 0; j <= 8; j++) {
				Cell c = Board[i][j];
				if (c.getValue() == 0) {
					done = false;
					ArrayList<Integer> invalidMoves = c.getInvalidOptions();
					if (invalidMoves.contains(1) && invalidMoves.contains(2)
							&& invalidMoves.contains(3)
							&& invalidMoves.contains(4)
							&& invalidMoves.contains(5)
							&& invalidMoves.contains(6)
							&& invalidMoves.contains(7)
							&& invalidMoves.contains(8)
							&& invalidMoves.contains(9)) {
						return false;
					}
					for (int k = 1; k <= 9; k++) {
						if (!invalidMoves.contains(k)) {// if this isnt an
														// invalid move at this
														// cell, try it
							c.setValue(k);
							Board[i][j] = c;
							findInvalidMoves();
							if (run() == true) {
								return true;
							} else {
								c.setValue(0); // reset the value to try a new
												// one
							}

						}
					}
				}
			}
		}
		return done;
	}

	public void printBoard() {
		System.out.println();
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

}

import java.util.ArrayList;



public class Cell {
	private int row,column;
	private int value;
	private ArrayList<Integer> invalidOptions=new ArrayList<Integer>();
	
	
	public Cell(int row,int column, int value)
	{
		this.row=row;
		this.column=column;
		this.value=value;
		
	}
	
	public Cell() {
		// TODO Auto-generated constructor stub
	}
	public int getValue(){
		return value;
	}
	public void setValue(int value){
		this.value=value;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column; //e
	}
	public void setCoordinates(int row,int column){
		this.row=row;
		this.column=column;
	}
	public void setInvalidOptions(ArrayList<Integer> invalidOptions){
			this.invalidOptions=invalidOptions;

	}
	public ArrayList<Integer> getInvalidOptions(){
		return invalidOptions;
	}
	}


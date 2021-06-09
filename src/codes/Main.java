package codes;

public class Main
{
	public static void main(String[] args) 
	{
		ChessBoard grid = new ChessBoard(5);
		
		//grid.display();
		grid.setPaths();
		
		grid.moveKnight(1, grid.getFirst());
	}
}

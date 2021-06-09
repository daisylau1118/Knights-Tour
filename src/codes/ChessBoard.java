package codes;

public class ChessBoard 
{
	private Node first;
	private int dimension;
	public int solution;
	public int counter = 1;
	
	public ChessBoard (int dimension)
	{
		this.dimension = dimension;
		
		Node temp = new Node(0);
		first = temp;
		first.setUp(null);
		first.setLeft(null);
		
		Node columnMarker = first;
		Node rowMarker = first;
		
		for(int x = 0; x < dimension-1; x++)
		{
			temp = new Node(0);
			temp.setLeft(columnMarker);
			temp.setUp(null);
			columnMarker.setRight(temp);
			columnMarker = temp;
		}
		
		for(int y = 0; y < dimension-1; y++)
		{
			temp = new Node(0);
			columnMarker = temp;
			temp.setUp(rowMarker);
			temp.setLeft(null);
			rowMarker.setDown(temp);
			
			for(int x = 0; x<dimension-1; x++)
			{
				temp = new Node(0);
				temp.setLeft(columnMarker);
				columnMarker.setRight(temp);
				columnMarker.getUp().getRight().setDown(temp);
				temp.setUp(columnMarker.getUp().getRight());
				columnMarker = temp;
			}
			
			rowMarker = rowMarker.getDown();
		}
	}
	
	public void setPaths()
	{
		Node temp = first;
		Node rowMarker = first;
		
		while (temp!= null)
		{
			while (temp != null)
			{				
				if (temp.getUp() != null)
					if (temp.getUp().getUp() != null)
						if (temp.getUp().getUp().getRight() != null)
						{
							//System.out.println("path1");
							temp.setPath1(temp.getUp().getUp().getRight());
						}
				
				if (temp.getRight() != null)
					if (temp.getRight().getRight() != null)
						if (temp.getRight().getRight().getUp() != null)
						{
							//System.out.println("path2");
							temp.setPath2(temp.getRight().getRight().getUp());
						}
				
				if (temp.getRight() != null)
					if (temp.getRight().getRight() != null)
						if (temp.getRight().getRight().getDown() != null)
						{
							//System.out.println("path3");
							temp.setPath3(temp.getRight().getRight().getDown());
						}
				
				if (temp.getDown() != null)
					if (temp.getDown().getDown() != null)
						if (temp.getDown().getDown().getRight() != null)
						{
							//System.out.println("path4");
							temp.setPath4(temp.getDown().getDown().getRight());
						}
				
				if (temp.getDown() != null)
					if (temp.getDown().getDown() != null)
						if (temp.getDown().getDown().getLeft() != null)
						{
							//System.out.println("path5");
							temp.setPath5(temp.getDown().getDown().getLeft());
						}
				
				if (temp.getLeft() != null)
					if (temp.getLeft().getLeft() != null)
						if (temp.getLeft().getLeft().getDown() != null)
						{
							//System.out.println("path6");
							temp.setPath6(temp.getLeft().getLeft().getDown());
						}
				
				if (temp.getLeft() != null)
					if (temp.getLeft().getLeft() != null)
						if (temp.getLeft().getLeft().getUp() != null)
						{
							//System.out.println("path7");
							temp.setPath7(temp.getLeft().getLeft().getUp());
						}
				
				if (temp.getUp() != null)
					if (temp.getUp().getUp() != null)
						if (temp.getUp().getUp().getLeft() != null)
						{
							//System.out.println("path8");
							temp.setPath8(temp.getUp().getUp().getLeft());
						}
				
				temp = temp.getRight();
			}
			
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
	}
	
	public void display()
	{
		Node temp = first;
		Node rowMarker = first;
		
		while(temp!=null)
		{
			while(temp!=null)
			{
				if(temp.getData() < 10)
					System.out.print(temp.getData() + "   ");
				else if (temp.getData() < 100)
					System.out.print(temp.getData() + "  ");
				else
					System.out.print(temp.getData() + " ");
				
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
	}
	
	public void moveKnight (int data, Node temp)
	{
		temp.setData(data);
			
		if (temp.getPath1() != null)
			if (temp.getPath1().getData() == 0)
			{
				//System.out.println("path1");
				moveKnight(++counter,temp.getPath1());
			}
		
		if (temp.getPath2() != null)
			if (temp.getPath2().getData() == 0)
			{
				//System.out.println("path2");
				moveKnight(++counter,temp.getPath2());
			}
				
		if (temp.getPath3() != null)
			if (temp.getPath3().getData() == 0)
			{
				//System.out.println("path3");
				moveKnight(++counter,temp.getPath3());
			}
		
		if (temp.getPath4() != null)
			if (temp.getPath4().getData() == 0)
			{
				//System.out.println("path4");
				moveKnight(++counter,temp.getPath4());
			}
		
		if (temp.getPath5() != null)
			if (temp.getPath5().getData() == 0)
			{
				//System.out.println("path5");
				moveKnight(++counter,temp.getPath5());
			}
		
		if (temp.getPath6() != null)
			if (temp.getPath6().getData() == 0)
			{
				//System.out.println("path6");
				moveKnight(++counter,temp.getPath6());
			}
		
		if (temp.getPath7() != null)
			if (temp.getPath7().getData() == 0)
			{
				//System.out.println("path7");
				moveKnight(++counter,temp.getPath7());
			}
		
		if (temp.getPath8() != null)
			if (temp.getPath8().getData() == 0)
			{
				//System.out.println("path8");
				moveKnight(++counter,temp.getPath8());
			}
					
		if (endCondition() == true) 
		{ 
			System.out.println();
			solution++;
			display();
			System.out.println("There are: " + solution + " solutions."); 
		}
				
		temp.setData(0);
		counter--;
	}
	
	public boolean endCondition()
	{
		Node temp = first;
		Node rowMarker = first;

		while (temp != null)
		{
			while (temp != null)
			{
				if (temp.getData() == 0)
				{
					return false;
				}
				
				temp = temp.getRight();
			}
			
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
		
		return true;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
}


package anti_Diagonals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
  Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
 */

public class Anti_Diagonals {
	
	private static void print_diagonally(int[][] array,int row,int column) {
		
		HashMap<Integer,ArrayList> map=new HashMap<>();		// uses extra space but simpler to understand
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				if(map.containsKey(i+j))					// If the sum exists
				{
					ArrayList list=map.get(i+j);			// adds the element to the existing arraylist
					list.add(array[i][j]);
					map.put(i+j, list);
				}
				else
				{
					ArrayList<Integer> temp=new ArrayList<>();
					temp.add(array[i][j]);							// adding new arraylist if row+column sum is not present
					map.put(i+j,temp);
				}
			}
		}
		System.out.println(map);
	}

	public static void main(String[] args) {
		
		

		Scanner scanner=new Scanner(System.in);
		int row=scanner.nextInt();
		int column=scanner.nextInt();
		int array[][]=new int[row][column];			
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				array[i][j]=scanner.nextInt();
			}
		}
		
		print_diagonally(array,row,column);
	}
}
/*
  	Input:			// the diagonals consists of same sum EG:
	1 2 3
	4 5 6
	7 8 9

	Output:
	1 0 0			 { 1(0,0) }  
	2 4 0			 { 2(1,0), 4(0,1) }
	3 5 7			 { 3(0,2) , 5(1,2) , 7(2,1) } ...
	6 8 0
	9 0 0
	
	Input:
	1 2
	3 4

	Output:
	1 0
	2 3
	4 0
*/
package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

//Permutations of placing 2 queens in 4 slots.

public class TwoQueenProblem {
	static ArrayList<String> permutation(boolean q[],int n,int count,int noOfQueenToBePlaced){
		if(count==noOfQueenToBePlaced) {
			ArrayList<String> empty=new ArrayList<>();
			empty.add("");
			return empty;
		}
		ArrayList<String> result=new ArrayList<>();
		for( int i=0;i<n;i++) {
			if(!q[i]) {
			q[i]=true;
			ArrayList<String> temp=permutation(q, n, count+1,noOfQueenToBePlaced);
			for(String s:temp) {
				result.add("q"+i+s);
			}
			}
			q[i]=false;
		}
		return result;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noofSlots,noOfQueensToBePlaced;
		Scanner scanner =new Scanner(System.in);
		System.out.print("enter number of queens to be placed: ");
		noOfQueensToBePlaced=scanner.nextInt();
		System.out.print("enter number of slots available: ");
		noofSlots=scanner.nextInt();
		boolean q[]= new boolean[noofSlots];
		System.out.print(permutation(q,q.length,0,noOfQueensToBePlaced));
		scanner.close();
	}

}

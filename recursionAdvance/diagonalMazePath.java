package recursionAdvance;

import java.util.ArrayList;

public class diagonalMazePath {
	static ArrayList<String> findPath(int x, int y,int xOfDestination,int yOfDestination ){
		if(x==xOfDestination && y==yOfDestination) {
			ArrayList<String> empty=new ArrayList<>();
			empty.add("");
			return empty;
		}
		if(x>xOfDestination || y>yOfDestination) {
			ArrayList<String> empty=new ArrayList<>();
			return empty;
		}
		ArrayList<String> result=new ArrayList<>();
		ArrayList<String> horizontalResult=findPath(x,y+1,xOfDestination,yOfDestination);
		for(String tempResult:horizontalResult) {
			result.add("H"+tempResult);
		}
		ArrayList<String> verticalResult=findPath(x+1,y,xOfDestination,yOfDestination);
		for(String tempResult:verticalResult) {
			result.add("V"+tempResult);
		}
		ArrayList<String> diagonalResult=findPath(x+1,y+1,xOfDestination,yOfDestination);
		for(String tempResult:diagonalResult) {
			result.add("D"+tempResult);
		}
		return result;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPath(0,0,3,3));
	}

}

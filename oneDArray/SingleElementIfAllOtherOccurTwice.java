package oneDArray;

//approach : using hashing.
//best approach: For this particular problem as all other element occur twice XOR operation can be used here too end the problem in a constatnt time.
public class SingleElementIfAllOtherOccurTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,3,4,5,6,5,4,3,2};
		for(int i:a) {
 			System.out.print(" "+i);
 		}
 		System.out.println();
 		System.out.print("Missing number  ");
 		int single=a[0];
 		for(int i=1;i<a.length;i++) {
 		    single=single^a[i];
 		}
 		System.out.print(single);
 		
 
	}

}

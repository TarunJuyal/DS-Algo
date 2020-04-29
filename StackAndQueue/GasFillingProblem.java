package StackAndQueue;

//we have to tell statring station in order to complete the journey or return -1 if not any.

public class GasFillingProblem {
	static int checkJourneyCompletion() {
		int gas[]= {1,2,3,4,5};
		int cost[]= {3,4,5,1,2};                                         //this means distance to be traveled.
		int surplus=0,currentAvailable=0,startingStation=0;
		for(int i=0;i<gas.length;i++) {
			currentAvailable=surplus+=gas[i]-cost[i];                    //curentAvailable keeps track of individual journeys while surplus for entire journey.
			if(currentAvailable<0) {
				startingStation=i+1;
				currentAvailable=0;
			}
		}
		return surplus>=0?startingStation-1:-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkJourneyCompletion());
	}

}

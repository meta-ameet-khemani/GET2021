/**
 * JobScheduler class implements First Come First Serve algorithm for job assignment
 * @author ameet.khemani_metacu
 *
 */
public class JobScheduler {

	/*
	 * TOTAL_PROCESSES represents total number of processes
	 */
	final static int TOTAL_PROCESSES = 6;
	static int completionTime[] = new int[TOTAL_PROCESSES];
	static int turnAroundTime[] = new int[TOTAL_PROCESSES];
	static int waitingTime[] = new int[TOTAL_PROCESSES];
	static int arrivalAndBurstTiming[][] = new int[TOTAL_PROCESSES][2];

	public static void main(String[] args) {
		
		arrivalAndBurstTiming[0][0] = 0;
		arrivalAndBurstTiming[0][1] = 3;
		arrivalAndBurstTiming[1][0] = 1;
		arrivalAndBurstTiming[1][1] = 2;
		arrivalAndBurstTiming[2][0] = 2;
		arrivalAndBurstTiming[2][1] = 1;
		arrivalAndBurstTiming[3][0] = 3;
		arrivalAndBurstTiming[3][1] = 4;
		arrivalAndBurstTiming[4][0] = 4;
		arrivalAndBurstTiming[4][1] = 5;
		arrivalAndBurstTiming[5][0] = 5;
		arrivalAndBurstTiming[5][1] = 2;
		
		getCompletionTime();
		getTurnAroundTime();
		getWaitingTime();
		showProcessesInfo();
		System.out.println("Total waiting time : " + getTotalWaitingTime());
		System.out.println("Average waiting time : " + getAverageWaitingTime());
		
	}
	
	/**
	 * shows completion time of each process
	 * @return array of completion time
	 */
	public static int[] getCompletionTime() {
		int previousCompletionTime = 0;
		completionTime[0] = 0;
		
		for (int rowIndex = 0; rowIndex < TOTAL_PROCESSES; rowIndex++) {
			if (previousCompletionTime < arrivalAndBurstTiming[rowIndex][0]) {
				completionTime[rowIndex] = arrivalAndBurstTiming[rowIndex][0] + arrivalAndBurstTiming[rowIndex][1];
			} else {
				completionTime[rowIndex] = previousCompletionTime + arrivalAndBurstTiming[rowIndex][1];
			}
			previousCompletionTime = completionTime[rowIndex];
		}
		return completionTime;
	}
	
	/**
	 * shows turn-around time for each process
	 * @return array of turn-aroung time
	 */
	public static int[] getTurnAroundTime() {
		
		for (int rowIndex = 0; rowIndex < TOTAL_PROCESSES; rowIndex++) {
			turnAroundTime[rowIndex] = completionTime[rowIndex] - arrivalAndBurstTiming[rowIndex][0];
		}
		
		return turnAroundTime;
	}
	
	/**
	 * shows waiting time of each process
	 * @return array of waiting time
	 */
	public static int[] getWaitingTime() {
		
		getTurnAroundTime();
		
		for (int rowIndex = 0; rowIndex < TOTAL_PROCESSES; rowIndex++) {
			waitingTime[rowIndex] = turnAroundTime[rowIndex] - arrivalAndBurstTiming[rowIndex][1];
		}
		
		return waitingTime;
	}
	
	/**
	 * gives average waiting time of all processes
	 * @return average waiting time
	 */
	public static int getAverageWaitingTime() {
		int totalWaitingTime = getTotalWaitingTime();
		return (totalWaitingTime/TOTAL_PROCESSES);
	}
	
	/**
	 * gives total waiting time of all processes
	 * @return total waiting time
	 */
	public static int getTotalWaitingTime() {
		int totalWaitingTime = 0, maxWaitingTime = 0;
		for(int singleWaitingTime : waitingTime) {
			totalWaitingTime += singleWaitingTime;
			if (maxWaitingTime < singleWaitingTime)
				maxWaitingTime = singleWaitingTime;
		}
		return totalWaitingTime;
	}
	
	/**
	 * shows arrival, burst, completion, turn-around and waiting time respectively for all processes
	 */
	public static void showProcessesInfo() {
		System.out.println("A : B : C : T : W");
		System.out.println("-----------------");
		for (int rowIndex = 0; rowIndex < TOTAL_PROCESSES; rowIndex++) {
			for (int colIndex = 0; colIndex < 2; colIndex++) {
				System.out.print(arrivalAndBurstTiming[rowIndex][colIndex++] + " : "
								+ arrivalAndBurstTiming[rowIndex][colIndex] + " : "
								+ completionTime[rowIndex] + " : "
								+ turnAroundTime[rowIndex] + " : "
								+ waitingTime[rowIndex] + "\n");
			}
		}
	}

}

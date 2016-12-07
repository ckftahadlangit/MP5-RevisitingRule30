import java.util.Scanner;

public class RuleThirtyTester{
	public static final int THREAD_CTR = 10;

	public static void main(String[] args) throws Exception{
		String dim;
		System.out.println("Please enter grid size:" ); 
		Scanner dimension = new Scanner(System.in);
		dim = dimension.nextLine();
		int size = Integer.parseInt(dim);
		//int[][] grid = new int[size][size];

		long timeStarted = System.currentTimeMillis();
		// int globalMaxDivisorCount = 0;
        // int whichInt = 0;

        //create 10 workers of rule30
        RuleThirty[] w = new RuleThirty[THREAD_CTR];
		int intperThread = size / THREAD_CTR;
		int begin = 1;
		int stop = (begin + intperThread) - 1;

		for(int i = 0 ; i < THREAD_CTR; i++){
			if(i == (THREAD_CTR - 1)){
				stop = size;
			}
			w[i] =  new RuleThirty(stop);
			begin = stop + 1;
			stop = (begin + intperThread)-1;
		}


		int ctr = 0;
		for(int x = 0; x < THREAD_CTR; x++){
			//w[ctr].start();
			while(w[ctr].isAlive()){
				try{
					w[ctr].join();
				}catch(InterruptedException ex){
					System.err.println("Interrupted thread: " + ex.getMessage());
				}
			}
		}

		w[ctr-1].print();
		System.out.println("Generated output: ");
		RuleThirty x = new RuleThirty(size);
		long timeEnded = System.currentTimeMillis();
		System.out.println("Time Consumed (in ms): " + (timeEnded - timeStarted));
    }
}
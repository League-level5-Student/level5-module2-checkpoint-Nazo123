import java.util.Random;

public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		//Your Code Here
		Thread slowSortArray = new Thread(()-> {
			SlowFunctions.slowSortLargeArray();
		});
		Thread ackerman = new Thread(()->{
			SlowFunctions.ackermann(3, 10);
		});
		Thread sqrt = new Thread(()->{
			SlowFunctions.millionsOfSqrts();
		});
		slowSortArray.start();
		ackerman.start();
		sqrt.start();
		try {
			slowSortArray.join();
			ackerman.join();
			sqrt.join();
		}
		catch(Exception e){
			System.out.println("YOUR PROGRAM IS BROKEN");
		}
		
		float endTime = (float)((double)System.currentTimeMillis() - (double)startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}

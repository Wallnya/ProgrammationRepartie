package pi;

/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
  public static void main(String[] args) throws Exception 
  {
    // 10 workers, 50000 iterations each
	long startTime = System.currentTimeMillis();
	for (int i=0;i<10;i++){
	    new Master().doRun(200000, 16);
	}

	long stopTime = System.currentTimeMillis();

	System.out.println("Time Duration: " + (stopTime - startTime) + "ms");

  }
}
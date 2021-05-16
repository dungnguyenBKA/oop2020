package hust.soict.hedspi.aims;

public class MemoryDaemon implements Runnable{
	private long memoryUsed = 0;
	public void run() {
		Runtime rtRuntime = Runtime.getRuntime();
		long used;
		
		while(true) {
			used = rtRuntime.totalMemory() - rtRuntime.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = "+ used);
				memoryUsed = used;
			}
		}
	}
}

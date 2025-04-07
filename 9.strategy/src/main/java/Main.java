import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();

		int[] smallArr = new int[100_000];
		int[] largeArr = new int[100_000_000];

		for (int i = 0; i < smallArr.length; i++) {
			smallArr[i] = rand.nextInt(10000);
		}

		for (int i = 0; i < largeArr.length; i++) {
			largeArr[i] = rand.nextInt(10000);
		}

		Context context = new Context();

		context.setStrategy(new HeapSort());
		measureTime(context, smallArr.clone(), "Heap Sort", "small");
		measureTime(context, largeArr.clone(), "Heap Sort", "large");

		context.setStrategy(new CountSort());
		measureTime(context, smallArr.clone(), "Count Sort", "small");
		measureTime(context, largeArr.clone(), "Count Sort", "large");

		context.setStrategy(new RadixSort());
		measureTime(context, smallArr.clone(), "Radix Sort", "small");
		measureTime(context, largeArr.clone(), "Radix Sort", "large");
	}

	private static void measureTime(Context context, int[] arr, String sortType, String arrType) {
		long startTime = System.currentTimeMillis();
		context.executeStrategy(arr);
		long endTime = System.currentTimeMillis();
		double result = (endTime - startTime) / 1000.0;
		System.out.printf("Sorting %s array of size %d using %s took %.10f s%n", arrType, arr.length, sortType,
		                  result);
		System.out.println();
	}
}
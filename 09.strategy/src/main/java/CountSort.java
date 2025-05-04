public class CountSort implements SortStrategy {
	private static int[] countSort(int[] inputArray) {
		int N = inputArray.length;
		int M = 0;

		for (int j : inputArray) {
			M = Math.max(M, j);
		}

		int[] countArray = new int[M + 1];

		for (int j : inputArray) {
			countArray[j]++;
		}

		for (int i = 1; i <= M; i++) {
			countArray[i] += countArray[i - 1];
		}

		int[] outputArray = new int[N];

		for (int i = N - 1; i >= 0; i--) {
			outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
			countArray[inputArray[i]]--;
		}

		return outputArray;
	}

	public static void main(String[] args) {
		int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
		int[] outputArray = countSort(inputArray);

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}

	@Override
	public void sort(int[] arr) {
		int[] result = countSort(arr);
		System.arraycopy(result, 0, arr, 0, arr.length);
	}
}

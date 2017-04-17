package seek.utils;

import java.util.Random;

public class SortUtils {

	public static <T> void swap(T[] arr, int source, int target) {
		T t = arr[source];
		arr[source] = arr[target];
		arr[target] = t;
	}
	
	public static Integer[] generateRandomArray(int n, int arrayL, int arrayR) {
		Integer[] arr = new Integer[n];
		for (int i=0; i < n; i++) {
			Random random = new Random();
			arr[i] = random.nextInt(arrayR)%(arrayR - arrayL + 1) + arrayL;
		}
		return arr;
	}
}

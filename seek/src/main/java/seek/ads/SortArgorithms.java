package seek.ads;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import seek.utils.SortUtils;

/**
 * Algorithm and Data Structure Test Class
 * 
 * @author Bao 2017年4月15日
 */
public class SortArgorithms {

	public static <T extends Comparable<T>> T[] insertionSort(T arr[], int n) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					SortUtils.swap(arr, j, j - 1);
				} else {
					break;
				}
			}
		}
		return arr;
	}

	public static <T extends Comparable<T>> T[] insertionSortOptimization(
			T arr[], int n) {
		for (int i = 1; i < arr.length; i++) {
			T t = arr[i];
			int j;
			for (j = i; j > 0; j--) {
				if (t.compareTo(arr[j - 1]) < 0) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = t;
		}
		return arr;
	}

	public static <T extends Comparable<T>> T[] selectionSort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			// look for the minimum in [i,n)
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					SortUtils.swap(arr, j, minIndex);
				}
			}
		}
		return arr;
	}

	public static <T extends Comparable<T>> T[] bubboSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					SortUtils.swap(arr, j, j + 1);
				}
			}
		}
		return arr;
	}

	public static <T extends Comparable<T>> T[] shellSort(T[] arr) {
		int gap = arr.length / 2;
		while (gap >= 1) {
			
			// 把距离为gap的元素编为一个组，扫描所有组
			for (int i = gap; i < arr.length; i++) {
				int j = 0;
				T temp = arr[i];

				// 对距离为gap的元素进行排序
				for (j = i - gap; j >= 0 && temp.compareTo(arr[j]) < 0; j = j - gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
			gap = gap / 2;
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer[] array = SortUtils.generateRandomArray(10000, 1, 10000);
		Integer[] arrayCopy = Arrays.copyOf(array, array.length);
		long startTime1 = new Date().getTime();
		SortArgorithms.insertionSort(array, 0);
		long endTime1 = new Date().getTime();
		System.out.println(Arrays.toString(array));
		System.out.println(new BigDecimal(endTime1 - startTime1)
				.movePointLeft(3));

		Integer[] array2 = SortUtils.generateRandomArray(10, 1, 100);
		SortArgorithms.selectionSort(array2);
		System.out.println(Arrays.toString(array2));

		long startTime2 = new Date().getTime();
		SortArgorithms.insertionSortOptimization(arrayCopy, 0);
		long endTime2 = new Date().getTime();
		System.out.println(Arrays.toString(arrayCopy));
		System.out.println(new BigDecimal(endTime2 - startTime2)
				.movePointLeft(3));

		String[] stringArr = { "E", "G", "H", "V", "R" };
		SortArgorithms.selectionSort(stringArr);
		System.out.println(Arrays.toString(stringArr));

		Integer[] bubboArray = SortUtils.generateRandomArray(10, 1, 100);
		SortArgorithms.bubboSort(bubboArray);
		System.out.println(Arrays.toString(bubboArray));
	}

}

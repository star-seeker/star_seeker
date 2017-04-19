package seek.ads;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import seek.utils.SortUtils;

/**
 * Algorithm and Data Structure Test Class
 * 
 * @author Bao 2017年4月15日
 */
public class SortArgorithms {

	public static <T extends Comparable<T>> T[] insertionSort(T arr[]) {
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

	public static <T> void insertionSortOptimization(T arr[], int left,
			int right, Comparator<T> comparator) {
		for (int i = left + 1; i <= right; i++) {
			T t = arr[i];
			int j;
			for (j = i; j > 0; j--) {
				if (comparator.compare(t, arr[j - 1]) < 0) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = t;
		}
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
				for (j = i - gap; j >= 0 && temp.compareTo(arr[j]) < 0; j = j
						- gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
			gap = gap / 2;
		}
		return arr;
	}

	public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
		mergeSort(arr, 0, arr.length - 1, comparator);
	}

	public static <T> void mergeSortBU(T arr[], Comparator<T> comparator) {
		int n = arr.length;
		for (int sz = 1; sz <= n; sz += sz)
			for (int i = 0; i + sz < n; i += sz + sz)
				// 对arr[i...i+sz-1]和arr[i+sz...i+2*sz-1]进行归并
				if (comparator.compare(arr[i + sz - 1], arr[i + sz]) > 0)
					merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1),
							comparator);
	}

	private static <T> void mergeSort(T[] arr, int left, int right,
			Comparator<T> comparator) {
		// int sortConstant = 15;
		// // 归并排序优化：当分组足够小时进行直接插入排序
		// if (right - left <= sortConstant) {
		// insertionSortOptimization(arr, left, right, comparator);
		// return;
		// }
		if (right <= left)
			return;
		int middle = (right + left) / 2;
		mergeSort(arr, left, middle, comparator);
		mergeSort(arr, middle + 1, right, comparator);
		if (comparator.compare(arr[middle], arr[middle + 1]) > 0)
			merge(arr, left, middle, right, comparator);
	}

	private static <T> void merge(T[] arr, int left, int middle, int right,
			Comparator<T> comparator) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[right - left + 1];
		for (int i = left; i <= right; i++)
			aux[i - left] = arr[i];
		int leftIndex = left;
		int rightIndex = middle + 1;
		for (int real = left; real <= right; real++) {
			if (leftIndex > middle) {
				arr[real] = aux[rightIndex - left];
				rightIndex++;
			} else if (rightIndex > right) {
				arr[real] = aux[leftIndex - left];
				leftIndex++;
			} else if (comparator.compare(aux[leftIndex - left], aux[rightIndex
					- left]) < 0) {
				arr[real] = aux[leftIndex - left];
				leftIndex++;
			} else {
				arr[real] = aux[rightIndex - left];
				rightIndex++;
			}
		}
	}

	public static void main(String[] args) {

		int arrayLength = 100000;
		Integer[] arrayMerge = SortUtils.generateRandomArray(arrayLength, 1,
				10000);
		Integer[] arrayInsertion = Arrays.copyOf(arrayMerge, arrayLength);
		Integer[] arrayMergeBU = Arrays.copyOf(arrayMerge, arrayLength);

		// Test mergeSort
		long startTimeMerge = new Date().getTime();
		mergeSort(arrayMerge, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		long endTimeMerge = new Date().getTime();
		System.out.println("mergeSort:"
				+ new BigDecimal(endTimeMerge - startTimeMerge)
						.movePointLeft(3) + "s");

		// Test mergeSortBU
		long startTimeMergeBU = new Date().getTime();
		mergeSortBU(arrayMergeBU, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		long endTimeMergeBU = new Date().getTime();
		System.out.println("mergeSortBU:"
				+ new BigDecimal(endTimeMergeBU - startTimeMergeBU)
						.movePointLeft(3) + "s");
		
		// Test insertionSort
		long startTimeInsertion = new Date().getTime();
		insertionSort(arrayInsertion);
		long endTimeInsertion = new Date().getTime();
		System.out.println("insertionSort:"
				+ new BigDecimal(endTimeInsertion - startTimeInsertion)
						.movePointLeft(3) + "s");

		// Integer[] array2 = SortUtils.generateRandomArray(10, 1, 100);
		// SortArgorithms.selectionSort(array2);
		// System.out.println(Arrays.toString(array2));
		//
		// long startTime2 = new Date().getTime();
		// SortArgorithms.insertionSortOptimization(arrayCopy, 0);
		// long endTime2 = new Date().getTime();
		// System.out.println(Arrays.toString(arrayCopy));
		// System.out.println(new BigDecimal(endTime2 - startTime2)
		// .movePointLeft(3));
		//
		// String[] stringArr = { "E", "G", "H", "V", "R" };
		// SortArgorithms.selectionSort(stringArr);
		// System.out.println(Arrays.toString(stringArr));
		//
		// Integer[] bubboArray = SortUtils.generateRandomArray(10, 1, 100);
		// SortArgorithms.bubboSort(bubboArray);
		// System.out.println(Arrays.toString(bubboArray));
	}

}

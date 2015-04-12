package com.minhaz.algorithm.sort;

public class QuickSort {

	public void sort(int[] array) {
		quicksort(array, 0, array.length - 1);

	}

	private void quicksort(int[] numbers, int low, int high) {
		// TODO Auto-generated method stub
		int i = low;
		int j = high;
		int pivot = numbers[low + ((high - low) / 2)];

		if (i <= j) {

			// partition(numbers, i, j, numbers[pivot])

		}

	}
	private static int partition(char[] arr, int low, int high, char pivot) {
		int i = low;
		char temp1, temp2;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				temp1 = arr[i];
				arr[i] = arr[j];
				arr[j] = temp1;
				i++;
			} else if (arr[j] == pivot) {
				temp1 = arr[j];
				arr[j] = arr[high];
				arr[high] = temp1;
				j--;
			}
		}
		temp2 = arr[i];
		arr[i] = arr[high];
		arr[high] = temp2;

		// Return the partition index of an array based on the pivot
		// element of other array.
		return i;
	}

	private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

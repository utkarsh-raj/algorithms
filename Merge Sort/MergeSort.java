import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class MergeSort {
	
	// This function calls itself recursively to merge the arrays according to the index
	void merge(int []arr, int low, int mid, int high) {
		
		// Temoprary arrays
		int sizeArr1 = mid - low + 1;
		int sizeArr2 = high - mid;

		int []arr1 = new int[sizeArr1];
		int []arr2 = new int[sizeArr2];

		// Instantiating the arrays
		int i, j;
		for (i = 0; i < sizeArr1; i++) {
			arr1[i] = arr[low + i];
		}
		for (j = 0; j < sizeArr2; j++) {
			arr2[j] = arr[mid + 1 + j];
		}

		i = 0;
		j = 0;
		int index = low;

		// If one array is empty
		while (i < sizeArr1 && j < sizeArr2) {
			if (arr1[i] <= arr2[j]) {
				arr[index] = arr1[i];
				i += 1;
			}
			else {
				arr[index] = arr2[j];
				j += 1;
			}
			index += 1;
		}

		// If there is any element left in the first array
		while (i < sizeArr1) {
			arr[index] = arr1[i];
			i += 1;
			index += 1;
		}

		// If there is any element left in the second array 
		while (j < sizeArr2) {
			arr[index] = arr2[j];
			j += 1;
			index += 1;
		}
	}

	// Wrapper function to call Sort function
	void sort(int []arr, int low, int high) {
		if (low < high) {
			
			int mid = (low + high) / 2;
			
			sort(arr, low, mid);
			sort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}
	}

	// Utility function to print the array 
	void display(int []arr, int N) {
		int i = 0;
		
		for (i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		MergeSort mSort = new MergeSort();

		int N = scanner.nextInt();
		int arr[] = new int[N];
		int i;
		
		for (i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		mSort.sort(arr, 0, N - 1);

		System.out.print("The Sorted Array: ");

		mSort.display(arr, N);
	}
}
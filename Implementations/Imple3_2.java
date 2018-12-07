import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class Imple3_2 {
	
	// Function to implement the Sort 
	void merge(int []arr, int low, int mid, int high) {
		
		int sizeArr1 = mid - low + 1;
		int sizeArr2 = high - mid;

		int []arr1 = new int[sizeArr1];
		int []arr2 = new int[sizeArr2];

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

		while (i < sizeArr1) {
			arr[index] = arr1[i];
			i += 1;
			index += 1;
		}

		while (j < sizeArr2) {
			arr[index] = arr2[j];
			j += 1;
			index += 1;
		}
	}

	// Function to invoke the sort
	void sort(int []arr, int low, int high) {
		if (low < high) {
			
			int mid = (low + high) / 2;
			
			sort(arr, low, mid);
			sort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}
	}

	// A function that return the boolean if there are the required elements and not if the required elements are not there
	static boolean checkForTwoElements(int []arr, int index, int sum, int N) {
		int lPtr = 0;
		int rPtr = N - 1;

		while (lPtr < rPtr) {
			// If the index is equal to the pointer the pointer is shifted so that the index is not rechecked
			if (lPtr == index) {
				lPtr += 1;
			}
			else if (rPtr == index) {
				rPtr -= 1;
			}
			else if (arr[lPtr] + arr[rPtr] == sum) {
				return true;
			}

			else if (arr[lPtr] + arr[rPtr] < sum) {
				lPtr += 1;
			}

			else {
				rPtr -= 1;
			}
		}
		return false;
	}

	// A utility function to print the array int the arguments
	void display(int []arr, int N) {
		int i = 0;
		
		for (i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.print("\n");
	}

	// Driver code
	public static void main(String []args) {
		
		Scanner scanner = new Scanner(System.in);
		Imple3_2 mSort = new Imple3_2();

		int N = scanner.nextInt();
		int arr[] = new int[N];
		int i, newQuery, flag1 = 0;
		
		for (i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		mSort.sort(arr, 0, N - 1);

		System.out.println("The Sorted Array: ");

		mSort.display(arr, N);

		System.out.println("Search Element: ");

		int key = scanner.nextInt();

		for (i = 0; i < N; i++) {
			newQuery = key - arr[i];

			if (checkForTwoElements(arr, i, newQuery, N)) {
				flag1 = 1;
				System.out.println("The required numbers are there.");
				break;
			}
		}
		if (flag1 == 0) {
			System.out.println("The required numbers are not there.");
		}
	}
}
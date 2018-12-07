import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class Imple3_3 {

	boolean found = false;
	
	// A function to implement here Binary Search using recursion
	// The Linear search is for selecting the element in the array and then Binary search
	void binarySearch(int []arr, int low, int key, int high) {
		
		int mid = (low + high) / 2;
		
		if (low > high) {
			found = false;
		}
		
		else {
			
			if (arr[mid] == key) {
				found = true;
			}
			
			else if (arr[mid] > key) {
				binarySearch(arr, low, key, mid - 1);
			}
			
			else {
				binarySearch(arr, mid + 1, key, high);
			}
		}
	}

	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		Imple3_3 bSearch = new Imple3_3();

		int N = scanner.nextInt();
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		int i, newQuery;
		
		for (i = 0; i < N; i++) {
			arr1[i] = scanner.nextInt();
		}
		for (i = 0; i < N; i++) {
			arr2[i] = scanner.nextInt();
		}
		
		System.out.print("Search Element: ");

		int key = scanner.nextInt();
		
		for (i = 0; i < N; i++) {
			newQuery = key - arr1[i];
			bSearch.binarySearch(arr2, 0, newQuery, N - 1);
			if (bSearch.found == true) {
				System.out.println("The required numbers are there.");
				break;
			}
		}
		if (bSearch.found == false) {
			System.out.println("The required numbers are not there.");
		}
	}
}
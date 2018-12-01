import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class BinarySearch {
	
	void binarySearch(int []arr, int low, int key, int high) {
		
		int mid = (low + high) / 2;
		
		if (low > high) {
			System.out.println("Element not found!");
		}
		
		else {
			
			if (arr[mid] == key) {
				System.out.println("Element " + key + " found at the index value " + mid);
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
		BinarySearch bSearch = new BinarySearch();

		int N = scanner.nextInt();
		int arr[] = new int[N];
		int i;
		
		for (i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("Search Element: ");

		int key = scanner.nextInt();
		
		bSearch.binarySearch(arr, 0, key, N - 1);
	}
}
import java.io.*;
import java.lang.Math;
import java.util.Scanner;

class Implementation1_4 {
	
	void binarySearch(int []arr, int low, int high) {
		
		int mid = (low + high) / 2;
		
		if (low > high) {
			System.out.println("Element not found!");
		}
		
		else {
			
			if (mid == arr[mid]) {
				System.out.println("Element found at the index value " + mid);
			}
			
			else if (mid < arr[mid]) {
				binarySearch(arr, low, mid - 1);
			}
			
			else {
				binarySearch(arr, mid + 1, high);
			}
		}
	}

	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		Implementation1_4 bSearch = new Implementation1_4();

		int N = scanner.nextInt();
		int arr[] = new int[N];
		int i;
		
		for (i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		// System.out.print("Search Element: ");

		// int key = scanner.nextInt();
		
		bSearch.binarySearch(arr, 0, N - 1);
	}
}
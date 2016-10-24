package quickSort;

public class QuickSort {

	public static void main(String[] args) {

		//initialize a random number
		int random = (int)(Math.random() * 100);
		
		//initialize array of size "random"
		int[] array = new int[random];
		
		//initialize each index of the array to a random value
		for(int i = 0; i < array.length; i++) {
			
			array[i] = (int)(Math.random() * 100);
			
		}
		
		//print header
		System.out.println("Unsorted array: ");
		
		//print unsorted array
		printArray(array);
		
		//perform quicksort on array
		quickSort(array, 0, array.length - 1);
		
		//print header
		System.out.println("Sorted Array using Quicksort: ");
		
		//print sorted array
		printArray(array);
		
	}

	//print entire array
	private static void printArray(int[] array) {

		//iterate through the array printing each element
		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i] + " ");
			
		}
		
		System.out.println();
		
		
	}

	//quicksort the array
	private static void quickSort(int[] array, int start, int end) { 
		
		//if the subarray is greater than one element
		if(start < end) {
		
			//initialize partition index
			int partitionIndex = partition(array, start, end);

			//recursively quicksort each subarray
			quickSort(array, start, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, end);
		
		}
		
	}

	//partition the subarray
	private static int partition(int[] array, int start, int end) {

		//choose first index of array as pivot
		int pivot = array[end];
		
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++) {
			
			if(array[j] <= pivot) {
				
				i++;
				
				//swap indices
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				
			}
			
		}
		
		//place pivot in correct place
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		
		return i;
		
	}

}

import java.io.*;
import java.util.Arrays;


public class Reporting1 {
	
	public static int[] generateAscending(int size){
		int[] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = i;
		}
		return arr;
	}
	
	public static int[] generateDescending(int size){
		int[] arr = new int[size];
		for(int i = size -1 ; i >= 0; i--){
			arr[i] = i;
		}
		return arr;
	}
	
	public static int[] generateRandom(int size){
		int[] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = (int) Math.random() * size;
		}
		return arr;
	}
	
	public static long median(long[] arr){
		Arrays.sort(arr);
		return arr[1];
	}
	
	public static void main(String[] args){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
			long[] sortedH = new long[3];
			long[] reverseH = new long[3];
			long[] randomH = new long[3];
			long[] sortedQ = new long[3];
			long[] reverseQ = new long[3];
			long[] randomQ = new long[3];			
			long[] sortedM = new long[3];
			long[] reverseM = new long[3];
			long[] randomM = new long[3];
			
			for(int i = 0; i < 3; i++){
				sortedH[i] = Sorting.HeapSort.sort(generateAscending(1000));
				reverseH[i] = Sorting.HeapSort.sort(generateDescending(1000));
				randomH[i] = Sorting.HeapSort.sort(generateRandom(1000));
				sortedQ[i] = Sorting.QuickSort.sort(generateAscending(1000));
				reverseQ[i] = Sorting.QuickSort.sort(generateDescending(1000));
				randomQ[i] = Sorting.QuickSort.sort(generateRandom(1000));
				sortedM[i] = Sorting.MergeSort.sort(generateAscending(1000));
				reverseM[i] = Sorting.MergeSort.sort(generateDescending(1000));
				randomM[i] = Sorting.MergeSort.sort(generateRandom(1000));
			}
			writer.write("Heap Sort - Array size 1,000:  " + "Sorted: " + median(sortedH)
							+ " Reverse: " + median(reverseH)
							+ " Random: " + median(randomH) + "\n");
			writer.write("Quick Sort - Array size 1,000:  " + "Sorted: " + median(sortedQ)
			+ " Reverse: " + median(reverseQ)
			+ " Random: " + median(randomQ) + "\n");
			writer.write("Merge Sort - Array size 1,000:  " + "Sorted: " + median(sortedM)
			+ " Reverse: " + median(reverseM)
			+ " Random: " + median(randomM) + "\n");
			
			for(int i = 0; i < 3; i++){
				sortedH[i] = Sorting.HeapSort.sort(generateAscending(10000));
				reverseH[i] = Sorting.HeapSort.sort(generateDescending(10000));
				randomH[i] = Sorting.HeapSort.sort(generateRandom(10000));
				sortedQ[i] = Sorting.QuickSort.sort(generateAscending(10000));
				reverseQ[i] = Sorting.QuickSort.sort(generateDescending(10000));
				randomQ[i] = Sorting.QuickSort.sort(generateRandom(10000));
				sortedM[i] = Sorting.MergeSort.sort(generateAscending(10000));
				reverseM[i] = Sorting.MergeSort.sort(generateDescending(10000));
				randomM[i] = Sorting.MergeSort.sort(generateRandom(10000));
			}
			
			writer.write("Heap Sort - Array size 10,000:  " + "Sorted: " + median(sortedH)
			+ " Reverse: " + median(reverseH)
			+ " Random: " + median(randomH) + "\n");
			writer.write("Quick Sort - Array size 10,000:  " + "Sorted: " + median(sortedQ)
			+ " Reverse: " + median(reverseQ)
			+ " Random: " + median(randomQ) + "\n");
			writer.write("Merge Sort - Array size 10,000:  " + "Sorted: " + median(sortedM)
			+ " Reverse: " + median(reverseM)
			+ " Random: " + median(randomM) + "\n");
			
			for(int i = 0; i < 3; i++){
				sortedH[i] = Sorting.HeapSort.sort(generateAscending(100000));
				reverseH[i] = Sorting.HeapSort.sort(generateDescending(100000));
				randomH[i] = Sorting.HeapSort.sort(generateRandom(100000));
				sortedQ[i] = Sorting.QuickSort.sort(generateAscending(100000));
				reverseQ[i] = Sorting.QuickSort.sort(generateDescending(100000));
				randomQ[i] = Sorting.QuickSort.sort(generateRandom(100000));
				sortedM[i] = Sorting.MergeSort.sort(generateAscending(100000));
				reverseM[i] = Sorting.MergeSort.sort(generateDescending(100000));
				randomM[i] = Sorting.MergeSort.sort(generateRandom(100000));
			}
			
			writer.write("Heap Sort - Array size 100,000:  " + "Sorted: " + median(sortedH)
			+ " Reverse: " + median(reverseH)
			+ " Random: " + median(randomH) + "\n");
			writer.write("Quick Sort - Array size 100,000:  " + "Sorted: " + median(sortedQ)
			+ " Reverse: " + median(reverseQ)
			+ " Random: " + median(randomQ) + "\n");
			writer.write("Merge Sort - Array size 100,000:  " + "Sorted: " + median(sortedM)
			+ " Reverse: " + median(reverseM)
			+ " Random: " + median(randomM) + "\n");
			
			for(int i = 0; i < 3; i++){
				sortedH[i] = Sorting.HeapSort.sort(generateAscending(1000000));
				reverseH[i] = Sorting.HeapSort.sort(generateDescending(1000000));
				randomH[i] = Sorting.HeapSort.sort(generateRandom(1000000));
				sortedQ[i] = Sorting.QuickSort.sort(generateAscending(1000000));
				reverseQ[i] = Sorting.QuickSort.sort(generateDescending(1000000));
				randomQ[i] = Sorting.QuickSort.sort(generateRandom(1000000));
				sortedM[i] = Sorting.MergeSort.sort(generateAscending(1000000));
				reverseM[i] = Sorting.MergeSort.sort(generateDescending(1000000));
				randomM[i] = Sorting.MergeSort.sort(generateRandom(1000000));
			}
			
			writer.write("Heap Sort - Array size 1,000,000:  " + "Sorted: " + median(sortedH)
			+ " Reverse: " + median(reverseH)
			+ " Random: " + median(randomH) + "\n");
			writer.write("Quick Sort - Array size 1,000,000:  " + "Sorted: " + median(sortedQ)
			+ " Reverse: " + median(reverseQ)
			+ " Random: " + median(randomQ) + "\n");
			writer.write("Merge Sort - Array size 1,000,000:  " + "Sorted: " + median(sortedM)
			+ " Reverse: " + median(reverseM)
			+ " Random: " + median(randomM) + "\n");
			writer.close();
		}
		catch(IOException exception){
			
		}
	}
}
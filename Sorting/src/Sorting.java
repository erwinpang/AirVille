
public class Sorting {
	
	public static class HeapSort{
		
		static int size;
		
		public static long sort(int[] arr){
			long time = System.nanoTime();
			buildHeap(arr);
			for(int i = size; i> 0; i--){
				swap(arr, 0, i);
				size = size - 1;
				sift(arr, 0);
			}
			return System.nanoTime() - time;
		}
		
		private static void buildHeap(int[] arr){
			size = arr.length -1;
			for(int i = size/2; i>= 0; i--){
					sift(arr,i);
			}
		}
		
		private static void sift(int[] arr, int i){
			int left = 2*i;
			int right = 2*i + 1;
			int max = i;
			if(left <= size && arr[left] > arr[i]){
				max = left;
			}
			if(right <= size && arr[right] > arr[max]){
				max = right;
			}
			if(max != i){
				swap(arr, i, max);
				sift(arr, max);
			}
		}

	}
	public static class QuickSort{
		private static int[] arr;
		private static int length;
		
		public static long sort(int[] arrIn){
			long time = System.nanoTime();
			arr = arrIn;
			length = arrIn.length -1;
			quickSort(0, length);
			return System.nanoTime() - time;
		}
		private static void quickSort(int lower, int upper){
			int i = lower;
			int j = upper;
			int pivot = arr[i + (j -i)/2];
			while(i <= j){
				while(arr[i] < pivot){
					i++;
				}
				while(arr[j] > pivot){
					j--;
				}
				if(i <= j){
					swap(arr, i, j);
					i++;
					j--;
				}
			}
			if (lower < j){
				quickSort(lower, j);
			}
			if(i < upper){
				quickSort(i, upper);
			}
		}
	}
	public static class MergeSort{
		private static void merge(int[] arr, int[] temp, int lower, int middle, int upper){
			for (int k = lower; k <= upper; k++){
				temp[k] = arr[k];
			}
			int i = lower;
			int j = middle + 1;
			for(int k = lower; k <= upper; k++){
				if(i > middle){
					arr[k] = temp[j++];
				}
				else if(j > upper){
					arr[k] = temp[i++];
				}
				else if(temp[j] < temp[i]){
					arr[k] = temp[j++];
				}
				else{
					arr[k] = temp[i++];
				}
			}
		}
		public static long sort(int[] arr){
			long time  = System.nanoTime();
			int length = arr.length;
			int[] temp =  new int[length];
			for(int i = 1; i < length; i += i){
	            for (int j = 0; j < length - i; j += i+i) {
	                int l = j;
	                int m  = j+i-1;
	                int h = Math.min(j+i+i-1, length-1);
	                merge(arr, temp, l, m, h);
	            }
			}
			return System.nanoTime() - time;
		}
	}
	public static void swap(int[] arr, int i, int j){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	public static void main(String[] args){
	}
}

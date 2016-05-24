import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reporting2 {
	public static void main(String[] args){
		String fileIn = args[0];
		StringBuilder str = new StringBuilder();
		try(BufferedReader br = new BufferedReader (new FileReader(fileIn))){
			String currentLine;
			while((currentLine = br.readLine()) != null){
				str.append(currentLine + " ");
			}
		}
		catch(IOException e){
			e.printStackTrace();
			return;
		}
		String strr = str.toString();
		String[] temp = strr.split(" ");
		int[] arr = new int[temp.length];
		for(int i = 0; i < temp.length; i++){
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		int[] arr2 = arr;
		int[] arr3 = arr;
		System.out.println("HS yxh364 = " + Sorting.HeapSort.sort(arr) + "ns; QS yxh364 = " + Sorting.QuickSort.sort(arr2) 
							+ "ns; MS yxh364 = " + Sorting.MergeSort.sort(arr3) + "ns");
		
	}
}

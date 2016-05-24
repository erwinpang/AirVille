import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WordCount {
	private static HashTable wordList;
	public static String[] words;
	
	
	public static void readText(String fileIn) throws IOException{
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
		String s = str.toString().toLowerCase();
		words = s.split("\\W");
	}
	
	public static String wordCount(String input_file, String output_file) throws IOException{
		readText(input_file);
		wordList = new HashTable();
		if(words == null){
			return "Input file error";
		}
		for (String s : words){
			wordList.put(s, 1);
		}
		String s = "OK; Total words: <" + wordList.getEntries() + "> Hash table size: <" + wordList.getTableSize() + 
					"> Average length of collision lists: <" + wordList.getCurrentLoad() + ">";
		PrintWriter wr = new PrintWriter("out.txt", "UTF-8");
		wr.print(wordList.toString());
		wr.close();
		return s;
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(wordCount("metamorphosis.txt","idk"));
	}
}

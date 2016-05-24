import java.util.LinkedList;
import java.util.ListIterator;

public class HashTable {
	
	public class HashEntry{
		private int value;
		private String key;
		private boolean removed;
		
		public HashEntry(String key, int value){
			this.key = key;
			this.value = value;
		}
		
		public int getValue(){
			return Integer.valueOf(this.value);
		}
		
		public String getKey(){
			String s = this.key;
			return s;
		}
		
		public void setValue(int value){
			this.value = value;
		}
		
	}
	
	private LinkedList<HashEntry>[] table;
	private int tableSize;
	private int numEntries;
	private double loadFactor = 0.75;
	
	//Constructs a HashTable with a default size of 1024
	public HashTable(){
		this.tableSize = 1024;
		this.table = new LinkedList[1024];
		for(int i = 0; i < 1024; i++){
			table[i] = new LinkedList<HashEntry>();
		}
	}
	
	//Constructs a HashTable of specified size
	public HashTable(int tableSize){
		this.tableSize = tableSize;
		this.table = new LinkedList[tableSize];
		for(int i = 0; i < tableSize; i++){
			table[i] = new LinkedList<HashEntry>();
		}
	}
	
	//Store key-value pair in hash table
	public void put(String key, int value){
		HashEntry hashEntry = new HashEntry(key, value);
		if(search(key) == -1){
			table[hash(key)].add(hashEntry);
			this.numEntries++;
		}
		else{
			update(key);
		}
		//Rehashes if load factor is exceeded
		if(getCurrentLoad() > loadFactor){
			rehash();
		}
	}
	
	//Increments the value of the key by 1
	public void update(String key){
		if(search(key) != -1){
			HashEntry he = table[hash(key)].get(search(key));
			he.setValue(he.getValue() + 1);
		}
		else{
			table[hash(key)].add(new HashEntry(key, 1));
		}
	}
	
	//Return the value associated with the key
	//or -1, if key DNE
	public int get(String key){
		int index = search(key);
		int value = table[hash(key)].get(index).getValue();
		return value;
	}
	
	//Resizes the table and recreates hashTable
	private void rehash(){
		System.out.println("Rehashing");
		LinkedList<HashEntry>[] newTable = new LinkedList[tableSize * 2];
		this.tableSize *= 2;
		for(int i = 0; i < newTable.length; i++){
			newTable[i] = new LinkedList<HashEntry>();
		}
		for(LinkedList l : table){
			ListIterator<HashEntry> itr = l.listIterator();
				while(itr.hasNext()){
					HashEntry he = itr.next();
					newTable[hash(he.getKey())].add(new HashEntry(he.getKey(), he.getValue()));
			}
		}
		table = newTable;
	}
	
	private int hash(String key){
		return Math.abs((key.hashCode() % this.tableSize));
	}
	
	//Returns index of key within bucket
	//-1 if key DNE
	public int search(String key){
		System.out.println(key + hash(key));
		ListIterator<HashEntry> itr = table[hash(key)].listIterator();
		int index = 0;
		while(itr.hasNext()){
			if (itr.next().getKey().equals(key)) return index;
			else index++;
		}
		return -1;
	}
	
	public int getEntries(){
		return this.numEntries;
	}
	
	public int getTableSize(){
		return this.tableSize;
	}
	
	public double getCurrentLoad(){
		return (double) this.numEntries / (double) this.tableSize;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(LinkedList l : table){
			ListIterator<HashEntry> itr = l.listIterator();
				while(itr.hasNext()){
					HashEntry he = itr.next();
					str.append("(" + he.getKey() + " " + he.getValue() + ")");
			}
		}
		return str.toString();
	}
}

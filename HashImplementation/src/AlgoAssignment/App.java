package AlgoAssignment;
import java.util.*;
public class App {
	private static String readfilename="F:/Jatin/Documents/Study/Algorithms/Pavlu/test.txt";
	private static String writefilename="F:/Jatin/Documents/Study/Algorithms/Pavlu/hash.txt";
	private static String[] data;
	static int m = 5000;
	static Hash hsh=new Hash();
	static TakeInput ti;
	//static ArrayList<Node> NodeList = new ArrayList<Node>();
	static Node[] hashtable = new Node[m];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Object to read data from different sources.
		//TakeInput ti=new UserInput();	
		ti=new FileOperations();
		data=ti.readFile(readfilename);	
		int val=1;
		String wrd;
		for(int i=0;i<data.length;i++){
			//System.out.println(data[i]);
			
				wrd=data[i];
				insertKey(wrd,val);
//				System.out.println("Indexing word: "+wrd+ ", at index: " +index);
//				if(hashtable[index]==null){ 					// if index is empty
//					hashtable[index] = new Node(wrd);
//				}else {
//					System.out.println("Calling chainKey for word: "+wrd+", at index: "+index);
//					chainKey(wrd,hashtable[index]);			// if index has one or more nodes
//				}
						
			
		}
		
		increase("businessah",10);
		//System.out.println(data.length);
		//Node n=hashtable[83];
		//Node n=hashtable[4605];
		Node n = hashtable[919];
		while(n!=null){
			System.out.println(n.key + " " + n.value);
			n=n.link;
		}
		
		int a=find("exporting");
		if(a != -1)
			System.out.println("Found at index : " + a);
		else
			System.out.println("Not found");
		
		//deleteKey("ebooks");
		//deleteKey("taking");
		deleteKey("exporting");
		System.out.println("After deleting");
		//n=hashtable[4605];
		//n=hashtable[83];
		n = hashtable[919];
		while(n!=null){
			System.out.println(n.key + " " + n.value);
			n=n.link;
		}
		a=find("exporting");
		if(a != -1)
			System.out.println("Found at index : " + a);
		else
			System.out.println("Not found");
		printHash(writefilename);
	}
	
	// this function will generate the index with the help of hash function and then add node at that index.
	public static void insertKey(String wrd,int val){   
		int  index;										  
		index=hsh.generateIndex(wrd);					 
		if(hashtable[index]==null){ 					// if index is empty
			hashtable[index] = new Node(wrd,val);
		}else {
			System.out.println("Calling chainKey for word: "+wrd+", at index: "+index);
			chainKey(wrd,hashtable[index]);			// if index has one or more nodes
		}
	}
	
	private static void chainKey(String k,Node n){ 		// add a new node if key is not present else update 
		boolean update=false;							// the count of node's value.
		Node p=n;
		while(n!=null && !update){
			if(n.key.equals(k)){
				n.value++;
				update=true;
			}
			p=n;
			n=n.link;
		}
		if(!update){									
			System.out.println("Adding a new node to this index for key: "+ k);
			p.link= new Node(k,1);
		}
	}
	
	
	
	public static void deleteKey(String key){
		int  index;
		index=hsh.generateIndex(key);
		if(hashtable[index]==null){ 					// if index is empty
			System.out.println("Er: Given key is not available in table.");
		}else {
				Node n=hashtable[index];
				Node p=n;
				boolean found=false;
				int i=0;
				while (n!= null && !found){
					if(n.key.equals(key)){
						if(i==0){
							System.out.println("Key: "+key+ " with value: "+ n.value +" has been deleted.");
							hashtable[index] = hashtable[index].link;							
						}else{
							p.link=n.link;
							System.out.println("Key: "+key+ " with value: "+ n.value +" has been deleted.");
						}
						found=true;
					}
					if(i>0){
						p=p.link;
					}
					n=n.link;
					i++;					
				}
				if(!found)
					System.out.println("Er: Given key is not available in table.");
		}
	}
	
	// function to increase the value of the key
	public static void increase(String key,int value){
		int index=find(key);
		if(index!=-1){
			Node n=hashtable[index];
			//System.out.println(n.key);
			while (!n.key.equals(key))
				n=n.link;
			
			if(n.value < value){
				System.out.println("Given key value has been changed from "+ n.value + " to "+ value);
				n.value=value;
			}				
			else
				System.out.println("Er: Given key value is not greater than the current value.");
			//deleteKey(key);
			//insertKey(key,value);
		}else{
			System.out.println("Er: Given key is not found");
		}
		
	}
	
	public static int find(String key){					// will return index of table
		int  index;
		int val=-1;
		index=hsh.generateIndex(key);
		if(hashtable[index]==null){ 					// if index is empty
			System.out.println("Er: Given key is not available in table.");
		}else {
			Node n=hashtable[index];
			boolean found=false;
			
			while (n!= null && !found){
				if(n.key.equals(key)){
					val=index;								
					System.out.println("Key: "+key+ " with value: "+ n.value +" is found.");
					found=true;
				}
				n=n.link;
			}			
		}
		return val;
	}
	
	public static void printHash(String filename){
		String str="";
		FileOperations fileops = new FileOperations();
		for(int i=0;i<m;i++){
			if(hashtable[i]!= null){
				Node n=hashtable[i];
				while(n.link != null){
					str += n.key + ","+ n.value + ",";
					n=n.link;
				}
				str +=n.key + ","+ n.value + "\n";
			}
		}
		fileops.writeFile(filename,str);
	}
	
}

package AlgoAssignment;

public class Hash {
	private int m = 5000;
	int generateIndex(String str){
		int index;
		char[] s;
		s=stringToArray(str);
		int i=0,j=i+1,sum=0,ascii;
		while(i<s.length){
			ascii=(int)s[i];
			sum += ascii * (j*j);
			i=j;
			j=i+1;
		}
		index = sum % m;
		return index;
	}
	private char[] stringToArray(String str){
		char[] s = str.toCharArray();
		return s;
	}
}

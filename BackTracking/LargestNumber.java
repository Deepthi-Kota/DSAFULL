import java.util.*;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine().trim();
        int k = sc.nextInt();
        
        System.out.println(findMaximumNum(n, k));
        sc.close();

    }
    static String maxi;
    public static String findMaximumNum(String s, int k) {
        maxi = s;
		find(new StringBuilder(s),k);
		return maxi;
    }
    static void find(StringBuilder s, int k){
		if(k==0){
			return;
		}
		
		for(int i=0; i<s.length(); i++){
		    for(int j=i+1; j<s.length(); j++){
		        if(s.charAt(j)>s.charAt(i)){
		            swap(s,i,j);
		            if(s.toString().compareTo(maxi)>0){
            			maxi = s.toString();
            		}
    				
    				find(s,k-1);
    				swap(s,i,j);
    			}
		    }
			
		}
	}
	static void swap(StringBuilder s, int i, int j){
		char temp = s.charAt(i);
		s.setCharAt(i,s.charAt(j));
		s.setCharAt(j,temp);
	}

}

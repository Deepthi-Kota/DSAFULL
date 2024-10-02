package BinarySearch;
import java.util.*;
public class Sorted2D {
    
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int t = sc.nextInt();
            int[] ans = search(arr,t);
            System.out.println(Arrays.toString(ans));
            sc.close();
        }
        static int[] search(int[][] arr, int t){
            int s = 0;
            int e = arr.length-1;
            int mid = s+(e-s)/2;
            if(s+1==e){
                int a = bs(arr[s],t);
                int b = bs(arr[e],t);
                System.out.println(a+" "+b);
                if(a>=0){
                    int[] ans = new int[2];
                    ans[0]=s;
                    ans[1]=a;
                    return ans;
                }
                int[] ans = new int[2];
                ans[0]=e;
                ans[1]=a;
                return ans;
            }
            if(arr[mid][0]>t && arr[s][0]<t){
                e=mid-1;
            } else{
                s=mid;
            }
            return new int[0];
        }
        static int bs(int[] arr, int t){
            int s = 0;
            int e = arr.length;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid]==t){
                    return mid;
                } else if(arr[mid]<t){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
            return -1;
        }
    }

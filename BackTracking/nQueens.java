import java.util.*;
public class nQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] placed = new boolean[n][n];
        int[][] arr = new int[n][n];
        System.out.println(check(n,0,placed,arr));
        int[][] arr2 = new int[n][n];
        boolean[][] placed2 = new boolean[n][n];
        System.out.println(counter(n,0,placed2,arr2));
    }
    
    static boolean check(int n, int row, boolean[][] placed, int[][] arr){
        if(row==n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }
        for(int i=0; i<n; i++){
            if(placable(row, i,placed)){
                placed[row][i]=true;
                arr[row][i]=1;
                // System.out.println(i+" "+row);
                if(check(n,row+1,placed,arr)){
                    return true;
                }
                
            }
            placed[row][i]=false;
            arr[row][i]=0;
            
        }
        return false;

    }

    static int counter(int n, int row, boolean[][] placed, int[][] arr){
        if(row==n){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return 1;
        }
        int count = 0;

        for(int i=0; i<n; i++){
            if(placable(row, i, placed)){
                placed[row][i]=true;
                arr[row][i]=1;
                count += counter(n, row+1, placed, arr);
                placed[row][i]=false;
                arr[row][i]=0;
            }
        }
        return count;
    }

    static boolean placable(int i, int j, boolean[][] placed){
        int r = i;
        int c = j;
        while(r>=0){
            if(placed[r][c]){
                return false;
            }
            r--;
        }
        r=i-1;
        c=j-1;
        while(r>=0 && c>=0){
            if(placed[r][c]){
                return false;
            }
            r--;
            c--;
        }
        r=i-1;
        c=j+1;
        while(r>=0 && c<placed[0].length){
            if(placed[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}

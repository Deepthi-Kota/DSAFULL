import java.util.*;
public class nKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] placed = new boolean[n][n];
        check(0,0,n,placed);
        
    }
    static void check(int row, int col, int n, boolean[][] arr){
        if(n==0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[i][j] ? "K " : "O ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if(row==arr.length-1 && col==arr.length){
            return;
        }
        if(col == arr.length){
            check(row+1,0,n,arr);
            return;
        }
        if(isSafe(row,col,arr)){
            arr[row][col]=true;
            check(row,col+1, n-1,arr);
            arr[row][col]=false;
        }
        check(row,col+1,n,arr);
    }
    static boolean isSafe(int row, int col, boolean[][] arr){
        if(isValid(row-2, col-1, arr)){
            if(arr[row-2][col-1]){
                return false;
            }
        }
        if(isValid(row-1, col-2, arr)){
            if(arr[row-1][col-2]){
                return false;
            }
        }
        if(isValid(row-1, col+2, arr)){
            if(arr[row-1][col+2]){
                return false;
            }
        }
        if(isValid(row-2, col+1, arr)){
            if(arr[row-2][col+1]){
                return false;
            }
        }
        return true;

    }

    static boolean isValid(int row, int col, boolean[][] arr){
        return row>=0 && col<arr.length && col>=0 && col<arr.length;
    }
}

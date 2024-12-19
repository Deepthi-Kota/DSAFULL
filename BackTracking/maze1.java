public class maze1 {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };
        int[][] arr = new int[3][3];
        allpath("", arr,board, 0, 0, 1);
    }
    static void allpath(String p, int[][] arr,boolean[][] vis, int r, int c, int step){
        if(r==arr.length-1 && c==arr.length-1){
            arr[r][c]=step;
            System.out.println(p);
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }
        if(!vis[r][c]){
            return;
        }
        vis[r][c]=false;
        arr[r][c]=step;
        if(r<arr.length-1){
            allpath(p+'D', arr,vis, r+1, c, step+1); //down
        }
        if(r>0){
            allpath(p+'U', arr,vis, r-1, c, step+1); //up
        }
        if(c<arr[0].length-1){
            allpath(p+'R', arr,vis, r, c+1, step+1); //right
        }
        if(c>0){
            allpath(p+'L', arr,vis, r, c-1,step+1); //left
        }
        vis[r][c]=true;
        arr[r][c]=0;
    } 
}

import java.util.*;
public class maze {
    public static void main(String[] args) {
        System.out.println(find(3,3));  
        List<String> list = new ArrayList<>();
        find("",3,3,list);
        System.out.println(list);     
        System.out.println(finddiag(3, 3));
        List<String> list2 = new ArrayList<>();
        finddig("",3,3,list2);
        System.out.println(list2); 
        boolean[][] maze ={
            {true, true, true},
            {true, false, true},
            {true, true, true},
        };
        pathRestriction("", maze, 0, 0);
    }    
    static int find(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int l = find(r-1,c);
        int right = find(r,c-1);
        return l+right;
    }
    static void find(String p, int r, int c, List<String> list){
        if(r==1 && c==1){
            list.add(p);
        }
        if(r>1){
            find(p+'d',r-1,c,list);
        }
        if(c>1){
            find(p+'r',r,c-1,list);
        }
    }
    static int finddiag(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int l = find(r-1,c);
        int right = find(r,c-1);
        int diag = 0;
        if(r>1 && c>1){
            diag = find(r-1, c-1);
        }
        return l+right+diag;
    }
    static void finddig(String p, int r, int c, List<String> list){
        if(r==1 && c==1){
            list.add(p);
        }
        if(r>1){
            finddig(p+'s',r-1,c,list);
        }
        if(c>1){
            finddig(p+'e',r,c-1,list);
        }
        if(r>1 && c>1){
            finddig(p+"B",r-1,c-1,list);
        }
    }
    static void pathRestriction(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestriction(p+'D', maze, r+1, c);
        }
        if(c<maze.length-1){
            pathRestriction(p+'R', maze, r, c+1);
        }
    }
}

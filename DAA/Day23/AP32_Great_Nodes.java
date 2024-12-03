package DAA.Day23;
/* c Given a binary tree root, a node X in the tree is named Great if in the path 
from root to X there are no nodes with a value greater than or equals X.

Return the number of Great nodes in the binary tree.

You will be given root node of a binary tree return total number of nodes which satisfies above statement.

Input format: 
-------------
Line-1: Space seperated integers

Output format:
---------------
Line-1: An integer

Sample Input-1:
---------------
3 1 4 3 -1 1 5

Sample Output-1:
----------------
4

Explanation: 
Root Node (3) is always a Great node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Sample Input-2:
---------------
3 5 1 6 2 9 8 -1 -1 7 4

Sample Output-2:
----------------
6*/
public class AP32_Great_Nodes {
    
}
import java.util.*;

class BinaryTreeNode 
{
    public Integer data;
    public BinaryTreeNode left, right;
    public BinaryTreeNode(Integer data) 
    {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {
    int c = 0;
    public int greatNodes(BinaryTreeNode root) {
        //Write your code here
        dfs(root,root.data);
        return c;
    }

    //Your supporting methods(if any) goes here
    public void dfs(BinaryTreeNode node, int great){
        if(node==null || node.data==-1){
            return;
        }
        if(node.data>=great){
            great = node.data;
            c++;
        }
        dfs(node.left, great);
        dfs(node.right,great);
    }
}

class BTree {
    static BinaryTreeNode root;

    void insert(BinaryTreeNode temp, Integer key) {
        if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(temp);
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.left == null) {
                if (key != null && key != -1) {
                    temp.left = new BinaryTreeNode(key);
                }
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                if (key != null && key != -1) {
                    temp.right = new BinaryTreeNode(key);
                }
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        BTree tree = new BTree();
        BinaryTreeNode root1 = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++) 
            tree.insert(root1, Integer.parseInt(str[i]));
        Solution sol = new Solution();
        System.out.println(sol.greatNodes(root1));
    }
}

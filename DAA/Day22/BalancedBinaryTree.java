package DAA.Day22;
/*Mr. Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Mr. Anil to check whether BT is a balanced BT or not.
A balanced BT is defined as follows:
    - The binary tree in which the left and right subtrees of every node 
    differ in height by no more than 1.

Can you help Mr. Anil to find and return "true" if the given BT is a balanced tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

NOTE:
    - In the tree '-1', indicates empty(null).
   
Input Format:
-------------
Line-1: Space separated integers, values at the treenode

Output Format:
--------------
Line-1: A boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false */
public class SP30_Balanced_Binary_Tree {
    
}
import java.util.*;

class BinaryTreeNode
{
    public int data; 
    public BinaryTreeNode left, right; 
    public BinaryTreeNode(int data)
    {
        this.data = data; 
        left = null; 
        right = null; 
    }
}

class Solution 
{
    public boolean isBalanced(BinaryTreeNode root) 
    {
        //Write your code here and return a boolean value
        if(root==null || root.data==-1){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int l = height(root.left, 0);
        int r = height(root.right, 0);
        return Math.abs(l-r)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(BinaryTreeNode node, int h){
        if(node==null || node.data==-1){
            return h;
        }
        int l = height(node.left, h+1);
        int r = height(node.right, h+1);
        return Math.max(l,r);
    }

    //Your supporting methods(if any) goes here
}

public class BalancedBinaryTree
{
    static BinaryTreeNode root;
    void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) 
        {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();
 
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        BalancedBinaryTree ln=new BalancedBinaryTree();
        Solution sol= new Solution();
        
        String str[]=sc.nextLine().split(" ");
        root=new BinaryTreeNode(Integer.parseInt(str[0]));
        for(int i=1; i<str.length; i++)
            ln.insert(root,Integer.parseInt(str[i]));

        System.out.println(sol.isBalanced(root));
    }
}

package PreFs.Day42;
/* For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
    - The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
      so on.
    - At level-1: There will be only one bulb as root bulb.,
    - From next level onwards, we can attach atmost two bulbs, one is to left side
      and/or the other is to right side of every bulb in previous level.
    
Entire X-Mas tree has to be prepared with certian rules as follows:
    - For every even level in the X-Mas Tree, all the bulbs should have
      odd voltages in strictly ascending order.
    - For every odd level in the X-Mas Tree, all the bulbs should have
      even voltages in strictly descending order.
    
You will be given the X-Mas Tree root,
Your task is to findout whether the X-Mas tree is prepared as per the rules
or not.

Implement the class Solution.
1.public boolean isXmasTree(Node root): returns a boolean value.

NOTE:
    '-1' in the input is to indicate NULL values.


Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3 8 4 3 5 -1 7 

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 8 4 3 5 7 7 

Sample Output-2:
----------------
false


Sample Input-3:
---------------
1

Sample Output-3:
----------------
true
*/

import java.util.*;


// Sample Binary Tree Node structure for reference
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}


class p1 {
    public boolean isXmasTree(Node root) {
        if (root == null || root.data == -1) {
            return true; 
        }
        List<List<Integer>> ans = new ArrayList<>();
        find(root, ans);
        return check(ans);
    }

    void find(Node root, List<List<Integer>> ans) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (n != null) {
                    list.add(n.data);
                    if (n.left != null && n.left.data != -1) {
                        q.add(n.left);
                    }
                    if (n.right != null && n.right.data != -1) {
                        q.add(n.right);
                    }
                }
            }
            ans.add(list);
        }
    }

    boolean check(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) { 
                if (!isOddAndAsc(arr.get(i))) {
                    return false;
                }
            } else { 
                if (!isEvenAndDesc(arr.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isOddAndAsc(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                return false;
            }
            if (i > 0 && arr.get(i) <= arr.get(i - 1)) {
                return false; 
            }
        }
        return true;
    }

    boolean isEvenAndDesc(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 != 0) {
                return false;
            }
            if (i > 0 && arr.get(i) >= arr.get(i - 1)) {
                return false; 
            }
        }
        return true;
    }
}

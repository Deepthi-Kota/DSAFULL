package BT;

import java.util.*;
public class BFS {
    public class node{
        int value;
        node left;
        node right;
        node(int value){
            this.value=value;
        }
    }
    public BFS(){

    }
    private node root;

    public void insert(int value){
        root = insert(value,root);
    }
    private node insert(int value, node node){
        if(node == null){
            node = new node(value);
            return node;
        }
        if(value<node.value){
            node.left = insert(value, node.left);
        }
        if(value>node.value){
            node.right = insert(value, node.right);
        }
        return node;
    }
    public void display(){
        levelOrder(root);
    }
    private void levelOrder(node node){
        if(node==null){
            return;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        // System.out.println(node.value);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0; i<levelSize; i++){
                node curr = q.poll();
                System.out.println(curr.value);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }

        }
    }

    public node successor(int key){
        return successor(root, key);
    }
    private node successor(node node, int key){
        if(node==null){
            return null;
        }
        Queue<node> q = new LinkedList<>();
        q.add(root);
        // System.out.println(node.value);
        while(!q.isEmpty()){
            node curr = q.poll();
            System.out.println(curr.value);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
            if(curr.value == key){
                break;
            }
        }
        return q.peek();
    }
    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            this.insert(nums[i]);
        }
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums);
        tree.display();
        System.out.println("Succesor of " + 6 +" is " +tree.successor(6).value);
    }
}

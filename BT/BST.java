package BT;

public class BST {
    public class node{
        private int value;
        private int height;
        private node left;
        private node right;

        public node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
    private node root;
    public BST(){

    }
    public int height(node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }
    public void display(){
        display(root, "Root Node: ");
    }
    private void display(node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "left child of "+node.getValue()+" : ");
        display(node.right, "right child of "+node.getValue()+" : ");
    }

    public void insert(int value){
        root = insert(value, root);
    }
    private node insert(int value, node node){
        if(node == null){
            node = new node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) +1 ;
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            this.insert(nums[i]);
        }
    }
    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }
    private void populateSorted(int[] nums, int start, int end){
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        tree.populate(nums);
        tree.display();
        int[] numssorted = {1,2,3,4,5,6,7,8,9,10};
        tree.populateSorted(numssorted);
        tree.display();
    }
}

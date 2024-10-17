public class SLL { 

    private Node head;
    private Node tail;
    private int size;
    public SLL(){
        this.size = 0;
    } 
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        } 
        Node node = new Node(val);
        tail.next=node;
        tail=node; 
        size+=1;         
    }

    public void insertAt(int val, int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++;
    }

    public int delFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    public int delLast(){
        if(size<=1){
            return delFirst();
        }
        Node secondlast = get(size-2);
        int val = tail.value;
        tail = secondlast;
        tail.next = null;
        return val;
    }

    public int delAt(int index){
        if(index==0){
            return delFirst();
        }
        if(index == size -1){
            return delLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println("END");

    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SLL ll = new SLL();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        ll.insertFirst(4);
        // ll.display();
        ll.insertLast(5);
        // ll.display();
        ll.insertAt(100, 3);
        ll.display();
        System.out.println(ll.delFirst());
        ll.display();
        System.out.println(ll.delLast());
        ll.display();
        System.out.println(ll.delAt(2));
        ll.display();
        
    }
}

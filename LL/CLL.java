import org.w3c.dom.Node;

public class CLL {

    private Node head;
    private Node tail;

    public CLL(){
        this.head = null;
        this.tail = null;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void del(int val){
        Node node = head;
        if(node==null){
            return;
        }
        if(node.val == val){
            head = head.next;
            tail.next = head;
        }
        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                break;
            }
            node=node.next;
        }while(node!=head);
    }

    public void display(){
        Node node = head;
        if(head !=null){
            do{
                System.out.print(node.val+ " -> ");
                node = node.next;
            } while(node!=head);
            System.out.println("end");
        }
    }

    private class Node{
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        CLL ll = new CLL();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.display();
        ll.del(3);
        ll.display();
    }
}

public class DLL {
    Node head;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }
        while(last.next != null){
            last=last.next;
        }
        last.next = node;
        node.prev = last;

    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }

    public void displayrev(){
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.prev;
        }
        System.out.println("head");
    }

    public void insertAt(int val, int index){
        Node prev = find(index);
        if(prev==null){
            System.out.println("dne");
            return;
        }
        Node node = new Node(val);
        node.next =prev.next;
        prev.next = node;
        node.prev = prev;
        if(node.next!=null){
            node.next.prev = node;
        }
    }

    public Node find(int val){
        Node node = head;
        while(node!=null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }
        // public Node(int val, Node next, Node prev){
        //     this.val = val;
        //     this.prev = prev;
        //     this.next = next;
        // }

    }

    public static void main(String[] args) {
        DLL ll = new DLL();
        ll.insertFirst(1);
        ll.insertFirst(2);
        ll.insertFirst(3);
        // ll.display();
        // ll.displayrev();
        ll.insertLast(4);
        // ll.display();
        ll.insertAt(100, 2);
        ll.display();
    }
}

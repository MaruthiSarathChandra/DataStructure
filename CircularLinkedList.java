public class circularLL {
    Node head;
    Node tail_next;
    class Node {
        int key;
        Node next;
        Node(int data){
            this.key = data;
            this.next = null;
        }
    }

    public void insert(int data) {
        Node new_node = new Node(data);
        if(head == null) {
            head = new_node;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            new_node.next = head;
            temp.next = new_node;
            tail_next = new_node;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        } else {
            System.out.print(head.key+"--->");
            Node temp = head.next;
            while(temp != head) {
                System.out.print(temp.key+"--->");
                temp = temp.next;
            }
        }
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            Node temp = head;
            Node rec = null;
            while(temp.key != data) {
                rec = temp;
                temp = temp.next;
            }
            if(rec == null) {
                if (temp.next == head) {
                    head = null;
                    tail_next = null;
                } else {
                    head = temp.next;
                    tail_next.next = head;
                }
            } else {
                if (temp.next == head) {
                    rec.next = head;
                    tail_next = rec;
                } else {
                    rec.next = temp.next;
                }
            }
            temp = null;
        }
    }
    public void add_beginning(int data){
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            head.next = head;
            tail_next = head;
        } else {
            if (head.next == head) {
                new_node.next = head;
                head.next = new_node;
                head = new_node;
            } else {
                new_node.next = head;
                head = new_node;
                tail_next.next = head;
            }
        }
    }

    public static void main(String[] args) {
        circularLL obj = new circularLL();
        Integer[] arr = {7,2,5,15,2,4,6,72,9};
        for(int i:arr) {
            obj.insert(i);
        }
        obj.display();
        System.out.println("");
        obj.add_beginning(1);
        obj.delete(2);
        obj.delete(9);
        obj.display();
    }
}

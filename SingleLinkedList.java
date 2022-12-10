public class LL {
    Node head;
    class Node{
        String key;
        Node next;
        Node(String data){
            this.key = data;
            this.next = null;
        }
    }
    public void Insert(String data){
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            System.out.println(newNode.key + "elements is inserted");
            return;

        }

    }
    public void addFirst(String data){
        Node obj = new Node(data);
        if (head == null) {
            head = obj;
        } else{
            obj.next = head;
            head = obj;
        }
    }
    public void deletes(String data){
        if(head == null) {
            System.out.println("List is Empty");return;
        } else if(data == head.key){
            Node h = head;
            head = head.next;
            h = null;
            return;
        } else {
            Node node = head;
            while(node.next.key != data){
                node = node.next;
            }
            Node ne = node.next;
            node.next = node.next.next;
            ne = null;
            return;
        }
    }
    public void printList(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.print(current.key + "-->");
            current = current.next;
        }
    }
    public static void main(String args[]){
        LL list = new LL();
    }
}

public class DLL {
    Node head;
    class Node{
        Node prev;
        String key;
        Node next;
        Node(String data){
            this.prev = null;
            this.key = data;
            this.next = null;
        }
    }
    public void insert(String data){
        Node new_node = new Node(data);
        if(head == null) {
            head = new_node;
        } else {
            Node current_last_node = head;
            while(current_last_node.next != null){
                current_last_node = current_last_node.next;
            }current_last_node.next = new_node;
            new_node.prev = current_last_node;
            //head = new_node;  //if u need to use printFromBackSide method just remove comment indexations at starting
        }
    }

    public void Delete(String data){
        if(head == null) {
            System.out.println("LinkedList");
        }else if(head.key == data){
            Node del_node = head;
            head.next.prev= null;
            head = head.next;
            del_node = null;
        }else {
            Node current = head;
            while(current.next.key != data){
                current = current.next;
            }
            current.next.prev = null;
            current.next.key = null;
            Node del_node = current.next;
            current.next = current.next.next;
            del_node = null;
        }
    }

    public void print(){
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node current_node = head;
        while(current_node != null){
            System.out.print(current_node.key+"--->");
            current_node = current_node.next;
        }
    }
    // THIS printFromBackSide is print linkedlist in reverse order. By this u can understand any node know its prev and next node.By this we can decrease the time complexity when it is
    // used at different situations like if we used Doublelinkedlist in place of list in Insertion Sorting algorithm.
    public void printFromBackSide(){ // if u want use this method u can free line 23 as comment and then u can use
        if(head == null){
            System.out.println("List is Empty");
        }else{
            Node current_node = head;
            while (current_node != null){
                System.out.print(current_node.key+"--->");
                current_node = current_node.prev;
            }
        }
    }
    public static void main(String args[]){
        DLL list = new DLL();
        list.insert("Double");
        list.insert("Linked");
        list.insert("List");
        list.Delete("Linked");
        list.print();
    }
}

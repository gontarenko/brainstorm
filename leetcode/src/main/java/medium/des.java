package medium;

public class des {


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
        // [[],[1],[3],[1,2],[1],[0],[0]]
        myLinkedList.addAtHead(1); // [1]
        myLinkedList.addAtTail(3); // [1, 3]
        myLinkedList.addAtIndex(1,2); // [1,2,3]
        int i = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(0);
        int i1 = myLinkedList.get(0);

//        //["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
//        //[[],[0,10],[0,20],[1,30],[0]]
//
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtIndex(0,10);
//        myLinkedList.addAtIndex(0,20);
//        myLinkedList.addAtIndex(1,30);
//        int i = myLinkedList.get(0);
//        System.out.println();

//        // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//        // [[],[1],[3],[1,2],[1],[1],[1]]
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead();
//        myLinkedList.addAtTail();
//        myLinkedList.addAtIndex();
//        myLinkedList.get();
//        myLinkedList.addAtIndex();
    }
}

class MyLinkedList {
    class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        var node = getAtIndex(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (head == null) {
            head = newHead;
            tail = newHead;
        } else {
            if (size == 1) {
                head = newHead;
                head.next = tail;
                tail.prev = head;
            } else {
                newHead.next = head;
                head.prev = newHead;
                head = newHead;
            }
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (tail == null) {
            head = newTail;
            tail = newTail;
        } else {
            if (size == 1) {
                tail = newTail;
                head.next = tail;
                tail.prev = head;
            } else {
                newTail.prev = tail;
                tail.next = newTail;
                tail = newTail;
            }
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (index < 0 || index > size ) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node nodeAtIndex = getAtIndex(index);
        Node prev = nodeAtIndex.prev;
        prev.next = newNode;
        nodeAtIndex.prev = newNode;
        newNode.prev = prev;
        newNode.next = nodeAtIndex;
        size++;
    }

    private Node getAtIndex(int index) {
        if (index < 0) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        Node nodeAtIndex = head;
        for (int i = 1; i <= index; i++) {
            nodeAtIndex = nodeAtIndex.next;
        }
        return nodeAtIndex;
    }

    public void deleteAtIndex(int index) {
        Node nodeAtIndex = getAtIndex(index);
        if (nodeAtIndex == null) {
            return;
        }
        Node prev = nodeAtIndex.prev;
        Node next = nodeAtIndex.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        if (index == 0) {
            head = next;
        }
        if (index == size - 1) {
            tail = prev;
        }
        size--;
    }

    @Override
    public String toString() {
        String s = "[";
        Node curr = head;
        if (curr != null) {
            s += curr.val;
            s += ",";
        }
        for (int i = 1; i < size; i++) {
            curr = curr.next;
            if (curr != null) {
                s += curr.val;
                s += ",";
            }
        }
        return s + "]";
    }
}

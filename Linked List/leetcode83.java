// DESCRIPTION


// 83. Remove Duplicates from Sorted List

// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
// Return the linked list sorted as well.



import java.util.*;

public class leetcode83 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        linkedlist ll = new linkedlist();
        
        System.out.println("Enter numbers (-1 to stop):");
        while (true) {
            int num = sc.nextInt();
            if (num == -1) break;
            ll.insert(num);
        }
        System.out.println("Before Deletion of Duplicates");
        ll.print();
        System.out.println("After deletion of duplicates");
        ll.deleteDuplicates();
        ll.print();

    }
}

class linkedlist {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    Node head = null;
    
    void insert(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }
    
    void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    void deleteDuplicates(){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
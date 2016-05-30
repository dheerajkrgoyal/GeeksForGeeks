package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class LengthOfLinkedList
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("list: ");
        list.printList();
        System.out.println("length of linked list: " + iterativeLengthOfLinkedList( list.getHead() ));
        System.out.println("length of linked list: " + recursiveLengthOfLinkedList( list.getHead() ));
    }

    public static int iterativeLengthOfLinkedList(Node head){
        if(head == null){
            return 0;
        }
        Node current = head;
        int length = 0;
        while(current != null){
            length += 1;
            current = current.getNext();
        }
        return length;
    }

    public static int recursiveLengthOfLinkedList(Node head){
        if(head == null){
            return 0;
        }
        return 1 + recursiveLengthOfLinkedList( head.getNext() );
    }
}

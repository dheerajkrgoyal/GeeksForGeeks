package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 16/5/16.
 */
public class InsertInSortedLinkedList
{
    public static void main( String[] args )
    {
        LinkedList<Integer> sortedList = new LinkedList<Integer>( new Integer[] { 3, 7, 13, 17, 18 } );
        System.out.println("list");
        sortedList.printList();
        sortedList.setHead(insertInSortedList(sortedList.getHead(), 12));
        System.out.println("list after inserting 12 :");
        sortedList.printList();
        sortedList.setHead( insertInSortedList( sortedList.getHead(),1 ) );
        System.out.println("list after inserting 1:");
        sortedList.printList();
        sortedList.setHead( insertInSortedList( sortedList.getHead(), 20 ) );
        System.out.println("list after inserting 20:");
        sortedList.printList();
    }

    public static Node insertInSortedList(Node head , int data){
        Node nodeToInsert = new Node( data );
        if(head == null){
            return nodeToInsert;
        }
        if(data < (Integer) head.getData()){
            nodeToInsert.setNext( head );
            return nodeToInsert;
        }
        Node current = head.getNext();
        Node prev = head;
        while(current != null){
            if(data < (Integer) current.getData()){
                nodeToInsert.setNext( prev.getNext() );
                prev.setNext( nodeToInsert );
                return head;
            }
            prev = current;
            current = current.getNext();
        }
        prev.setNext( nodeToInsert );
        return head;
    }
}

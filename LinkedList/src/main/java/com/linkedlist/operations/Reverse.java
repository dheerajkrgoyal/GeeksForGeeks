package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class Reverse
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list =LinkedList.getDefaultIntegerList();
        System.out.println("list:");
        list.printList();
        list.setHead( iterativeReverseList( list.getHead() ) );
        System.out.println("Reverse list:");
        list.printList();
//        list.setHead( recursiveReverseList( list.getHead() ) );
//        System.out.println("Reverse list:");
//        list.printList();
    }

    public static Node iterativeReverseList(Node head) throws Exception{
        if(head == null){
            throw new Exception( "list is empty" );
        }
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.getNext();
            current.setNext( prev );
            prev = current;
            current = next;
        }
        return prev;
    }

//    public static Node recursiveReverseList(Node head, Node prev) throws Exception{
//        Node current = head;
//        if(current == null){
//            return prev;
//        }
//
//        return recursiveReverseList(  )
//    }
}

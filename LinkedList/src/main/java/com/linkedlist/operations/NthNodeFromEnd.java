package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class NthNodeFromEnd
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("list:");
        list.printList();
        System.out.println("3rd from end: " + getNthNodeFromEnd( list.getHead(),3 ).getData());
        System.out.println("6th from end: " + getNthNodeFromEnd( list.getHead(),6 ).getData());
        System.out.println("1st from end: " + getNthNodeFromEnd( list.getHead(),1 ).getData());
        getNthNodeFromEnd( list.getHead(), 8 );
    }

    private static Node getNthNodeFromEnd(Node head, int n) throws Exception{
        if(head == null){
            throw new Exception( "list is empty" );
        }
        Node current = head;
        Node nAhead = head;
        int i= 1;
        while(i <= n){
            if(nAhead == null){
                throw new Exception( "n is greater than length of the list" );
            }
            nAhead = nAhead.getNext();
            i++;
        }
        while ( nAhead != null ){
            current = current.getNext();
            nAhead = nAhead.getNext();
        }
        return current;
    }
}

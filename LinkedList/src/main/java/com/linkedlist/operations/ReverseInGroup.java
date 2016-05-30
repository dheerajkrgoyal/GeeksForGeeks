package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 21/5/16.
 */
public class ReverseInGroup
{
    public static void main( String[] args )
    {
        LinkedList list = LinkedList.getDefaultIntegerList();
        Insertion.append( list.getHead(), 15 );
        Insertion.append( list.getHead(), 8 );
        Insertion.append( list.getHead(), 25 );
        Insertion.append( list.getHead(), 17 );
        Insertion.append( list.getHead(), 4 );
        Insertion.append( list.getHead(), 99 );
        Insertion.append( list.getHead(), 87 );
        Insertion.append( list.getHead(), 60 );
        System.out.println( "list:" );
        list.printList();
        list.setHead( reverseInAlternateGroup( list.getHead(), 3 ) );
        System.out.println( "list after reverse:" );
        list.printList();
    }


    public static Node reverseInGroup( Node head, int groupSize )
    {
        if ( head == null ) {
            return null;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0 ;
        while ( current != null && count < groupSize ) {
                next = current.getNext();
                current.setNext( prev );
                prev = current;
                current = next;
                count++;
        }
        head.setNext( reverseInGroup( current, groupSize ) );
        return prev;
    }

    public static Node reverseInAlternateGroup(Node head, int groupSize){
        if(head == null){
            return null;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;

        while ( current != null && count < groupSize ) {
            next = current.getNext();
            current.setNext( prev );
            prev = current;
            current = next;
            count++;
        }
        head.setNext( current );
        count = 0;
        Node previous = null;
        while(count < groupSize && current!= null){
            previous = current;
            current = current.getNext();
            count++;
        }
        if(current != null)
            previous.setNext( reverseInAlternateGroup( current, groupSize ) );

        return prev;

    }
}

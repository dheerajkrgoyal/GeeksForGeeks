package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 22/5/16.
 */
public class SegregateEvenOdd
{
    public static void main( String[] args )
    {
        LinkedList list = LinkedList.getDefaultIntegerList();
        Insertion.append( list.getHead(), 8 );
        Insertion.append( list.getHead(),10 );
        System.out.println("list:"); list.printList();
        list.setHead( segregateOddEven(list.getHead()) );
        System.out.println("list:"); list.printList();
    }

    public static Node segregateOddEven(Node head){
        if(head == null){
            return null;
        }
        Node end = head;
        while(end.getNext() != null){
            end = end.getNext();
        }
        Node newEnd = end;
        Node prev = null;
        Node current = head ;
        while ( current != end ) {
            if ( (Integer) current.getData() % 2 != 0 ) {
                if ( current == head ) {
                    Node temp = head;
                    head = head.getNext();
                    temp.setNext( null );
                    newEnd.setNext( temp );
                    newEnd = newEnd.getNext();
                    current = head;
                } else {
                    Node toDelete = current;
                    prev.setNext( toDelete.getNext() );
                    toDelete.setNext( null );
                    newEnd.setNext( toDelete );
                    newEnd = newEnd.getNext();
                    current = prev.getNext();
                }
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        if((Integer)current.getData()%2 != 0){
            if(current != head){
                prev.setNext( current.getNext() );
            }
            else{
                head = current.getNext();
            }
            newEnd.setNext( current );
            current.setNext( null );
        }
        return head;
    }
}

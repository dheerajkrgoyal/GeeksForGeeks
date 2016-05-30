package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class Deletion
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println( "Initial linked list:" );
        list.printList();
        list.setHead( deleteFirstKey( list.getHead(), 7 ) );
        System.out.println( "Deleted node 7 from list:" );
        list.printList();
        list.setHead( deleteFirstKey( list.getHead(), 5 ) );
        System.out.println( "If key is at the head of the list:" );
        list.printList();
        list.setHead( deleteAtPosition( list.getHead(), 1 ) );
        System.out.println("Deleting at the first position");
        list.printList();
        list.setHead( deleteAtPosition( list.getHead(), 2 ) );
        System.out.println("Deleting at the middle position");
        list.printList();
        list.setHead( deleteAtPosition( list.getHead(), 5 ) );
    }


    private static Node<Integer> deleteFirstKey( Node<Integer> head, int data ) throws Exception
    {
        if ( head == null ) {
            throw new Exception( "list is already empty" );
        }
        Node prev = null;
        Node current = head;

        if ( (Integer) current.getData() == data ) {
            head = current.getNext();
            return head;
        }

        while ( current != null && (Integer) current.getData() != data ) {
            prev = current;
            current = current.getNext();
        }
        if ( current == null ) {
            throw new Exception( "Key not found to delete." );
        }
        prev.setNext( current.getNext() );
        return head;
    }

    private static Node<Integer> deleteAtPosition(Node<Integer> head, int position) throws Exception{
        if(head == null){
            throw new Exception( "List is empty." );
        }
        Node prev=  null;
        Node current = head;
        if(position == 1){
            head = current.getNext();
            return head;
        }
        int count = 1;
        while(current != null && position != count){
            prev = current;
            current = current.getNext();
            count ++;
        }

        if(current == null){
            throw new Exception( "List is shorter than the given position" );
        }
        prev.setNext(current.getNext());
        return head;
    }
}

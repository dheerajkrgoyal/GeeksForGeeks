package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 21/5/16.
 */
public class AlternateSplit
{
    public static void main( String[] args )
    {
        LinkedList list  = LinkedList.getDefaultIntegerList();
        Insertion.append( list.getHead(),15 );
        System.out.println("list:");list.printList();
        alternateSplit(list.getHead());
    }

    public static void alternateSplit(Node head){
        if(head == null){
            return;
        }

        Node head1 = head;
        Node current1 = head1;
        Node head2 = head.getNext();
        Node current2 = head2;
        Node current =  null;
        if(head.getNext() != null){
            current = head.getNext().getNext();
        }
        while(current != null && current.getNext() != null){
            current1.setNext(current);
            current1 = current1.getNext();
            current2.setNext( current.getNext() );
            current2 = current2.getNext();
            current = current.getNext().getNext();

        }
        if(current != null){
            current1.setNext( current );
            current1 = current1.getNext();
        }
        current1.setNext( null );
        current2.setNext( null );
        LinkedList list = new LinkedList(  );
        list.setHead( head1 );
        list.printList();
        list.setHead( head2 );
        list.printList();
    }
//
//    public static Node recursiveAlternateSplit(Node head){
//        if(head == null && head.getNext() != null){
//            return null;
//        }
//        Node head1 = head;
//        Node head2 = head.getNext();
//        head1.setNext(recursiveAlternateSplit( head1.getNext().getNext() ));
//        head2.setNext(recursiveAlternateSplit( head2.getNext().getNext() ));
//
//        LinkedList list = new LinkedList(  );
//        list.setHead( head1 );
//        list.printList();
//        list.setHead( head2 );
//        list.printList();
//        return null;
//    }
}

package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 16/5/16.
 */
public class MergeTwoList
{
    public static void main( String[] args )
    {
        LinkedList<Integer> sortedList1 = new LinkedList<Integer>( new Integer[] { 3, 7, 13, 17, 18 } );
        LinkedList<Integer> sortedList2 = new LinkedList<Integer>( new Integer[] { 2, 9, 10, 12, 15, 20, 25 } );
        Node headOfMergedList = mergeList( sortedList1, sortedList2 );
        System.out.println( "Link list 1:" );
        sortedList1.printList();
        System.out.println( "Link list 2:" );
        sortedList2.printList();
        System.out.println( "Merged list:" );
        LinkedList mergedList = new LinkedList();
        mergedList.setHead( headOfMergedList );
        mergedList.printList();
        Node headOfRecursiveMergedList = recursiveMergeList( sortedList1.getHead(),sortedList2.getHead() );
        LinkedList recursiveMergedList = new LinkedList(  );
        recursiveMergedList.setHead( headOfRecursiveMergedList );
        System.out.println("Recursive merged list:");
        recursiveMergedList.printList();
    }


    public static Node mergeList( LinkedList list1, LinkedList list2 )
    {
        Node<Integer> headOfMergedList = null;
        Node pointer1 = list1.getHead();
        Node pointer2 = list2.getHead();
        if ( (Integer) pointer1.getData() <= (Integer) pointer2.getData() ) {
            headOfMergedList = new Node<Integer>( (Integer) pointer1.getData() );
            pointer1 = pointer1.getNext();
        } else {
            headOfMergedList = new Node<Integer>( (Integer) pointer2.getData() );
            pointer2 = pointer2.getNext();
        }
        Node prev = headOfMergedList;
        while ( pointer1 != null && pointer2 != null ) {
            Node current = null;
            Integer data1 = (Integer) pointer1.getData();
            Integer data2 = (Integer) pointer2.getData();
            if ( data1 <= data2 ) {
                current = new Node( data1 );
                prev.setNext( current );
                pointer1 = pointer1.getNext();
            } else {
                current = new Node( data2 );
                prev.setNext( current );
                pointer2 = pointer2.getNext();
            }
            prev = current;
        }
        if ( pointer1 == null ) {
            Node current = null;
            while ( pointer2 != null ) {
                current = new Node( pointer2.getData() );
                prev.setNext( current );
                pointer2 = pointer2.getNext();
                prev = current;
            }
        }
        if ( pointer2 == null ) {
            Node current = null;
            while ( pointer1 != null ) {
                current = new Node( pointer1.getData() );
                prev.setNext( current );
                pointer1 = pointer1.getNext();
                prev = current;
            }
        }
        return headOfMergedList;
    }

    public static Node recursiveMergeList(Node head1, Node head2){
        Node result=null;
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if((Integer)head1.getData() <= (Integer)head2.getData()){
            result = head1;
            result.setNext( recursiveMergeList( head1.getNext(),head2 ) );
        }
        else{
            result = head2;
            result.setNext( recursiveMergeList( head1,head2.getNext() ) );
        }
        return result;
    }
}

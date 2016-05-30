package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 17/5/16.
 */
public class PairwiseSwap
{
    public static void main( String[] args )
    {
        LinkedList list = LinkedList.getDefaultIntegerList();
        System.out.println("list:");list.printList();
        pairwiseSwap(list.getHead());
        System.out.println("After swaping:");list.printList();
        recursivePairwiseSwap( list.getHead() );
        System.out.println("Recursive swaping:");list.printList();
    }

    public static void pairwiseSwap(Node head){
        if (head == null){
            return;
        }
        Node current = head;
        int temp;
        while(current != null && current.getNext() != null){
            temp = (Integer)current.getData();
            current.setData( current.getNext().getData() );
            current.getNext().setData( temp );
            current = current.getNext().getNext();
        }
    }

    public static void recursivePairwiseSwap(Node head){
        if(head == null || head.getNext() == null){
            return;
        }
        int temp = (Integer) head.getData();
        head.setData( head.getNext().getData() );
        head.getNext().setData( temp );
        recursivePairwiseSwap( head.getNext().getNext() );
    }
}

package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/6/16.
 */
public class MergeAtAlternatePosition
{
    public static void main( String[] args )
    {
        LinkedList firstList  =LinkedList.getDefaultIntegerList();
        System.out.println("First list: "); firstList.printList();
        LinkedList<Integer> secondList = new LinkedList<Integer>( new Integer[]{4,9,3,7,8,0,1,5,6,7,2} );
        System.out.println("Second list: "); secondList.printList();
        mergeAtAlternatePosition(firstList.getHead(), secondList.getHead());
        System.out.println("Merged list: "); firstList.printList();
    }

    public static void mergeAtAlternatePosition(Node firstHead, Node secondHead){
        Node head = firstHead;
        Node current = firstHead;
        Node secondListPointer = secondHead;

        while(current != null && secondListPointer != null){
            Node temp = current.getNext();
            current.setNext( secondListPointer );
            secondListPointer = secondListPointer.getNext();
            current = current.getNext();
            current.setNext( temp );
            current = current.getNext();
        }
    }
}

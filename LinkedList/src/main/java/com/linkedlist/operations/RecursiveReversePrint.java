package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 17/5/16.
 */
public class RecursiveReversePrint
{
    public static void main( String[] args )
    {
        LinkedList list = LinkedList.getDefaultIntegerList();
        System.out.println("list:");
        list.printList();
        System.out.println("Recursice reverse print: ");
        recursiveReversePrint( list.getHead() );
    }

    public static void recursiveReversePrint(Node head){
        if(head == null){
            return;
        }
        recursiveReversePrint( head.getNext() );
        System.out.print(head.getData() + " ");
    }
}

package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class SearchElement
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("list:");
        list.printList();
        System.out.println("Position of 7 in list is: " + iterativeSearchElement( list.getHead(), 7 ));
        System.out.println("Position of 1 in list is: " + recursiveSearchElement( list.getHead(), 1 ));
        System.out.println("Position of 100 in list is: " + recursiveSearchElement( list.getHead(), 100 ));
    }

    private static int iterativeSearchElement(Node head, int data) throws Exception{
        if(head == null){
            throw new Exception( "list is empty" );
        }
        int position = 0;
        Node current = head;
        while(current != null && (Integer)current.getData() != data){
            position += 1;
            current = current.getNext();
        }
        if(current == null){
            throw new Exception( "element not found" );
        }
        return position + 1;
    }

    private static int recursiveSearchElement(Node head, int data) throws Exception{
        if(head == null ){
            throw new Exception( "either list is empty or no element found" );
        }
        if((Integer)head.getData() == data){
            return 1;
        }
        return 1 + recursiveSearchElement( head.getNext(), data );
    }

}

package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class MiddleOfList
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("list:");
        list.printList();
        System.out.println("Middle of list: " + getMiddleNode( list.getHead() ).getData());

    }

    private static Node getMiddleNode(Node head) throws Exception{
        if(head == null){
            throw new Exception( "list is empty" );
        }
        Node singleJump = head;
        Node doubleJump = head;
        while(doubleJump != null && doubleJump.getNext() != null){
            doubleJump = doubleJump.getNext().getNext();
            singleJump = singleJump.getNext();
        }
        return singleJump;
    }
}

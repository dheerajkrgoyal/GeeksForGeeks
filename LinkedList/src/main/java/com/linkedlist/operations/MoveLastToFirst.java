package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 17/5/16.
 */
public class MoveLastToFirst
{
    public static void main( String[] args )
    {
        LinkedList list= LinkedList.getDefaultIntegerList();
        System.out.println("list:");list.printList();
        list.setHead( moveLastToFirst(list.getHead()) );
        System.out.println("list:");list.printList();
    }

    public static Node moveLastToFirst(Node head){
        if (head == null){
            return null;
        }
        Node prev =  null;
        Node current = head;
        while(current.getNext() != null){
            prev = current;
            current  = current.getNext();
        }
        prev.setNext( null );
        current.setNext( head );
        head = current;
        return head;
    }
}

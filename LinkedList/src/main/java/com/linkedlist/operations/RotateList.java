package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 30/5/16.
 */
public class RotateList
{
    public static void main( String[] args )
    {
        LinkedList list = LinkedList.getDefaultIntegerList();
        System.out.println("list:"); list.printList();
        list.setHead( rotateAntiClockWise( list.getHead(),3 ) );
        System.out.println("After rotating list anti-clockwise by 3: "); list.printList();
        list.setHead( rotateAntiClockWise( list.getHead(), 10 ) );
        System.out.println("After rotating list anti-clockwise by 10: "); list.printList();
    }

    public static Node rotateAntiClockWise(Node head, int index){
        if(head == null){
            return null;
        }
        int length = LengthOfLinkedList.recursiveLengthOfLinkedList( head );
        index = index % length;
        int count = 1;
        Node current = head;
        while(count < index ){
            current = current.getNext();
            count ++;
        }
        Node prevHead = head;
        head = current.getNext();
        current.setNext( null );
        Node last = head;
        while(last.getNext() != null){
            last = last.getNext();
        }
        last.setNext( prevHead );
        return head;
    }
}

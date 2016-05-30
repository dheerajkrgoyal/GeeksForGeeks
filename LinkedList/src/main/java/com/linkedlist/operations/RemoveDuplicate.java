package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dheeraj on 17/5/16.
 */
public class RemoveDuplicate
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list = new LinkedList<Integer>( new Integer[]{2,6,6,6,7,7,9,14,14} );
        System.out.println("Sorted list:");list.printList();
        list.setHead( removeDuplicateFromSortedList(list.getHead()) );
        System.out.println("Removed duplicate from sorted list:");list.printList();
        LinkedList<Integer> list1 = new LinkedList<Integer>( new Integer[]{6,6,2,2,2,7,14,14,3} );
        System.out.println("Unsorted list:"); list1.printList();
        list1.setHead( removeDuplicateFromUnsortedList(list1.getHead()) );
        System.out.println("Removed duplicate from unsorted list:");list1.printList();
    }

    public static Node removeDuplicateFromSortedList(Node head){
        int element = (Integer)head.getData();
        Node prev = head;
        Node current = head.getNext();

        while(current != null){
            if((Integer)current.getData() == element){
                prev.setNext( current.getNext() );
            }
            else{
                prev = current;
                element = (Integer)current.getData();
            }
            current = current.getNext();
        }
        return head;
    }

    public static Node removeDuplicateFromUnsortedList(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }
        Map<Integer, Boolean> elementsVisited = new HashMap();
        Node current = head.getNext();
        Node prev = head;
        elementsVisited.put( (Integer)head.getData(),true );
        while(current != null){
            if(elementsVisited.get( current.getData() ) != null ){
                prev.setNext( current.getNext() );
            }
            else{
                elementsVisited.put( (Integer)current.getData(),true );
                prev = current;
            }
            current = current.getNext();
        }
        return head;
    }
}

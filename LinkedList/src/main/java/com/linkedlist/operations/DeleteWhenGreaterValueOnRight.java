package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 21/5/16.
 */
public class DeleteWhenGreaterValueOnRight
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = new LinkedList<Integer>( new Integer[]{12,15,10,11,5,6,2,3} );
        System.out.println("list:"); list.printList();
        list.setHead(deleteNodeWhenValueGreaterOnRight(list.getHead()));
        System.out.println("list after deletion:"); list.printList();

    }

    public static Node deleteNodeWhenValueGreaterOnRight(Node head) throws Exception
    {
        if(head == null || head.getNext() == null){
            return head;
        }
        head = Reverse.iterativeReverseList( head );

        Node current = head.getNext();
        Node max = head;
        while(current != null){
            if((Integer)max.getData() > (Integer)current.getData()){
                max.setNext( current.getNext() );
                current = current.getNext();
            }
            else {
                max = current;
                current = current.getNext();
            }
        }
        head = Reverse.iterativeReverseList( head);
        return head;
    }
}

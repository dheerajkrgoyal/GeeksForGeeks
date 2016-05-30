package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 17/5/16.
 */
public class ListIntersection
{
    public static void main( String[] args )
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>( new Integer[]{1,2,3,4,6} );
        LinkedList<Integer> list2 = new LinkedList<Integer>( new Integer[]{2,4,6,8} );
        LinkedList result = new LinkedList();
        result.setHead(listIntersection(list1.getHead(),list2.getHead()));
        System.out.println("list 1:"); list1.printList();
        System.out.println("list 2:"); list2.printList();
        System.out.println("Intersection result:"); result.printList();
    }

    public static Node listIntersection(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        if((Integer)head1.getData() < (Integer)head2.getData()){
            listIntersection( head1.getNext(),head2 );
        }
        else if((Integer)head1.getData() > (Integer)head2.getData()){
            listIntersection( head1, head2.getNext() );
        }
        Node head = new Node( head1.getData() );
        head.setNext( listIntersection( head1.getNext(), head2.getNext() ) );
        return head;
    }
}

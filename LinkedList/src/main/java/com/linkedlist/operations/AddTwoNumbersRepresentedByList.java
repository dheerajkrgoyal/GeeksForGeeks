package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 30/5/16.
 */
public class AddTwoNumbersRepresentedByList
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list1 = new LinkedList<Integer>( new Integer[]{4,5,6,7} );
        System.out.println("list1: "); list1.printList();
        LinkedList<Integer> list2 = new LinkedList<Integer>( new Integer[]{7,4,2,4,7} );
        System.out.println("list2: "); list2.printList();
        LinkedList sum = new LinkedList();
        sum.setHead( sumOfList(list1.getHead(),list2.getHead()) );
        System.out.println("sum of list: "); sum.printList();
    }

    public static Node sumOfList(Node head1, Node head2) throws Exception{
        if(head1 == null && head2 == null){
            return null;
        }
        head1 = Reverse.iterativeReverseList( head1 );
        head2 = Reverse.iterativeReverseList( head2 );
        Node current1 = head1;
        Node current2 = head2;
        int sum = (Integer) current1.getData() + (Integer)current2.getData();
        int remainder = sum % 10;
        int carry = sum / 10;
        current1 = current1.getNext();
        current2 = current2.getNext();
        Node sumOfListHead = new Node( remainder );
        Node sumCurrent = sumOfListHead;
        while(current1 != null && current2 != null){
            sum = (Integer) current1.getData() + (Integer)current2.getData() + carry;
            remainder = sum % 10;
            carry = sum / 10;
            Node newNode = new Node( remainder );
            newNode.setNext( null );
            sumCurrent.setNext( newNode );
            sumCurrent = sumCurrent.getNext();
            current1 = current1.getNext();
            current2 = current2.getNext();
        }

        if(current1 == null && current2 != null){
            while ( current2 != null ){
                sum = (Integer)current2.getData() + carry;
                remainder = sum % 10;
                carry = sum / 10;
                Node newNode = new Node( remainder );
                newNode.setNext( null );
                sumCurrent.setNext( newNode );
                sumCurrent = sumCurrent.getNext();
                current2 = current2.getNext();
            }
        }

        if(current2 == null && current1 != null){
            while ( current1 != null ){
                sum = (Integer)current1.getData() + carry;
                remainder = sum % 10;
                carry = sum / 10;
                Node newNode = new Node( remainder );
                newNode.setNext( null );
                sumCurrent.setNext( newNode );
                sumCurrent = sumCurrent.getNext();
                current1 = current1.getNext();
            }
        }

        if(current1 == null && current2 == null && carry != 0){
            Node newNode = new Node( carry );
            newNode.setNext( null );
            sumCurrent.setNext( newNode );
        }

        return Reverse.iterativeReverseList( sumOfListHead );
    }
}

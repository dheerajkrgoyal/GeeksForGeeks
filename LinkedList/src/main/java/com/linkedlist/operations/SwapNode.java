package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by Dheeraj on 15/5/16.
 */
public class SwapNode
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("lsit before swapping:");
        list.printList();
        list.setHead(swapNode( list.getHead(), 5, 2));
        System.out.println("list after swapping 5 and 2");
        list.printList();

    }

    private static Node<Integer> swapNode(Node<Integer> head, int data1, int data2) throws Exception{
        if(head == null){
            throw new Exception( "list is empty" );
        }
        if(data1 == data2){
            throw new Exception( "data are same" );
        }
        Node prev1 = null;
        Node node1 = head;
        while(node1 != null && (Integer)node1.getData() != data1){
            prev1 = node1;
            node1 = node1.getNext();
        }
        Node prev2 = null;
        Node node2 = head;
        while(node2 != null && (Integer)node2.getData() != data2){
            prev2 = node2;
            node2 = node2.getNext();
        }
        if(node1 == null || node2 == null){
            throw new Exception( "Either one of or both node is not found in the list" );
        }

        Node temp = node1.getNext();
        node1.setNext( node2.getNext() );
        node2.setNext( temp );

        if(prev1 == null){
            prev2.setNext( node1 );
            head = node2;
        }
        if(prev2 == null) {
            prev1.setNext( node2 );
            head = node1;
        }
        return head;
    }
}

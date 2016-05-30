package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;

/**
 * Created by Dheeraj on 15/5/16.
 */
public class Insertion
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> list = LinkedList.getDefaultIntegerList();
        System.out.println("Initial linked list:");
        list.printList();
        push( list, 12 );
        System.out.println("Added element 12 at head:");
        list.printList();
        insert( list.getHead().getNext().getNext(), 10 );
        System.out.println("Added element 10 in between");
        list.printList();
        append( list.getHead(), 99 );
        System.out.println("Added element 99 at the end");
        list.printList();
        System.out.println("Added at the end in an empty list:");
        LinkedList<Integer> list1 = new LinkedList<Integer>(  );
        list1.setHead( append( list1.getHead(),100 ) );
        list1.printList();
    }


    /**
     * Insert at first
     * @param list
     * @param data
     */
    public static void push(LinkedList<Integer> list, int data){
        Node<Integer> newHead= new Node<Integer>( data );
        newHead.setNext( list.getHead() );
        list.setHead( newHead );
    }


    /**
     * Insert at middle
     * @param prevNode
     * @param data
     * @throws Exception
     */
    public static void insert(Node<Integer> prevNode, int data) throws Exception{
        if(prevNode == null){
            throw new Exception( "prevNode in insertion is null" );
        }
        Node<Integer> node = new Node<Integer>( data );
        node.setNext( prevNode.getNext() );
        prevNode.setNext( node );
    }


    /**
     * Insert at end
     * @param head
     * @param data
     */
    public static Node<Integer> append(Node<Integer> head, int data){
        Node<Integer> node =  new Node<Integer>( data );
        if(head == null){
            head = node;
            return head;
        }
        Node<Integer> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext( node );
        return head;
    }
}

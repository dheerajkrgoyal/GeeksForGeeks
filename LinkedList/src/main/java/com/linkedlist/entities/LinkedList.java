package com.linkedlist.entities;

/**
 * Created by Dheeraj on 15/5/16.
 */
public class LinkedList<T>
{
    private Node<T> head;

    public LinkedList(){

    }

    /**
     * Accepts array of data and create a linklist of it
     * @param arrayData
     */
    public LinkedList( T[] arrayData )
    {
        this.head = new Node<T>( arrayData[0] );
        Node<T> prev=head;
        for ( int i = 1; i < arrayData.length; i++ ) {
            Node<T> current = new Node<T>(arrayData[i],prev);
            prev = current;
        }
    }


    public void setHead( Node<T> head )
    {
        this.head = head;
    }


    public Node<T> getHead()
    {
        return this.head;
    }


    public static LinkedList<Integer> getDefaultIntegerList()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Node<Integer> head = new Node<Integer>( 5 );
        Node<Integer> second = new Node<Integer>( 3, head );
        Node<Integer> third = new Node<Integer>( 7, second );
        Node<Integer> fourth = new Node<Integer>( 2, third );
        Node<Integer> fifth = new Node<Integer>( 1, fourth );
        Node<Integer> sixth = new Node<Integer>( 9, fifth );
        //new Node<Integer>(4, sixth);
        list.setHead( head );
        return list;
    }

    public static LinkedList<Integer> getIntegerListWithLoop(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        Node<Integer> head = new Node<Integer>( 5 );
        Node<Integer> second = new Node<Integer>( 3, head );
        Node<Integer> third = new Node<Integer>( 7, second );
        Node<Integer> fourth = new Node<Integer>( 2, third );
        Node<Integer> fifth = new Node<Integer>( 1, fourth );
        Node<Integer> sixth = new Node<Integer>( 9, fifth );
        Node<Integer> seventh = new Node<Integer>(4, sixth);
        seventh.setNext( fourth );
        list.setHead( head );
        return list;
    }

    public void printList(){
        Node<T> current = this.head;
        while(current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

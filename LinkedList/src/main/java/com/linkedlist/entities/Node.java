package com.linkedlist.entities;

/**
 * Created by Dheeraj on 15/5/16.
 */
public class Node<T>
{
    private T data;
    private Node next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node previousNode){
        this.data = data;
        this.next = null;
        previousNode.next = this;
    }


    public T getData()
    {
        return data;
    }


    public void setData( T data )
    {
        this.data = data;
    }


    public Node getNext()
    {
        return next;
    }


    public void setNext( Node next )
    {
        this.next = next;
    }
}

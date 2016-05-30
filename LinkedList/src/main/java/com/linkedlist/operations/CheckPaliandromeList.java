package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;

/**
 * Created by Dheeraj on 17/5/16.
 */
public class CheckPaliandromeList
{
    public static void main( String[] args )
    {
        LinkedList<Character> paliandromeList = new LinkedList<Character>(new Character[]{'r','a','a','r' } );
        System.out.println("Is list paliandrome? : " + checkPaliandrome(paliandromeList.getHead()) );
    }

    public static boolean checkPaliandrome(Node head){
        if(head == null){
            return true;
        }
        Node singleJump = head;
        Node doubleJump = head;

        while(doubleJump.getNext() != null && doubleJump.getNext().getNext() != null){
            singleJump = singleJump.getNext();
            doubleJump = doubleJump.getNext().getNext();
        }

        Node middle = singleJump.getNext();
        //detaching first and second half
        singleJump.setNext( null );
        //Reversing second half
        Node prev = null;
        Node current = middle;
        Node next = null;

        while(current != null){
            next = current.getNext();
            current.setNext( prev );
            prev = current;
            current = next;
        }
        Node reverseHead = prev;

        Node pointer1 = head;
        Node pointer2 = reverseHead;
        while(pointer1 != null && pointer2 != null){
            if(pointer1.getData() != pointer2.getData()){
                return false;
            }
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }

        return true;
    }
}

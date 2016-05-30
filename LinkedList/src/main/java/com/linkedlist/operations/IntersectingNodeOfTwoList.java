package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;


/**
 * Created by raremile on 17/5/16.
 */
public class IntersectingNodeOfTwoList
{
    public static void main( String[] args )
    {
        LinkedList firstList = LinkedList.getDefaultIntegerList();
        System.out.println("list1:");
        firstList.printList();
        LinkedList<Integer> secondList = new LinkedList<Integer>( new Integer[]{2,7} );
        System.out.println("list2:");
        secondList.printList();
        createIntersection(firstList,secondList);
        System.out.println("Intersection point created on 4th node of first list:");
        secondList.printList();
        Node intersectionPoint = findIntersectionNode(firstList.getHead(),secondList.getHead());
        System.out.println("Intersecting point: " + intersectionPoint.getData());
    }

    public static void createIntersection(LinkedList firstList, LinkedList secondList){
        Node intersectionNode = firstList.getHead().getNext().getNext().getNext();
        Node secondEnd = secondList.getHead();

        while(secondEnd.getNext() != null){
            secondEnd = secondEnd.getNext();
        }
        secondEnd.setNext( intersectionNode );
    }

    public static Node findIntersectionNode(Node firstHead, Node secondHead){
        int firstLength = 0;
        int secondLength = 0;
        Node current = firstHead;
        while(current != null){
            firstLength +=1;
            current = current.getNext();
        }
        current = secondHead;
        while ( current != null ){
            secondLength +=1;
            current = current.getNext();
        }
        int difference = Math.abs( firstLength - secondLength );

        if(firstLength > secondLength){
            for(int i = 0 ; i<difference;i++){
                firstHead = firstHead.getNext();
            }
        }
        else{
            for ( int i=0;i<difference;i++ ){
                secondHead = secondHead.getNext();
            }
        }

        while(firstHead != secondHead){
            firstHead = firstHead.getNext();
            secondHead = secondHead.getNext();
        }

        return firstHead;
    }

}

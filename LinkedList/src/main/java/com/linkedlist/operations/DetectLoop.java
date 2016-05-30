package com.linkedlist.operations;

import com.linkedlist.entities.LinkedList;
import com.linkedlist.entities.Node;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Dheeraj on 16/5/16.
 */
public class DetectLoop
{
    public static void main( String[] args ) throws Exception
    {
        LinkedList<Integer> listWithoutLoop = LinkedList.getDefaultIntegerList();
        LinkedList<Integer> listWithLoop = LinkedList.getIntegerListWithLoop();
        System.out.println("list without loop:");
        listWithoutLoop.printList();
        System.out.println("Detected loop: " + detectLoopInList( listWithoutLoop.getHead() ));
        System.out.println("list with loop:");
        System.out.println("Detected loop: " + detectLoopInList( listWithLoop.getHead() ));

        System.out.println("list without loop:");
        listWithoutLoop.printList();
        System.out.println("Detected loop using floyd cycle detection: " + floydCycleFinding( listWithoutLoop.getHead() ));
        System.out.println("list with loop:");
        System.out.println("Detected loop using floyd cycle detection: " + floydCycleFinding( listWithLoop.getHead() ));
        System.out.println("list without loop:");listWithoutLoop.printList();
        System.out.println("Trying to remove loop if exist:" );
        listWithoutLoop.setHead( removeLoop( listWithoutLoop.getHead() ) );
        listWithoutLoop.printList();
        System.out.println("list with loop :");
        System.out.println("Trying to remove loop if exist:" );
        listWithLoop.setHead( removeLoop( listWithLoop.getHead() ) );
        listWithLoop.printList();
    }


    /**
     * This is a basic method which uses a map to store every visited loop. Iteratively when we visit
     * to new node we check if it already stored in a map or not. If it is there, then we are confirm
     * that there is a loop
     * @param head
     * @return
     * @throws Exception
     */
    public static boolean detectLoopInList(Node head) throws Exception{
        if(head ==  null){
            throw new Exception( "list is empty" );
        }
        Map<Node,Integer> visitedNode = new HashMap<Node, Integer>();
        Node current = head;
        int count = 0;
        boolean loop = false;
        while(current != null){
            if(visitedNode.get( current ) == null){
                visitedNode.put( current, count );
                count ++;
                current = current.getNext();
            }
            else{
                loop = true;
                break;
            }
        }
        return loop;
    }


    /**
     * This is an implementation of Floyd cycle detection algorithm
     * We have two pointers to the list one traverse one step at a time and other two step at a time.
     * If there is a loop then at one point both pointers will point to the same node
     * If there isnt any loop one of the pointer will reeach to the end of the list
     * @param head
     * @return
     * @throws Exception
     */
    public static boolean floydCycleFinding(Node head) throws Exception{
        if(head == null){
            throw new Exception( "list is empty." );
        }
        Node singleJump = head;
        Node doubleJump = head;
        boolean loop = false;
        while(singleJump != null && doubleJump != null && doubleJump.getNext() != null){
            singleJump = singleJump.getNext();
            doubleJump = doubleJump.getNext().getNext();
            if(singleJump == doubleJump){
                loop = true;
                break;
            }
        }
        return loop;
    }


    /**
     * This uses Floyd Cycle Detection Algotrithm to detect loop. If there is loop acording to algorithm slow and fast pointer meets at some point
     * within loop. Now in order to find the point where  the loop starts we start one pointer from head of list and run the slow pointer and head pointer
     * ond by one until they meet again. The point of meeting is starting of the loop. We make the previous of slow pointer's next as null to terminate
     * the loop.
     * @param head head of the list
     * @return new head of the list after removing loop
     * @throws Exception
     */
    public static Node removeLoop(Node head){
        if(head == null){
            return null;
        }
        Node singleJump = head;
        Node doubleJump = head;
        boolean loop = false;
        while(singleJump != null && doubleJump != null && doubleJump.getNext() != null){
            singleJump = singleJump.getNext();
            doubleJump = doubleJump.getNext().getNext();
            if(singleJump == doubleJump){
                loop = true;
                break;
            }
        }
        if(!loop){
            return head;
        }

        Node meetingPoint = singleJump;
        Node tempNode = head;
        Node prev = null;
        while(tempNode != meetingPoint){
            prev = meetingPoint;
            tempNode = singleJump.getNext();
            meetingPoint = meetingPoint.getNext();
        }

        prev.setNext( null );
        return head;
    }
}

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


/**
 * Created by dheeraj on 21/1/17.
 */
public class Median
{
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    int numOfElement;

    public Median(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>( 100, new MaxHeapComparator() );
        numOfElement = 0;
    }

    private class MaxHeapComparator implements Comparator<Integer>{
        public int compare( Integer integer, Integer t1 )
        {
            return t1-integer;
        }
    }

    public void addELement(int data){
        maxHeap.add( data );
        if(numOfElement % 2 == 0){
            if(minHeap.isEmpty()){
                numOfElement ++;
                return;
            }
            else{
                if(maxHeap.peek()>minHeap.peek()){
                    int maxHeapRoot = maxHeap.poll();
                    int minHeapRoot = minHeap.poll();
                    maxHeap.add( minHeapRoot );
                    minHeap.add( maxHeapRoot );
                }
            }
        }
        else {
            minHeap.add( maxHeap.poll() );
        }
        numOfElement ++;
    }

    public Double getMedian(){
        if ( numOfElement % 2 !=0 ){
            return new Double( maxHeap.peek());
        }
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }


    public static void main( String[] args )
    {
        Median median = new Median();
        Scanner s = new Scanner( System.in );
        System.out.print("How many no. you want to enter: ");
        int steps = s.nextInt();
        for(int i=0; i<steps; i++){
            System.out.print("Enter no. : ");
            median.addELement( s.nextInt() );
            System.out.println( "Median now is: " + median.getMedian() );
        }
    }
}

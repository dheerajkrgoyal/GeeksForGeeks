import java.util.ArrayList;
import java.util.Scanner;


/**
 * Implementation of min heap
 * Created by dheeraj on 20/1/17.
 */
public class Heap<T extends Comparable<T>>
{
    ArrayList<T> items;

    public Heap(){
        items = new ArrayList<T>();
    }

    /**
        While inserting an element to heap we insert it at the end and then call this function
     It checks the parent of the newly inserted element recursively and move it up if it is less than the
     parent.
     */
    private void shiftUp(){
        int k = items.size() - 1;
        while(k>0){
            int p = (k-1)/2;
            if(items.get(p).compareTo( items.get( k ) )>0){
                T temp = items.get( p );
                items.set( p, items.get( k ) );
                items.set( k, temp );
                k=p;
            }
            else{
                break;
            }
        }
    }


    /**
        While deleting an element from heap we delete the top element, we move the last element to the top
     and call this function.
     It checks which of it's child has lower value and swap its position with it and does it recursively till
     it hits the end of the heap.
     */
    private void shiftDown(){
        int k=0;
        int l= 2*k +1;

        while(l<items.size()){
            int min =1;
            int r = l+1;
            if(r<items.size()){
                if(items.get( l ).compareTo( items.get( r )) >0){
                    min++;
                }
            }

            if(items.get( k ).compareTo( items.get( min ) )>0){
                T temp = items.get( k );
                items.set( k, items.get( min ) );
                items.set( min, temp );
                k= min;
                l= 2*k +1;
            }
            else{
                break;
            }
        }
    }

    public void insert(T data){
        items.add( data );
        shiftUp();
    }


    public T delete(){
        if(items.size() ==0){
            return null;
        }
        if(items.size() == 1){
            return items.remove( 0 );
        }
        T hold = items.get( 0 );
        items.set(0 , items.remove( items.size()-1 ));
        shiftDown();
        return hold;
    }

    public int size(){
        return items.size();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public String toString(){
        return items.toString();
    }


    public static void main( String[] args )
    {
        Heap<Integer> heap = new Heap();
        System.out.println("Enter element or 'done' to exit: ");
        Scanner s = new Scanner( System.in );
        String line = s.nextLine();
        while(!line.equals("done")){
            heap.insert( Integer.parseInt( line ) );
            System.out.println(heap);
            System.out.println("Enter element or 'done' to exit: ");
            line = s.nextLine();

        }

        while(!heap.isEmpty() ){
            Integer min = heap.delete();
            System.out.println(min + " " + heap);
        }
    }
}

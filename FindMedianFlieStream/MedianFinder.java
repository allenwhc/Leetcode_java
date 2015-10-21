import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;

public class MedianFinder{
    private static PriorityQueue<Integer> minHeap;
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> printminHeap;
    private static PriorityQueue<Integer> printmaxHeap;

    public MedianFinder(){
    	this.minHeap=new PriorityQueue<Integer>();
    	this.maxHeap=new PriorityQueue<Integer>();
    	this.printminHeap=minHeap;
    	this.printmaxHeap=maxHeap;
    }

	// Adds a number into the data structure.
    public static void addNum(int num) {
    	if(maxHeap.size()==0)
    		maxHeap.offer(num);
    	else{
    		if(minHeap.size()==0){
    			maxHeap.offer(num);
    			minHeap.offer(maxHeap.poll());
    		}
    		else{
    			if(num>minHeap.peek()){
    				minHeap.offer(num);
    				maxHeap.offer(minHeap.poll());
    			}
    			else{
    				maxHeap.offer(num);
    			}
    			if(maxHeap.size()-minHeap.size()>1){
    				minHeap.offer(maxHeap.poll());
    			}
    		}
    	}
    }

    // Returns the median of current data stream
    public static double findMedian() {
    	maxHeap=reversePQ();
        if(minHeap.size()==maxHeap.size())	//The size of stream is even
        	return ((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
        else	//The size of stream is odd
        	return (double)(minHeap.size()>maxHeap.size()?minHeap.peek():maxHeap.peek());
    }

    private static PriorityQueue<Integer> reversePQ(){
    	PriorityQueue<Integer> reversed=new PriorityQueue<Integer>(maxHeap.size(), Collections.reverseOrder());
    	reversed.addAll(maxHeap);
    	return reversed;
    }

    public static void printHeap(){
    	System.out.print("Min heap is: ");
    	while(printminHeap.size()>0)
    		System.out.print(printminHeap.poll()+" ");
    	System.out.println();
    	System.out.print("Max heap is: ");
    	while(printmaxHeap.size()>0)
    		System.out.print(printmaxHeap.poll()+" ");
    }

    public static void main(String[] args) {
    	MedianFinder mf=new MedianFinder();
    	mf.addNum(6);
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(10);
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(2);
    	System.out.println("median="+mf.findMedian());
    	//mf.printHeap();
    	mf.addNum(6);
    	//mf.printHeap();
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(5);
    	//mf.printHeap();
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(0);
    	//mf.printHeap();
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(6);
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(3);
    	System.out.println("median="+mf.findMedian());
    	mf.addNum(1);
    	System.out.println("median="+mf.findMedian());
    	//mf.printHeap();
    	mf.addNum(0);
    	System.out.println("median="+mf.findMedian());
    	//mf.addNum(0);
    	//System.out.println("median="+mf.findMedian());

    	//mf.printHeap();
    	//System.out.println("median="+mf.findMedian());
    	//mf.printHeap();
    }
}
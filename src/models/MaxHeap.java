package models;

import java.util.*;

public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {

	private ArrayList<T> MaxHeap;
	
	public MaxHeap()
	{
		MaxHeap = new ArrayList<T>();
	}
	
	//siftUp method
	public void siftUp() {
		int k = MaxHeap.size() -1;
		while (k > 0) {
			int p = (k-1)/2;
			T item = MaxHeap.get(k);
			T parent = MaxHeap.get(p);
			
			if (item.compareTo(parent) > 0){
				//Swapping the content
				Collections.swap(MaxHeap, k, p);
				//moving up a level
				k=p;
			} else {
				break;
			}
		}
	}
	
	//siftDown method
	public void siftDown() {
		int k = 0;
		int l = 2*k+1;
		while(l < MaxHeap.size()){
			int max = l, r=l+1;
			if(r < MaxHeap.size()){
				if(MaxHeap.get(r).compareTo(MaxHeap.get(l)) > 0){
					max++;
				}
			}
			if(MaxHeap.get(k).compareTo(MaxHeap.get(max)) < 0) {
				Collections.swap(MaxHeap, max, k);
				k = max;
				l = 2*k+1;
			} else{
				break;
			}
		}
	}
	
	//adds entry to bottom of heap
	@Override
	public void add(T newEntry) {
		MaxHeap.add(newEntry);
		siftUp();
	}
	
	//Delete method to which deletes top node then sifts down the tree to find new top node
	//collections swaps basically swaps the elements at the specified positions in the specified list
	@Override
	public T removeMax() throws NoSuchElementException {
		if(isEmpty() == true)
		{
			throw new NoSuchElementException();
		}
		else{
			Collections.swap(MaxHeap, 0, MaxHeap.size()-1);
			T max= MaxHeap.remove(MaxHeap.size()-1);
			siftDown();
			return max;
		}
	}
	
	//returns the first entry on the heap, the max
	@Override
	public T getMax() {
		if(isEmpty() == false)
		{
			return MaxHeap.get(0);
		}
		return null;
	}

	//Checks if heap is empty and provides true/false
	@Override
	public boolean isEmpty() {
		return MaxHeap.isEmpty();
	}

	//returns how many entries are in the heap
	@Override
	public int getSize() {
		return MaxHeap.size();
	}

	@Override
	public void clear() {
		MaxHeap.clear();
	}
	
	public String toString(){
		String s="Heap size= "+MaxHeap.size()+": ";
		for(int i=0;i<MaxHeap.size()-1;i++)
			s+=MaxHeap.get(0);
		return s;
	}
}
	
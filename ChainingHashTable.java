package assignment10;

import java.util.ArrayList;
import java.util.Collection;

public class ChainingHashTable implements Set<String>{
	
	ArrayList<ArrayList<String>> list;
	int capacity;
	HashFunctor functor;
	int size;
	
	public ChainingHashTable(int capacity_, HashFunctor functor_) {
		this.functor = functor_;
		this.capacity = capacity_;
		this.list = new ArrayList<ArrayList<String>>(capacity_);
		this.size = 0;
		
		for (int i = 0; i < capacity_; i++) {
			list.add(new ArrayList<String>());
		}
		
	}

	@Override
	public boolean add(String item) {
		int index = Math.abs(functor.hash(item))%capacity;
		if (list.get(index).contains(item)) {
			return false;
		}
		list.get(index).add(item);
		size++;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends String> items) {
		boolean hasChanged = false;
		for(String str: items) {
			if(this.add(str) == true) {
				hasChanged = true;
			}
		}
		return hasChanged;
	}

	@Override
	public void clear() {
		list = new ArrayList<ArrayList<String>>();
		size = 0;
		for (int i = 0; i < capacity; i++) {
			list.add(null);
		}
	}

	@Override
	public boolean contains(String item) {
		int index = Math.abs(functor.hash(item))%capacity;
		if (list.get(index).contains(item)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<? extends String> items) {
		for(String str: items) {
			if(this.contains(str) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
		{
			return true;
		}
		return false;

	}

	@Override
	public int size() {
		return size();
	}

}

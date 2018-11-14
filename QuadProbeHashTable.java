package assignment10;

import java.util.ArrayList;
import java.util.Collection;

public class QuadProbeHashTable implements Set<String> {

	int size;
	ArrayList<String> list;
	int capacity;
	HashFunctor functor;

	/**
	 * Constructs a hash table of the given capacity that uses the hashing function
	 * specified by the given functor.
	 */

	public QuadProbeHashTable(int capacity_, HashFunctor functor_) {
		this.size = 0;
		this.capacity = capacity_;
		this.functor = functor_;
		this.list = new ArrayList<String>(capacity_);
		
		for (int i = 0; i < capacity_; i++) {
			list.add(null);
		}

	}

	@Override
	public boolean add(String item) {
		
		if (((((double)size + 1)/((double)capacity))) >= 0.5d) {
			grow();
		}

		int index = Math.abs(functor.hash(item)) % capacity;
		int probe = 1;
		if (list.get(index) == null) {
			list.set(index, item);
			size++;
			return true;
		}
		if (list.get(index).equals(item)){
			return false;
		}

		while (list.get((index + (int)Math.pow(probe, 2)) % capacity) != null) {
			if (list.get((index + (int)Math.pow(probe, 2)) % capacity).equals(item)) {
				return false;
			}
			probe++;
		}
		list.set(((index + (int)Math.pow(probe, 2)) % capacity), item);
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
		this.size = 0;
		list = new ArrayList<String>();
		for (int i = 0; i < capacity; i++) {
			list.add(null);
		}
	}

	@Override //TODO fix
	public boolean contains(String item) {
		int index = Math.abs(functor.hash(item)) % capacity;
		int probe = 1;

		
		if (list.get(index) != null) {
			if (list.get(index).equals(item)) {
				return true;
			}
		}
		while (list.get((index + (int)Math.pow(probe, 2)) % capacity) != null) {
			if (list.get((index + (int)Math.pow(probe, 2)) % capacity).equals(item)) {
				return true;
			}
			probe++;
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
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}
	
	private void grow() {
		ArrayList<String> temp = list;
		list = new ArrayList<String>();
		capacity = nextPrime(capacity);
		this.size = 0;
		for (int i = 0; i < capacity; i++) {
			list.add(null);
		}
		for(String str: temp) {
			if(str != null) {
				add(str);
			}
		}
	}
	
	private int nextPrime(int input) {
		int counter;
		input++;
		while(true) {
			counter = 0;
			for (int i = 2; i <= Math.sqrt(input); i++) {
				if (input % i == 0)
					counter++;
			}
			if(counter == 0)
				return input;
			else {
				input++;
				continue;
			}
		}
	}
	
	
	
	
	
	
}

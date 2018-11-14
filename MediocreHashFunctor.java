package assignment10;

public class MediocreHashFunctor implements HashFunctor {

	@Override
	public int hash(String item) {
		int hash = 0;
		for (int i = 0; i < item.length(); i++) {
			hash = hash + item.charAt(i);
		}
		return hash;
	}

}

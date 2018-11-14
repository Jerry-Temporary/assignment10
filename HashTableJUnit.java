package assignment10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HashTableJUnit {

	//Quadratic Probing tests
	
	@Test
	void testBasicAddQuad() {
		QuadProbeHashTable tester = new QuadProbeHashTable(13, new BadHashFunctor());
		assertTrue(tester.add("car"));
		assertTrue(tester.contains("car"));
		assertFalse(tester.contains("gnar"));
		assertTrue(tester.add("gnar"));
		assertTrue(tester.contains("gnar"));
		assertFalse(tester.add("gnar"));
		assertTrue(tester.add("tar"));
		assertTrue(tester.contains("tar"));
		assertFalse(tester.contains("far"));
		assertTrue(tester.add("five"));
		assertTrue(tester.add("six"));
		assertTrue(tester.add("seven"));
		assertTrue(tester.add("longerthan13letters"));
		assertTrue(tester.add("onemoreitem"));
		
		ArrayList<String> myStrings = new ArrayList<String>();
		myStrings.add("car");
		myStrings.add("gnar");
		myStrings.add("tar");
		myStrings.add("five");
		myStrings.add("six");
		myStrings.add("seven");
		myStrings.add("longerthan13letters");
		myStrings.add("onemoreitem");
		
		assertTrue(tester.containsAll(myStrings));
		
	}
	
	@Test
	void testAddAllQuad() {
		QuadProbeHashTable tester = new QuadProbeHashTable(13, new BadHashFunctor());
		ArrayList<String> myStrings = new ArrayList<String>();
		myStrings.add("car");
		myStrings.add("gnar");
		myStrings.add("tar");
		myStrings.add("five");
		myStrings.add("six");
		myStrings.add("seven");
		myStrings.add("longerthan13letters");
		myStrings.add("onemoreitem");
		
		tester.addAll(myStrings);
		
		assertTrue(tester.containsAll(myStrings));
		
	}
	
	@Test
	void testAddAllChaining() {
		ChainingHashTable tester = new ChainingHashTable(13, new BadHashFunctor());
		ArrayList<String> myStrings = new ArrayList<String>();
		myStrings.add("car");
		myStrings.add("gnar");
		myStrings.add("tar");
		myStrings.add("five");
		myStrings.add("six");
		myStrings.add("seven");
		myStrings.add("longerthan13letters");
		myStrings.add("onemoreitem");
		
		tester.addAll(myStrings);
		
		assertTrue(tester.containsAll(myStrings));
		
	}
	
	//SeperateChainingHashTable
	@Test
	void testBasicAddChain() {
		ChainingHashTable tester = new ChainingHashTable(13, new BadHashFunctor());
		assertTrue(tester.add("car"));
		assertTrue(tester.contains("car"));
		assertFalse(tester.contains("gnar"));
		assertTrue(tester.add("gnar"));
		assertTrue(tester.contains("gnar"));
		assertFalse(tester.add("gnar"));
		assertTrue(tester.add("tar"));
		assertTrue(tester.contains("tar"));
		assertFalse(tester.contains("far"));
		assertTrue(tester.add("five"));
		assertTrue(tester.add("six"));
		assertTrue(tester.add("seven"));
		assertTrue(tester.add("longerthan13letters"));
		assertTrue(tester.add("onemoreitem"));
		
		ArrayList<String> myStrings = new ArrayList<String>();
		myStrings.add("car");
		myStrings.add("gnar");
		myStrings.add("tar");
		myStrings.add("five");
		myStrings.add("six");
		myStrings.add("seven");
		myStrings.add("longerthan13letters");
		myStrings.add("onemoreitem");
		
		assertTrue(tester.containsAll(myStrings));
	}

}

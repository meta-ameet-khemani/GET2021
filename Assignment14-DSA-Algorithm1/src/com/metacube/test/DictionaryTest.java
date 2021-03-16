package com.metacube.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.metacube.assignment.dictionary.Dictionary;
import com.metacube.assignment.dictionary.MyDictionary;
import com.metacube.assignment.dictionary.Value;

/**
 * DictionaryTest class is used for testing Dictionary
 * @author ameet.khemani_metacu
 *
 */
public class DictionaryTest {

	/**
	 * Test case for adding a node
	 */
	@Test
	public void addNodeTest () {
		String value = new String();
		try {
			FileReader file = new FileReader(new File("data.json"));
			JSONParser parser = new JSONParser();
			
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new MyDictionary(json);
			
			value = dictionary.getValue("20");
			assertEquals(value, "twenty");
			
			value = dictionary.getValue("30");
			assertEquals(value, "thirty");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for getting all values from tree
	 */
	@Test
	public void getAllValuesTest () {
		try {
			FileReader file = new FileReader("data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new MyDictionary(json);
			List<Value> expectedValues = new ArrayList<Value>();
			
			expectedValues.add(new Value("10", "ten"));
			expectedValues.add(new Value("20", "twenty"));
			expectedValues.add(new Value("30", "thirty"));
			expectedValues.add(new Value("40", "fourty"));
			expectedValues.add(new Value("50", "fifty"));
			
			List<Value> valuesList = dictionary.getAll();
			
			for (int index = 0; index < expectedValues.size(); index++) {
				assertEquals(expectedValues.get(index).getKey(), valuesList.get(index).getKey());
				assertEquals(expectedValues.get(index).getValue(), valuesList.get(index).getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for checking in between values
	 */
	@Test
	public void getBetweenTest () {
		try {
			FileReader file = new FileReader("data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new MyDictionary(json);
			List<Value> expectedValues = new ArrayList<Value>();
			
			expectedValues.add(new Value("20", "twenty"));
			expectedValues.add(new Value("30", "thirty"));
			expectedValues.add(new Value("40", "fourty"));
			
			List<Value> valuesList = dictionary.getBetween("10", "50");
			
			for (int index = 0; index < expectedValues.size(); index++) {
				assertEquals(expectedValues.get(index).getKey(), valuesList.get(index).getKey());
				assertEquals(expectedValues.get(index).getValue(), valuesList.get(index).getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for deleting a node
	 */
	@Test
	public void deleteTest () {
		try {
			FileReader file = new FileReader("data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new MyDictionary(json);
			List<Value> expectedValues = new ArrayList<Value>();
			
			expectedValues.add(new Value("10", "ten"));
			expectedValues.add(new Value("20", "twenty"));
			expectedValues.add(new Value("40", "fourty"));
			expectedValues.add(new Value("50", "fifty"));
			expectedValues.add(new Value("60", "sixty"));
			expectedValues.add(new Value("70", "seventy"));
			expectedValues.add(new Value("80", "eighty"));
			
			dictionary.delete("30");
			List<Value> valuesList = dictionary.getAll();
			
			for (int index = 0; index < expectedValues.size(); index++) {
				assertEquals(expectedValues.get(index).getKey(), valuesList.get(index).getKey());
				assertEquals(expectedValues.get(index).getValue(), valuesList.get(index).getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for getting a value of node
	 */
	@Test
	public void getValueTest () {
		try {
			FileReader file = new FileReader("data.json");
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(file);
			Dictionary dictionary = new MyDictionary(json);
			
			assertEquals("fifty", dictionary.getValue("50"));
			assertEquals("seventy", dictionary.getValue("70"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test case for passing null as value to node
	 * @throws Exception
	 */
	@Test (expected = AssertionError.class)
	public void nullValueTest () throws Exception {
		Dictionary dictionary = new MyDictionary();
		dictionary.add(null, "value");
	}
	
	/**
	 * Test case for passing null as key to node
	 * @throws Exception
	 */
	@Test (expected = AssertionError.class)
	public void nullKeyTest () throws Exception {
		Dictionary dictionary = new MyDictionary();
		dictionary.add("null", null);
	}

}

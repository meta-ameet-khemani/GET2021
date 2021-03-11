package com.metacube.Q3Counselling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Counselling class used to process the allotment of streams to students
 * @author ameet.khemani_metacu
 */
public class Counselling {
	
	// queue to maintain students
	static Queue<String> students = new LinkedList<String>();
	
	// Map to store streams with maximum students allowed
	static HashMap<String, Double> streamCapacity = new HashMap<>();
	
	// Map to store students prefered stream
	static HashMap<String, String> studentPreference = new HashMap<>();
	
	/**
	 * Reads and processes the file which stores streams along with their student capacities
	 * @param filename name of the excel file to read
	 */
	public void readStreamCapacityFile (String filename) {
		
		try {
			// convert file into stream
			FileInputStream input = new FileInputStream(new File(filename));
			
			// create a workbook from stream
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			
			// select sheet from file
			Sheet firstSheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator = firstSheet.iterator();
			
			// iterate through all rows
			while (iterator.hasNext()) {
				
				// create a row object
				Row nextRow = iterator.next();
				
				// iterate through columns of a row
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				String programName = null;
				Double capacity = null;
				
				while (cellIterator.hasNext()) {
					
					// create a column object
					Cell cell = cellIterator.next();
					if (nextRow.getRowNum() > 0) {
						
						// check the type of the data in column
						switch (cell.getCellType()) {
							case NUMERIC:
								capacity = cell.getNumericCellValue();
								break;
							case STRING:
								programName = cell.getStringCellValue();
								break;
						}
					}
				}
				
				// add row data to map
				if (programName != null && capacity != null) {
					streamCapacity.put(programName, capacity);
				}
			}
			
			// close workbook and stream
			workbook.close();
			input.close();
		
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Reads and processes the file which stores student prefered streams
	 * @param filename name of the excel file to read
	 */
	public void readStudentPreferenceFile (String filename) {
		
		try {
			// convert the file into stream
			FileInputStream input = new FileInputStream(new File(filename));
			
			// create workbook from that stream
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			
			// read the first sheet of file
			Sheet firstSheet = workbook.getSheetAt(0);
			
			Iterator<Row> iterator = firstSheet.iterator();
			
			// iterate through all rows
			while (iterator.hasNext()) {
				
				// create row object
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();			
				String student = null;
				String preference = null;
				
				// iterate through all columns
				while (cellIterator.hasNext()) {
					
					// create a column object
					Cell cell = cellIterator.next();
					if (nextRow.getRowNum() > 0) {
						if (cell.getColumnIndex() == 0) {
							
							// check the type of data of column
							switch (cell.getCellType()) {
								case STRING:
									student = cell.getStringCellValue();
									students.add(student);
									break;
							}	
						} else if (cell.getColumnIndex() == 1) {
							switch (cell.getCellType()) {
								case STRING:
									preference = cell.getStringCellValue();
									break;
							}
						}
					}
				}
				
				// add row to map
				if (student != null && preference != null) {
					studentPreference.put(student, preference);
				}
			}
			
			// close workbook and stream
			workbook.close();
			input.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	/**
	 * Used to process the allotment of stream to students
	 */
	public void allotStreams () {
		
		// list to hold the data we need to write to file
		List<StudentStream> dataToWrite = new ArrayList<StudentStream>();
		
		// heading of columns as first row
		dataToWrite.add(new StudentStream("Student Name", "Alloted Stream"));
		
		while (!students.isEmpty()) {
			
			// get the name of student
			String studentName = students.remove();
			
			// get all the preferences
			String pref = studentPreference.get(studentName);
			String preferences[] = pref.split(",");
			
			// iterate through preferences
			for (int loop = 0; loop < preferences.length; loop++) {
				String subject = preferences[loop];
				
				// get the maximum students allowed in a stream
				Double capacity = streamCapacity.get(subject);
				
				// if capacity allows then add the student else select next prefered stream
				if (capacity > 0) {
					capacity--;
					dataToWrite.add(new StudentStream(studentName, preferences[loop]));
					streamCapacity.put(subject, capacity);
					break;
				} else {
					continue;
				}
			}
		}
		System.out.println("data to write");
		for (StudentStream s : dataToWrite) {
			System.out.println(s.getStudentName() + " " + s.getAllotedStream());
		}
		
		// create a workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// create a sheet object
		XSSFSheet sheet = workbook.createSheet("Student Alloted Stream");
		
		int rowCount = 0;
		for (int i = 0; i < dataToWrite.size(); i++) {
			
			// create a row object
			Row row = sheet.createRow(rowCount++);
			
			// create student data as object
			StudentStream data = dataToWrite.get(i);
			
			int columnCount = 0;
			
			// create a new column in row
			Cell cell = row.createCell(columnCount++);
			
			if (data.getStudentName() instanceof String) {
				cell.setCellValue((String)data.getStudentName());
			}
			
			// add another column in same row
			cell = row.createCell(columnCount++);
			if (data.getAllotedStream() instanceof String) {
				cell.setCellValue((String)data.getAllotedStream());
			}
		}
		
		// add data to the file
		try (FileOutputStream outputStream = new FileOutputStream("Student Alloted Stream.xlsx")) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			System.out.println("File not found !!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// close workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates an excel file containing the names of students along with their prefered choices of stream separated by comma
	 */
	private void createStudentPreferencesFile () {
		
		// create a workbook object
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// create a sheet object
		XSSFSheet sheet = workbook.createSheet("Student Preference");
		
		// multidimensional array to store data
		Object[][] studentPreferences = {
				{"Name", "Preferences"},
				{"First", "CS,IT,EC,ME,CIVIL"},
				{"Second", "IT,CS,EC,ME,CIVIL"},
				{"Third", "CS,CIVIL,EC,ME,IT"},
				{"Fourth", "CS,CIVIL,EC,ME,IT"},
				{"Fifth", "IT,CIVIL,EC,ME,CIVIL"},
		};
		
		int rowCount = 0;
		
		// iterate through data
		for (Object[] studentPreference : studentPreferences) {
			
			// create a row object
			Row row = sheet.createRow(rowCount++);
			
			int columnCount = 0;
			for (Object field : studentPreference) {
				
				// create a column object
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					
					// add data to column
					cell.setCellValue((String)field);
				}
			}
		}
		
		// add complete data to excel file
		try (FileOutputStream outputStream = new FileOutputStream("StudentPreferences.xlsx")) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// close workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Creates an excel file containing the name of stream along with their maximum number of students allowed
	 */
	private void createStreamsWithCapacityFile () {
			
		// create a workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// create a sheet
		XSSFSheet sheet = workbook.createSheet("Streams Capacity");
		
		// create an object containing data
		Object[][] streamsCapacity = {
				{"Stream", "Capacity"},
				{"CS", 1},
				{"IT", 2},
				{"EC", 3},
				{"ME", 4},
				{"CIVIL", 5},
		};
		
		int rowCount = 0;
		
		// iterate through data
		for (Object[] streamCapacity : streamsCapacity) {
			
			// creates a row object
			Row row = sheet.createRow(rowCount++);
			
			int columnCount = 0;
			for (Object field : streamCapacity) {
				
				// create a new column object
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					
					// add data to column
					cell.setCellValue((String)field);
				} else if (field instanceof Integer) {
					
					// add data to column
					cell.setCellValue((Integer)field);
				}
			}
		}
		
		// add data to file
		try (FileOutputStream outputStream = new FileOutputStream("Streams Capacity.xlsx")) {
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// close workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main (String args[]) throws IOException {
		
		Counselling counselling = new Counselling ();
		counselling.createStudentPreferencesFile ();
		counselling.createStreamsWithCapacityFile ();
		
		counselling.readStreamCapacityFile ("Streams Capacity.xlsx");
		counselling.readStudentPreferenceFile ("StudentPreferences.xlsx");
		streamCapacity.entrySet ().forEach (program -> {
			System.out.println (program.getKey () + "  " + program.getValue ());
		});
		System.out.println ("=======================================");
		studentPreference.entrySet ().forEach (student -> {
			System.out.println (student.getKey () + "  " + student.getValue ());
		});
		System.out.println ("=======================================");
		counselling.allotStreams ();
	}
	
}

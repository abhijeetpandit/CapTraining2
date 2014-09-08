package org.abhi.a1.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Test1 {
	public static void main(String[] args) {
		try {
			CSVParser csvParser = CSVFormat.DEFAULT.parse(new FileReader("Book1.csv"));
			List<CSVRecord> csvRecords = csvParser.getRecords();
			for(CSVRecord csvRecord : csvRecords) {
				System.out.println(csvRecord);
				System.out.println(csvRecord.size());
				System.out.println(csvRecord.get(0));
				System.out.println(csvRecord.get(4));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

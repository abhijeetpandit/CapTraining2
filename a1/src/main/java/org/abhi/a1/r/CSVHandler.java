package org.abhi.a1.r;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.math.NumberUtils;

public class CSVHandler {
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVParser csvParser = CSVFormat.DEFAULT.parse(new FileReader("Book1.csv"));
		List<CSVRecord> csvRecords = csvParser.getRecords();
		
		Map<Integer, Integer> lotNoOccurances = new HashMap<>();
		
		for(CSVRecord csvRecord : csvRecords) {
			for(int i = 0; i < csvRecord.size(); i++) {
				Integer value = lotNoOccurances.get(NumberUtils.toInt(csvRecord.get(i)));
				if(value == null) {
					lotNoOccurances.put(NumberUtils.toInt(csvRecord.get(i)), 1);
				} else {
					lotNoOccurances.put(NumberUtils.toInt(csvRecord.get(i)), ++value);
				}
			}
		}
		
		Set<Entry<Integer, Integer>> entries = lotNoOccurances.entrySet();
		TreeSet<Entry<Integer, Integer>> treeSet = new TreeSet<>(new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		treeSet.addAll(entries);
		for(Entry<Integer, Integer> entry : treeSet) {
			System.out.println(entry);
		}
	}
}

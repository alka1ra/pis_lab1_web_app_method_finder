package datahandler;

import java.util.ArrayList;
import java.util.List;

public class DataFormer {
	static List<String> getFormattedMethods(List methods){
		List<String> strings = new ArrayList<String>();
		
		for(Object object: methods) {
			strings.add(object.toString());
		}
		
		return strings;
	}
}

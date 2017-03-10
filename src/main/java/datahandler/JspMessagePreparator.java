package datahandler;

import java.util.ArrayList;
import java.util.List;

public class JspMessagePreparator {
	public static List<String> getMessage(String className){
		Object message = MethodGetter.getMethods(className);

		return formatReturnMessage(message, className);
	}	
	
	private static List<String> formatReturnMessage(Object message, String className){
		List<String> returnMessages = new ArrayList<String>(); 
		
		if (message instanceof Integer){
			returnMessages.add("There is no class with such name.");
		} else if (message == null) {
			returnMessages.add("The class \"" + className + "\" does not have any methods.");
		} else if (message instanceof List) {
			returnMessages.add("The class \"" + className + "\" has next methods:");
			returnMessages.addAll(DataFormer.getFormattedMethods((List) message));
		} else {
			returnMessages.add("Unknown error.");
		}	
		
		return returnMessages;
	}
}
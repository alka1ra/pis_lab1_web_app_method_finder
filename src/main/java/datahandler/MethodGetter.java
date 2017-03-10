package datahandler;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MethodGetter {
	static Object getMethods(String className){
		Class cl;
        List<Method> listOfMethods = null;
        
        try {
        	cl = Class.forName(className);
        	listOfMethods = Arrays.asList(cl.getDeclaredMethods());
        	
        	if (listOfMethods.isEmpty()) return null;
        	
        } catch (ClassNotFoundException e ) {
        	return new Integer(0);
        }
		return listOfMethods;
	}
}

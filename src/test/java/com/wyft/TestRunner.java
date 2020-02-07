package com.wyft;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    //RUN THIS METHOD IN YOUR IDE TO EXECUTE TESTS
    public static void main(String[] args) throws Exception{
    	System.out.println("Starting Tests....");
    	System.out.println("|-----------------------------------------------------------------------------------------------|");

    	//UNCOMMENT THIS AND COMMENT LINES 16 thru 23 TO RUN A SINGLE TEST
    	//runSingleTest("cancelRideShouldReturnAlreadyInProgress_whenRideHasAlreadyStarted");

        Method[] testMethods = Tests.class.getMethods();
        for (Method m : testMethods){
            if (m.getReturnType().equals(Void.TYPE) && !m.getName().equals("wait") && !m.getName().equals("notify") && !m.getName().equals("notifyAll")){
                m.invoke(new Tests());
                System.out.print(" | " + m.getName() + "\n");
                System.out.println("|-----------------------------------------------------------------------------------------------|");
            }
        }
    }

    private static void runSingleTest(String testName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method testMethod = Tests.class.getMethod(testName);

		testMethod.invoke(new Tests());
		System.out.print(" | " + testMethod.getName() + "\n");
		System.out.println("-------------------------------------------------------------");

	}
}

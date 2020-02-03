package com.wyft;

public class TestHelper {

	public static void assertEquals(String expected, String actual){
		if (expected.equals(actual)){
			System.out.print("| PASS");
		} else {
			System.out.print("| FAIL");
		}
	}

	public static void assertEquals(int expected, int actual){
		if (expected == actual){
			System.out.print("| PASS");
		} else {
			System.out.print("| FAIL");
		}
	}
}

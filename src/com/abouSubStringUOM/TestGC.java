package com.abouSubStringUOM;

/*
 * VM args: -Xmx20m -Xmx20m -XX:HeapDumpOnOutOfMemaryError
 */
	public class TestGC {
	    private String largeString = new String(new byte[100000]);

	    String getString() {
	        //return this.largeString.substring(0,2);
	      return new String("ab");
	    }

	    public static void main(String[] args) {
	        java.util.ArrayList list = new java.util.ArrayList();
	        for (int i = 0; i < 1000000; i++) {
	        	System.out.println(i);
	            TestGC gc = new TestGC();
	            list.add(gc.getString());
	        }

	    }
	}


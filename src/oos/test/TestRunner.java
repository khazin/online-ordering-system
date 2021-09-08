package oos.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(
		  oos.test.ProductListTest.class, // First Test Class
		  oos.test.CustomerListTest.class, // Second Test Class
		  oos.test.OrderListTest.class // Third Test Class
      );

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }


      System.out.println(result.wasSuccessful());
   }
}
import java.util.*;
import java.io.*;

public class Ex2 {
  static int hashcode(String s) {
    int hash = 0;
    int n = s.length();

    for (int i = 0; i < n; i++) {
      hash = 31*hash + s.charAt(i);
      System.out.println("hash now: " + hash);
    }
    return hash;
  }

  public static void main(String[] argv) {
    String s1 = "hello";
    String s2 = "world";
    System.out.println(s1);
    System.out.println("s1: " + hashcode(s1) + " " + s1.hashCode());
    System.out.println(s2);
    System.out.println("s2: " + hashcode(s2) + " " + s2.hashCode());
  }
}

/*
 int hash = 0;
 int n = s.length();
 for (int i = 0; i < n; i ++) 
 hash = a * hash + s.charAt(i);
*/

import java.util.*;
import java.io.*;

public class Ex1 {
  
  public static void main(String[] args) {
    Integer i = 10;
    Integer j = 10;
    Integer k = 20;
    System.out.println("i: " + i.hashCode());
    System.out.println("j: " + j.hashCode());
    System.out.println("k: " + k.hashCode());

    Float f1 = new Float(10.1);
    Float f2 = new Float(10.11);
    System.out.println("f1: " + ((Integer)Float.floatToIntBits(f1)).hashCode());
    System.out.println("f2: " + ((Integer)Float.floatToIntBits(f2)).hashCode());

    String s1 = "hello";
    String s2 = "hello";
    String s3 = "world";
    System.out.println("s1: " + s1.hashCode());
    System.out.println("s2: " + s2.hashCode());
    System.out.println("s3: " + s3.hashCode());

    int[] A = {1, 2, 3};
    int[] B = A;
    int[] C = {1, 2, 3};
    System.out.println("array A: " + A.hashCode());
    System.out.println("array B: " + B.hashCode());
    System.out.println("array C: " + C.hashCode());
  }
}


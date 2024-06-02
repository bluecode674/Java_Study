import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.List;

public class Main {
   public static void main(String[] args) {
      int intArray[] = new int[10];
      Scanner scan = new Scanner(System.in);
      
      System.out.println("10개의 정수를 입력하세요");
      for(int k=0; k<10; k++) {
         int n = scan.nextInt();
         intArray[k] = n;
      }
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i=0; i<10; i++) {
         int min = intArray[i];
         for(int j=i+1; j<10; j++) {
            if (intArray[j] < min) {
               min = intArray[j];
               intArray[j] = intArray[i];
               intArray[i] = min;
               //intArray[] = 
               //System.out.println(min);
            }
            arr.remove(intArray[j]);
            //intArray[i] = min;   
         }
           //intArray[i] = min;
          // 새로 할당이 아닌 자리가 바뀌어야함
         //System.out.println(min);
      }
      for(int m=0; m<10; m++) {
         System.out.print(intArray[m] + " ");
      }
      scan.close();
   }
}
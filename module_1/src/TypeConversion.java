public class TypeConversion 
{ 
   public static void main (String args []) 
   { 
      /* Define constant PI */
       final double PI = 3.141592654; 

      /* Assign product as double result */
       double dProduct = PI * 3.45; 
 
      /* Assign product as converted (float) result */
      float fProduct = (float) PI * 3.52f;
 
      /* Assign product as converted integer (int) result */
      int iProduct = (int) PI * 50;
 
      /* Print products */
       System.out.println ("Product as double:" + dProduct); 
      System.out.println ("Product as float:" + fProduct); 
      System.out.println ("Product as integer:" + iProduct); 

   
   } 
}

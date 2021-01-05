import java.util.*;
public class digits
{
   private ArrayList <Integer> digitList; 
   public digits(int n)
   {
      digitList = new ArrayList <Integer>();
      int temp = 0;
      if(n == 0)
      {
         digitList.add(0,n);
      }
      while(n >= 1)
      {
         System.out.println(digitList);
         temp = n % 10;
         digitList.add(0,temp);
         n = (n - temp)/10;
      }
      System.out.println(digitList);
   }
   
   public boolean isStrictlyIncreasing()
   {
      if(digitList.size() == 1)
      {
         return true;
      }
      for(int i = 0; i < digitList.size()-1; i++)
      {
         if(digitList.get(i) >= digitList.get(i+1))
         {
            return false;
         }
      }
      return true;
   }
   
   public static void main(String[] args)
   {
      digits a = new digits(987654321);
      System.out.println(a.isStrictlyIncreasing());
   }
}
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class bankAcc
{
   private String name;
   private double balance;
   
   public String getName()
   {
      return name;
   }
     
   public double getBal()
   {
      return balance;
   }
   
   public bankAcc(String n, double b)
   {
      name = n;
      balance = b;
   }
   
   public int compareTo(bankAcc other)
   {
   int compareVal = this.getName().compareTo(other.getName());    
      return compareVal;
   }

   private static void swap(List<bankAcc> list, int a, int b)
   {
         bankAcc temp = list.get(a);
         list.set(a, list.get(b)); 
         list.set(b, temp);                 
   }

   public String toString()
   {
      return name+" has $"+balance;
   
   }
   
   public static void selSort (List<bankAcc> list)
   {
      int min; 
      int size = list.size();
      
      for (int x=0; x < size; x++)
      {						
      
         min = x;
         
         for (int y = x + 1; y < size; y++)
         {
            if (list.get(y).compareTo(list.get(min)) < 0)	      
            min = y;
         }
         swap (list, x, min);
      }
    }
    public static bankAcc binSearch(List<bankAcc> list, String key)
{
     int left = 0;			//left index of subarray to search in
     int right = list.size()-1;	//right index of subarray to search in
     while(left <= right)
     {
          int mid = (left+right)/2;	//find index in the middle of subarray
          if(list.get(mid).getName().compareTo(key) == 0)
               return list.get(mid);		//we found it – return its index
          if(key.compareTo(list.get(mid).getName()) < 0)
               right = mid - 1;		//search in left side
          else
               left = mid + 1;		//seach in right side
     }
     return null;			//key not found in array
}

      public static bankAcc linSearch(List<bankAcc> list)
      {
         bankAcc maxVal = list.get(0);  
         for(int i = 1; i < list.size(); i++)
         {
            if(list.get(i).getBal() > maxVal.getBal())
            {
               maxVal = list.get(i);
            } 
         }
         return maxVal;
      }
   public static void main(String[] args)throws IOException
   {
      Scanner fileInput = new Scanner(new FileReader("account.txt"));
      List<bankAcc> accountList = new ArrayList <bankAcc>();
      while(fileInput.hasNextLine())
      {
         String line = fileInput.nextLine();
         String[] temp = line.split(",");
         String temp1 = temp[0];
         double temp2 = Double.parseDouble(temp[1]);
         bankAcc a = new bankAcc(temp1, temp2);
         accountList.add(a);
      }
      for(int i = 0; i < accountList.size(); i++)
         {
            System.out.println(accountList.get(i));
         }
       
       selSort(accountList);
       System.out.println("Sorted by name:");
       for(int i = 0; i < accountList.size(); i++)
         {
            System.out.println(accountList.get(i));
         }
         System.out.println("Enter account name:");
         Scanner keyboard = new Scanner (System.in);
         String key = keyboard.nextLine();
         bankAcc returnVal = binSearch(accountList, key);
         System.out.println("Found at: "+returnVal.toString());
         bankAcc maxBal = linSearch(accountList);
         System.out.println(maxBal.toString());
         
         
   }


}
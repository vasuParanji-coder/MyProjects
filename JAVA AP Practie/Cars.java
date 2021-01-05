import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Cars
{
   private String carName;
   private int carNum;
   
   public Cars(){
      
   }
   
   public Cars(String s, int i){
      carName = s;
      carNum = i;
   }

   public String getName()
   {
      return carName;
   }
     
   public int getNum()
   {
      return carNum;
   }
   
public int compareTo(Cars other)
{
   int compareVal = this.getName().compareTo(other.getName());

   if(compareVal == 0)
   {  
      if(this.getNum() < other.getNum())
         compareVal = -1;
         
      else if (this.getNum() == other.getNum())
         compareVal = 0;
         
      else 
         compareVal = 1;
   }   
    
   return compareVal;
}

   public static void dislayArray(Cars [] carList)
   {
      for(int i = 0; i < carList.length; i++)
      {
         System.out.println(carList[i].getName() + " " + carList[i].getNum());
      }
   } 
   
    public static void dislayArray(List<Cars> list)
   {
      for(Cars c : list)
      {
         System.out.println(c.getName() + " " + c.getNum());
      }
   } 

   
   public static void insertionSort(List<Cars> list)
{
   for (int x=1; x< list.size(); x++)
   {
      Cars key = list.get(x);
      int j = x - 1;      			
       while (j>=0 && list.get(j).compareTo(key) > 0)  	
      {
         list.set(j+1, list.get(j));       		
          j-- ;
      }				   
      list.set(j+1,key);		
   }
}

public static int binSearch(List<Cars> list, String key)
{
     int left = 0;			//left index of subarray to search in
     int right = list.size()-1;	//right index of subarray to search in
     while(left <= right)
     {
          int mid = (left+right)/2;	//find index in the middle of subarray
          if(list.get(mid).getName().compareTo(key) == 0)
               return mid;		//we found it – return its index
          if(key.compareTo(list.get(mid).getName()) < 0)
               right = mid - 1;		//search in left side
          else
               left = mid + 1;		//seach in right side
     }
     return -1;			//key not found in array
}


   
   /*public static Cars[] insertionSort(Cars [] carList)
   {
      for(int x = 1; x < carList.length; x++)
      {
         Cars key = carList[x];
         int j = x-1;
            while(j>=0 && key.compareTo(carList[j]) <= 0)
            //while(j >= 0 && carList[j].getNum() >= key.getNum())
            {
               carList[j+1] = carList[j];       		
               j -- ;
            }				
            carList[j+1] = key;		
      }
      return carList;
      }
      */
      
      
      
      
      
  /*    public static int binSearch(Cars[]array, String key)
      {
     int left = 0;			//left index of subarray to search in
     int right = array.length-1;	//right index of subarray to search in
     while(left <= right)
      {
          int mid = (left+right)/2;	//find index in the middle of subarray
          if(array[mid].getName().equals(key))
               return mid;		//we found it – return its index
          if(key.compareTo(array[mid].getName())<0)
               right = mid - 1;		//search in left side
          else
               left = mid + 1;		//seach in right side
      }
     return -1;			//key not found in array
      }*/

         
      
   public static void main(String[] args)throws IOException
   {      
      Scanner fileInput = new Scanner(new FileReader("cars.txt"));
      //Cars[] carList = new Cars[10];
      List<Cars> carList = new ArrayList <Cars>();
      int i=0;
      while(fileInput.hasNextLine())
      {
         String line = fileInput.nextLine();
         String[] strs = line.split(", ");
         String temp = strs[0];
         int temp2 = Integer.parseInt(strs[1]);
            
         Cars a = new Cars(temp, temp2);
         //carList[i] = a;
         carList.add(a);
         //i++;
               }
      fileInput.close();
      
      dislayArray(carList);
    insertionSort(carList);  
      System.out.println("Sorted:");
      dislayArray(carList);  
      System.out.println("Enter the car you are searching for: ");
      Scanner keyboard = new Scanner(System.in);  
      String search = keyboard.nextLine();
      int pos = binSearch(carList,search);
      System.out.println("Found at: "+pos);
      
            
   }
    
}
import java.util.*;
public class ascendingSorter
{
   public static int[] insertionSort(int [] sorter)
   {
      for(int x = 1; x < sorter.length; x++)
      {
         int key = sorter[x];
         int j = x-1;
            while(j >= 0 && sorter[j] >= key)
            {
               sorter[j+1] = sorter[j];       		
               j -- ;
            }				
            sorter[j+1] = key;		
      }
      return sorter;
   }
   public static void main (String[] args)
   {
      int [] sorter = new int[20];
      System.out.println("Enter 20 values to be sorted: ");
      Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < 5; i++)
         {
         int temp = keyboard.nextInt();
         sorter [i] = temp;
         }
         
         System.out.println("Unsorted");
         for(int i = 0; i < sorter.length; i++ )
         {
            System.out.println(" "+sorter[i]);
         }    
         
         sorter = insertionSort(sorter);
          System.out.println("Sorted");
         for(int i = 0; i < sorter.length; i++ )
         {
            System.out.println(" "+sorter[i]);
         }    
    }

}
public class AP2
{
public static void longestStreak(String str)
{
   int count = 1; String old = str.substring(0,1);
   int maxCount = 0; String maxChar = "";
   for(int i = 1; i < str.length(); i++)
   {
      current = str.substring(i,i+1);
      if(old.equals(current))
      count++;
   }
   
      else
      {
         count = 1;
         old = current;
      }  
         
      else if(count>maxCount)
      {
         maxCount = count;
         maChar = old;
      }   
      System.out.println(count);
   }
}

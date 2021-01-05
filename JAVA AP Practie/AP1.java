public class AP1
{
public void merge(Customer[] list1, Customer[] list2, Customer[] result)
{
   int count1 = 0; int count2 = 0;
   for(int i = 0; i < result.length; i++)
   {
       if(list1[count1]).compareCustomer(list2[count2]) < 0)
       {
         result[i] = list1[count1];
         count1++;
       }
       else if(list1[count1]).compareCustomer(list2[count2]) > 0)
       {
         result[i] = list2[count2];
         count2++;
       }
       else 
       {
         result[i] = list1[count1];
         count1++;
         count2++;
       }
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


   }
}
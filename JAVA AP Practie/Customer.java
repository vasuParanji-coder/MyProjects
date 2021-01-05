public class Customer
{
   String customerName;
   int customerId;
   public Customer(String n, int id)
   {  
      customerName = n;
      customerId = id;
   }
   
   public String getName()
   {
      return customerName;
   }
   
   public int getNum()
   {
      return customerId;
   }
   
   public String toString()
   {
      return customerName+"'s id is "+customerId;
   }
   public int compareCustomer(Customer other)
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
   
   public void perfixMerge(Customer[] list1, Customer[] list2, Customer[] result)
   {  
      int count1 = 0;
      int count2 = 0;
      for(int i = 0; i < result.length; i++)
      {
         if(list1[count1].compareCustomer(list2[count2]) < 0)
         {
            result[i] = list1[count1];
            count1++;  
         }
         
         else if(list1[count1].compareCustomer(list2[count2]) == 0)
         {
            result[i] = list2[count2];
            count1++;
            count2++;
         }
         
         else
         {
            result[i] = list2[count2];
            count2++;
         }
      }
   }
   
   public static void main(String[] args)
   {
      Customer c1 = new Customer("Smith", 1001);
      Customer c2 = new Customer("Adam", 1002);
      Customer c3 = new Customer("Smith", 1003);
      System.out.println(c1.compareCustomer(c1));
      System.out.println(c1.compareCustomer(c2));
      System.out.println(c1.compareCustomer(c3));
      
      Customer[] list = new Customer[5];
      Customer[] list1 = new Customer[6];
      Customer[] list2 = new Customer[7];
      
      list1[0] = new Customer("V", 1992);
      list1[1] = new Customer("Va", 1994);
      list1[2] = new Customer("Vs", 1983);
      list1[3] = new Customer("Vu", 2831);
      list1[4] = new Customer("Vd", 2477);
      list1[5] = new Customer("Ve", 1922);
      
      list2[0] = new Customer("A", 1823);
      list2[1] = new Customer("Va", 2847);
      list2[2] = new Customer("Vt", 2832);
      list2[3] = new Customer("Vy", 4723);
      list2[4] = new Customer("Vq", 1923);
      list2[5] = new Customer("Vei", 1234);
      list2[6] = new Customer("Vep", 9876);
      
      Customer x = new Customer("a", 1);
      
      x.perfixMerge(list1, list2, list);
      
      for(int i = 0; i < list.length; i++)
      {
         System.out.println(list[i]);
      }      
   }
}
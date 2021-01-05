public class ab
{
      // Precondition: b > 0
      public static int surprise(int b)
      {
      if ((b % 2) == 0)
      {
      if (b < 10)
      return b;
      else
      return ((b % 10) + surprise(b / 10));
      }
      else
      {
      if (b < 10)
      return 0;
      else
      return surprise(b / 10);
      }
      }
      
         public static int addFun(int n)
   {
      if (n <= 0)
   return 0;
      if (n == 1)
   return 2;
      return addFun(n - 1) + addFun(n - 2);
   }
   
   public static void merge(int[] arr, int from, int middle, int to, int[] temp)
   {
      System.out.println("Hello");
   }
   
   public static void mergeSortHelper(int[] arr,

int from, int to, int[] temp)

{

if (from < to)

{

int middle = (from + to) / 2;

mergeSortHelper(arr, from, middle, temp);

mergeSortHelper(arr, middle + 1, to, temp);

merge(arr, from, middle, to, temp);

}

}
   public static void main(String[] args)
   {
      System.out.println(surprise(146781));
      System.out.println(surprise(7754));
      System.out.println(surprise(58216));
      System.out.println(addFun(6));
      
      int[] numbers = {40, 10, 20, 30};

      int[] temp = new int[numbers.length];

      mergeSortHelper(numbers, 0, numbers.length - 1, temp);

   }      
      
}
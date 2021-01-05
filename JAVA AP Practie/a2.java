public static int hailStoneLength(int n)
{
   int length = 1;
 while(n != 1)
 {
   if(n % 2 == 0)
   {
      n = n/2;
      length++;
   }
   
   else
   {
      n = 3*n + 1;
      length++;
   }
 } 
   return length;
}

/*
public static double porpLong(int n)
Decalre a vairable to store the count of numLongSeq and
assign it to 0.0-double isLongCount = 0.0;
Create a for loop starting with n and decrementing to 1,
decrementing by 1 each time
Create a local boolean variable that stores the value of the method
isLongSeq- boolean isLong = isLongSeq(n)
Increment the isLongCount variable by 1 everytime the boolean isLongSeq is true
else do nothing
When loop finishes return the value of isLongCount divided by n;
*/
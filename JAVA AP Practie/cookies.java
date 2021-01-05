public class cookies
{  
   public int getTotalBoxes()
   {
      int totalBoxes = 0;
      for(int i = 0; i < orders.size(); i++)
      {
         totalBoxes += orders.get(i).getNumBoxes();
      }
      return totalBoxes;
   }
   
   public int removeVariety(String cookieVar)
   {
      int removedCookies = 0;
      CookieOrder removed;
      for(int i = 0; i < orders.size(); i++)
      {
         if(orders.get(i).getVariety().equals(cookieVar))
         {
            removed = orders.remove(i);
            removedCookies += removed.getNumBoxes();
            i--;
         }
      }
      return removedCookies;
   }
}
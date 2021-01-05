public class battery
{
   private int[] rateTable;
   
   public battery(int[] costs)
   {
      rateTable = costs;
   }
   public int getChargingCost(int startHour, int chargeTime)
   {
      int total = 0;
      while(chargeTime > 0)
      {
         total += rateTable[startHour];
         startHour++;
         if(startHour >= rateTable.length)
         {
            startHour = 0;
         }  
         chargeTime--;
      }
      return total;
   }
   
   public int getChargeStartTime(int chargeTime)
   {
      int mostEconomical = Integer.MAX_VALUE;
      int mostEconIndex = -1;
      for(int i = 0; i < rateTable.length; i++)
      {
         int totalCost = getChargingCost(i,chargeTime);
         if(totalCost < mostEconomical)
         {
            mostEconomical = totalCost;
            mostEconIndex = i;
         }
      }
      return mostEconIndex;
   }
   
   public static void main(String[] args)
   {
      int[] cost = {50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};
      battery x = new battery(cost);
      int n = x.getChargingCost(0,2);
      int k = x.getChargeStartTime(3);
      System.out.println(k);
      System.out.println(n);
   }
}
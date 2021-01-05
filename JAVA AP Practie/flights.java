public class flights
{
   public int getDuration()
   {
      int firstFlight = 0;
      int lastFlight = flights.size()-1;
      if(flights.size() == 0)
         return 0;
      
      int totalTime = flights.get(lastFlight).getArrivalTime().minutesUntil(flights.get(firstFlight).getDepartureTime());
         return totalTime;
   }
   
   public int getShortestLayover()
   {
     int shortestLayover = Integer.MAX_VALUE;
     if(flights.size() < 2)
         return -1;   
      for(int i = 0; i < flights.size()-1; i++)
      {
         int layOver = flights.get(i+1).getDepartureTime().minutesUntil(flights.get(i).getArrivalTime);
         if(layOver < shortestLayover)
         {
            shortestLayover = layOver;
         }
      }
      return shortestLayover;
   }
}
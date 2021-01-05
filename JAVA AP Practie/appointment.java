import java.util.*;
class TimeInterval
{
   public boolean overlapsWith(TimeInterval interval)
   {
      return false;
   }   
}

public class appointment
{
   private TimeInterval time;
   
   public TimeInterval getTime()
   {
      return time;
   }
   public boolean conflictsWith(appointment other)
   {
      if(this.getTime().overlapsWith(other.getTime()))
      {
         return true;
      }
      else
      {
         return false; 
      }
      
      /*can be collapsed into single line
      return this.getTime().overlapsWith(other.getTime()); */
   }
}

class DailySchedule
{
   private ArrayList <appointment> apptList;
   
   public DailySchedule()
   {
      apptList = new ArrayList<appointment>();
   }
   public boolean apptAdd(appointment appt, boolean emergency)
   {
      if(emergrncy == true)
      {
         appList.clearConflictsWith(appt);
         appList.add(appt);     
         return true;      
      }
      boolean isConflict = false;
      for(int i = 0; i < apptList.size(); i++)
      {
         if(apptList.get(i).conflictsWith(appt) == false)
         {
            apptList.add(appt);
            isConflict = true;
            break;
         }
      }
      return isConflict;
   }
      
   public void clearConflictsWith(appointment other)
   {
      for(int i = 0; i < apptList.size(); i++)
      {
         if(apptList.get(i).conflictsWith(other))
         {
            apptList.remove(i);
            i--;
         }
      }
   }
      boolean isConflicting = conflictsWith(appt);
      if( isConflicting == false)
      {
         appList.add(appt);
         return true;
      }
      return false;
   }
   
   public static void main(String[] args)
   {
      DailySchedule sch = new DailySchedule();
      
   }
}
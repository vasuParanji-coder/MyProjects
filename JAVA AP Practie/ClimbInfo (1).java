import java.util.*;
class ClimbInfo
{
   String _peakName;
   int _climbTime;
   public ClimbInfo(String s, int a)
   {
      _peakName = s;
      _climbTime = a;
   }
   public String getName() { return _peakName;}
   public int getTime() { return _climbTime;}  
   public String toString() { return _peakName + " in " + _climbTime + " secs";} 
}
class ClimbingClub
{
      private List<ClimbInfo> climbList;
      public ClimbingClub()
      {
         climbList = new ArrayList<ClimbInfo>();
      }
      public void addClimb(String peakName, int climbTime)
      {
         ClimbInfo climbVlaues = new ClimbInfo(peakName, climbTime);
         if(climbList.size() == 0)
         {
            climbList.add(climbVlaues);
            return;
         }
         for(int i = 0; i < climbList.size(); i++)
         {
            if(peakName.compareTo(climbList.get(i).getName())<=0)
            {
               climbList.add(i, climbVlaues);
               return;
            }
         }
         climbList.add(climbVlaues);
      }
      
      public String toString()
      {
         return climbList.toString();
      }
}
 class mockAPQ1
{
      
/*public static void insertionSort(List<ClimbInfo> list)
{
   for (int x=1; x< list.size(); x++)
   {
      ClimbInfo key = list.get(x);
      int j = x - 1;      			
       while (j>=0 && list.get(j).compareTo(key) > 0)  	
      {
         list.set(j+1, list.get(j));       		
          j-- ;
      }				   
      list.set(j+1,key);		
   }
}
*/
   public static void main(String[] ar)
   {
      ClimbingClub hikerClub = new ClimbingClub();
      
      hikerClub.addClimb("Monadnock", 274);
      hikerClub.addClimb("Whiteface", 301);
      hikerClub.addClimb("Algonquin", 225);
      hikerClub.addClimb("Monadnock", 344);

   System.out.println(hikerClub.toString());

   }
}
 
 
 

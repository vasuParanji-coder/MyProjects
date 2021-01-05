import java.util.*;
class cars
{
   private String carName;
   private int milesDriven;
   
   public String getName()
   {
      return carName;
   }
   
   public int getMiles()
   {
      return milesDriven;
   }
   
   public cars(String n, int m)
   {
      carName = n;
      milesDriven = m;
   }
   
   public String toString()
   {
      return carName+":"+milesDriven;
   }
}

public class carMax
{
   private ArrayList<cars> carList;
   
   public carMax(ArrayList<cars> inputCars)
   {
      carList = inputCars;   
   }
   public ArrayList<cars> getCarsWithinRange(int milesThreshold, boolean isGreater)
   {
      ArrayList <cars> greaterThan = new ArrayList<cars>();
      ArrayList<cars> lessThan = new ArrayList<cars>();
      for(int i = 0; i < carList.size(); i++)
      {
         if(carList.get(i).getMiles() >= milesThreshold && isGreater == true)
         {
            greaterThan.add(carList.get(i));
         }
         
         if(carList.get(i).getMiles() <= milesThreshold && isGreater == false) 
         {
            lessThan.add(carList.get(i));
         }  
      }
      if(isGreater == false)
      {
         return lessThan;
      }
      else
      {
         return greaterThan;
      }
   }
   
   public double percentCarsAvailable( int milesThreshold, boolean isGreater)
   {
      ArrayList<cars> temp = getCarsWithinRange(milesThreshold, isGreater);
      double percentAvailable = ((double)temp.size()/carList.size())*100;
      return percentAvailable;
   }
   
   public static void main(String[] arg)
   {
      ArrayList<cars> c = new ArrayList<cars>();
      c.add(new cars("Honda", 50000));
      c.add(new cars("Toyota", 25000));
      c.add(new cars("Simba", 15000));
      c.add(new cars("Hyundai", 5000));
      c.add(new cars("Tesla", 400));
      c.add(new cars("Benz", 30000));
      
      carMax cm = new carMax(c);
      
      System.out.println(cm.getCarsWithinRange(30000,false));
      System.out.println(cm.percentCarsAvailable(30000,false));
   }
}
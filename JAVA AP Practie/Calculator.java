import java.util.Scanner;
class studScores
{  
   private String name;
   private double scores;
   
   public String getName()
   {
      return name;
   }
   
   public double getScore()
   {
      return scores;
   }
   
   public String toString()
   {
      return name+":"+scores;
   }
   
   public studScores(String n, double s)
   {
      name = n;
      scores = s;
   }
}
public class Calculator
{
   public static double meanScore(studScores[] score)
   {
      double totalScore = 0.0;
      int count = 0;
      for(int i = 0; i < score.length; i++)
      {
         totalScore += score[i].getScore();
         count++;
      }
      return totalScore/count;
   }
   
   public static double standardDeviation(studScores[] stuScore)
   {
      double mean = meanScore(stuScore);
      double difference = 0.0;
      double standardDev = 0.0;
      double sum = 0.0;
      int count = 0;
      for(int i = 0; i < stuScore.length; i++)
      {
        difference = stuScore[i].getScore() - mean;
        sum += Math.pow(difference,2);
        count++;
      }
      standardDev = sum/count;
      standardDev = Math.sqrt(standardDev);
      return standardDev;
   }   
   
   
   public static void main(String[] args)
   {
      studScores[] ClassScores = new studScores[5];
      Scanner keyboard = new Scanner(System.in);
      int i = 0;
      while(i < 5)
      {
         System.out.println("Enter Student Name:");
         String name = keyboard.nextLine();
         System.out.println("Enter Student score:");
         double score = keyboard.nextDouble();
         studScores newStud = new studScores(name, score);
         ClassScores[i] = newStud;
         keyboard.nextLine();
         i++;
       } 
       for(int j = 0; j < ClassScores.length; j++)
       {
         System.out.println(ClassScores[j]);
       }
       double mean = meanScore(ClassScores);
       double standardDeviation = standardDeviation(ClassScores);
       System.out.print("Mean: "+mean+" Standard Deviation: "+standardDeviation);
  
   }
}
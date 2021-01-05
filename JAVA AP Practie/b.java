public boolean record(int score)
{
   ScoreInfo a = new ScoreInfo(score);
         
   for(int i = 0; i < scoreList.size(); i++)
   {
      if(scoreList.get(i).getScore() == score)
      {
         scoreList.get(i).increment();
         return false;
      }
      else if(scoreList.get(i).getScore() > score)
      {  
         scoreList.add(i,a);
         return true;
      }
   }
   scoreList.add(a);
   return true;
}

public void recordScores(int[] stuScores)
{
   for(int i = 0; i < stuScores.length; i++)
   {
       record(stuScore[i]);
   }
}

/*
public double getSeniorPercentage(int score)
Add int instance variable numSeniors in ScoreInfo class
private int numSenior; add getter method,
update constructor so it takes an additional boolean value showing
if a senior received this score.
When this boolean is true, set the number of seniors to 1
Pass a boolean indicating wether a senior got this score as parameter to increment method, 
it should check if the parameter boolean is true and increment the
numStudents and numSeniors, else the increment method just updates 
numStudents.
then return the double of numSeniors divided by numStudents
*/

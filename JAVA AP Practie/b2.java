public String recombine(String word1, String word2)
{
   return word1.substring(0,word1.length/2) + word2.substring(length/2,length);
}

/*
public boolean checkValidLength(String word1, String word2)
Create local variable that stores the value of recombine method passing word1 and word2 
as input in new String-String newString = recombine(word1, word2)
Then declare a local boolean which shows wether the word is valid
boolean isValid = true
Then add an if loop comparing the length of the new String with word1 and word2
and update the isValid boolean and return the isValid boolean
*/
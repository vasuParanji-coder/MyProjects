import java.util.*;
public class basicGapWidth
{
public static int totalLetters(List<String> wordList)
{
   int letCount = 0;
   for(int i = 0; i < wordList.size(); i++)
   {
      if(wordList.get(i).isEmpty() != true)
      {
         letCount += wordList.get(i).length();
      }
   }
   return letCount;
}

public static int basicWidthGap(List<String> wordList, int formattedLen)
{
   int letterCount = totalLetters(wordList);
   int spaceCount = wordList.size()-1;
   int availableSpaces = formattedLen - letterCount;
   int basicGap = availableSpaces/spaceCount;
   return basicGap;
}
public static int leftoverSpaces(List<String> wordList, int formattedLen)
{
   int l = totalLetters(wordList);
   int left = formattedLen - l -(basicWidthGap(wordList,formattedLen)*(wordList.size()-1));
   return left;
}

public static String format(List<String> wordList, int formattedLen)
{
   int gapWidth = basicWidthGap(wordList, formattedLen);
   int leftOverSpaces = leftoverSpaces(wordList, formattedLen);
   StringBuilder sb = new StringBuilder();
   for(int i = 0; i < wordList.size(); i++)
   {
      sb.append(wordList.get(i));
      for(int j=0; j<gapWidth; j++)
      {  
         sb.append(' ');
      }
      if(leftOverSpaces>0)
      {
         sb.append(' ');
         leftOverSpaces--;
      }
   }
   return sb.toString();
}
   public static void main(String[] a)
   {
      List<String> l = new ArrayList<String>();
      l.add("AP");
      l.add("COMP");
      l.add("SCI");
      l.add("ROCKS");
      System.out.println(format(l,20));
   }
}
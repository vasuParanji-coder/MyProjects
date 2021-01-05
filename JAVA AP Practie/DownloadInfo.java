import java.util.*;
public class DownloadInfo
{
   private String songName;
   private int timesDownloaded;
   
   public DownloadInfo(String title)
   {
     songName = title;
     timesDownloaded = 1; 
   }
   
   public String getTitle()
   {
      return songName;
   }
   
   public void incrementTimesDownloaded()
   {
      timesDownloaded++;
   }
   public String toString()
   {
      return songName + ":" + timesDownloaded;
   }
}  
class MusicDownload
{
   private List<DownloadInfo> downloadList;
   
   public MusicDownload()
   {
      downloadList = new ArrayList<DownloadInfo>();
   }
   public void display()
   {
      System.out.println(downloadList);
   }
   
   public DownloadInfo getDownloadInfo(String title)
   {
      for(int i = 0; i < downloadList.size(); i++)
      {
         if(downloadList.get(i).getTitle().equals(title))
            return downloadList.get(i);
      }
      return null;
   }
   
   public void updateDownloadList(List<String> titles)
   {
      for(int i = 0; i < titles.size(); i++)
      {
         boolean added = false;
         for(int j = 0; j < downloadList.size(); j++)
         {
            if(downloadList.get(j).getTitle().equals(titles.get(i)))
            {
               downloadList.get(j).incrementTimesDownloaded();
               added = true;
               break;
            }
            else
            {
               DownloadInfo newDownload = new DownloadInfo(titles.get(i));
               downloadList.add(newDownload);
               added = true;
               break;
            }
         }
         if(!added)
            downloadList.add(new DownloadInfo(titles.get(i)));
      }
   }
   
   public static void main(String[] args)
   {
      List<String> titles = new ArrayList<String>();
      titles.add("Hello");
      titles.add("How");
      titles.add("Was");
      titles.add("Your");
      titles.add("Day");
      titles.add("Hello");
      titles.add("Fire");
      titles.add("Start");
      titles.add("Star");
      System.out.println(titles);
     MusicDownload a = new MusicDownload();
     a.display();
     a.updateDownloadList(titles);
      a.display();
     DownloadInfo c = a.getDownloadInfo("Hello");
     System.out.println(c);
   }
}  
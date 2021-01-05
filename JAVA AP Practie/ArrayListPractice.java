import java.util.*;
public class ArrayListPractice{
public static void main(String[] args){
/*
List<String> names = new ArrayList<String>();

names.add("bob");
names.add("anna");
names.add("otto");
names.add(1, "pip");
System.out.println(names);

String gone = names.remove(0);
System.out.println(gone + " is gone");
System.out.println(names);
*/
List<Integer> nums = new ArrayList();
for(int i = 1; i < 20; i+=2){
   nums.add(new Integer(i));
 }
 int sum = 0; 
 for (Integer x : nums)
 sum = sum+ x.intValue();
 System.out.println(nums);
 System.out.println(sum);
 nums.remove(2);
 System.out.println(nums);
 nums.remove(new Integer(9));
 System.out.println(nums); 
}



}
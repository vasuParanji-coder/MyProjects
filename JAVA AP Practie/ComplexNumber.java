public class ComplexNumber{
   private int real;
   private int img;
   
   public ComplexNumber(){
   real = 0;
   img = 0;
   
   }
      
   public ComplexNumber(int r, int i){
      real = r;
      img = i;
   }
   public int getR(){
      return real;
   }
   
   public int getI(){
      return img;
   }
   public String toString(){
   return real+" + "+img+"i";
   
   }

}  
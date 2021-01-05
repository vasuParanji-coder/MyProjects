public class complexExample{ 
   public static void main(String[] args){
   complexNumber num1 = new complexNumber(1,5);
   
   System.out.println(num1.displayComplex());
   num1.setreal(6);
   num1.setimaginary(2);
   System.out.println(num1.displayComplex());
   
   }
}

class complexNumber{
   int real;
   int imaginary;
   
   public complexNumber(int r, int i){   
   real=r;
   imaginary=i;
  }
int getreal(){
     return real;
 }


int getimaginary(){
     return imaginary;
 }
 
  public void setreal(int newreal) {
    this.real = newreal;
   }
   
 public void setimaginary(int newimaginary) {
    this.imaginary = newimaginary;
}


  String displayComplex(){
         String val = "The complex number is " +real+ " + " +imaginary+ "i"; 
         return val;
     }


}
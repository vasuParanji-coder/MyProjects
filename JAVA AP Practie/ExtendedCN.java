public class ExtendedCN extends ComplexNumber{

public ExtendedCN(int r, int i){
   super(r, i);
   
}
public ExtendedCN add(ComplexNumber o){
   int r = getR()+o.getR();
   int i = getI()+o.getI();
   return new ExtendedCN(r,i);
}

public ExtendedCN sub(ComplexNumber o){
   int r = getR()-o.getR();
   int i = getI()-o.getI();
   return new ExtendedCN(r,i);

}
}
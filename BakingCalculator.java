//Terrence Urich//
import java.util.Scanner;
public class BakingCalculator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int cookieCount = s.nextInt();
        System.out.print("Enter number of Banana loafs: ");
        int loafCount = s.nextInt();

        System.out.println(loafCount);
        System.out.println(cookieCount);
        
        double flour = cookieCount*2.25/48 +loafCount*1.5;
        double salt = cookieCount/48 + loafCount*(1/8);
        double baking_soda = cookieCount/48 + loafCount;
        double vanilla = cookieCount/48 + loafCount;
        double eggs = cookieCount*2/48 + loafCount;
        double sugar = cookieCount*1.5/48 + loafCount*(3/4);
        double butter  = cookieCount*2/48 + loafCount*(1/3);
        double banana= loafCount*2;
        double chips = cookieCount*2.5/48;  
    
        //double cost = ((hops/2)*3.99) + malt*1.50 + yeast*2.59; 
        System.out.println(Math.ceil(flour/3.33) + " Bag(s) of flour");
        System.out.println(Math.ceil(salt/6)+ " ounces of salt");
        System.out.println(Math.ceil(baking_soda/60) + " box(es) of baking soda");
        System.out.println(Math.ceil(vanilla/6) + " bottles of vanilla");
        System.out.println(Math.ceil(eggs/12) +" Carton(s) of eggs");
        System.out.println(Math.ceil(sugar/2)  +" bag(s) of sugar");
        System.out.println(butter +" package(s) of butter");
        System.out.println(banana +" banana(s)");
        System.out.println(Math.ceil(chips/2) +" bag(s) of chocolate chips");
        //System.out.println("cost: "+"$"+cost);   
    }

}
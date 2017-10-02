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
        
        double cookieRecipe = (cookieCount/48);
        double flour = cookieRecipe*2.25 +loafCount*1.5;
        double salt = cookieRecipe + loafCount*(1/8);
        double baking_soda= cookieRecipe + loafCount;
        double vanilla= cookieRecipe + loafCount;
        double eggs= cookieRecipe*2 + loafCount;
        double sugar= cookieRecipe*1.5 + loafCount*(3/4);
        double butter= cookieRecipe*2 + loafCount*(1/3);
        double banana= loafCount*2;
        double chips= cookieRecipe*2.5;  
    
        //double cost = ((hops/2)*3.99) + malt*1.50 + yeast*2.59; 
        System.out.println(flour/3.33 + " Bag(s) of flour");
        System.out.println(salt/6+ " ounces of salt");
        System.out.println(baking_soda/60 + " box(es) of baking soda");
        System.out.println(vanilla/6 + " bottles of vanilla");
        System.out.println(eggs/12 +" Carton(s) of eggs");
        System.out.println(sugar/2  +" bag(s) of sugar");
        System.out.println(butter +" package(s) of butter");
        System.out.println(banana+" banana(s)");
        System.out.println(chips/2 +" bag(s) of chocolate chips");
        //System.out.println("cost: "+"$"+cost);        
    }

}
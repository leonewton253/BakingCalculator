//Terrence Urich//
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BakingCalculator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int cookieCount = s.nextInt();
        System.out.print("Enter number of Banana loafs: ");
        int loafCount = s.nextInt();
    
        
        double flour = cookieCount*(2.25/48) +loafCount*1.5;
        double salt = cookieCount/48 + loafCount/8;
        double baking_soda = cookieCount*(1/48) + loafCount;
        double vanilla = cookieCount*(1/48) + loafCount;
        double eggs = cookieCount*(2/48) + loafCount;
        double sugar = cookieCount*(1.5/48) + loafCount*(3/4);
        double butter  = cookieCount/48 + loafCount/3;
        double banana= loafCount*2;
        double chips = cookieCount*(2.5/48);  

        double flourP = (flour/3.33)/5;
        double saltP = (salt/6)/26;
        double baking_sodaP = (((baking_soda/6)/16)); 
        double vanillaP = vanilla/6; 
        double eggsP = eggs/12; 
        double sugarP = sugar/2;   
        double chipsP = chips/2; 
        double butterP = butter/2;
        

        double cost = flourP*2.50 + saltP*1.09 + baking_sodaP*1.09 + vanillaP*3.99 + eggsP*1.59 + sugarP*1.99 + chipsP*3.99 + banana*0.16 + butterP*4.19;
        System.out.println("Shopping list for "+cookieCount+" cookie(s)"+" and "+loafCount+" loaf(s) of bread:");
        System.out.println();
        System.out.println(flourP + " Bag(s) of flour");
        System.out.println(saltP + " package(s) of salt");
        System.out.println(baking_sodaP + " box(es) of baking soda");
        System.out.println(vanillaP + " bottles of vanilla");
        System.out.println(eggsP +" Carton(s) of eggs");
        System.out.println(sugarP  +" bag(s) of sugar");
        System.out.println(butterP +" package(s) of butter");
        System.out.println((int) banana +" banana(s)");
        System.out.println(chipsP +" bag(s) of chocolate chips");
        System.out.println();  
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(cost));

        

    }

}
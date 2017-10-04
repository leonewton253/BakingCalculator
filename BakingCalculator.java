//Terrence Urich//
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BakingCalculator {

    public static void main(String[] args) {
        int cookieCount= 24;
        int loafCount = 1;
        //Scanner functionality//
        
        //Scanner s = new Scanner(System.in);
        //System.out.print("Enter number of cookies: ");
        //int cookieCount = s.nextInt();
        //System.out.print("Enter number of Banana loafs: ");
        //int loafCount = s.nextInt();
    
        //Recipes//
        double flour = cookieCount*(2.25/48) +loafCount*1.5;
        double salt = cookieCount*(1.0/48.0) + loafCount*(1.0/8.0);
        double baking_soda = cookieCount*(1/48) + loafCount;
        double vanilla = cookieCount*(1/48) + loafCount;
        double eggs = cookieCount*(2/48) + loafCount;
        double sugar = cookieCount*(1.5/48) + loafCount*(3.0/4);
        double butter  = cookieCount/48.0 + loafCount/3.0;
        double banana= loafCount*2;
        double chips = cookieCount*(2.5/48);  
        //Converting to packaged quantities//
        double flourP = (int) Math.ceil((flour/3.33)/5);
        double saltP = (int) Math.ceil((salt/6.0)/26.0);
        double baking_sodaP =(int) Math.ceil(((baking_soda/6.0)/16.0)); 
        double vanillaP = (int) Math.ceil(vanilla/6.0); 
        double eggsP = (int) Math.ceil(eggs/12.0); 
        double sugarP = (int) Math.ceil(sugar/2.0);   
        double chipsP = (int) Math.ceil(chips/2.0); 
        double butterP = (int) Math.ceil(butter/2.0);
         //Calculate cost of each package//
        double cost = flourP*2.50 + saltP*1.09 + baking_sodaP*1.09 + vanillaP*3.99 + eggsP*1.59 + sugarP*1.99 + chipsP*3.99 + banana*0.16 + butterP*4.19;
        //Output Shopping list with cost//
        System.out.println("Shopping list for "+cookieCount+" cookie(s)"+" and "+loafCount+" loaf(s) of bread:");
        System.out.println((int) flourP + " Bag(s) of flour");
        System.out.println((int)saltP + " package(s) of salt");
        System.out.println((int)baking_sodaP + " box(es) of baking soda");
        System.out.println((int)vanillaP + " bottle(s) of vanilla extract");
        System.out.println((int)eggsP +" Carton(s) of eggs");
        System.out.println((int)sugarP  +" bag(s) of sugar");
        System.out.println((int)butterP +" package(s) of butter");
        System.out.println((int) banana +" banana(s)");
        System.out.println((int)chipsP +" bag(s) of chocolate chips");
        System.out.println();  
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(cost));
    }

}
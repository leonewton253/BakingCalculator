//Terrence Urich//
import java.util.Scanner;
public class BakingCalculator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of cookies: ");
        int cookieCount = s.nextInt();
        System.out.print("Enter number of Banana loafs: ");
        int loafCount = s.nextInt();
        
        double flour = cookieCount*2.25/48 +loafCount*1.5;
        double salt = cookieCount/48 + loafCount*(1/8);
        double baking_soda = cookieCount/48 + loafCount;
        double vanilla = cookieCount/48 + loafCount;
        double eggs = cookieCount*2/48 + loafCount;
        double sugar = cookieCount*1.5/48 + loafCount*(3/4);
        double butter  = cookieCount*2/48 + loafCount*(1/3);
        double banana= loafCount*2;
        double chips = cookieCount*2.5/48;  

        int flourP = (int) (Math.ceil(flour/3.33*5));
        int saltP = (int) (Math.ceil(salt/6*26));
        int baking_sodaP = (int) (Math.ceil(baking_soda/6*16)); 
        int vanillaP = (int) (Math.ceil(vanilla/6)); 
        int eggsP = (int) (Math.ceil(eggs/12)); 
        int sugarP = (int) (Math.ceil(sugar/2));   
        int chipsP = (int) (Math.ceil(chips/2)); 
        int butterP = (int) (Math.ceil(butter/4));
        

        double cost = flourP*2.50 + saltP*1.09 + baking_sodaP*1.09 + vanillaP*3.99 + eggsP*1.59 + sugarP*1.99 + chipsP*3.99 + banana*0.16 + butterP*4.19;
        System.out.println(flourP + " Bag(s) of flour");
        System.out.println(saltP + " package(s) of salt");
        System.out.println(baking_sodaP + " box(es) of baking soda");
        System.out.println(vanillaP + " bottles of vanilla");
        System.out.println(eggsP +" Carton(s) of eggs");
        System.out.println(sugarP  +" bag(s) of sugar");
        System.out.println(butterP +" package(s) of butter");
        System.out.println((int) banana +" banana(s)");
        System.out.println(chipsP +" bag(s) of chocolate chips");
        System.out.println("Total cost: "+"$"+cost);   
    }

}
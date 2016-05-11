/*
* Michael Cole
* 3.3.2016
* I-Tech AM
*
*
* packageDiscounts.java
 */

import java.util.*;
import java.text.*;


public class packageDiscountCalculator {

    //declarations
    static int quantity;
    static double subTotal;
    static double discountPct;
    static double discountAmount;
    static double total;
    static Scanner input = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("$00.00");


    public static void main(String[] args) {


        //input
        GetOrderQuantity();

        //processing
        GetDiscountRate();
        GetSubTotal();
        GetTotal();
        GetDiscountAmount();

        //output
        DisplayOrderInformation();

    }

    private static void GetOrderQuantity() {
        System.out.println("Our software packages are available at $99 each.");
        System.out.println("Bulk orders offer discount rates as follows: ");
        System.out.println("10-19 units gets 20% off");
        System.out.println("20-49 units gets 30% off");
        System.out.println("50-99 units gets 40% off");
        System.out.println("100 or more units gets 50% off");
        System.out.println("Please enter the number of units you will be ordering");
        quantity = input.nextInt();
    }

    private static void GetDiscountRate() {
        if (quantity >= 10 && quantity < 20) {
            discountPct = .2;
        } else if (quantity >= 20 && quantity < 50) {
            discountPct = .3;
        } else if (quantity >= 50 && quantity < 100) {
            discountPct = .4;
        } else if (quantity >= 100) {
            discountPct = .5;
        }
    }

    private static void GetSubTotal() {
        subTotal = quantity * 99;
    }

    private static void GetTotal() {
        total = subTotal * (1.0 - discountPct);
    }

    private static void GetDiscountAmount() {
        discountAmount = subTotal - total;
    }

    private static void DisplayOrderInformation() {
        System.out.println("You ordered a total of " + quantity + " units");
        if (discountPct != 0.0) {
            System.out.println("The subtotal is " + df.format(subTotal));
            System.out.println("You qualified for a discount of " + (discountPct * 100) + " % and are saving " + df.format(discountAmount));

        } else {
            System.out.println("You did not purchase enough units to qualify for a discount");
        }
        System.out.println("The order total is " + df.format(total));

        System.out.println();

    }

}

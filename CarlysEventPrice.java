/**
 * This program calculates the cost for an event,
 * and outputs the price per person, the total cost,
 * and whether or not it is a large event of 50 people
 * or over. It displays an error message if it
 * receives bad input.
 *
 * Travis Hurt
 * 6/11/2020
 */

import java.text.DecimalFormat;
import java.util.Scanner;
public class CarlysEventPrice {
    //Global variables
    static Scanner inputDevice;
    static DecimalFormat dfDouble3V2, dfInt3; //Format variables
    static final double RATE_PER_PERSON = 35; //Named Constant is declared
    public static void main(String[] args){
        init();
        int iGsts = inputGuests(); //Returning input to use in calcs
        double cTotal = calcs(iGsts); //Returning cTotal to be used in ouput
        output(iGsts, cTotal);// Two variable returned to be put in to output
    }

    private static void init() {
        //Setting input method
        inputDevice = new Scanner(System.in);

        //Written formatting for decimals
        dfDouble3V2 = new DecimalFormat("$##0.00");
        dfInt3 = new DecimalFormat("##0");
    }

    private static Integer inputGuests() {
        System.out.println("How many guests are attending?: ");
        //String iData = inputDevice.nextLine(); //input is converted from a string
        //int iGuests = Integer.parseInt(iData); //to an integer
        try { //try takes only the original intended input and returns it
            return Integer.parseInt(inputDevice.nextLine()); //iGuests is returned to the main
        }
        catch(Exception e) {//catch displays an error message and returns a 0
            System.out.println("You must enter a whole number.");
            System.out.println("Input has been changed to a 0.");
            return 0;
        }
    }

    private static double calcs(int iGuests) {
        return iGuests * RATE_PER_PERSON; //Calculated Total Price
    }

    private static void output(int iGuests, double cTotalPrice) {
        //Declaring and formatting output variables
        String oGuests = dfInt3.format(iGuests);
        String oTotalPrice = dfDouble3V2.format(cTotalPrice);
        String oRatePerPerson = dfDouble3V2.format(RATE_PER_PERSON);

        CarlysMotto2.output(); //Bring in output method for a heading from a separate class CarlysMotto2

        //printf statements format to make output into a horizontal table with headings
        System.out.printf("%-10s%5s%-12s%5s%-12s%5s%-12s\n", "Guests", " ",
                "Price per", " ", "Total Price", " ", "Large Event?");
        //This printf displays the output from what was processed in the program
        System.out.printf("%-10s%5s%-7s%10s%-7s%9s%-9s", oGuests, " ", oRatePerPerson, " ",
                oTotalPrice, " ", (iGuests >= 50));

    }
}

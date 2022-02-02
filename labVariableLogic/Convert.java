
package   labVariableLogic;

/**
 * @author Name:  Harshdeep Kaur Dhunna
 * Student number: A00246003 
 * Program description: JAV-1001 - 11329 - App Development for Android - 202201 - 001
 * Compile the whole package: javac -cp . .\labVariableLogic\*.java  
 * Run the class containing Main Method:  java labVariableLogic.Convert
 */


import java.util.Scanner;
import java.util.Arrays;

public class Convert {
    
    //Array to check whether the conversion unit present or not in code 
    public static String[] unitsToConvert = new String[] {"km", "mi", "cm", "in", "kg", "lb", "g", "oz", "c", "f", "l", "cups"};   
    
    /**
     * @method Main method
     * @param args 
     * @input Collect a numeric value current unit of measurement from the user.
     * @see  Display the new result after Conversion 
     */
        public static void main(String[] args)
        {
            String conversionVal;

            //Make input bold
            String boldString = "\033[0;1m";
        
            //tell user the conversion unit present in code 
            System.out.println(" Conversion Units present for conversion " + Arrays.toString(unitsToConvert));

            // Scanner permits a user to read a number from the System.in
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter a value to convert:" + boldString);
            conversionVal = userInput.nextLine();

            //remove whitespace 
            conversionVal = conversionVal.trim().replaceAll("\\s+","");

            //Method call for conversion
            getConvertedValue(conversionVal);
            
        }

        /**
         * @method split the string to get numeric value and conversion unit
         * @param input String User input for conversion
         * @return Print the the conerted value 
         */
        public static void getConvertedValue(String inputVal){

            //Split String to get Numeric value and Conversion Unit
            String inputParts[] = inputVal.split("(?i)(?<=\\d)(?=[a-z])|(?<=[a-z])(?=\\d)");
            float conversionVal = Float.parseFloat(inputParts[0]) ;
            String conversionUnit = inputParts[1] ;

            //Check converion unit is entered or not
            if(!conversionUnit.isEmpty() && conversionUnit != null){

                //Convert to lowercase to match the values present in Array
                conversionUnit = conversionUnit.toLowerCase();

                //Check whether the conversion unit present or not in code
                boolean containsVal = Arrays.stream(unitsToConvert).anyMatch(conversionUnit::equals);

                if(containsVal){

                    //Instance of util
                    ConversionUtil conversionUtil = new ConversionUtil();

                    //Call the util Method for conversion
                    System.out.println(conversionUtil.doConversion(conversionUnit,conversionVal));
                }else{
                    System.out.print("Please Enter a valid converstion unit");
                }
            }else{
                System.out.print("Please Enter a valid converstion unit");  
            }
        }
}



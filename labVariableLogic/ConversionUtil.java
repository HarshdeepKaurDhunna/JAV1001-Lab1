package labVariableLogic;

/**
 * @author Name:  Harshdeep Kaur Dhunna
 * Student number: A00246003 
 * Program description: JAV-1001 - 11329 - App Development for Android - 202201 - 001
 */
import java.text.DecimalFormat;
 /** 
  * Util to Conversion of Measurment Unit
  */
public class ConversionUtil {

    /**
     * Static Unit conversion value
     */
    private final double kmToMiles = 0.62;
    private final double milesToKm = 1.61;
    private final double centimeterToInch = 0.39;
    private final double inchToCentimeter = 2.54;
    private final double kilogramsToLb = 2.2;
    private final double lbToKg = 0.45;
    private final double gramToOunce = 0.04;
    private final double ounceToGram = 28.35;
    private final double literToCup = 4.17;
    private final double cupToLiter = 0.24;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    /**
     * 
     * @param conversionUnit Unit type entered by user use for conversion
     * @param conversionVal Value ebtered by user to convert
     * @return Converted Value and Unit
     */
    public String doConversion(String conversionUnit, double conversionVal) {
        String output = "";

        // If user temp conversion
        if(conversionUnit.equalsIgnoreCase("c") || conversionUnit.equalsIgnoreCase("f")){
            if(conversionUnit.equalsIgnoreCase("c")){
                output = getCelsiusOutputVal(conversionUnit, conversionVal, "F");
            }else if (conversionUnit.equalsIgnoreCase("f")){
                output = getFarenheatOutputVal(conversionUnit, conversionVal, "C");
            }
           
        }else{
            //Each case check the measurement unit to get desired output
            switch (conversionUnit) {
                case "km":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, kmToMiles , "mi");
                    break;
                case "mi":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, milesToKm , "km");
                    break;
                case "cm":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, centimeterToInch , "in");
                    break;
                case "in":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, inchToCentimeter , "cm");
                    break;
                case "kg":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, kilogramsToLb, "lb");
                    break;
                case "lb":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, lbToKg , "kg");
                    break;
                case "g":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, gramToOunce , "oz");
                    break;
                case "oz":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, ounceToGram , "g");
                    break;
                case "l":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, literToCup , "cups");
                    break;
                case "cups":
                    output = getMeasurementOutputVal(conversionUnit, conversionVal, cupToLiter , "l");
                    break;
                default:
                    output = "Something went wrong!. Please try again";
                    break;
            }
        }
        
        return output;
    }

    /**
     * 
     * @param unitToConvrt Unit type entered by user use for conversion
     * @param valueToConvrt double to allow user to enter in decimal  
     * @param unitsVal unit and their conversions
     * @param conervertedUnit Output Unit
     * @return String i.e 10.0 km is equal to 6.2mi
     */
    public String getMeasurementOutputVal(String unitToConvrt, double valueToConvrt, double unitsVal, String conervertedUnit) {
        String outpulVal = String.valueOf(DECIMAL_FORMAT.format(unitsVal * valueToConvrt));
        outpulVal = valueToConvrt + " " + unitToConvrt +  " is equal to " + outpulVal + " " + conervertedUnit;
        return outpulVal;
    }

    /**
     * @param unitToConvrt Unit type entered by user use for conversion
     * @param valueToConvrt Value ebtered by user to convert
     * @param conervertedUnit Output Unit
     * @return String 10.0c is equal to 50.0F and  50.0K
     */
    public String getCelsiusOutputVal(String unitToConvrt, double valueToConvrt, String conervertedUnit) {
        String farnheatOutpulVal = String.valueOf(DECIMAL_FORMAT.format((valueToConvrt * 9/5) + 32));
        String kelvinOutpulVal = String.valueOf(DECIMAL_FORMAT.format(valueToConvrt + 273.15));
        return valueToConvrt + " " + unitToConvrt +  " is equal to " + farnheatOutpulVal + " " + conervertedUnit + " and " + kelvinOutpulVal + " K.";

    }

    /**
     * 
     * @param unitToConvrt Unit type entered by user use for conversion
     * @param valueToConvrt Value ebtered by user to convert
     * @param conervertedUnit Output Unit
     * @return String 10.0f is equal to 50.0C and  50.0K
     */
    public String getFarenheatOutputVal(String unitToConvrt, double valueToConvrt, String conervertedUnit) {
        String celsiusOutpulVal = String.valueOf(DECIMAL_FORMAT.format((valueToConvrt - 32) * 5/9 ));
        String kelvinOutpulVal = String.valueOf(DECIMAL_FORMAT.format((valueToConvrt - 32) * 5/9 + 273.15));
        return valueToConvrt + " " + unitToConvrt +  " is equal to " + celsiusOutpulVal + " " + conervertedUnit + " and " + kelvinOutpulVal + " K.";

    }
}

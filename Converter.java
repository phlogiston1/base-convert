import java.util.ArrayList;

public class Converter {
    //public char[] lookupTable = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String lut = "0123456789abcdefghijklmnopqrstuvwxyz"; //default character set
    public ArrayList<Integer> output = new ArrayList<Integer>(); //hold the position of the desired character as calculated.
    private int nextDiv, nextMult, base;
    public Converter(){}
    public Converter(String initLut){
        lut = initLut;
    }

    /**
     * convert from base 10 to the converters lut base
     * @param decimal the number to convert from
     * @return the string of characters in the lut that specify the number.
     */
    public String convert(int decimal){
        base = lut.length();//hold the base number. user allowed to change lut, so have to check every time
        //set up for cRecurse. should have used a loop. i've learned.
        nextDiv = decimal;
        output = new ArrayList<Integer>();
        cRecurse();
        return getString();
    }

    //could be done with a loop, but this is how I did it
    private void cRecurse(){
        int store2 = nextDiv; //retain to check if finished
        int store = (nextDiv - (nextDiv%base))/base; //math to convert between bases (I wrote this code ages ago and I've forgotten the math)
        output.add(nextDiv % base); //append next solved character to output
        nextDiv = store; //hold the carry number (probably??)
        if(store2 != 0){
            cRecurse(); //loop
        }
    }

    /**
     * convert from converted string (in specified base) to a base-10 integer.
     * @param stringIn the number in the lut base.
     * @return the number in base 10
     */
    public int deConvert(String stringIn){
        //reset variables
        output = new ArrayList<Integer>();
        base = lut.length();
        nextMult = 1;
        int out = 0;

        //loop for each place in the input
        for(int i = stringIn.length() - 1; i >= 0; i--){
            out += lut.indexOf(stringIn.charAt(i)) * nextMult; //convert to base-10
            nextMult *= base; //carry or something. this is just the math.
        }
        return out;
    }

    /**
     * converts between two bases held in the specified Converters.
     * @param input the string as input to the deConvert method on the input convert
     * @param inConverter the Converter with the lut for the input base
     * @param outConverter the Converter with the lut for the output base
     * @return the result as a String.
     */
    public static String convertBetween(String input, Converter inConverter, Converter outConverter){
        return outConverter.convert(inConverter.deConvert(input));
    }

    /**
     * convert between an ArrayList of indexes of nubers in a lut into a string of the actual values in the lut.
     * @return
     */
    public String getString(){
        String out = "";//hold string while building
        //loop through output index values
        for(int i = output.size() - 2; i >= 0; i--){
            //append lut value as pointed to by the output.
            out += lut.charAt(Integer.parseInt(output.get(i).toString()));
        }
        return out;
    }
    /**
     *
     * @return the base of the current lut (only works after running convert/deConvert)
     */
    public int getBase(){
        return base;
    }
    //testing:
    public static void main(String args[]){
        Converter binary = new Converter("01");
        Converter hex = new Converter("0123456789abcdef");
        System.out.println(Converter.convertBetween("1010", binary, hex));
    }
}
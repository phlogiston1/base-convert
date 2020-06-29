package manyNumberBases;

import java.util.ArrayList;

public class Convert {
    public char[] lookupTable = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String lut = "0123456789abcdefghijklmnopqrstuvwxyz";
    public ArrayList<Integer> output = new ArrayList<Integer>();
    private String in = "";
    private int nextDiv;
    private int nextMult;
    public int base;
    public Convert(){
        //nextDiv = decimal;
    }
    public String convert(int decimal){
        base = lut.length();
        nextDiv = decimal;
        output = new ArrayList<Integer>();
        cRecurse();
        return getString();
    }
    public void cRecurse(){
        int store2 = nextDiv;
        int store = (nextDiv - (nextDiv%base))/base;
        //System.out.println(store);
        output.add(nextDiv % base);
        //System.out.println(base);
        //System.out.println(nextDiv);
        //System.out.println(nextDiv % base);
        nextDiv = store;
        if(store2 != 0){
            cRecurse();
        }
    }
    public int deConvert(String stringIn){
        output = new ArrayList<Integer>();
        in = stringIn;
        base = lut.length();
        nextMult = 1;
        int out = 0;
        for(int i = stringIn.length() - 1; i >= 0; i--){
            out += lut.indexOf(stringIn.charAt(i)) * nextMult;
            nextMult *= base;
        }
        return out;
    }
    public String getString(){
        String out = "";
        for(int i = output.size() - 2; i >= 0; i--){
            //System.out.println(lut.charAt(Integer.parseInt(output.get(i).toString())));
            out += lut.charAt(Integer.parseInt(output.get(i).toString()));
        }
        return out;
    }
    public static void main(String args[]){
        Convert cv = new Convert();
        //cv.lut = "`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;;\'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>? ";
        cv.lut = "0123456789";
        //String cmon = cv.convert(2);
        //System.out.println("|" + cmon + "|");
        System.out.println(cv.convert(1));
        //System.out.println(cv.deConvert("ff"));
        System.out.println("(base " + cv.base + ")");
    }
    
}
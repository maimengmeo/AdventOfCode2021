package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import FileManager.FileManager;

public class Day03Run {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager fm = new FileManager();
        File file = new File("day03/input.txt");
        ArrayList<String> list = fm.loadInputFromFile(file);

        int gamma = binToDec(makeGamma(list));
        int epsilon = binToDec(makeEpsilon(list));
        int result = gamma * epsilon;

        System.out.println(result);
    }

    public static String makeGamma(ArrayList<String> arrList) {
        int count0 = 0;
        int count1 = 0;
        String gammaString = "";
        for (int i = 0; i < arrList.get(i).length(); i++) {
            for(String a: arrList) {
                if (a.charAt(i) == '0') {
                    count0++;                   
                } else  {
                    count1++;
                }
            }
            if (count0 > count1) {
                gammaString += "0";
            } else {
                gammaString += "1";
            }
            count0 = 0;
            count1 = 0;            
        }
        
        return gammaString;
    }

    public static String makeEpsilon(ArrayList<String> arrList) {
        int count0 = 0;
        int count1 = 0;
        String epsilonString = "";
        for (int i = 0; i < arrList.get(i).length(); i++) {
            for(String a: arrList) {
                if (a.charAt(i) == '0') {
                    count0++;                   
                } else  {
                    count1++;
                }
            }
            if (count0 > count1) {
                epsilonString += "1";
            } else {
                epsilonString += "0";
            }
            count0 = 0;
            count1 = 0;            
        }
        
        return epsilonString;
    }

    public static int binToDec(String bin) {
        int numb = 0;
        for (int i = 0; i < bin.length(); i++) {
            int index = Character.getNumericValue(bin.charAt(i));
            int cal = (int) (index * Math.pow(2, bin.length() - i -1));
            numb += cal;
        }
        return numb;

    }


}

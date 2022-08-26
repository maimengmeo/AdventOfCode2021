package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import FileManager.FileManager;

public class Day01Run {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager fm = new FileManager();
        File file = new File("day01/input.txt");
        ArrayList<SeaFloorDeep> list = new ArrayList<>();
        
        ArrayList<String> tempList = fm.loadInputFromFile(file);
        for (String t: tempList) {
            int temp = Integer.parseInt(t);
            list.add(new SeaFloorDeep(temp));
        }

        System.out.println(countIncrease(list)); 
        System.out.println(countWindowIncrease(list));
    }

    public static int countIncrease(ArrayList<SeaFloorDeep> list) {
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getDepth() > list.get(i-1).getDepth()) {
                count++;
            }
        }
        return count;
    }

    public static int countWindowIncrease(ArrayList<SeaFloorDeep> list) {
        int count = 0;
        int sum = 0;
        ArrayList<SeaFloorDeep> newList = new ArrayList<>();
        for (int i = 2; i <list.size(); i++) {           
            sum = list.get(i).getDepth() + list.get(i-1).getDepth() + list.get(i-2).getDepth();            
            newList.add(new SeaFloorDeep(sum));
        }
        for (int i = 1; i < newList.size(); i++) {
            if (newList.get(i).getDepth() > newList.get(i-1).getDepth()) {
                count++;
            }
        }
        return count;
    }

}
package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import day01.SeaFloorDeep;

public class FileManager {
    public ArrayList<String> loadInputFromFile(File file) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()) {
                String temp = scan.nextLine();
                list.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getClass());
        }
        return list;
    }

    
}

package day02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import FileManager.FileManager;
import day02.Command.Direction;

public class Day02Run {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager fm = new FileManager();
        File file = new File("day02/test.txt");
        
        ArrayList<String> data = fm.loadInputFromFile(file);
        ArrayList<Command> list = new ArrayList<>();
        

        for (String d: data) {
            String[] temp = d.split(" ");
            list.add(new Command(Direction.valueOf(temp[0]), Integer.parseInt(temp[1])));
        }

        ArrayList<Command> horizontal = new ArrayList<>();
        ArrayList<Command> vertical = new ArrayList<>();

        for (Command l: list) {
            if (l.getDirection() == Direction.up || l.getDirection() == Direction.down) {
                vertical.add(l);
            }
        }
        for (Command l: list) {
            if (l.getDirection() == Direction.forward) {
                horizontal.add(l);
            }
        }

        int horizontalValue = countPosition(horizontal);
        int verticalValue = countPosition(vertical);
        int result = horizontalValue*verticalValue;

        System.out.println(result);

        int complexDepthValue = countComplexDepth(list);
        int complexResult = horizontalValue * complexDepthValue;

        System.out.println(complexResult);
    }

    public static int countPosition(ArrayList<Command> plane) {
        int count = 0;
        for (Command p: plane) {
            count += p.getDirection().dirValue * p.getValue();
        }
        return count;
    }

    public static int countComplexDepth(ArrayList<Command> plane) {
        int value = 0;
        int depth = 0;
        for (Command p: plane) {
            if (p.getDirection() == Direction.up || p.getDirection() == Direction.down) {
                value += p.getDirection().dirValue * p.getValue();
                System.out.println(value);
            }
            else {
                depth = depth + value*p.getValue();
                System.out.println(depth);
            }
        }
        return depth;
    }

}

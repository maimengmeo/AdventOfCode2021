package day02;

public class Command {
    public enum Direction{
        forward(1),
        down(1),
        up(-1);
    
        final int dirValue;
        Direction (int dirValue) {
            this.dirValue = dirValue;
        }
    }
     
    private Direction dir;
    private int value;

    public Command(Direction dir, int value) {
        this.dir = dir;
        this.value = value;
    }
    public Direction getDirection() {
        return dir;
    }
    public int getValue() {
        return value;
    }
    public void setDirrection(Direction dir) {
        this.dir = dir;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

package wistful;

public class Block {
    public Integer x;
    public Integer y;
    public String color;

    public Boolean falling = false;
    public Integer tick = 60;

    public Block(int x, int y, String color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

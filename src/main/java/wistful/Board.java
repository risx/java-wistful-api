package wistful;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Random;

class Board {
    Integer rows = 13; // 12 but 0 is + 1
    Integer cols = 5; // 6 but 0 is + 1
    public Integer y = 0;

    Random rand = new Random();

    // private List<Block> board = new ArrayList<>();
    String[] colors = {
            "red",
            "blue",
            "purple",
            "green"
    };

    Block[][] board = new Block[rows][cols];

    void fillboard(){
        for (int y = 0; y < rows; y++){
            createRow(y);
        }
    }

    private void createRow(int y){
        for (int x = 0; x < cols; x++) {
            board[y][x] = new Block(x, y, colors[rand.nextInt(4)]);
            //board.add(block);
        }
    }

    Block[][] getBoard(){
        return board;
    }

    public void Switch(Integer x, Integer y) {
        Block block_one = board[y][x];
        Block block_two = board[y][x + 1];

        board[y][x]     = block_two;
        board[y][x + 1] = block_one;
    }

    public void moveUp(){
        y++;
    }

    public void findMatching() {
        for (int x = 0; x < cols; x++) {
            for (int y = 0; x < rows; y++){
                Block block = board[y][x];
            }
        }
    }

}
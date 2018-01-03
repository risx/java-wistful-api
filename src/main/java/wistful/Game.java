package wistful;

import java.util.UUID;

public class Game {
    public String gid; // uuid for game
    public final String id; //id for mapping other games

    private Board board;
    public Integer[] selector_position = {1, 1};
    public Integer score;

    public Game(String id){
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        this.gid = randomUUIDString;
        this.score = 0;
        this.id = id;
        this.board = new Board();
    }

    public Block[][] getBoard(){
        board.fillboard();
        //System.out.println(board.rows);
        return board.getBoard();
    }
}
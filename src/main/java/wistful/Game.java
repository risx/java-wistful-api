package wistful;

import java.util.UUID;

public class Game {
    public String gid; // uuid for game
    public final Integer id; //id for mapping other games

    private Board board;
    public Integer[] selector_position;
    public Integer score;
    public Integer active_time;
    public Integer pause_time;
    public Integer move;

    public Game(Integer id) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        this.gid = randomUUIDString;
        this.score = 0;
        this.active_time = 0;
        this.pause_time = 0;
        this.move = 0;
        this.id = id;
        this.board = new Board();
    }

    public Block[][] getBoard(){
        board.fillboard();
        //System.out.println(board.rows);
        return board.getBoard();
    }
}
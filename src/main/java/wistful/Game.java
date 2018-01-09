package wistful;

import java.util.UUID;

public class Game {
    public String gid; // uuid for game
    public final Integer id; //id for mapping other games

    private Board board;
    public Integer[] selector_position = { 0, 0 };
    public Integer score;
    public Integer active_time;
    public Integer pause_time;
    public Integer move;

    public Game(Integer id, Integer left, Integer right) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        this.gid = randomUUIDString;
        this.score = 0;
        this.active_time = 0;
        this.selector_position[0] = left;
        this.selector_position[1] = right;
        this.pause_time = 0;
        this.move = 0;
        this.id = id;

    }

    public void initBoard(){
        this.board = new Board();
        board.fillboard();
    }

    public Block[][] getBoard(){
        //System.out.println(board.rows);
        return board.getBoard();
    }

    public void Switch(){
        board.Switch(selector_position[0],selector_position[1]);
    }
}
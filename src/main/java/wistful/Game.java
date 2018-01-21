package wistful;

import java.util.UUID;

public class Game {
    public String gid; // uuid for game
    public final Integer id; //id for mapping other games

    private Board board;
    public Integer[] selector_position = { 0, 0 };
    public Integer score = 0;
    public Integer active_time = 0;
    public Integer pause_time  = 0;
    public Integer move = 0;

    public Game(Integer id) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        this.gid = randomUUIDString;
        this.selector_position[0] = 1;
        this.selector_position[1] = 1;
        this.id = id;

    }

    public void moveSelector(Integer direction){
        if (selector_position[0] < 6 && selector_position[0] > -1
                && selector_position[1] < 15 && selector_position[1] > -1) {
            switch (direction) {
                case 0: //left
                    this.selector_position[0] += 1;
                case 1: //right
                    this.selector_position[0] -= 1;
                case 2: //up
                    this.selector_position[1] -= 1;
                case 3: //down
                    this.selector_position[1] += 1;
            }
        }
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
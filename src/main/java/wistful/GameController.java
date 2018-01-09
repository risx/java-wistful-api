package wistful;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class GameController {
    HashMap<Integer, Game> existantgames = new HashMap<>();

    @RequestMapping("/")
    public String index() {
        return "Oh, hey, I didn't see you there.";
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET,
            produces = "application/json")
    public String ping() {
        return "Cya space cowboy!";
    }

    @RequestMapping(value = "/g/{id}/{xmove}/{ymove}/{action}", method = RequestMethod.GET, produces = "application/json")
    public Game game(@PathVariable("id") Integer id,
                     @PathVariable("xmove") Integer xmove,
                     @PathVariable("ymove") Integer ymove,
                     @PathVariable("action") Integer action) {
        Integer x = xmove;
        Integer y = ymove;
        Integer a = action; //0 neutral, 1 switch blocks, 2 pause/resume, 3 quit

        if (existantgames.get(id) == null) {
            existantgames.put(id, new Game(id, x, y));
            existantgames.get(id).initBoard();
        }
        if (x <= 5 && x >= 0) {
            existantgames.get(id).selector_position[0] = x;
        }
        if (y <= 14 && y >= 0) {
            existantgames.get(id).selector_position[1] = y;
        }
        switch (a) {
            case 0: //no action
                break;
            case 1: //switch blocks based on cursor position
                existantgames.get(id).Switch();
                break;
            case 2: //pause / resume timer
                break;
            case 3: //quit game
                existantgames.remove(id);
                break;
        }

        return existantgames.get(id);
    }
}
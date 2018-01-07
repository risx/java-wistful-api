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

    @RequestMapping(value = "/g/{id}/{leftmove}/{rightmove}",
            method = RequestMethod.GET, produces = "application/json")
    //public Game game(@RequestParam(value="id", defaultValue="null") Integer id) {
    public Game game(@PathVariable("id") Integer id,
                     @PathVariable("leftmove") Integer leftmove,
                     @PathVariable("rightmove") Integer rightmove){

        Integer left = leftmove;
        Integer right = rightmove;

        if (existantgames.get(id) == null){
            existantgames.put(id, new Game(id));
        }
        return existantgames.get(id);
    }
}
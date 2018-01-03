package wistful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GameController {
    HashMap<Integer, Game> existantgames = new HashMap<Integer, Game>();

    @RequestMapping("/")
    public String index() { return "Oh, hey, I didn't see you there."; }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
    public String ping() { return "Cya space cowboy!"; }

    @RequestMapping(value = "/g", method = RequestMethod.GET, produces = "application/json")
    public Game game(@RequestParam(value="id", defaultValue="null") Integer id) {
        if (existantgames.get(id) == null){
            existantgames.put(id, new Game(id));
        }
        return existantgames.get(id);
    }
}
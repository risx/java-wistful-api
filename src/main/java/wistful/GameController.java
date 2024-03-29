package wistful;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class GameController {
    HashMap<Integer, Game> existantgames = new HashMap<>();

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "Cya space cowboy!";
    }

    @RequestMapping(value = "/g/{id}/switch", method = RequestMethod.GET)
    public void switchSelector(@PathVariable("id") Integer id){
        existantgames.get(id).Switch();

    }

    @RequestMapping("/g/{id}")
    public Game game(@PathVariable("id") Integer id){
        if (existantgames.get(id) == null) {
            existantgames.put(id, new Game(id));
            existantgames.get(id).initBoard();
        }
        return existantgames.get(id);
    }

    @RequestMapping("/g/{id}/move/{direction}")
    public Game moveSelector(@PathVariable("id") Integer id, @PathVariable("direction") Integer direction){
        //down, up, left, right
        existantgames.get(id).moveSelector(direction);
        return existantgames.get(id);
    }

    @RequestMapping(value = "/g/{id}/pause", method = RequestMethod.GET)
    public void pauseGamer(@PathVariable("id") Integer id){

    }

}
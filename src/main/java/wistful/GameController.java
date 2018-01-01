package wistful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @RequestMapping("/")
    public String index() { return "Hello World!"; }

    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
    public String ping() { return "Cya space cowboy!"; }

    @RequestMapping(value = "/g", method = RequestMethod.GET, produces = "application/json")
    public Game game(@RequestParam(value="id", defaultValue="null") String id) {
        return new Game(String.format(id));
    }
}
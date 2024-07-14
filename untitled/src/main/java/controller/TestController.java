package controller;

import model.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/")
    public String hellowWorld(){
        return "Hello world";
    }

    @PatchMapping("/hello")
    public HelloResponse hello(@RequestBody String name){
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setMessage("Hello "+name);
        return helloResponse;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public HelloResponse helloVersion(@PathVariable String name, @RequestParam(value = "v", required = false) Integer version){
        HelloResponse helloResponse = new HelloResponse();
        if (version==null) helloResponse.setMessage("Unknown version");
        else if (version==1) helloResponse.setMessage("Hi"+name);
        else helloResponse.setMessage("Hello"+name);
        return helloResponse;
    }

}

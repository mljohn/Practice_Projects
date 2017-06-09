package spring_web_server;

import static java.net.URI.create;
import static org.springframework.http.HttpStatus.TEMPORARY_REDIRECT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @RequestMapping(value = "/test", method = GET)
    public ResponseEntity<Void> redirectGet() {
        return ResponseEntity.status(TEMPORARY_REDIRECT).location(create("/test/redirect")).build();
    }
    
    @RequestMapping(value = "/test/redirect", method = GET)
    public ResponseEntity<String> getString() {
        return ResponseEntity.created(create("/test/redirect")).body("Hello World");
    }

}

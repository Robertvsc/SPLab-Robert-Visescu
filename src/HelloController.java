import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final ClientComponent client;

    public HelloController(ClientComponent client) {
        this.client = client;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from " + client;
    }
}

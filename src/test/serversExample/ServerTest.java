package serversExample;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServerTest {


    @Test
    public void serviceTest() {
        Server server = new Server();
        Request request = new Request("TesTowY");
        Response response = server.service(request);

        server.service(request);

        assertEquals("tEStOWy", request.getPayload());

    }

}
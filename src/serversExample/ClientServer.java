package serversExample;

public class ClientServer {

}


class Client {

    Connection connect(Server server) {
        return new Connection(server);
    }

}

class Server {

    public Response service(Request request) {

        String reversed = reverse(request.getPayload());
        String flipped = flip(reversed);
        return new Response(flipped);

    }

    private String flip(String reversed) {

        char[] reversedToChar = reversed.toCharArray();
        for (Character character : reversedToChar) {
            if (character.isLowerCase(character)) {
                Character.toUpperCase(character);

            } else if (character.isLowerCase(character)) {
                Character.toLowerCase(character);
            }

        }
        return reversed;
    }

    private String reverse(String payload) {

        return payload;
    }

}


class Connection {
    private Server server;

    public Connection(Server server) {
        this.server = server;
    }


    public Response execute(Request request) {
        return server.service(request);
    }

}


class Request {
    private String payload;

    public Request(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

}


class Response {
    private String payload;

    public Response(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

}

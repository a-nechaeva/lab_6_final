package itmo.lab6.commands.implemented;

import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

public final class ClearCommand implements Action {
    @Override
    public Response run(String username) {
        UdpServer.collection.clear(username);
        UdpServer.getDatabase().clearCollection(username);
        return new Response("Collection cleaned successfully", ResponseType.SUCCESS);
    }
}

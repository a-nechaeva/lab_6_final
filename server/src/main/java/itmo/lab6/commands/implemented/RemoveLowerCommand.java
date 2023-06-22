package itmo.lab6.commands.implemented;

import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

public final class RemoveLowerCommand implements Action {

    private final Long key;

    public RemoveLowerCommand(Long key) {
        this.key = key;
    }

    @Override
    public Response run(String username) {
        if (UdpServer.collection.removeLower(key)) {
            UdpServer.getDatabase().removeLower(Math.toIntExact(key), username);
            return new Response("Lower elements have been successfully deleted", ResponseType.SUCCESS);
        }
        return new Response("There are no items in the collection less than a given", ResponseType.ERROR);
    }
}

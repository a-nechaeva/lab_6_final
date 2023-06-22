package itmo.lab6.commands.implemented;

import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

public final class RemoveKeyCommand implements Action {
    private final Long key;

    public RemoveKeyCommand(Long key) {
        this.key = key;
    }

    @Override
    public Response run(String username) {
        if (UdpServer.collection.removeByKey(key)) {
            UdpServer.getDatabase().removeByKey(key, username);
            return new Response("Music band with key %d deleted successfully".formatted(key), ResponseType.SUCCESS);
        }
        return new Response("It is impossible to delete a music band with key=%d, because band with this key doesn't exist.".formatted(key), ResponseType.ERROR);
    }
}

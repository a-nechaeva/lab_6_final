package itmo.lab6.commands.implemented;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import static itmo.lab6.server.UdpServer.collection;

public class UpdateCommand implements Action {
    private final MusicBand musicBand;

    public UpdateCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    @Override
    public Response run(String username) {
        if (!collection.isKeyPresented(musicBand.getId()))
            return new Response("Collection does not contain such a key", ResponseType.ERROR);

        collection.update(musicBand);
        UdpServer.getDatabase().updateById(username, Math.toIntExact(musicBand.getId()), musicBand);

        return new Response("Update was completed successfully", ResponseType.SUCCESS);
    }
}

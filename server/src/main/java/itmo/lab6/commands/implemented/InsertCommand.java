package itmo.lab6.commands.implemented;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.commands.Action;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import static itmo.lab6.server.UdpServer.collection;

public final class InsertCommand implements Action {
    private final MusicBand musicBand;

    public InsertCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    @Override
    public Response run() {
        collection.insert(musicBand);
        return new Response("Insert was completed successfully", ResponseType.SUCCESS);
    }
}
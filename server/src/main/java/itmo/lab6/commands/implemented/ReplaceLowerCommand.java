package itmo.lab6.commands.implemented;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.commands.Action;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import static itmo.lab6.server.UdpServer.collection;

public final class ReplaceLowerCommand implements Action {
    private final MusicBand musicBand;

    public ReplaceLowerCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    @Override
    public Response run() {
        if (collection.replaceLower(musicBand.getId(), musicBand)) return new Response("Element has been successfully replaced", ResponseType.SUCCESS);
        return new Response("Element either doesn't exist or has less oscars.", ResponseType.SUCCESS);
    }
}

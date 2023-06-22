package itmo.lab6.commands.implemented;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import static itmo.lab6.server.UdpServer.collection;

public final class InsertCommand implements Action {
    private final MusicBand musicBand;

    public InsertCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }


    @Override
    public Response run(String username) {
        if (collection.insert(musicBand)) {
            UdpServer.getDatabase().insertToCollection(username, musicBand);
            return new Response("Insert was completed successfully", ResponseType.INFO);
        }
        return new Response("Insertion failed due to indices collision", ResponseType.INFO);
    }
}
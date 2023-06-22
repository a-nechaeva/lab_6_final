package itmo.lab6.commands.implemented;

import itmo.lab6.commands.Action;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.MessagePainter;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import java.util.Arrays;
import java.util.List;

import static itmo.lab6.server.UdpServer.collection;
import static java.lang.Math.min;

public final class PrintDescendingCommand implements Action {

    private final int index;

    /**
     * Constructor for the {@link PrintDescendingCommand} class.
     *
     * @param index the index of the number to be printed
     */
    public PrintDescendingCommand(Integer index) {
        this.index = index;
    }

    /**
     * Constructor for the {@link PrintDescendingCommand} class.
     * Sets the index to 0.
     */
    public PrintDescendingCommand() {
        this(0);
    }

    /**
     * Runs the  command.
     *
     * @return A response with the result of the command.
     */
    @Override
    public Response run(String username) {
        if (collection.size() == 0)
            return new Response("Collection is empty", ResponseType.SUCCESS);

        List<String> movieStrings = Arrays.stream(collection.getSortedMovies(true)).
                map(musicBand -> musicBand.toString(username))
                .toList();

        String message = MessagePainter.ColoredInfoMessage(movieStrings
                .subList(index, min(index + 20, collection.size())).toString()
                .replace("., ", ",\n"));

        return new Response(message.substring(1, message.length() - 1), ResponseType.INFO);
    }
}

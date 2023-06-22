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

public final class PrintAscendingCommand implements Action {
    private final int index;

    /**
     * Constructor for the {@link PrintAscendingCommand} class.
     *
     * @param index The index of the command.
     */
    public PrintAscendingCommand(Integer index) {
        this.index = index;
    }

    /**
     * Constructor for the {@link PrintAscendingCommand} class.
     * Sets the index to 0.
     */
    public PrintAscendingCommand() {
        this(0);
    }

    /**
     * Runs the command and returns the response.
     *
     * @return the response of the command
     */
    @Override
    // Override the run method from the Command interface
    public Response run(String username) {
        // If the collection size is 0, return a success response
        if (collection.size() == 0)
            return new Response("Collection is empty", ResponseType.SUCCESS);

        List<String> movieStrings = Arrays.stream(collection.getSortedMovies(false)).
                map(movie -> movie.toString(username))
                .toList();

        String message = MessagePainter.ColoredInfoMessage(movieStrings
                .subList(index, min(index + 20, collection.size())).toString()
                .replace("., ", ",\n"));

        return new Response(message.substring(1, message.length() - 1), ResponseType.INFO);
    }
}

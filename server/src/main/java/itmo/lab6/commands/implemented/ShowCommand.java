package itmo.lab6.commands.implemented;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.commands.Action;
import itmo.lab6.server.response.MessagePainter;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static itmo.lab6.server.UdpServer.collection;
import static java.lang.Math.min;

public class ShowCommand implements Action {

    private final int index;
    private boolean isScript = false;

    /**
     * Constructor for ShowCommand
     *
     * @param index the index of the item to be shown
     */
    public ShowCommand(Integer index) {
        this.index = index;
    }

    /**
     * Constructs a new {@code ShowCommand} with the given {@code id}.
     * Sets index to 0;
     */
    public ShowCommand() {
        this(0);
    }

    /**
     * Constructor for ShowCommand.
     *
     * @param isScript Boolean value indicating whether the command is being executed from a script.
     */
    public ShowCommand(Boolean isScript) {
        this();
        this.isScript = isScript;
    }

    /**
     * Runs the command.
     *
     * @return The response of the command.
     */
    @Override
    public Response run(String username) {
        if (collection.isEmpty()) return new Response("Collection is empty", ResponseType.SUCCESS);

        List<String> movieStrings = Arrays.stream(collection.values()).
                map(musicBand -> musicBand.toString(username))
                .toList();

        if (isScript) {
            String test = MessagePainter.ColoredInfoMessage(movieStrings.toString().replace("., ", ",\n"));
            return new Response(test.substring(1, test.length() - 1), ResponseType.INFO);
        }

        String message = MessagePainter.ColoredInfoMessage(movieStrings.subList(index, min(index + 20, collection.size())).toString().replace("., ", ",\n"));
        return new Response(message.substring(1, message.length() - 1), ResponseType.INFO);
    }
}

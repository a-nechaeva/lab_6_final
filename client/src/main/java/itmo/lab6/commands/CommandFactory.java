package itmo.lab6.commands;

import itmo.lab6.basic.baseclasses.MusicBand;
import itmo.lab6.basic.utils.files.FileUtils;
import itmo.lab6.basic.utils.files.ScriptExecutor;
import itmo.lab6.basic.utils.parser.ArgumentParser;
import itmo.lab6.basic.utils.parser.UserInputParser;
import itmo.lab6.basic.utils.parser.exceptions.ObjectParsingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import static itmo.lab6.commands.CollectionValidator.isMovieValid;

/**
 * This class is used to create new instances of {@link Command}
 */
public final class CommandFactory {
    private static HashSet<CommandType> commandsHistory = new HashSet<>();

    /**
     * Returns new command instance {@link Command}
     *
     * @param type type of the command
     * @param args arguments to the command
     * @return command instance (can be null)
     */
    public static Command createCommand(CommandType type, String[] args) {
        if (!type.equals(CommandType.DEFAULT)) commandsHistory.add(type);
        return switch (type) {
            case EXIT -> {
                System.out.println("Shutting down...");
                System.exit(0);
                yield null;
            }
            case EXECUTE_SCRIPT -> {
                if (args.length < 1) {
                    System.err.println("Not enough arguments for command " + CommandType.EXECUTE_SCRIPT);
                    yield null;
                }
                String filePath = args[0];
                if (!FileUtils.isFileExist(filePath)) {
                    System.err.println("Script file does not exist: " + filePath);
                    yield null;
                }
                ArrayList<Command> commands = new ScriptExecutor(new File(filePath)).readScript().getCommandList();
                yield new Command(type, commands);
            }
            case HELP, PRINT_ASCENDING, PRINT_DESCENDING, INFO, SHOW, CLEAR -> new Command(type);
            case HISTORY -> {
                System.out.println(commandsHistory.stream().map(CommandType::name).reduce((s1, s2) -> s1 + "\n" + s2).orElse("No commands were executed."));
                yield null;
            }
            case REMOVE_GREATER, REMOVE_KEY, REMOVE_LOWER -> {
                if (args.length < 1) {
                    System.err.println("Not enough arguments for command " + type.name());
                    yield null;
                }
                try {
                    yield new Command(type, Long.parseLong(args[0]));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument for command " + type.name());
                    yield null;
                }
            }

            case INSERT, UPDATE -> {
                MusicBand musicBand = null;
                if (args.length == 1) {
                    musicBand = parseMovie(type, args);
                } else if (args.length >= 2) {
                    musicBand = parseMovie(type, new String[]{args[0]}, Arrays.copyOfRange(args, 1, args.length));
                }
                if (musicBand != null) yield new Command(type, musicBand);
                yield null;
            }
            // DEFAULT command
            default -> {
                System.err.println("Unknown command.");
                yield null;
            }
        };
    }

    /**
     * Parses movie from console
     *
     * @param type command type
     * @param args command arguments
     * @return read movie from console
     */
    public static MusicBand parseMovie(CommandType type, String[] args) {
        if (Boolean.FALSE.equals(isMovieValid(type, args))) return null;

        MusicBand musicBand = new UserInputParser().readObject(MusicBand.class);
        Objects.requireNonNull(musicBand).setId(Long.parseLong(args[0]));
        return musicBand;
    }

    /**
     * Parses movie from file
     *
     * @param args      command args
     * @param movieArgs movie args
     * @return read movie from file
     */
    public static MusicBand parseMovie(CommandType type, String[] args, String[] movieArgs) {
        // if (Boolean.FALSE.equals(isMovieValid(type, args))) return null;
        MusicBand movie = null;
        try {
            movie = new ArgumentParser(movieArgs).readObject(MusicBand.class);
            Objects.requireNonNull(movie).setId(Long.parseLong(args[0]));
        } catch (ObjectParsingException e) {
            System.err.println("Error parsing: " + e.getMessage());
        }
        return movie;
    }
}

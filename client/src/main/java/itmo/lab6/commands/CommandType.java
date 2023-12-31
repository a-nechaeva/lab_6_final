package itmo.lab6.commands;

import itmo.lab6.commands.implemented.*;

import java.io.Serializable;

public enum CommandType implements Serializable {
    CLEAR(ClearCommand.class, "clear: clear the collection"),
    EXECUTE_SCRIPT(ExecuteScriptCommand.class, "execute_script <file_name>: read and execute the script from the specified file. The script contains commands in the same form in which they are entered by the user in interactive mode. USE RELATIVE PATHS."),
    EXIT(null, "exit: exit the program"),
    HELP(HelpCommand.class, "help: shows this message"),
    HISTORY(HistoryCommand.class, "history: output the last 7 commands (without their arguments)"),
    INFO(InfoCommand.class, "info: output to the standard output stream information about the collection (type initialization date number of elements etc.)"),
    INSERT(InsertCommand.class, "insert <id> {element}: add a new element with the specified key"),
    PRINT_ASCENDING(PrintAscendingCommand.class, "print_ascending: print the elements of the collection in ascending order"),
    PRINT_DESCENDING(PrintDescendingCommand.class, "print_descending: print the elements of the collection in descending order"),
     REMOVE_GREATER(RemoveLowerCommand.class, "remove_greater <SinglesCount>: remove from the collection all elements exceeding the specified"),

    REMOVE_LOWER(RemoveLowerCommand.class, "remove_lower <SinglesCount>: remove from the collection all elements less than the specified"),

    //  REPLACE_IF_LOWER(ReplaceLowerCommand.class, "replace_if_lower <id> {element}: replace the value by key if the new value is less than the old one."),
    REMOVE_KEY(RemoveKeyCommand.class, "remove_key <id>: delete an element from the collection by its key"),
    SHOW(ShowCommand.class, "show: output to the standard output stream all elements of the collection in the string representation"),
    UPDATE(UpdateCommand.class, "update <id> {element}: update the value of a collection element whose id is equal to the specified"),
    DEFAULT(DefaultCommand.class, ""),
    SERVICE(ServiceCommand.class, "");

    private final Class<? extends Executable> executableClass;
    private final String description;

    CommandType(Class<? extends Executable> executableClass, String description) {
        this.executableClass = executableClass;
        this.description = description;
    }

    public Class<? extends Executable> getExecutableClass() {
        return executableClass;
    }

    public String getDescription() {
        return description;
    }
}

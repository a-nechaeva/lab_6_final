package itmo.lab6.commands.implemented;

import itmo.lab6.commands.Action;
import itmo.lab6.server.ClientAddress;
import itmo.lab6.server.UdpServer;
import itmo.lab6.server.response.Color;
import itmo.lab6.server.response.Response;
import itmo.lab6.server.response.ResponseType;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

import static itmo.lab6.server.UdpServer.commandHistory;

public final class HistoryCommand implements Action {

    private final String username;

    public HistoryCommand(String username) {
        this.username = username;
    }

    @Override
    public Response run(String username) {
        return new Response(Color.PURPLE + "Command history:\n" + Color.RESET + Arrays.stream(UdpServer.getDatabase().getCommandHistory(username)).reduce("", (a, b) -> a + "\n" + b).substring(1), ResponseType.INFO);
    }
}

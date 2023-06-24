package itmo.lab6.connection;

import itmo.lab6.basic.utils.terminal.Colors;
import itmo.lab6.chuncks.ChuckReceiver;
import itmo.lab6.chuncks.Chuncker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Connector is used to connect to a remote server
 */
public class Connector {
    /**
     * Socket for UDP connection
     */
    private static DatagramSocket socket;
    private final InetAddress address;
    private final int port;
    private final static int socketTimeout = 4000;

    private int chunkSize;


    /**
     * Connector constructor with specified server port
     *
     * @param port server port
     * @throws Exception Socket exception
     */
    public Connector(InetAddress address, int port) throws Exception {
        socket = new DatagramSocket();
        socket.setSoTimeout(socketTimeout);
        this.address = address;
        this.port = port;
    }

    /**
     * Return port of client
     *
     * @return localhost port
     */
    public static int getPort() {
        return socket.getLocalPort();
    }

    public void setBufferSize(int size) throws SocketException {
        socket.setReceiveBufferSize(size);
        socket.setSendBufferSize(size);
        this.chunkSize = 1024;
    }

    /**
     * Sends string to remote server
     *
     * @param message string message
     * @throws Exception sending exception
     */
    public void send(String message) throws Exception {
        this.send(message.getBytes());
    }

    /**
     * Sends bytes to remote server
     *
     * @param dataBytes bytes to send
     * @throws Exception sending exceptions
     */
    public void send(byte[] dataBytes) throws Exception {
        Chuncker dataChunker = new Chuncker(dataBytes, chunkSize);
        var chunkIterator = dataChunker.newIterator();
        short totalChunks = (short) ((int) Math.ceil((double) dataBytes.length / (double) this.chunkSize));
        int c = 0;
        while (chunkIterator.hasNext()) {
            if (++c % 50 == 0) {
                System.out.printf("%sSending chunks:%s %d/%d kb\r", Colors.AsciiPurple, Colors.AsciiReset, c, totalChunks);
                Thread.sleep(100);
            }
            byte[] chunk = chunkIterator.next();
            DatagramPacket dataPacket = new DatagramPacket(chunk, chunk.length, this.address, port);
            socket.send(dataPacket);
        }
    }

    /**
     * Receives bytes from remote server and transforms them into string
     *
     * @return string message
     * @throws IOException Receiving exception
     */
    public String receive() throws IOException {
        ChuckReceiver receiver = new ChuckReceiver();
        byte[] buffer = new byte[chunkSize + 4];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.print(" ".repeat(3) + "\r");
        System.out.print(Colors.AsciiPurple + "Receiving..." + Colors.AsciiReset);
        do {
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            receiver.add(Arrays.copyOf(packet.getData(), packet.getLength()));
        } while (!receiver.isReceived());
        System.out.print("\r");
        return new String(receiver.getAllChunks(), StandardCharsets.UTF_8);
    }
}

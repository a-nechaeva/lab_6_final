package itmo.lab6;

import itmo.lab6.basic.moviecollection.MovieCollection;
import itmo.lab6.database.Database;
import itmo.lab6.server.UdpServer;
import itmo.lab6.utils.config.Config;

import java.sql.SQLException;


public class ServerMain {
    /**
     * Global variable with name of collection's xml file
     */
    public static String collectionFileName;
    private static Integer serverPort;

    private static final String url;
    private static final String user;
    private static final String password;

    static {
        Config config = null;
        //config = new Config("server_hel.scfg");
        config = new Config("C:\\Users\\user\\OneDrive\\Рабочий стол\\renew\\prog-6-develop\\server\\server_loc.scfg");
        collectionFileName = config.get("collection_file");
        if (collectionFileName == null) {
            // Setting up the default file name
            collectionFileName = "server.xml";
        }
        try {
            serverPort = Integer.parseInt(config.get("server_port"));
        } catch (NumberFormatException e) {
            // Setting up the default port
            serverPort = 1611;
        }
        url = config.get("db_url");
        user = config.get("user");
        password = config.get("password");
    }

    public static void main(String[] args) {
        MovieCollection collection;
        Database db = null;

        try {
            db = new Database(url, user, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        collection = db.getCollection();

        UdpServer server = new UdpServer(db, collection, serverPort);
        server.run();
    }
}
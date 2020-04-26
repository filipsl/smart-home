package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectAdapter;
import devices.DeviceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class Server {
    public static final Logger logger = Logger.getLogger(Server.class.getName());
    private List<DeviceImpl> deviceImplList = new LinkedList<>();

    public void start(String[] args) {
        int status = 0;
        Communicator communicator = null;
        logger.info("Smart home server is starting...");

        try {
            communicator = Util.initialize(args);

            ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");
            logger.info("New Adapter defined");

            MyServantLocator myServantLocator = new MyServantLocator(deviceImplList, adapter);
            adapter.addServantLocator(myServantLocator, "");
            adapter.activate();
            logger.info("Adapter activated");

            logger.info("Entering event processing loop...");

            communicator.waitForShutdown();

        } catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            // Clean up
            try {
                communicator.destroy();
            } catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.start(args);
    }
}

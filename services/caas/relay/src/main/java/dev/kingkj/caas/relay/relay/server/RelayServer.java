package dev.kingkj.caas.relay.relay.server;

import dev.kingkj.caas.relay.connection.ConnectionStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
@RequiredArgsConstructor
public class RelayServer {

    private final int port;
    private final ConnectionStore connectionStore;

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Relay server started on port {}", port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

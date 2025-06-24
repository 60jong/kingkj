package dev.kingkj.caas.relay.agent.server;

import dev.kingkj.caas.relay.connection.ConnectionStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
@RequiredArgsConstructor
public class AgentServer {

    private final int port;
    private final ConnectionStore connectionStore;

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Agent server started on port {}", port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

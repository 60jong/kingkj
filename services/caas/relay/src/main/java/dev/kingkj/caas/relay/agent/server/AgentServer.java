package dev.kingkj.caas.relay.agent.server;

import dev.kingkj.caas.relay.connection.store.ConnectionStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@RequiredArgsConstructor
public class AgentServer {

    private final int port;
    private final ConnectionStore connectionStore;

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Agent server started on port {}", port);

            Socket agentSocket = serverSocket.accept();

            // TODO : generate agentId
            connectionStore.saveConnection(agentSocket.toString(), agentSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

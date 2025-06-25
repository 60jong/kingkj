package dev.kingkj.caas.relay.agent.server;

import dev.kingkj.caas.relay.connection.store.ConnectionStore;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// TODO : Agent 서버 다운시에 재가동 로직 구현
@Slf4j
@Component
public class AgentServerStarter {

    private final int port;
    private final ConnectionStore connectionStore;

    public AgentServerStarter(
            @Value("${caas.agent.server.port}") int port,
            ConnectionStore agentConnectionStore
    ) {
        this.port = port;
        this.connectionStore = agentConnectionStore;
    }

    @PostConstruct
    public void startServer() {
        Thread.ofPlatform()
                .name("agent-server-t")
                .unstarted(() -> new AgentServer(port, connectionStore).run())
                .start();
    }
}

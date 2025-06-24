package dev.kingkj.caas.relay.agent.server;

import dev.kingkj.caas.relay.connection.ConnectionStore;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// TODO : Agent 서버 다운시에 재가동 로직 구현
@Slf4j
@Component
public class AgentServerStarter {
    @Value("${caas.agent.server.port}")
    private int port;

    @Autowired
    private ConnectionStore agentConnectionStore;

    @PostConstruct
    public void startServer() {
        Thread.ofPlatform()
                .name("agent-server-t")
                .unstarted(() -> new AgentServer(port, agentConnectionStore).run())
                .start();
    }
}

package dev.kingkj.caas.relay.relay.server;

import dev.kingkj.caas.relay.connection.store.ConnectionStore;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// TODO : Relay 서버 다운시에 재가동 로직 구현
@Slf4j
@Component
public class RelayServerStarter {

    private final int port;
    private final ConnectionStore connectionStore;

    public RelayServerStarter(
            @Value("${caas.relay.server.port}") int port,
            ConnectionStore relayConnectionStore
    ) {
        this.port = port;
        this.connectionStore = relayConnectionStore;
    }

    @PostConstruct
    public void startServer() {
        Thread.ofPlatform()
                .name("relay-server-t")
                .unstarted(() -> new RelayServer(port, connectionStore).run())
                .start();
    }
}

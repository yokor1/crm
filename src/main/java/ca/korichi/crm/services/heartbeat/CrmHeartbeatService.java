package ca.korichi.crm.services.heartbeat;

import ca.korichi.crm.controllers.heartbeat.Heartbeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "HeartbeatService")
public class CrmHeartbeatService implements HeartbeatService {
    private final CrmClock crmClock;

    @Autowired
    public CrmHeartbeatService(CrmClock crmClock) {
        this.crmClock = crmClock;
    }

    @Override
    public Heartbeat getBeat(String token) {
        long timestamp = crmClock.getTimestamp();
        return new Heartbeat(token, timestamp);
    }
}

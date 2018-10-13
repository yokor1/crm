package ca.korichi.crm.services.heartbeat;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component(value = "CrmClock")
public class SystemClock implements CrmClock {
    @Override
    public long getTimestamp() {
        return Instant.now().toEpochMilli();
    }
}

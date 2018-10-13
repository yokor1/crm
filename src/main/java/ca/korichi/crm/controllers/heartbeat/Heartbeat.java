package ca.korichi.crm.controllers.heartbeat;


import lombok.Value;

import java.time.Instant;

@Value
public class Heartbeat {
    private final  String token;
    private final long timestamp;

    public Heartbeat(String token) {
        this.token = token;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public  Heartbeat(String token, long timestamp ) {
        this.token = token;
        this.timestamp = timestamp;
    }

}

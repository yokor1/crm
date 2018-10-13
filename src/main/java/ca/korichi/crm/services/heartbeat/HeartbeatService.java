package ca.korichi.crm.services.heartbeat;

import ca.korichi.crm.controllers.heartbeat.Heartbeat;

public interface HeartbeatService {
    Heartbeat getBeat(String token);
}

package ca.korichi.crm.controllers.heartbeat;

import ca.korichi.crm.services.heartbeat.Heartbeat;
import ca.korichi.crm.services.heartbeat.HeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    private final HeartbeatService heartbeatService;

    @Autowired
    public HeartbeatController(HeartbeatService heartbeatService) {
        this.heartbeatService = heartbeatService;
    }

    @GetMapping(
            value = "/beat",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResponseEntity<Heartbeat> beat(@RequestParam("token") String token) {
        return ResponseEntity.ok(heartbeatService.getBeat(token));
    }
}

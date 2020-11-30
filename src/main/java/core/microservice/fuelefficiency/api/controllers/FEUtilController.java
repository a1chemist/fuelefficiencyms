package core.microservice.fuelefficiency.api.controllers;

import core.microservice.fuelefficiency.api.objects.api.ApiObjectFactory;
import core.microservice.fuelefficiency.api.objects.api.FuelEfficiencyPingResponse;
import core.microservice.fuelefficiency.api.objects.api.FuelEfficiencyResponse;
import core.microservice.fuelefficiency.service.FuelSaverService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Utility API Endpoints")
@Schema(hidden = true)
@RestController
public class FEUtilController {

    static final Logger log = LoggerFactory.getLogger(FEUtilController.class);
    private final FuelSaverService fuelSaverService;
    private final ApiObjectFactory apiObjectFactory;

    public FEUtilController(FuelSaverService fuelSaverService,
                            ApiObjectFactory apiObjectFactory) {
        this.fuelSaverService = fuelSaverService;
        this.apiObjectFactory = apiObjectFactory;
    }

    @GetMapping("/fuel-efficiency/util/ping")
    public ResponseEntity<FuelEfficiencyPingResponse> ping() throws Exception {
        return ResponseEntity.ok(apiObjectFactory.createPingResponse(fuelSaverService.checkApiStatus()));
    }

}
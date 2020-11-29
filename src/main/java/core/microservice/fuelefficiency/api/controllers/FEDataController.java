package core.microservice.fuelefficiency.api.controllers;

import core.microservice.fuelefficiency.api.objects.api.FuelEfficiencyResponse;
import core.microservice.fuelefficiency.service.FuelSaverService;
import core.microservice.fuelefficiency.api.objects.api.ApiObjectFactory;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Data API Endpoints")
@Schema(hidden = true)
@RestController
public class FEDataController {

    static final Logger log = LoggerFactory.getLogger(FEDataController.class);
    private final FuelSaverService fuelSaverService;
    private final ApiObjectFactory apiObjectFactory;

    public FEDataController(FuelSaverService fuelSaverService,
                            ApiObjectFactory apiObjectFactory) {
        this.fuelSaverService = fuelSaverService;
        this.apiObjectFactory = apiObjectFactory;
    }

    @GetMapping("/fuel-efficiency/data/get-by-plate")
    public ResponseEntity<FuelEfficiencyResponse> getByplate(String plate) throws Exception {
        FuelEfficiencyResponse response = apiObjectFactory.createFuelEfficiencyResponse(fuelSaverService.getFeDataByPlate(plate));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fuel-efficiency/data/get-by-vin")
    public ResponseEntity<FuelEfficiencyResponse> getByVin(String vin) throws Exception {
        FuelEfficiencyResponse response = apiObjectFactory.createFuelEfficiencyResponse(fuelSaverService.getFeDataByVin(vin));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fuel-efficiency/data/get-by-chassis")
    public ResponseEntity<FuelEfficiencyResponse> getByChassis(String chassis) throws Exception {
        FuelEfficiencyResponse response = apiObjectFactory.createFuelEfficiencyResponse(fuelSaverService.getFeDataByChassis(chassis));
        return ResponseEntity.ok(response);
    }

}
package core.microservice.fuelefficiency.api.controllers;

import core.microservice.fuelefficiency.api.objects.api.ApiObjectFactory;
import core.microservice.fuelefficiency.api.objects.api.LabelResponse;
import core.microservice.fuelefficiency.api.objects.api.PrintLabelResponse;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;
import core.microservice.fuelefficiency.service.FuelSaverService;
import core.microservice.fuelefficiency.utils.FileUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@Tag(name = "Label API Endpoints")
@Schema(hidden = true)
@RestController
public class FELabelController {

    static final Logger log = LoggerFactory.getLogger(FELabelController.class);
    private final FuelSaverService fuelSaverService;
    private final ApiObjectFactory apiObjectFactory;
    private final FileUtils fileUtils;

    public FELabelController(FuelSaverService fuelSaverService,
                             ApiObjectFactory apiObjectFactory,
                             FileUtils fileUtils) {
        this.fuelSaverService = fuelSaverService;
        this.apiObjectFactory = apiObjectFactory;
        this.fileUtils = fileUtils;
    }

    @GetMapping("/fuel-efficiency/label/get-print-label-by-plate")
    public ResponseEntity<PrintLabelResponse> getPrintLabel(String plate) throws Exception {
        FEPrintLabel response = fuelSaverService.getFePrintLabelByPlate(plate);
        PrintLabelResponse printLabelResponse = apiObjectFactory.createPrintLabelResponse(response);
        return ResponseEntity.ok(printLabelResponse);
    }

    @GetMapping("/fuel-efficiency/label/download-print-label-by-plate")
    public ResponseEntity downloadPrintLabel(String plate) throws Exception {
        Path labelPath = null;
        try {
            FEPrintLabel response = fuelSaverService.getFePrintLabelFileByPlate(plate);
            return apiObjectFactory.createRawFileResponseEntity(
                    "fe-label-" + plate + "jpg",
                    response
            );
        } finally {
            fileUtils.deleteFile(labelPath);
        }
    }

    @GetMapping("/fuel-efficiency/label/get-label-urls-by-plate")
    public ResponseEntity<LabelResponse> getLabelUrls(String plate) throws Exception {
        LabelResponse labelResponse = apiObjectFactory.createLabelResponse(
                fuelSaverService.getLabelUrlByPlate(plate)
        );
        return ResponseEntity.ok(labelResponse);
    }

}
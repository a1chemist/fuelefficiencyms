package core.microservice.fuelefficiency.api.objects.api;

import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;
import org.springframework.http.ResponseEntity;

public interface ApiObjectFactory {

    LabelResponse createLabelResponse(FELabelUrl feLabelUrl);

    ResponseEntity createRawFileResponseEntity(String filename,
                                               FEPrintLabel printLabelResponse);

    PrintLabelResponse createPrintLabelResponse(FEPrintLabel fePrintLabel);

    FuelEfficiencyResponse createFuelEfficiencyResponse(FEData feData);
}

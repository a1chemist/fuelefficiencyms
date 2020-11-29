package core.microservice.fuelefficiency.domain;

import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.client.fuelsaver.model.v1.FuelSaverRvidResponse;
import core.client.fuelsaver.model.v2.FuelSaverLabelResponse;
import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;

public interface FEObjectFactory {

    FELabelUrl createFeLabelUrl(String smallLabelUrl, String mediumLabelUrl);

    FEPrintLabel createFileFEPrintLabel(FuelSaverLabelResponse response) throws Exception;

    FEPrintLabel createEmbeddedFEPrintLabel(FuelSaverLabelResponse response) throws Exception;

    FEData createFeData(FuelSaverRvidResponse response);
}

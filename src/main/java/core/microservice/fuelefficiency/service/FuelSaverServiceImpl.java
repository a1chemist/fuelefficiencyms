package core.microservice.fuelefficiency.service;

import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.client.fuelsaver.FuelSaverClientFactory;
import core.client.fuelsaver.model.v1.FuelSaverRvidResponse;
import core.client.fuelsaver.model.v2.FuelSaverLabelResponse;
import core.client.fuelsaver.model.v2.FuelSaverResponse;
import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.domain.FEObjectFactory;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;
import org.springframework.stereotype.Component;

@Component
public class FuelSaverServiceImpl implements FuelSaverService {

    private final FuelSaverClientFactory fuelSaverClientFactory;
    private final FEObjectFactory feObjectFactory;

    public FuelSaverServiceImpl(FuelSaverClientFactory fuelSaverClientFactory,
                                FEObjectFactory feObjectFactory) {
        this.fuelSaverClientFactory = fuelSaverClientFactory;
        this.feObjectFactory = feObjectFactory;
    }

    @Override
    public FELabelUrl getLabelUrlByPlate(String plate) throws Exception {
        FuelSaverResponse response = fuelSaverClientFactory.createFuelSaverClient().getFuelSaverDataByPlate(plate);
        return feObjectFactory.createFeLabelUrl(
                response.getFuelPromoSmallBadgeUrl(),
                response.getFuelPromoMediumBadgeUrl()
        );
    }

    @Override
    public FEPrintLabel getFePrintLabelByPlate(String plate) throws Exception {
        FuelSaverLabelResponse response = fuelSaverClientFactory.createFuelSaverClient().getFuelSaverLabelByPlate(plate);
        return feObjectFactory.createEmbeddedFEPrintLabel(response);
    }

    @Override
    public FEPrintLabel getFePrintLabelFileByPlate(String plate) throws Exception {
        FuelSaverLabelResponse response = fuelSaverClientFactory.createFuelSaverClient().getFuelSaverLabelByPlate(plate);
        return feObjectFactory.createFileFEPrintLabel(response);
    }

    @Override
    public FEData getFeDataByPlate(String plate) throws Exception {
        FuelSaverRvidResponse response = fuelSaverClientFactory.createFuelSaverClient().rvidLookupByPlate(plate);
        return feObjectFactory.createFeData(response);
    }

    @Override
    public FEData getFeDataByVin(String vin) throws Exception {
        FuelSaverRvidResponse response = fuelSaverClientFactory.createFuelSaverClient().rvidLookupByVin(vin);
        return feObjectFactory.createFeData(response);
    }

    @Override
    public FEData getFeDataByChassis(String chassis) throws Exception {
        FuelSaverRvidResponse response = fuelSaverClientFactory.createFuelSaverClient().rvidLookupByChassis(chassis);
        return feObjectFactory.createFeData(response);
    }

    @Override
    public boolean checkApiStatus() throws Exception {
        try {
            return fuelSaverClientFactory.createFuelSaverClient().ping();
        }
        catch (Exception e) {
            return false;
        }
    }

}
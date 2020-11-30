package core.microservice.fuelefficiency.service;

import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;

public interface FuelSaverService {

    FELabelUrl getLabelUrlByPlate(String plate) throws Exception;

    FEPrintLabel getFePrintLabelByPlate(String plate) throws Exception;

    FEPrintLabel getFePrintLabelFileByPlate(String plate) throws Exception;

    FEData getFeDataByPlate(String plate) throws Exception;

    FEData getFeDataByVin(String vin) throws Exception;

    FEData getFeDataByChassis(String chassis) throws Exception;

    boolean checkApiStatus() throws Exception;
}

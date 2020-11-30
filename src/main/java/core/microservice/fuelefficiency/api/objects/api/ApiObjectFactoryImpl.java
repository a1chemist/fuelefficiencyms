package core.microservice.fuelefficiency.api.objects.api;

import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApiObjectFactoryImpl implements ApiObjectFactory {

    @Override
    public LabelResponse createLabelResponse(FELabelUrl feLabelUrl) {
        return new LabelResponse(
                createTransaction(),
                feLabelUrl.getSmallLabelUrl(),
                feLabelUrl.getMediumLabelUrl());
    }

    @Override
    public ResponseEntity createRawFileResponseEntity(String filename,
                                                      FEPrintLabel fePrintLabel) {

        if (fePrintLabel != null && fePrintLabel.getImageByteData() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/jpeg; charset=utf-8");
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(fePrintLabel.getImageByteData().length)
                    .body(fePrintLabel.getImageByteData());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public PrintLabelResponse createPrintLabelResponse(FEPrintLabel fePrintLabel) {
        return new PrintLabelResponse(
                createTransaction(),
                fePrintLabel.getBase64ImageData()
        );
    }

    @Override
    public FuelEfficiencyResponse createFuelEfficiencyResponse(FEData feData) {
        FuelEfficiencyResponse response = new FuelEfficiencyResponse(createTransaction());
        response.setAnnualFuelCostDesc(feData.getAnnualFuelCostDesc());
        response.setAnnualFuelCost(feData.getAnnualFuelCost());
        response.setDriverSafetyStars(feData.getDriverSafetyStars());
        response.setDriverSafetyTest(feData.getDriverSafetyTest());
        response.setElectricConsumption(feData.getElectricConsumption());
        response.setElectricRange(feData.getElectricRange());
        response.setFuelConsumption(feData.getFuelConsumption());
        response.setFuelEconomy(feData.getFuelEconomy());
        response.setFuelEconomyDesc(feData.getFuelEconomyDesc());
        response.setFuelType(feData.getFuelType());
        response.setMake(feData.getMake());
        response.setModel(feData.getModel());
        response.setSubModel(feData.getSubModel());
        response.setVehicleWeight(feData.getVehicleWeight());
        response.setTransmission(feData.getTransmission());
        response.setNoOfDoors(feData.getNoOfDoors());
        response.setNoOfSeats(feData.getNoOfSeats());
        response.setCombustionEngineSize(feData.getCombustionEngineSize());
        response.setEnginePower(feData.getEnginePowerInKw());
        response.setNztaModelCode(feData.getNztaModelCode());
        response.setNztaVariant(feData.getNztaVariant());
        response.setFuelSaverVehicleType(feData.getFuelSaverVehicleType());
        response.setEmissionTestRegime(feData.getEmissionTestRegime());
        response.setRawResponse(feData.getRawResponse());
        response.setFoundMatch(feData.getFoundMatch());
        return response;
    }

    @Override
    public Transaction createTransaction() {
        return new Transaction(UUID.randomUUID().toString(), DateTime.now().toDate());
    }

    @Override
    public FuelEfficiencyPingResponse createPingResponse(boolean status) {
        return new FuelEfficiencyPingResponse(status);
    }

}
package core.microservice.fuelefficiency.domain;

import core.client.fuelsaver.model.v1.FuelSaverRvidResponse;
import core.client.fuelsaver.model.v2.FuelSaverLabelResponse;
import core.microservice.fuelefficiency.domain.objects.FELabelUrl;
import core.microservice.fuelefficiency.domain.objects.FEPrintLabel;
import core.microservice.fuelefficiency.domain.objects.FEData;
import core.microservice.fuelefficiency.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;

@Component
public class FEObjectFactoryImpl implements FEObjectFactory {

    private final FileUtils fileUtils;

    public FEObjectFactoryImpl(FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    @Override
    public FELabelUrl createFeLabelUrl(String smallLabelUrl, String mediumLabelUrl) {
        return new FELabelUrl(smallLabelUrl, mediumLabelUrl);
    }

    @Override
    public FEPrintLabel createFileFEPrintLabel(FuelSaverLabelResponse response) throws Exception {
        if (response.hasLabel()) {
            File tempFile = response.getLabelAsFile().toFile();
            byte[] bytes = fileUtils.readStream(new FileInputStream(tempFile));
            return new FEPrintLabel(bytes, tempFile);
        }
        return new FEPrintLabel();
    }

    @Override
    public FEPrintLabel createEmbeddedFEPrintLabel(FuelSaverLabelResponse response) {
        if (response.hasLabel()) {
            return new FEPrintLabel(response.getLabelAsEmbeddedImage());
        }
        return new FEPrintLabel();
    }

    @Override
    public FEData createFeData(FuelSaverRvidResponse response) {
        FEData feData = new FEData();
        feData.setAnnualFuelCostDesc(response.getExplanation());
        feData.setAnnualFuelCost(response.getYearlyCost());
        feData.setDriverSafetyStars(response.getDriverSafetyStars());
        feData.setDriverSafetyTest(response.getDriverSafetyTest());
        feData.setElectricConsumption(response.getElectricConsumption());
        feData.setElectricRange(response.getElectricRange());
        feData.setFuelConsumption(response.getFuelConsumption());
        feData.setFuelEconomyDesc(response.getExplanation());
        feData.setFuelType(response.getFuelType());
        feData.setMake(response.getMake());
        feData.setModel(response.getModel());
        feData.setSubModel(response.getSubModel());
        feData.setRawResponse(response.getRawResponse());
        feData.setVehicleWeight(response.getWeight());
        feData.setTransmission(response.getTransmission());
        feData.setNoOfDoors(response.getDoors());
        feData.setNoOfSeats(response.getSeats());
        feData.setCombustionEngineSize(response.getEngineSize());
        feData.setEnginePowerInKw(response.getEnginePower());
        feData.setNztaModelCode(response.getModelCode());
        feData.setNztaVariant(response.getVariant());
        feData.setFuelSaverVehicleType(response.getVehicleType());
        feData.setEmissionTestRegime(response.getTestRegime());
        feData.setFoundMatch(response.foundMatch());
        return feData;
    }

}

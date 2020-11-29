package core.microservice.fuelefficiency.api.objects.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@JsonInclude(NON_EMPTY)
public class FuelEfficiencyResponse {

    private String annualFuelCostDesc;
    private Double annualFuelCost;
    private Integer driverSafetyStars;
    private String driverSafetyTest;
    private Double electricConsumption;
    private Integer electricRange;
    private Double fuelConsumption;
    private String fuelEconomy;
    private String fuelEconomyDesc;
    private String fuelType;
    private String make;
    private String model;
    private String subModel;
    @JsonIgnore
    private String rawResponse;
    private boolean foundMatch;
    private Integer vehicleWeight;
    private String transmission;
    private Integer noOfDoors;
    private Integer noOfSeats;
    private Integer combustionEngineSize;
    private Integer enginePower;
    private String nztaModelCode;
    private Integer nztaVariant;
    private String fuelSaverVehicleType;
    private String emissionTestRegime;

    public void setAnnualFuelCostDesc(String annualFuelCostDesc) {
        this.annualFuelCostDesc = annualFuelCostDesc;
    }

    public String getAnnualFuelCostDesc() {
        return annualFuelCostDesc;
    }

    public void setAnnualFuelCost(Double annualFuelCost) {
        this.annualFuelCost = annualFuelCost;
    }

    public Double getAnnualFuelCost() {
        return annualFuelCost;
    }

    public void setDriverSafetyStars(Integer driverSafetyStars) {
        this.driverSafetyStars = driverSafetyStars;
    }

    public Integer getDriverSafetyStars() {
        return driverSafetyStars;
    }

    public void setDriverSafetyTest(String driverSafetyTest) {
        this.driverSafetyTest = driverSafetyTest;
    }

    public String getDriverSafetyTest() {
        return driverSafetyTest;
    }

    public void setElectricConsumption(Double electricConsumption) {
        this.electricConsumption = electricConsumption;
    }

    public Double getElectricConsumption() {
        return electricConsumption;
    }

    public void setElectricRange(Integer electricRange) {
        this.electricRange = electricRange;
    }

    public Integer getElectricRange() {
        return electricRange;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomyDesc(String fuelEconomyDesc) {
        this.fuelEconomyDesc = fuelEconomyDesc;
    }

    public String getFuelEconomyDesc() {
        return fuelEconomyDesc;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSubModel(String subModel) {
        this.subModel = subModel;
    }

    public String getSubModel() {
        return subModel;
    }

    public void setRawResponse(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRawResponse() {
        return rawResponse;
    }

    public void setFoundMatch(boolean foundMatch) {
        this.foundMatch = foundMatch;
    }

    public boolean getFoundMatch() {
        return foundMatch;
    }

    public void setVehicleWeight(Integer vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    public Integer getVehicleWeight() {
        return vehicleWeight;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setNoOfDoors(Integer noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    public Integer getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setCombustionEngineSize(Integer combustionEngineSize) {
        this.combustionEngineSize = combustionEngineSize;
    }

    public Integer getCombustionEngineSize() {
        return combustionEngineSize;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setNztaModelCode(String nztaModelCode) {
        this.nztaModelCode = nztaModelCode;
    }

    public String getNztaModelCode() {
        return nztaModelCode;
    }

    public void setNztaVariant(Integer nztaVariant) {
        this.nztaVariant = nztaVariant;
    }

    public Integer getNztaVariant() {
        return nztaVariant;
    }

    public void setFuelSaverVehicleType(String fuelSaverVehicleType) {
        this.fuelSaverVehicleType = fuelSaverVehicleType;
    }

    public String getFuelSaverVehicleType() {
        return fuelSaverVehicleType;
    }

    public void setEmissionTestRegime(String emissionTestRegime) {
        this.emissionTestRegime = emissionTestRegime;
    }

    public String getEmissionTestRegime() {
        return emissionTestRegime;
    }
}

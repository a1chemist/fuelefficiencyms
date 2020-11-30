package core.microservice.fuelefficiency.api.objects.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pingResponse")
public class FuelEfficiencyPingResponse {

    @JsonProperty("status")
    private FuelEfficiencyStatus fuelEfficiencyStatus;

    public FuelEfficiencyPingResponse(boolean status) {
        fuelEfficiencyStatus = status ? FuelEfficiencyStatus.UP : FuelEfficiencyStatus.DOWN;
    }

    public FuelEfficiencyStatus getFuelEfficiencyStatus() {
        return fuelEfficiencyStatus;
    }

    public void setFuelEfficiencyStatus(FuelEfficiencyStatus fuelEfficiencyStatus) {
        this.fuelEfficiencyStatus = fuelEfficiencyStatus;
    }
}

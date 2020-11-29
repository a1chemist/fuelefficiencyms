package core.microservice.fuelefficiency.api.objects.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelResponse {

    private String smallLabelUrl;

    private String mediumLabelUrl;

    public LabelResponse(){}

    public LabelResponse(String smallLabelUrl, String mediumLabelUrl) {
        this.smallLabelUrl = smallLabelUrl;
        this.mediumLabelUrl = mediumLabelUrl;
    }

    public String getSmallLabelUrl() {
        return smallLabelUrl;
    }

    public void setSmallLabelUrl(String smallLabelUrl) {
        this.smallLabelUrl = smallLabelUrl;
    }

    public String getMediumLabelUrl() {
        return mediumLabelUrl;
    }

    public void setMediumLabelUrl(String mediumLabelUrl) {
        this.mediumLabelUrl = mediumLabelUrl;
    }
}

package core.microservice.fuelefficiency.domain.objects;

public class FELabelUrl {

    private String smallLabelUrl;

    private String mediumLabelUrl;

    public FELabelUrl(String smallLabelUrl, String mediumLabelUrl) {
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

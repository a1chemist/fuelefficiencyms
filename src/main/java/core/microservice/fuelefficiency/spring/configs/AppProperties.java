package core.microservice.fuelefficiency.spring.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${fuelsaver.service.soap.url}")
    private String fuelSaverSoapUrl;

    @Value("${fuelsaver.service.rest.label.url}")
    private String fuelSaverRestLabelUrl;

    @Value("${fuelsaver.service.rest.listing.url}")
    private String fuelSaverRestListingUrl;

    @Value("${fuelsaver.service.image.small.base.url}")
    private String fuelSaverImageSmallBaseUrl;

    @Value("${fuelsaver.service.image.medium.base.url}")
    private String fuelSaverImageMediumBaseUrl;

    @Value("${fuelsaver.service.username}")
    private String fuelSaverUsername;

    @Value("${fuelsaver.service.soap.debug}")
    private boolean fuelSaverSoapDebug;

    @Value("${fuelsaver.service.rest.debug}")
    private boolean fuelSaverRestDebug;

    @Value("${fuelsaver.service.connection.timeout}")
    private int fuelSaverConnectionTimeout;

    @Value("${fuelsaver.service.request.timeout}")
    private int fuelSaverRequestTimeout;

    public String getFuelSaverSoapUrl() {
        return fuelSaverSoapUrl;
    }

    public void setFuelSaverSoapUrl(String fuelSaverSoapUrl) {
        this.fuelSaverSoapUrl = fuelSaverSoapUrl;
    }

    public String getFuelSaverRestLabelUrl() {
        return fuelSaverRestLabelUrl;
    }

    public void setFuelSaverRestLabelUrl(String fuelSaverRestLabelUrl) {
        this.fuelSaverRestLabelUrl = fuelSaverRestLabelUrl;
    }

    public String getFuelSaverRestListingUrl() {
        return fuelSaverRestListingUrl;
    }

    public void setFuelSaverRestListingUrl(String fuelSaverRestListingUrl) {
        this.fuelSaverRestListingUrl = fuelSaverRestListingUrl;
    }

    public String getFuelSaverImageSmallBaseUrl() {
        return fuelSaverImageSmallBaseUrl;
    }

    public void setFuelSaverImageSmallBaseUrl(String fuelSaverImageSmallBaseUrl) {
        this.fuelSaverImageSmallBaseUrl = fuelSaverImageSmallBaseUrl;
    }

    public String getFuelSaverImageMediumBaseUrl() {
        return fuelSaverImageMediumBaseUrl;
    }

    public void setFuelSaverImageMediumBaseUrl(String fuelSaverImageMediumBaseUrl) {
        this.fuelSaverImageMediumBaseUrl = fuelSaverImageMediumBaseUrl;
    }

    public String getFuelSaverUsername() {
        return fuelSaverUsername;
    }

    public void setFuelSaverUsername(String fuelSaverUsername) {
        this.fuelSaverUsername = fuelSaverUsername;
    }
}

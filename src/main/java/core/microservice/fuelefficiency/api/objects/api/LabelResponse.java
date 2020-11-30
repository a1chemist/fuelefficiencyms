package core.microservice.fuelefficiency.api.objects.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelResponse {

    private Transaction transaction;

    private String smallLabelUrl;

    private String mediumLabelUrl;

    public LabelResponse() {}

    public LabelResponse(Transaction transaction,
                         String smallLabelUrl,
                         String mediumLabelUrl) {
        this.transaction = transaction;
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

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

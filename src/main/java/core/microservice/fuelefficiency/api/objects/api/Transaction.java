package core.microservice.fuelefficiency.api.objects.api;

import java.util.Date;

public class Transaction {

    private String reference;

    private Date creationDate;

    public Transaction(String reference, Date creationDate) {
        this.reference = reference;
        this.creationDate = creationDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}

package core.microservice.fuelefficiency.api.objects.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.File;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrintLabelResponse {

    private Transaction transaction;

    private String base64ImageData;

    @JsonIgnore
    private byte[] imageByteData;

    @JsonIgnore
    private File tempFile;

    public PrintLabelResponse() {}

    public PrintLabelResponse(Transaction transaction,
                              String base64ImageData) {
        this.transaction = transaction;
        this.base64ImageData = base64ImageData;
    }

    public String getBase64ImageData() {
        return base64ImageData;
    }

    public void setBase64ImageData(String base64ImageData) {
        this.base64ImageData = base64ImageData;
    }

    public byte[] getImageByteData() {
        return imageByteData;
    }

    public void setImageByteData(byte[] imageByteData) {
        this.imageByteData = imageByteData;
    }

    public File getTempFile() {
        return tempFile;
    }

    public void setTempFile(File tempFile) {
        this.tempFile = tempFile;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
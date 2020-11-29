package core.microservice.fuelefficiency.domain.objects;

import java.io.File;

public class FEPrintLabel {

    private String base64ImageData;

    private byte[] imageByteData;

    private File tempFile;

    public FEPrintLabel() {}

    public FEPrintLabel(byte[] imageByteData, File tempFile) {
        this.imageByteData = imageByteData;
        this.tempFile = tempFile;
    }

    public FEPrintLabel(String base64ImageData) {
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

}
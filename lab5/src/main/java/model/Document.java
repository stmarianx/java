package model;

public class Document {
    private final String name;
    private final String fileType;

    public Document(String name, String fileType) {
        this.name = name;
        this.fileType = fileType;
    }

    public String getName() {
        return name;
    }

    public String getFileType() {
        return fileType;
    }
}

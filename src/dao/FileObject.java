package dao;

import java.io.File;

public class FileObject {

    private String fileName = "none";

    public static final String SPLIT_ONE = ";;";
    public static final String SPLIT_TOO = "::";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean fileExiste() {
        return new File(fileName).exists();
    }

    public boolean fileIsEmpty() {
        File file = new File(fileName);
        if(fileExiste() && file.length() == 0) {
            return true;
        }
        return false;
    }
}

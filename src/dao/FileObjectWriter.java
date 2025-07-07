package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class FileObjectWriter extends FileObject {

    public FileObjectWriter(String fileName) {
        setFileName(fileName);
    }

    public void initObjectInFile(Class<?> class1) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFileName()));
            Field[] fields = class1.getDeclaredFields();
            String classeName = class1.getName();

            bw.write(classeName);
            bw.newLine();
            for (int i = 0; i < fields.length; i++) {
                bw.write(fields[i].getName());
                if (i != fields.length - 1) {
                    bw.write(";;");
                }
            }
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writetRow(String row) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(getFileName(), true));
            bw.write(row);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
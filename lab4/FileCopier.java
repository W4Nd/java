package lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopier {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourceFilePath);
            fos = new FileOutputStream(destinationFilePath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии исходного файла: " + e.getMessage());
            }

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии целевого файла: " + e.getMessage());
            }
        }
    }
}


package pl.czarek.carnet.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageSaver {
    private final static String imageDirectory = System.getProperty("user.dir") +
            "/out/production/resources/static/img";

    private MultipartFile file;
    private byte[] binaryRepresentation;
    private String message;
    private String newCarImage;

    public ImageSaver(MultipartFile file) {
        this.file = file;
        this.newCarImage = "car-main" + System.currentTimeMillis() + ".jpg";
    }

    public boolean writeFile(long carId) {
        try {
            binaryRepresentation = file.getBytes();
        } catch (IOException e) {
            message = "Nie można było odczytać postaci bajtowej pliku";
            return false;
        }

        String pathToCarDirectory = imageDirectory + "/cars/" + carId;

        File carDirectory = new File(pathToCarDirectory);
        String pathToCarImage = pathToCarDirectory + "/" + newCarImage;

        if(!carDirectory.mkdir() && carDirectory.listFiles() != null) {
            File[] filesInDirectory = carDirectory.listFiles();

            if(filesInDirectory != null) {
                for (File fileInDir : filesInDirectory) {
                    boolean successfulDelete = fileInDir.delete();

                    if (!successfulDelete) {
                        message = "Nie można usunąć poprzedniego zdjęcia: " + fileInDir.getName();
                        return false;
                    }
                }
            }
        }

        try {
            Files.write(Paths.get(pathToCarImage), binaryRepresentation);
        } catch (IOException e) {
            message = "Błąd przy zapisie pliku na serwer";
            return false;
        }

        return true;
    }

    public String getMessage() {
        return message;
    }

    public String getNewNameOfFile() {
        return newCarImage;
    }
}

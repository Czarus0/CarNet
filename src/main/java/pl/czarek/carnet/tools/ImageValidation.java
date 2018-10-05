package pl.czarek.carnet.tools;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageValidation {
    private String message;
    private MultipartFile file;


    public ImageValidation(MultipartFile file) {
        this.file = file;
    }

    public boolean validImage() {
        if (file != null && file.getOriginalFilename() != null) {
            if (file.isEmpty()) {
                message = "Proszę wybrać plik, który jest zdjęciem";
                return false;
            }

            if (!file.getOriginalFilename().endsWith(".jpg")) {
                message = "Plik musi mieć rozszerzenie .jpg";
                return false;
            }

            try {
                BufferedImage image = ImageIO.read(file.getInputStream());

                if(image.getHeight() != 1080 || image.getWidth() != 1920) {
                    message = "Zdjęcie musi być wymiarów 1920x1080";
                    return false;
                }
            } catch (IOException e) {
                message = "Wystąpił błąd przy odczycie pliku";
                return false;
            }
        } else {
            message = "Nie podano żadnego pliku do weryfikacji";
            return false;
        }

        return true;
    }

    public String getMessage() {
        return message;
    }
}

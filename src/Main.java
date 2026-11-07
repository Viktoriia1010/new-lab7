//Описание:
//Ссылки на сайты, с которых надо скачать картинки,
//могут поступать из разных источников
//(например, с клавиатуры или из файла).
//Оценить возможность повторного использования кода из проекта "Качаем музыку"

import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {

            URL picture1 = new URL("https://i.pinimg.com/736x/c0/6b/dc/c06bdcb4af3557526c0c0f4c70cb3c6c.jpg");
            URLConnection connection = picture1.openConnection();

            try (InputStream input = connection.getInputStream()) {
                Files.copy(input,
                        new File("C:/Users/Привет/picture1.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            String input1 = scan.nextLine().trim();

            URL picture2 = new URL(input1);
            URLConnection connection2 = picture2.openConnection();

            String contentType = connection2.getContentType();
            String extension = "";

            if (contentType != null) {//проверка форматов чтобы корректно сохранялось
                if (contentType.contains("jpeg")) {
                    extension = ".jpg";
                } else if (contentType.contains("png")) {
                    extension = ".png";
                } else if (contentType.contains("webp")) {
                    extension = ".webp";
                } else if (contentType.contains("gif")) {
                    extension = ".gif";
                }
            }

            String fileName = "picture2" + extension;
            File file = new File("C:/Users/Привет/" + fileName);

            try (InputStream input2 = connection2.getInputStream()) {
                Files.copy(input2, file.toPath(), StandardCopyOption.REPLACE_EXISTING);}//StandardCopyOption.REPLACE_EXISTING/если файл сущесвует с таким именем то замени его новым файлом

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




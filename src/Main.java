import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        newDirectory("Games", "src");
        newDirectory("Games", "res");
        newDirectory("Games", "savegames");
        newDirectory("Games", "temp");

        // 2. В каталоге src создайте две директории: main, test.
        newDirectory("Games//src", "main");
        newDirectory("Games//src", "test");

        // 3. В подкаталоге main создайте два файла: Main.java, Utils.java
        newFile("Games//src//main", "Main.java");
        newFile("Games//src//main", "Utils.java");

        // 4. В каталог res создайте три директории: drawables, vectors, icons.
        newDirectory("Games//res", "drawables");
        newDirectory("Games//res", "vectors");
        newDirectory("Games//res", "icons");

        // 5.В директории temp создайте файл temp.txt
        newFile("Games//temp", "temp.txt");

        // 6.  Сохранения лога
        newLog();
    }

    /*
    Метод создающий папки в директории Games
    и добавляющий информацию в файл log об успешности/ошибки создания
     */
    public static void newDirectory(String directory, String name) {
        File dir = new File(directory + "//" + name);
        Date data = new Date();
        String login;
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ");
        if (dir.mkdir()) {
            login = "\n" + formatForDateNow.format(data) + ": папка \"" + name + "\" создана в директории " + directory;
        } else {
            login = formatForDateNow.format(data) + ": ОШИБКА создании папки \"" + name + "\" в директории " + directory;
        }
        log.append(login);
    }


    /*
    Метод создающий файлы в директории Games\"dirPath"
    и добавляющий информацию в файл log об успешности/ошибки создания
    */
    public static void newFile(String dirPath, String nameFile) {
        File myFile = new File(dirPath, nameFile);
        Date data = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ");
        String login;
        try {
            if (myFile.createNewFile()) {
                login = "\n" + formatForDateNow.format(data) + ": файл \"" + nameFile + "\" создан в директории " + dirPath;
            } else {
                login = formatForDateNow.format(data) + ": ОШИБКА создания файла \"" + nameFile + "\" директории " + dirPath;
            }
            log.append(login);
        } catch (IOException ex) {
        }
    }

    /*
    Запись лога в файл temp
    */
    public static void newLog() {
        try (FileWriter writer = new FileWriter("Games//temp//temp.txt", false)) {
            writer.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

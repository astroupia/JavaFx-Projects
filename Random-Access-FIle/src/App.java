import java.io.IOException;
import java.io.RandomAccessFile;

public class App {

    public static void main(String[] args) {
        String filePath = "personData.dat";

        // Write to the Random Access File
        writeToFile(filePath, "Abebe", "Addis", 30,'M');

        // Read from the Random Access File
        readFromFile(filePath);
    }

    // Write data to the Random Access File
    private static void writeToFile(String filePath, String name, String address, int age, char sex) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            writeString(file, name, 30);
            writeString(file, address, 30);
            file.writeInt(age);
            file.writeChar(sex);
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read data from the Random Access File
    private static void readFromFile(String filePath) {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            System.out.println("Reading from the file:");
            System.out.println("Name: " + readString(file, 30).trim());
            System.out.println("Address: " + readString(file, 30).trim());
            System.out.println("Age: " + file.readInt());
            System.out.println("Sex: " + file.readChar());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeString(RandomAccessFile file, String data, int length) throws IOException {
        file.writeBytes(String.format("%-" + length + "s", data));
    }

    // Method to read string from the Random Access File
    private static String readString(RandomAccessFile file, int length) throws IOException {
        byte[] bytes = new byte[length];
        file.readFully(bytes);
        return new String(bytes);
    }
}

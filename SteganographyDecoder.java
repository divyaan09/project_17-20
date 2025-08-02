import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SteganographyDecoder {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("encoded_test.png"));
        String hiddenMessage = decodeMessage(image);
        System.out.println("Hidden Message: " + hiddenMessage);
    }

    private static String decodeMessage(BufferedImage image) {
        StringBuilder message = new StringBuilder();
        int charValue = 0;
        int bitIndex = 0;

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int b = rgb & 0xFF;
                charValue = (charValue << 1) | (b & 1);
                bitIndex++;

                if (bitIndex == 8) {
                    char ch = (char) charValue;
                    message.append(ch);
                    if (message.toString().endsWith("#END#")) {
                        return message.substring(0, message.length() - 5);
                    }
                    bitIndex = 0;
                    charValue = 0;
                }
            }
        }
        return message.toString();
    }
}

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SteganographyEncoder {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("input.png"));
        String message = "This is a secret!";
        BufferedImage encoded = encodeMessage(image, message);
        ImageIO.write(encoded, "png", new File("encoded.png"));
        System.out.println("Message hidden successfully.");
    }

    private static BufferedImage encodeMessage(BufferedImage image, String message) {
        message += "#END#";
        int msgIndex = 0;
        int charValue = message.charAt(msgIndex);
        int bitIndex = 0;

        outer:
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                b = (b & 0xFE) | ((charValue >> (7 - bitIndex)) & 1);
                int newRGB = (r << 16) | (g << 8) | b;
                image.setRGB(x, y, newRGB);

                bitIndex++;
                if (bitIndex == 8) {
                    bitIndex = 0;
                    msgIndex++;
                    if (msgIndex == message.length()) break outer;
                    charValue = message.charAt(msgIndex);
                }
            }
        }
        return image;
    }
}

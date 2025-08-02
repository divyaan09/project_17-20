# 🖼️ Java Steganography Tool

A beginner-friendly Java application that hides and retrieves secret messages inside image files using the Least Significant Bit (LSB) steganography technique.

---

## 📌 Features

- ✅ Encode any secret text message into a PNG image
- ✅ Decode and retrieve the hidden message from the encoded image
- ✅ Simple Java code with no external libraries required
- ✅ Uses the Least Significant Bit (LSB) of the blue color channel

---

## 🧠 Concepts Used

- **Steganography**: Hiding data within image pixels
- **LSB manipulation**: Modifying the last bit of pixel data
- **BufferedImage**: Java class for image processing
- **Bitwise operations**: For encoding and decoding binary data

---

## 📁 Project Structure

```
SteganographyTool/
│
├── SteganographyEncoder.java     # Code to encode message in image
├── SteganographyDecoder.java     # Code to decode message from image
├── input.png                     # Sample input image for encoding
└── README.md                     # Project documentation
```

---

## 🚀 How to Run

### 🛠️ Requirements
- Java JDK 8 or later
- VS Code or any Java IDE

### 📦 Step-by-Step Instructions

1. Place your `input.png` image in the project folder.
2. Update `SteganographyEncoder.java` with your custom message:
   ```java
   String message = "Your secret message here";
   ```

3. Compile the code:

   ```bash
   javac SteganographyEncoder.java
   javac SteganographyDecoder.java
   ```

4. Run the encoder:

   ```bash
   java SteganographyEncoder
   ```

   This creates a new file `encoded.png` with the hidden message.

5. Run the decoder:

   ```bash
   java SteganographyDecoder
   ```

   This will read `encoded.png` and print the hidden message.

---

## 📝 Notes

* The message is appended with `#END#` internally to mark the end.
* Ensure your input image has enough pixels (e.g., 300x100 is sufficient).
* Only PNG or BMP formats are recommended (JPG may lose data due to compression).

---

## 📌 Example Output

**Hidden Message:**

```
This is a secret message!
```

---

## 📧 Contact

For any doubts or contributions, feel free to connect!
# project_17-20

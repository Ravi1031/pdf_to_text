import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        changePdf();
    }

    private static void changePdf() {
        BufferedWriter fileWriter = null;
        PDDocument document = null;
        try {
            File file = new File("D:\\Unit\\pdf_word_maven\\src\\main\\resources\\abcd.pdf");
            System.out.println(file.length());
             fileWriter = new BufferedWriter(
            new FileWriter("D:\\Unit\\pdf_word_maven\\src\\main\\resources\\abcd.txt"));
           document =
                    Loader.loadPDF(
                            new RandomAccessReadBufferedFile(
                                    "D:\\Unit\\pdf_word_maven\\src\\main\\resources\\abcd.pdf"));

            PDFTextStripper pdfTextStripper =new PDFTextStripper();
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                pdfTextStripper.setStartPage(i);
                pdfTextStripper.setEndPage(i);
                String text = pdfTextStripper.getText(document);
                fileWriter.write(text);
                fileWriter.newLine();
            }
            System.out.println("pdf written successfully");
            System.out.println(document.getNumberOfPages());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
           try {
               if (fileWriter!=null){
                   fileWriter.close();
               }
               if (document != null){
                   document.close();
               }
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
        }
    }

}

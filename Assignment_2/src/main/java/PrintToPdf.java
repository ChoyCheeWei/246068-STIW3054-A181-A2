import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class PrintToPdf {

    public static void Convert(ArrayList<Data> tablecontents,
                               ArrayList<String> DataOutsideTable) throws IOException, DocumentException {

        // create output PDF document page A4 size
        Document document = new Document(PageSize.A4);

        //set path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ccw\\Desktop\\Assignment_2.pdf"));
        document.open();

        // Create row and set width
        PdfPTable table = new PdfPTable(new float[] {6, 51, 8, 8, 5, 22});
        table.setWidthPercentage(100);


        // Convert Data before table
        int count = 0;


        System.out.println("Generating pdf file..............");
        Paragraph paragraph = new Paragraph();
        for (String text : DataOutsideTable ) {

            if (count >= 0 && count < 4) {

                paragraph = new Paragraph(new Phrase(text));
                document.add(paragraph);
            }
            count++;

        }
        // Make some spacing between table for the following output
        document.add(Chunk.NEWLINE);


        Iterator<Data> iterator = tablecontents.iterator();

        // convert table data
        while (iterator.hasNext()) {
            Data data = iterator.next();

            table.addCell(data.getNo());
            table.addCell(data.getName());
            table.addCell(data.getFidelID());
            table.addCell(data.getFed());
            table.addCell(data.getRtg());
            table.addCell(data.getClub_or_city());
        }

        document.add(table);

        // Make some spacing
        document.add(Chunk.NEWLINE);

        //reset count to 0
        count =0;

        // convert data after table
        for (String text : DataOutsideTable ) {
            if (count >= 4 && count < 6) {

                paragraph = new Paragraph(new Phrase(text));
                document.add(paragraph);
            }
            count++;
        }

        document.close();
        System.out.println("Pdf File had successfully created.");
    }
}

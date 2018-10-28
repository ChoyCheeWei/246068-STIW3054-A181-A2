import com.itextpdf.text.DocumentException;

import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException, DocumentException {

        ReadExcel readExcel = new ReadExcel();
        readExcel.Read();

        PrintToPdf.Convert(readExcel.getTablecontents(),readExcel.getDataOutsideTable());
    }
}

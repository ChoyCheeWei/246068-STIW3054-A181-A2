import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class ReadExcel {

    // set path
    private static final String path = "C:\\Users\\ccw\\Desktop\\chessResultsList.xlsx";

    private final ArrayList<Data> tablecontents = new ArrayList<Data>();
    private final ArrayList<String> DataOutsideTable = new ArrayList<String>();


    public void Read() throws IOException {

        // Creating a Workbook from an Excel file
        Workbook workbook = WorkbookFactory.create(new File(path));

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // obtain a rowIterator iterate over it
        Iterator<Row> rowIterator = sheet.rowIterator();

        System.out.println("Reading excel file.......");

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //to store the data that before and after the table
            if (row.getRowNum() < 4 || row.getRowNum() > 154) {
                DataOutsideTable.add(row.getCell(0).toString());

            } else {
                String no = dataFormatter.formatCellValue(row.getCell(0));
                String name = row.getCell(2).toString();
                String fideID = row.getCell(3).toString();
                String fed = row.getCell(4).toString();
                String rtg = dataFormatter.formatCellValue(row.getCell(5));
                String club_or_city = row.getCell(6).toString();
                tablecontents.add(new Data(no, name, fideID, fed, rtg, club_or_city));

            }
        }
        // Closing the workbook
        workbook.close();

        System.out.println("Complete.");
    }

    public ArrayList<Data> getTablecontents() {
        return tablecontents;
    }

    public ArrayList<String> getDataOutsideTable() {
        return DataOutsideTable;
    }
}


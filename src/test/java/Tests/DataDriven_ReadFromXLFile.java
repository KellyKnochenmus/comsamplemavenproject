package Tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class DataDriven_ReadFromXLFile {

    public static void main(String[] args) {

        //create data types
        XSSFWorkbook ExcelWBook;
        XSSFSheet ExcelWSheet;
        XSSFCell Cell;

        //Location of the Excel file
        String strPath = "//Users//kknochenmus//Desktop//ExcelRead.xlsx";
        String strSheetName = "Sheet1";

        //Read the data from a particular cell
        try {
            //set path to Excel file
            FileInputStream ExcelFile = new FileInputStream(strPath);
            //instantiate the workbook
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            //instantiate the sheet within the workbook
            ExcelWSheet = ExcelWBook.getSheet(strSheetName);

            Cell = ExcelWSheet.getRow(1).getCell(2);
            String strCellData = Cell.getStringCellValue();
            System.out.println("Cell Data: "+ strCellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

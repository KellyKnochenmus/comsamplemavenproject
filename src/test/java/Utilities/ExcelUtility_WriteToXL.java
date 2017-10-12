package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtility_WriteToXL {

    public static XSSFWorkbook ExcelWBook;
    public static XSSFSheet ExcelWSheet;
    public static XSSFCell Cell;
    public static XSSFRow Row;

        //Set the File path, open Excel file (Params are path name and sheet name)
        public static void setExcelFile(String strPath, String strSheetName) throws Exception {
            try {
                //Open the Excel file
                FileInputStream ExcelFile = new FileInputStream(strPath);

                //Access the Excel Data Sheet
                ExcelWBook = new XSSFWorkbook(ExcelFile);
                ExcelWSheet = ExcelWBook.getSheet(strSheetName);
            } catch (Exception e) {
                throw (e);
            }
        }

        //Get number of rows in the data sheet
        public static int getNumberOfRows(String strPath, String strSheetName) throws Exception {
            int intRowCount = ExcelWSheet.getLastRowNum()+1;
            return intRowCount;
        }


        //Get Cell Data Method - String
        public static String getCellData(int intRowNum, int intColNum) throws Exception {
            try {
                Cell = ExcelWSheet.getRow(intRowNum).getCell(intColNum);
                String strCellData = Cell.getStringCellValue();
                return strCellData;
            } catch (Exception e) {
                return "";
            }
        }

    //Get Date Data Method - String
    public static String getDateCellData(int intRowNum, int intColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(intRowNum).getCell(intColNum);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateValue = Cell.getDateCellValue();
            String strDateValueFormat = df.format(dateValue);
            return strDateValueFormat;

        } catch (Exception e) {
            return "";
        }
    }

    //Write to the Excel Cell - Result is String Type
    public static void setCellData(String strResult, int intRowNum, int intColNum, String strPath, String strSheetName) throws Exception {
            try {
                Row = ExcelWSheet.getRow(intRowNum);
                Cell = Row.getCell(intColNum);
                if (Cell == null) {
                    Cell = Row.createCell(intColNum);
                    Cell.setCellValue(strResult);
                } else {
                    Cell.setCellValue(strResult);
                }

                //Open the file to write the results
                FileOutputStream fileOut = new FileOutputStream(strPath + strSheetName);

                ExcelWBook.write(fileOut);
                fileOut.flush();
                fileOut.close();
            } catch (Exception e) {
                throw (e);
        }
    }

    //Write to the Excel Cell - Result is Double Type
    public static void setCellData(double Result, int intRowNum, int intColNum, String strPath, String strSheetName) throws Exception {
        try {
            Row = ExcelWSheet.getRow(intRowNum);
            Cell = Row.getCell(intColNum);
            if (Cell == null) {
                Cell = Row.createCell(intColNum);
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }

            //Open the file to write the results
            FileOutputStream fileOut = new FileOutputStream(strPath + strSheetName);

            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            throw (e);
        }
    }
}

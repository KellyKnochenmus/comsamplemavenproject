package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtility_ReadFromXL {

    public static XSSFWorkbook ExcelWBook;
    public static XSSFSheet ExcelWSheet;
    public static XSSFCell Cell;
    public static XSSFRow Row;

    //Set the File path, open EXcel file (Params are path name and sheet name)
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

    //Get Test Data Method - creates a multi-dimensional array that collects all the data
    public static String[][] getTestData(String strTableName) {
        String[][] arrTestData = null;
        try {
            DataFormatter formatter = new DataFormatter();
            XSSFCell[] arrBoundaryCells = findCells(strTableName);
            XSSFCell startCell = arrBoundaryCells[0];
            XSSFCell endCell = arrBoundaryCells[1];

            int intStartRow = startCell.getRowIndex() + 1;
            int intEndRow = endCell.getRowIndex() - 1;
            int intStartCol = startCell.getColumnIndex() + 1;
            int intEndCol = endCell.getColumnIndex() - 1;

            arrTestData = new String[intEndRow - intStartRow + 1][intEndCol - intStartCol + 1];

            for (int i = intStartRow; i < intEndRow + 1; i++) {
                for (int j = intStartCol; j < intEndCol + 1; j++) {
                    arrTestData[i - intStartRow][j - intStartCol] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
                    Cell cell = ExcelWSheet.getRow(i).getCell(j);
                    String strCellValue = cell.getStringCellValue();
                    arrTestData[i - intStartRow][j - intStartCol] = formatter.formatCellValue(cell);
                    System.out.println("Cell Data for Row " + i + " and Column " + j + " = '" + strCellValue + "'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrTestData;
   }

    //Find Cells Method - if the String Cell Value = Table Name, it gets the cell number
    public static XSSFCell[] findCells(String strTableName) {
        String strPos = "begin";
        XSSFCell[] arrCells = new XSSFCell[2];

        for (Row row : ExcelWSheet) {
            for (Cell cell : row) {
                if (strTableName.equals(cell.getStringCellValue())) {
                    if (strPos.equalsIgnoreCase("begin")) {
                        arrCells[0] = (XSSFCell) cell;
                        strPos = "end";
                    } else {
                        arrCells[1] = (XSSFCell) cell;
                    }
                }
            }
        }
        return arrCells;
    }
}

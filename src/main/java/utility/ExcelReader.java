//package utility;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExcelReader {
//    FileInputStream excelFile = null;
//    XSSFWorkbook workbook;
//    XSSFSheet sheet;
//    XSSFCell cell;
//    String filepath;
//    String sheetName;
//
//    public ExcelReader (String filepath,String sheetName){
//        this.filepath =filepath;
//        this.sheetName = sheetName;
//    }
//
//    public String getDataFromCell(int row,int column) {
//        String value = null;
//
//        try {
//            excelFile = new FileInputStream(filepath);
//            workbook = new XSSFWorkbook(excelFile);
//            sheet = workbook.getSheet(sheetName);
//            cell = sheet.getRow(row).getCell(column);
//            value = cell.getStringCellValue();
//            excelFile.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return value;
//
//    }
//
//    public  List <String> getEntireColumnData(String rowStart, String column)  {
//        List<String> columnData = new ArrayList<>();
//        try {
//            excelFile = new FileInputStream(filepath);
//            workbook = new XSSFWorkbook(excelFile);
//            sheet = workbook.getSheet(sheetName);
//            for ( int i = rowStart ; i <= sheet.getLastRowNum(); i++) {
//                columnData.add(sheet.getRow(i).getCell(column).getStringCellValue());
//
//            } excelFile.close();
//
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//            return columnData;
//    }
//    public String getDataForGivenHeaderAndKey(){
//        String Value =null;
//    while(getDataFromCell(0),))
//
//        return value;
//    }
//
//    public static void main(String[] args) {
//        ExcelReader excelReader =new ExcelReader("/Users/sanjaysinghgussain/IdeaProjects/comlearnAutomation/data/test-data.xlsx");
//        List<String> data = excelReader.getEntireColumnData("1","0");
//
//    }
//
//    }
//
//
//
//
//
//
//
//
//

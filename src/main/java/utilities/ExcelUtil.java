package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import modeles.CompanyprofileData;
import modeles.FlightBookingData;



public final class ExcelUtil {


    private static Workbook workbook;
    private static Sheet sheet;


    private ExcelUtil() {

    }


    public static void openExcel(String excelPath, String sheetName) {

        try {

            File file = new File(excelPath);

            if (!file.exists()) {
                throw new RuntimeException(
                        "Excel file not found : " + excelPath);
            }

            FileInputStream fis = new FileInputStream(file);

            workbook = WorkbookFactory.create(fis);

            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found : " + sheetName
                        + " in file : " + excelPath);
            }

            System.out.println("Excel File : " + excelPath);
            System.out.println("Sheet : " + sheet.getSheetName());

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to open Excel File : " + excelPath,
                    e);
        }
    }
    /**
     * Read Complete Excel Data
     */
    public static Object[][] getExcelData() {

        DataFormatter formatter = new DataFormatter();

        int cols = sheet.getRow(0).getLastCellNum();

        List<Object[]> rows = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            if (row == null) {
                continue;
            }

            Cell firstCell = row.getCell(0);

            if (firstCell == null ||
                formatter.formatCellValue(firstCell).trim().isEmpty()) {
                continue;
            }

            Object[] rowData = new Object[cols];

            for (int j = 0; j < cols; j++) {

                Cell cell = row.getCell(j);

                rowData[j] = (cell == null)
                        ? ""
                        : formatter.formatCellValue(cell);
            }

            rows.add(rowData);
        }

        return rows.toArray(new Object[0][]);
    }





  
    public static CompanyprofileData getCompanyprofileData(
            Object[] row) {



        return new CompanyprofileData(
               row[0].toString(),
                row[1].toString(), 

                row[2].toString(),  

                row[3].toString(),  

                row[4].toString(),  

                row[5].toString(),  

                row[6].toString(),  

                row[7].toString(),  

                row[8].toString(), 

                row[9].toString(),  

                row[10].toString(),

                row[11].toString(),
                row[12].toString(), 

                row[13].toString(), 

                row[14].toString(), 

                row[15].toString() , 
                row[16].toString(),
                row[17].toString(),
                row[18].toString(),
                row[19].toString(),
                row[20].toString(),
                row[21].toString(),
                row[22].toString(),
                row[23].toString(),
                row[24].toString(),
                row[25].toString(),
                row[26].toString(),
                row[27].toString(),
                row[28].toString(),
                row[29].toString(),
                row[30].toString(),
                row[31].toString(),
                row[32].toString(),
                row[33].toString(),
                row[34].toString(),
                row[35].toString(),
                row[36].toString(),
                row[37].toString(),
                row[38].toString(),
                row[39].toString(),
                row[40].toString(),
                row[41].toString(),
                row[42].toString(),
                row[43].toString(),
                row[44].toString(),
                row[45].toString(),
                row[46].toString(),
                row[47].toString(),
                row[48].toString(),
                row[49].toString(), 

                row[50].toString(),  

                row[51].toString(),  

                row[52].toString(),  

                row[53].toString(),  

                row[54].toString(),  

                row[55].toString(),  

                row[56].toString(), 

                row[57].toString(),  

                row[58].toString(),

                row[59].toString(),
                row[60].toString(),
                row[61].toString()
                
                
                
              
                
                
                
                 
          
       
          );      
     

    }
    
    
    
    public static FlightBookingData getFlightBookingData(Object[] row) {
    	
    	
    	 return new FlightBookingData(
    			 
    			 row[0].toString(),
                 row[1].toString(), 

                 row[2].toString(),  

                 row[3].toString(),  

                 row[4].toString(),  

                 row[5].toString(),  

                 row[6].toString(),  

                 row[7].toString(),  

                 row[8].toString(), 

                 row[9].toString(),
                 
                 row[10].toString(),
                 row[11].toString(),
                 row[12].toString(),
                 row[13].toString(),
                 row[14].toString(),
                 row[15].toString(),
                 row[16].toString(),
                 row[17].toString(),
                 row[18].toString(),
                 row[19].toString(),
                 row[20].toString(),
                 row[21].toString(),
                 row[22].toString(),
                 row[23].toString(),
                 row[24].toString(),
                 row[25].toString(),
                 row[26].toString(),
                 row[27].toString(),
                 row[28].toString(),
                 row[29].toString(),
                 row[30].toString(),
                 row[31].toString(),
                 row[32].toString(),
                 row[33].toString(),
                 row[34].toString(),
                 row[35].toString(),
                 row[36].toString()
                 
                 
              
       
              
                 
                 
                
    			 
    			 
    			 
    			 
    			 
    			 
    			 );
    	
    	
    	
    	
    }
    public static Object[][] getCompanyProfileTestData() {

        Object[][] excelData = getExcelData();

        Object[][] testData =
                new Object[excelData.length][1];

        for (int i = 0; i < excelData.length; i++) {

            testData[i][0] =
                    getCompanyprofileData(excelData[i]);
        }

        return testData;
    }

    public static Object[][] getFlightBookingTestData() {

        Object[][] excelData = getExcelData();

        Object[][] testData =
                new Object[excelData.length][1];

        for (int i = 0; i < excelData.length; i++) {

            testData[i][0] =
                    getFlightBookingData(excelData[i]);
        }

        return testData;
    }
 
    
    public static void closeExcel() {


        try {


            if(workbook != null) {

                workbook.close();

            }


        } catch(IOException e) {


            throw new RuntimeException(
                    "Unable to close Excel",
                    e);

        }

    }


}
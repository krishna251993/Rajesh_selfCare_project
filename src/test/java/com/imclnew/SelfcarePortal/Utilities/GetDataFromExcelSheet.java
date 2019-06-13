package com.imclnew.SelfcarePortal.Utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.imclnew.SelfcarePortal.Constants.ConstantData.FRCODE;

public class GetDataFromExcelSheet {
    public static String readExcel(String filepath,String filename,String Pagename,int i,int j) throws IOException
    {
        /*i is row, j is column*/
        String Value;
        //Create an object of File class to open xlsx file
        File file = new File(filepath+"/"+filename);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream=new FileInputStream(file);

        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtention = filename.substring(filename.indexOf("."));

        //Check condition if the file is xlsx file
        Workbook book = null;
        if(fileExtention.equalsIgnoreCase(".xlsx"))
        {
            book=new XSSFWorkbook(inputStream);
        }
        else
        if(fileExtention.equalsIgnoreCase(".xls"))
        {
            book=new HSSFWorkbook(inputStream);
        }
        //Read sheet inside the workbook by its name
        Sheet getSheetname = book.getSheet(Pagename);

        //Find number of rows in excel file
        int rowcount = getSheetname.getLastRowNum();
        System.out.println(rowcount+"=========>rowcount");
        //Create a loop over all the rows of excel file to read it
//		        for(int i=0;i<=rowcount;i++)
//		        {
        Row row=getSheetname.getRow(i);
        Cell cell = row.getCell(i);
//      int cellcount=row.getLastCellNum();
//					System.out.println(cellcount+"=========>cellcount");
//		            for(int j=0;j<cellcount;j++)
//		            {
        try
        {
            Value=getSheetname.getRow(i).getCell(j).getStringCellValue();
            System.out.print("String------->"+getSheetname.getRow(i).getCell(j).getStringCellValue()+"		");
        } catch (Exception e)
        {
            System.out.print(getSheetname.getRow(i).getCell(j).getNumericCellValue()+"    ");
            int code=(int) getSheetname.getRow(i).getCell(j).getNumericCellValue();
            Value=Integer.toString(code);

            System.out.println("integer------->"+Value);
        }
//		            }
        System.out.println();
//		        }
        return Value;
    }
}
package com.imclnew.SelfcarePortal.Utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataToExcelSheet {
    public static String writeExcel(String filepath,String filename,String Pagename, int i, String/*[]*/ Data) throws IOException {
        String Value="";
        File file = new File(filepath+"/"+filename);
        FileInputStream inputStream=new FileInputStream(file);
        String fileExtention = filename.substring(filename.indexOf("."));
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

        Sheet page = book.createSheet(Pagename);

        Sheet getSheetname = book.getSheet(Pagename);

        /*int rowcount = getSheetname.getLastRowNum()-getSheetname.getFirstRowNum();
        Row row=getSheetname.getRow(i);
        Row newRow = getSheetname.createRow(rowcount+1);

        for(int j = 0; j < row.getLastCellNum(); j++)
        {
            Cell cell = newRow.createCell(j);
            //cell.setCellValue(Data[j]);
            cell.setCellValue(Data);
        }

        inputStream.close();*/
        FileOutputStream outputStream = new FileOutputStream(file);
        book.write(outputStream);
        outputStream.close();

        return Value;
    }
}
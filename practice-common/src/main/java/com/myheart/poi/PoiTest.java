package com.myheart.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;

/**
 * @author yangxin
 * @date 2019/11/29
 */
public class PoiTest {

    public static void main(String[] args) {
        File file = new File("/Users/apple/Downloads/未命名文件夹/还款信息导入模板 (6).xlsx");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);

//            Row row = sheet.getRow(0);
//            System.out.println(row.getFirstCellNum());
//            System.out.println(row.getLastCellNum());
//            System.out.println(row.getPhysicalNumberOfCells());

            Row row1 = sheet.getRow(1);
//            System.out.println(row1.getFirstCellNum());
            System.out.println(row1.getLastCellNum());
            System.out.println(row1.getPhysicalNumberOfCells());
            System.out.println(row1.getCell(20).getStringCellValue());
            if (row1.getCell(21).getStringCellValue() == null){
                System.out.println("null");
            }else if (row1.getCell(21).getStringCellValue().equals("")){
                System.out.println("konghcuan");
            }
            System.out.println(row1.getSheet().getRow(0).getLastCellNum());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

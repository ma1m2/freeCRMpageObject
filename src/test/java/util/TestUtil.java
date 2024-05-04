package util;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICIT_WAIT = 10;
    public static String TESTDATA_SHEET_PATH = "./src/test/resources/testdata/FreeCrmTestData.xlsx";
    public static String TESTDATA_CSV_PATH = "./src/test/resources/testdata/FreeCrmTestDataContacts.csv";
    public static String PROP_NEW_FILE_PATH = "/src/test/resources/config/new.properties";

    private static XSSFWorkbook wb;
    private static XSSFSheet sheet;

    public static Object[][] getTestData(String sheetName){
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(TESTDATA_SHEET_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if(fis != null) {
                wb = new XSSFWorkbook(fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[lastRowNum][lastCellNum];
        System.out.println(lastRowNum + "--------------------" + lastCellNum);
        for(int i = 0; i < lastRowNum; i++){
            for(int j = 0; j < lastCellNum; j++){
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                System.out.print(i + " " + j + " " + data[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println(Arrays.deepToString(data));
        return data;
    }

    public static String getCurrentDir(){
        File currentDir = new File(".");
        String path = currentDir.getAbsolutePath();
        return  path;
    }

    public static String getUserDir(){
        String path = System.getProperty("user.dir");
        return  path;
    }

    public static void readCsvFile(){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(TESTDATA_CSV_PATH));
            String line;
            int i=0;
            while ((line = bfReader.readLine()) != null){
                String[] words = line.split(",");
                for (String word: words) {
                    System.out.print(word + "\t");
                }
                System.out.println("  " + i);
                i++;
            }
            bfReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeReadPropertiesFile(){
        Properties prop = new Properties();
        prop.setProperty("name","Sveta");
        prop.setProperty("age","15");
        prop.setProperty("email","test@gmail.com");

        try {
            FileOutputStream fos = new FileOutputStream (PROP_NEW_FILE_PATH);
            prop.store(fos, "Write new properties!");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.getProperty("user.dir") + PROP_NEW_FILE_PATH);

        //read from prop all keys
        try {
            FileInputStream fis = new FileInputStream(PROP_NEW_FILE_PATH);
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> keys = prop.stringPropertyNames();
        System.out.println(keys);
        Set<Object> keyProps = prop.keySet();
        System.out.println(keyProps);
        for (String key : keys){
            System.out.println(key + " " + prop.getProperty(key));
        }
    }

}

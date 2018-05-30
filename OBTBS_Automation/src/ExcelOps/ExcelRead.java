package ExcelOps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import masterBeans.place;
import masterBeans.state;

public class ExcelRead {
	
	private List<state> stateList=new ArrayList<state>();
	private List<place> placeList=new ArrayList<place>(); 

	
	
	//To read state lists from excel	
	public List<state> readStatesFromExcel(String fileName,String sheetName) throws IOException{
		 
		
		String stateCode="",stateName="";
		state e=null;
		
		//Create an object of File class to open xlsx file
		File file = new File(fileName);
		
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;
		
		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			 
			//If it is xlsx file then create object of XSSFWorkbook class
			Workbook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class
			Workbook = new HSSFWorkbook(inputStream);

	    }
		
		
		//Read sheet inside the workbook by its name
		Sheet Sheet = Workbook.getSheet(sheetName);
		
		
		//Find number of rows in excel file
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();

		
		
		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount+1; i++) {
			
			Row row = Sheet.getRow(i);
			
			//Read State-code
			if(row.getCell(0).getCellTypeEnum()==CellType.STRING){
				stateCode = row.getCell(0).getStringCellValue();
			}else if(row.getCell(0).getCellTypeEnum()==CellType.NUMERIC){
				stateCode = Double.toString(row.getCell(0).getNumericCellValue());
			}
			

			//Read State-name
			if(row.getCell(1).getCellTypeEnum()==CellType.STRING){
				stateName = row.getCell(1).getStringCellValue();
			}else if(row.getCell(1).getCellTypeEnum()==CellType.NUMERIC){
				stateName = Double.toString(row.getCell(1).getNumericCellValue());
			}
			

			System.out.println("state code:"+stateCode+" state name "+stateName);
			e=new state(stateCode,stateName);
			stateList.add(e);		

		}
		
//		System.out.println("From Excel:");
//		for(state s:stateList) {
//            System.out.println(s.getStateName());
//            System.out.println(s.getStateCode());
//
//        }
		
		return stateList;
	}
	
	
	//To read Placelist from excel
	public List<place> readPlacesFromExcel(String fileName,String sheetName) throws IOException{
		 
		
		String placeCode="",placeName="",placeType="",state="",district="",pickUp="";
		place e=null;
		
		//Create an object of File class to open xlsx file
		File file = new File(fileName);
		
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;
		
		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			 
			//If it is xlsx file then create object of XSSFWorkbook class
			Workbook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class
			Workbook = new HSSFWorkbook(inputStream);

	    }
		
		
		//Read sheet inside the workbook by its name
		Sheet Sheet = Workbook.getSheet(sheetName);
		
		
		//Find number of rows in excel file
		int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();

		
		
		//Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount+1; i++) {
			
			Row row = Sheet.getRow(i);
			
			//Read Place-code
			if(row.getCell(0).getCellTypeEnum()==CellType.STRING){
				placeCode = row.getCell(0).getStringCellValue();
			}else if(row.getCell(0).getCellTypeEnum()==CellType.NUMERIC){
				placeCode = Double.toString(row.getCell(0).getNumericCellValue());
			}
			

			//Read Place-name
			if(row.getCell(1).getCellTypeEnum()==CellType.STRING){
				placeName = row.getCell(1).getStringCellValue();
			}else if(row.getCell(1).getCellTypeEnum()==CellType.NUMERIC){
				placeName = Double.toString(row.getCell(1).getNumericCellValue());
			}
			
			//Read Place-type
			if(row.getCell(2).getCellTypeEnum()==CellType.STRING){
				placeType = row.getCell(2).getStringCellValue();
			}else if(row.getCell(2).getCellTypeEnum()==CellType.NUMERIC){
				placeType = Double.toString(row.getCell(2).getNumericCellValue());
			}
			
			//Read State
			if(row.getCell(3).getCellTypeEnum()==CellType.STRING){
				state = row.getCell(3).getStringCellValue();
			}else if(row.getCell(3).getCellTypeEnum()==CellType.NUMERIC){
				state = Double.toString(row.getCell(3).getNumericCellValue());
			}

			
			
			//Read District
			if(row.getCell(4).getCellTypeEnum()==CellType.STRING){
				district = row.getCell(4).getStringCellValue();
			}else if(row.getCell(4).getCellTypeEnum()==CellType.NUMERIC){
				district = Double.toString(row.getCell(4).getNumericCellValue());
			}
			
			//Read pickup
			if(row.getCell(5).getCellTypeEnum()==CellType.STRING){
				pickUp = row.getCell(5).getStringCellValue();
			}else if(row.getCell(5).getCellTypeEnum()==CellType.NUMERIC){
				pickUp = Double.toString(row.getCell(5).getNumericCellValue());
			}


			System.out.println("Place code:"+placeCode+" Place name "+placeName);
			e=new place(placeCode,placeName,placeType,state,district,pickUp);
			placeList.add(e);		

		}
		
		System.out.println("From Excel:");
		for(place p:placeList) {
            System.out.println(p.getPlaceCode());
            System.out.println(p.getPlaceName());
            System.out.println(p.getDistrict());
            System.out.println(p.getState());
            System.out.println(p.getPlaceType());
            System.out.println(p.getPickup());
        }
		
		return placeList;
	}


	

}

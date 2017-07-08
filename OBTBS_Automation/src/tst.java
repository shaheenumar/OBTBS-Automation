import java.io.IOException;
import java.util.List;

import ExcelOps.ExcelRead;
import masterBeans.state;

public class tst {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		//Create an object of ReadExcel class
		ExcelRead objExcelFile = new ExcelRead();

		//Prepare the path of excel file
		String filePath = System.getProperty("user.dir");

		//Call read file method of the class to read data
		List<state> sts = objExcelFile.readExcel(filePath,"test.xlsx","sheet1");
		
		for(state d:sts) {
            System.out.println(d.getStateName());
            System.out.println(d.getStateCode());

        }
		

	}

}

package com.api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersClass {

	@DataProvider(name = "data")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("/API_Automation_testing_framework/TestData/userData.xlsx");
		XLUtility xl = new XLUtility(path);

		int rowcount = xl.getRowCount("Sheet1");
		int cellcount = xl.getCellCount("Sheet1", 1);

		String data[][] = new String[rowcount][cellcount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j <= cellcount; j++) {
				data[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}

		}
		return data;
	}

	@DataProvider(name = "userName")
	public String[] getUsernames() throws IOException {
		String path = System.getProperty("/API_Automation_testing_framework/TestData/userData.xlsx");
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		String apidata[] = new String[rownum];
		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);
		}
		return apidata;
	}

}
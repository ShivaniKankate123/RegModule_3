package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class MuiGridHandler extends base {


	public void selectRow(int rowIndex) {
		// Assuming the grid rows have the class name "MuiTableRow"
		List<WebElement> rows = driver.findElements(By.xpath("(//div[@role='grid'])[1]"));
		if (rowIndex >= 0 && rowIndex < rows.size()) {
			rows.get(rowIndex).click();
		} else {
			System.out.println("Invalid row index.");
		}
	}

	// Method to click on a cell in the MUI grid based on row and column index
	public void clickCell(int rowIndex, int columnIndex) {
		// Assuming the grid cells have the class name "MuiTableCell"
		List<WebElement> rows = driver.findElements(By.className("MuiTableRow"));
		if (rowIndex >= 0 && rowIndex < rows.size()) {
			WebElement row = rows.get(rowIndex);
			List<WebElement> cells = row.findElements(By.className("MuiTableCell"));
			if (columnIndex >= 0 && columnIndex < cells.size()) {
				cells.get(columnIndex).click();
			} else {
				System.out.println("Invalid column index.");
			}
		} else {
			System.out.println("Invalid row index.");
		}
	}

	// Method to search for data in the MUI grid
	public boolean searchData(String searchText) {
		// Assuming the search input has the class name "MuiInputBase-input"
		WebElement searchInput = driver.findElement(By.className("MuiInputBase-input"));
		searchInput.sendKeys(searchText);

		// Assuming the grid rows have the class name "MuiTableRow"
		List<WebElement> rows = driver.findElements(By.className("MuiTableRow"));
		for (WebElement row : rows) {
			// Assuming the cell data has the class name "MuiTableCell-body"
			WebElement cellData = row.findElement(By.className("MuiTableCell-body"));
			if (cellData.getText().contains(searchText)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MuiGridHandler gridHandler = new MuiGridHandler();
		gridHandler.driver.get("URL_OF_YOUR_MUI_GRID_PAGE");

		// Example usage:
		gridHandler.selectRow(2);
		gridHandler.clickCell(1, 3);
		boolean dataFound = gridHandler.searchData("Example Search Text");
		System.out.println("Data Found: " + dataFound);

		gridHandler.driver.quit();
	}
}

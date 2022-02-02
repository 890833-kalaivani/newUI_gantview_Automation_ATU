package get.next.gen.utilities;

import get.next.gen.commonaction.CommonTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import get.next.gen.commonaction.CompareExcel;
import get.next.gen.webtestcase.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })



//

public class Gatechange_old extends CommonTest {
	
	
	

	public static void gatechange() throws Exception {
		getDriver().findElement(By.xpath("//img[@title='Update Gate']")).click();
		List<WebElement> Ganntlist = getDriver().findElements(By.xpath(Web_UI.GanttTable));
		int Ganntlistcount = Ganntlist.size();
		if(Ganntlistcount == 0)
		{
			
		}
		
		if(Ganntlistcount == 0)
		{
			ATUReports.add(" ",  LogAs.PASSED, null);
			captureinfoScreenshot(getDriver(), "PuckUIPlacementListZero");
		}
		
		else
		{
			if (Ganntlist != null) {
				int i=0;
				for (WebElement gantelement : Ganntlist) {
					i++;
					
								try {

									Actions actions = new Actions(getDriver());
									actions.moveToElement(gantelement).build().perform();
									actions.moveToElement(gantelement);
									String storeelementid = gantelement.getAttribute("id").trim();
									String storegateid = gantelement.findElement(By.xpath("ancestor::div[@drop='handleDrop']")).getAttribute("id").trim();
									List<WebElement> gatelist = getDriver().findElements(By.xpath("//div[@drop='handleDrop']"));
									for (WebElement gate : gatelist)
									{
										String fetchid = gate.getAttribute("id");
										WebElement Toid = getDriver().findElement(By.xpath("//div[@id='A10']"));
										WebElement Toid1 = getDriver().findElement(By.xpath("//div[@id='A10']/div[1]/div[1]"));
										
										if(fetchid.contains(storegateid))
										{
											
										}
										else{
											WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='"+storeelementid+"']"));
											
											// seems working after release need to pass click
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release().click(Toid1);
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release().click(Toid1).build().perform();
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release().click(Toid1);
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid).build().perform();
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid);
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid1).build().perform();
											actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
											actions.dragAndDrop(movableelement, Toid).click(Toid).build().perform();
											actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
											actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release().click(Toid1);
											actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid1).release().click(Toid1).build().perform();
											//String movabletotop = movableelement.getLocation();
											actions.dragAndDrop(movableelement, Toid).perform();
											actions.dragAndDrop(movableelement, Toid1).build().perform();
											actions.clickAndHold(movableelement).moveToElement(Toid).release().build().perform();
											actions.dragAndDrop(movableelement, Toid).perform();
											actions.clickAndHold(movableelement).moveToElement(Toid).release(Toid).build().perform();
										
											//actions.dragAndDrop(movableelement, Toid).build().perform();
											actions.clickAndHold(movableelement).release(Toid).build().perform();
										Thread.sleep(3000);
										}
										
									}
								break;
								}catch(Exception ER)
								{
									
								}
	}
	
	
	
			}
		}
		
	}
}
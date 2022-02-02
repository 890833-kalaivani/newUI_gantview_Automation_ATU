package get.next.gen.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.webdriven.commands.GetLocation;

import get.next.gen.commonaction.CommonTest;
import get.next.gen.webtestcase.Web_UI;

public class GateChange extends CommonTest{

	public static void verifyUpdateGateIcon() throws Exception {
		System.out.println("Verify Update gate icon displayed");
		getDriver().findElement(By.xpath("//img[@title='Update Gate']")).isDisplayed();
		System.out.println("Update Gate Icon is displayed");
		Thread.sleep(1000);
		//Perform Sort functionality so that empty gates issue can be avoided
		clickByXpath(Web_UI.SortAscending,"SortAscending");
		Thread.sleep(1000);
		// Select Sort Ascending gate by alphabetical order from dropdown
		clickByXpath(Web_UI.SortAscendinggate,"SortAscendinggate");
		Thread.sleep(1000);
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//img[@title='Update Gate']")).click();
		Thread.sleep(5000);
		/*List<WebElement> findElements = getDriver().findElements(By.xpath("//div[@data-ng-repeat='(key, flt) in ganttObject[gate]']/div[@data-ng-click='getEvents(flt,$event);']"));
		
		
		//for(WebElement movableelement:findElements) {*/
			/*JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].style.backgroundColor = 'red'", findElement);
			Thread.sleep(5000);
			Point P = findElement.getLocation();
			int x = P.getX();
			System.out.println("x vaue is "+x);
			int y = P.getY();
			System.out.println("y value is "+y);
			int xx = x;
			int yy = y+25;*/
			WebElement movableelement = getDriver().findElement(By.xpath("//div[@id='0971-2020-06-16-ORIGINATED']"));
			Actions actions = new Actions(getDriver());
			//action.moveToElement(findElement).build().perform();
			Thread.sleep(1000);
			WebElement Toid1 = getDriver().findElement(By.xpath("//div[@id='A11']"));
			WebElement nextGate1 = getDriver().findElement(By.xpath("(//div[contains(@drop,'handle')])[3]/div/div[2]/div[@data-ng-repeat='(key, flt) in ganttObject[gate]'][last()-1]"));
			WebElement Toid = getDriver().findElement(By.xpath("//div[@id='A11']/div/div[2]"));
			
			actions.moveToElement(movableelement).build().perform();
			actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid).build().perform();
			actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid).build().perform();
			
			//actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid);
			//actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid).build().perform();
			//actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
			//actions.dragAndDrop(movableelement, Toid).click(Toid).build().perform();
			//actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
			//actions.dragAndDrop(movableelement, Toid).click(Toid).perform();
			//actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid);
		//	actions.clickAndHold(movableelement).dragAndDrop(movableelement, Toid).release().click(Toid).build().perform();
			//String movabletotop = movableelement.getLocation();
			//actions.dragAndDrop(movableelement, Toid).perform();
			//actions.dragAndDrop(movableelement, Toid1).build().perform();
		//	actions.clickAndHold(movableelement).moveToElement(Toid).release().build().perform();
		//	actions.dragAndDrop(movableelement, Toid).perform();
		//	actions.clickAndHold(movableelement).moveToElement(Toid).release(Toid).build().perform();
		
			//actions.dragAndDrop(movableelement, Toid).build().perform();
			//actions.clickAndHold(movableelement).release(Toid).build().perform();
			

		
			
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate1).build().perform();
//			action.clickAndHold(findElement).moveToElement(nextGate1).release().build().perform();
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate1).perform();
//			action.dragAndDrop(findElement, nextGate1).build().perform();
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate1).release(nextGate1).build().perform();
//			Thread.sleep(1000);
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate).build().perform();
//			action.clickAndHold(findElement).moveToElement(nextGate).release().build().perform();
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate).perform();
//			action.dragAndDrop(findElement, nextGate).build().perform();
//			action.clickAndHold(findElement).dragAndDrop(findElement, nextGate).release(nextGate).build().perform();
//			//action.clickAndHold(findElement).dragAndDrop(findElement, nextGate).perform();
//			Thread.sleep(3000);
//			//action.dragAndDropBy(findElement, x, yy).release().build().perform();
//			Thread.sleep(1000);

			/*js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
					+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
					+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
					+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
					+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
					+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
					+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
					+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
					+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
					+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
					+ "var dropEvent = createEvent('drop');\n"
					+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
					+ "var dragEndEvent = createEvent('dragend');\n"
					+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
					+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
					+ "simulateHTML5DragAndDrop(source,destination);", findElement, nextGate);*/
			
			
			
		}

	

}

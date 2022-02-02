package get.next.gen.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import get.next.gen.commonaction.CommonTest;

public class SharedGates extends CommonTest {

	public static void scroll() throws Exception {
		clickByXpath("//div[@title='choose font size']/div[1]","fitToScreen");
		Thread.sleep(2000);
		clickByXpath("//div[@title='choose font size']/div[2]","minFontSize");
		Thread.sleep(2000);
		for(int i=1;i<=15;i++) {
			scroll1(i);
			Thread.sleep(2000);
			try {
				if(getDriver().findElements(By.xpath("//span[@class='requested-gate ng-scope']")) != null) {
					Thread.sleep(2000);
					System.out.println("Element found");
					getDriver().findElement(By.xpath("//span[@class='requested-gate ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='close-icn ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='requested-gate ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='close-icn ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='requested-gate ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='close-icn ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//span[@class='requested-gate ng-scope']")).click();
					Thread.sleep(2000);
					getDriver().findElement(By.xpath("//a[@id='airport_activity']")).click();
					Thread.sleep(5000);
					WebElement activityLogFrame = getDriver().findElement(By.xpath("html/body//iframe[contains(@src,'https://get.azne.aa.com/getx/#/activityLog/DFW/GETNG/D7')]"));
					System.out.println("Switching to Activity Log frame");
					getDriver().switchTo().frame(activityLogFrame);
					Thread.sleep(5000);
					System.out.println("switched to frame");
					getDriver().findElement(By.xpath("//textarea[@id='mat-input-3']")).sendKeys("Test123");
					String attribute = getDriver().findElement(By.xpath("//mat-toolbar-row[@class='mat-toolbar-row']")).getAttribute("innerText");
					System.out.println("attribute is"+attribute);
					getDriver().findElement(By.xpath("(//span[@class='mat-button-wrapper'])[1]")).click();
					//textContent
					break;
				}
			}catch(Exception e) {

			}
			
		}
	}

	public static void scroll1 (int i) {
		Actions action = new Actions(getDriver());
		getDriver().findElement(By.xpath("//div[@id='scroll-row']")).click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("clicked"+i);
	}
}

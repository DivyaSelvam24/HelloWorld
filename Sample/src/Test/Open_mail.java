package Test;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Open_mail {

	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String exePath = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.cognizant.com/owa/auth/logon.aspx?replaceCurrent=1&url=https%3a%2f%2fmail.cognizant.com%2fowa%2f");
		
		driver.manage().window().maximize();
	/*
		driver.findElement(By.xpath("//div[@class='dropdown dropdown--login ud-component--header-v6--login-button']//div//button[@type='button'][contains(text(),'Log In')]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'ud-app-loader ud-angular--social-auth--app ud-render-angular-apps--ignore-parents ud-app-loaded')]"));
		*/
		System.out.println("Either Pop Up is displayed or it is Timed Out");
		 
		Thread.sleep(4000);
		
	    //driver.activeElement(driver.findElement(By.className("modal-dialog")));
		driver.findElement(By.name("username")).sendKeys("546363");;
		driver.findElement(By.id("password")).sendKeys("karthika!97");
		driver.findElement(By.className("signinTxt")).click();
		Thread.sleep(4000);
		
		
		//driver.manage().window().maximize();
		
		String FilePath = "D:\\selenium\\source.xlsx";
		
		File myFile = new File(FilePath); 
		FileInputStream fis = new FileInputStream(myFile); // Finds the workbook instance for XLSX file 
		XSSFWorkbook myWorkBook = new XSSFWorkbook (fis); // Return first sheet from the XLSX workbook 
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		
		System.out.println(mySheet.getLastRowNum());
		
		
		Cell cell = mySheet.getRow(0).getCell(0);
		String st = cell.getStringCellValue();
		
		driver.findElement(By.id("q")).sendKeys(st);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);
		
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File("D:\\screenShot.jpg"));
		
		Thread.sleep(1000);
		
		driver.close();
	}
		

}

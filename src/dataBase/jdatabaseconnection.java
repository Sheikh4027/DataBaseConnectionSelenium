package dataBase;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Statement;

public class jdatabaseconnection {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		String host= "localhost";
		String port = "3306";
		String user= "root";
		String password= "Tufail529";

	
	Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qabdt",user,password); //connecting the dB.

	Statement s =(Statement) con.createStatement(); // creating road to table.
	
   ResultSet rs = s.executeQuery("select * from employeeinfo where name = 'Sam'"); // selecting a row and calling it from db.
	
 
   while( rs.next()){

	  //rs.getString("name"));               // this command to call data from table from name column.
		//System.out.println(rs.getString("Password")); // this also call and print in the consol.
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmad\\Downloads\\Documents\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://login.salesforce.com");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(rs.getString("name"));
		driver.findElement(By.cssSelector("input[name='pw'")).sendKeys(rs.getString("Password"));
		driver.findElement(By.cssSelector("input[id='Login']")).click();
	    System.out.println(driver.findElement(By.cssSelector("#error")).getText());
	  File  src=driver.findElement(By.id("main")).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("logingPage.png"));
		
  
	}
	}
}

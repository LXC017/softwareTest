package lab2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class lab2test {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private String id, pwd, github;
	

	//��Ĺ��캯��
	
	public lab2test(String id, String github) {
	this.id = id;
	this.pwd = id.substring(4);
	this.github = github;
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin","G:/software/firefox/firefox.exe");
		driver = new FirefoxDriver();
		// ����Ҫ���Ե���ַ
		baseUrl = "http://121.193.130.195:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//ʹ��@Parametersע�⣬���������ԣ����ڶ�ͬһ������������һ������
	@Parameters
	public static Collection<Object[]> getData() throws IOException {
		//inputgit.csv��117������
		Object[][] obj = new Object[117][];
		CsvReader r = new CsvReader("I:/ѧϰ����/������/�������/inputgit.csv", ',',
				Charset.forName("GBK"));
		int count = 0;
		r.readHeaders();
		//��ȡinputgit.csv��ÿ������
		while (r.readRecord()) {
			obj[count] = new Object[] { r.get("ѧ��"), r.get("github��ַ") };
			count++;
		}
		return Arrays.asList(obj);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl);
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(this.id);
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys(this.pwd);
	    driver.findElement(By.id("submit")).click();
	    assertEquals(this.github, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}

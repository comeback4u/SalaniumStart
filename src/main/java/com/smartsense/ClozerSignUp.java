package com.smartsense;


import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;

import Utill.Constant;
import Utill.ExcelUtils;
import Utill.Log;

public class ClozerSignUp {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	private Mouse mouse;

	@Before
	public void setUp() throws Exception {
//		DOMConfigurator.configure("log4j.xml");
		Log.logSetup();
//		File file = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
//		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability("marionette", true);
//		WebDriver driver = new FirefoxDriver(capabilities);

		System.setProperty("javax.xml.transform.TransformerFactory",
                "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		driver = new ChromeDriver();
		
		mouse = ((HasInputDevices) driver).getMouse();
		baseUrl = "http://dev01.goclozer.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		ExcelUtils.setExcelFile(Constant.FILE_FULL_PATH , Constant.SHEET_NAME);
	}

	@Test
	public void testClozerSignUp1() throws Exception {
		
		//move to Sign Up page
		Log.startTestCase("Clozer Signup Phase 1");
		driver.get(baseUrl + "/");
		Log.info("Open URL");
		Thread.sleep(1000);
		driver.findElement(By.linkText("SIGN UP")).click();
		Log.info("Click on Signup");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Sign up']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("START YOUR FREE TRIAL")).click();
		Thread.sleep(2000);
		
		//fill all the details
		
		
		 
		
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(ExcelUtils.getCellData(1, 1));
		driver.findElement(By.id("card-name")).clear();
		driver.findElement(By.id("card-name")).sendKeys(ExcelUtils.getCellData(1, 2));
		driver.findElement(By.id("card-number")).clear();
		driver.findElement(By.id("card-number")).sendKeys(ExcelUtils.getCellData(1, 3));
		driver.findElement(By.id("card-cvc")).clear();
		driver.findElement(By.id("card-cvc")).sendKeys(ExcelUtils.getCellData(1, 4));
		driver.findElement(By.id("card-year")).clear();
		driver.findElement(By.id("card-year")).sendKeys(ExcelUtils.getCellData(1, 5));
		driver.findElement(By.id("card-month")).clear();
		driver.findElement(By.id("card-month")).sendKeys(ExcelUtils.getCellData(1, 6));
		
		//move to next page
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Log.info("Click on Submit");
		Thread.sleep(1000);
		
		//close popup
		driver.findElement(By.xpath("//div[@id='emailSentModal']/div/div/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		
		assertEquals("Thank you choosing Clozer", driver.getTitle());
		
		ExcelUtils.setCellData("Pass", 1, 7);
		Log.endTestCase();
	}

//	@Test
//	public void testSignUp2() throws Exception {
//
//		// Java Mail API for verify Register Link
//		Properties props = System.getProperties();
//		props.setProperty("mail.store.protocol", "imaps");
//		Session session = Session.getDefaultInstance(props, null);
//		Store store = session.getStore("imaps");
//		store.connect("imap.gmail.com", "rajutheanalyst@gmail.com", "smart@123");//work only on less secure mode ON in mail id
//		Folder folder = store.getFolder("Inbox");
//		folder.open(Folder.READ_WRITE);
//		Message[] messages = null;
//		String link = "";
//
//		// Check mail with Sub. Name
//		for (int i = 0; i < 5; i++) {
//			SearchTerm st = new AndTerm(new SubjectTerm("Clozer | Finish creating your account on Clozer"),
//					new BodyTerm("Click and confirm that you want to create an account on Clozer"));
//			messages = folder.search(st);
//			if (messages.length == 0) {
//
//				Thread.sleep(10000);
//			}
//		}
//
//		// Get mail link for verify
//		for (Message message : messages) {
//			Object content = message.getContent();
//			if (content instanceof Multipart) {
//				Multipart mp = (Multipart) content;
//				for (int i = 0; i < mp.getCount(); i++) {
//					BodyPart bp = mp.getBodyPart(i);
//					if (Pattern.compile(Pattern.quote("text/html"), Pattern.CASE_INSENSITIVE)
//							.matcher(bp.getContentType()).find()) {
//
//						String buffer = (String) bp.getContent();
//						Pattern p = Pattern.compile("href=\"([^\"]*)\"", Pattern.DOTALL);
//						Matcher m = p.matcher(buffer);
//						if (m.find()) {
//							// Get all groups for this match
//							for (int j = 0; j <= m.groupCount(); j++) {
//								String groupStr = m.group(j);
//								link = groupStr;
//							}
//						}
//						break;
//					}
//				}
//			}
//		}
//		// 
//		driver.get(link);// open mail Link
//
//		// filling the all details
//		driver.findElement(By.id("forname")).clear();
//		driver.findElement(By.id("forname")).sendKeys("Karan");
//		driver.findElement(By.id("surname")).clear();
//		driver.findElement(By.id("surname")).sendKeys("Nagrecha");
//		driver.findElement(By.id("skype")).clear();
//		driver.findElement(By.id("skype")).sendKeys("karan_nagrecha");
//		driver.findElement(By.id("mobile")).clear();
//		driver.findElement(By.id("mobile")).sendKeys("4521545455");
//		driver.findElement(By.id("inUrl")).clear();
//		driver.findElement(By.id("inUrl")).sendKeys("https://linkedin.com");
//		driver.findElement(By.id("password_confirmation")).clear();
//		driver.findElement(By.id("password_confirmation")).sendKeys("smart123");
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("password")).sendKeys("smart123");
//		driver.findElement(By.id("title")).click();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//
//		// next page
//		driver.findElement(By.id("name")).clear();
//		driver.findElement(By.id("name")).sendKeys("Karan Corp");
//
//		// select drop down
//		driver.findElement(By.id("countrySelector")).sendKeys("ind");
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("India")).click();
//
//		driver.findElement(By.id("citySelector")).sendKeys("ahmeda");
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Ahmedabad")).click();
//
//		new Select(driver.findElement(By.id("currency"))).selectByVisibleText("INR");
//		driver.findElement(By.id("target")).sendKeys("35,135,153");
//		driver.findElement(By.id("avgDeal")).sendKeys("35,135,135");
//
//		new Select(driver.findElement(By.id("customersCount"))).selectByVisibleText("0-5");
//
//		// next page
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		Thread.sleep(5000);
//
//		// next page
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
//		Thread.sleep(5000);
//
//		// select check box
//		WebElement toggel = driver.findElement(By.cssSelector(
//				"html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.container.MB70 div.row.MT30 div.custom-form div.padding-20 div.row div.col-md-6.col-sm-12.business-city-boxes.text-center div.cities-toggle div.col-md-12.col-sm-12.select-all label.checkbox-inline.toggle-select div.toggle.btn.btn-success"));
//		Locatable toggelLc = (Locatable) toggel;
//		mouse.click(toggelLc.getCoordinates());
//		
//		// select drop down
//		driver.findElement(By.cssSelector("ul.select2-selection__rendered")).click();
//		driver.findElement(By.className("select2-search__field")).sendKeys("ahmed");
//		Thread.sleep(2000);
//		
//		// next page
//		WebElement elem = driver.findElement(By.cssSelector(
//				"html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body span.select2-container.select2-container--default.select2-container--open span.select2-dropdown.select2-dropdown--below span.select2-results ul#select2-auto_load_cities-results.select2-results__options li.select2-results__option.select2-results__option--highlighted"));
//		Locatable locat = (Locatable) elem;
//		mouse.click(locat.getCoordinates());
//
//		WebElement btn = driver.findElement(By.cssSelector(
//				"html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body div.container.MB70 div.row.MT30 div.custom-form div.padding-20 div.row div.col-md-12.col-sm-12 div.col-md-12.col-sm-12 input.btn.btn-add.pull-right"));
//		Locatable locatbtn = (Locatable) btn;
//		mouse.click(locatbtn.getCoordinates());
//		Thread.sleep(5000);
//
//		// check box select
//		WebElement ch1 = driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[1]/div[1]/input"));
//		Locatable locatch1 = (Locatable) ch1;
//		mouse.click(locatch1.getCoordinates());
//		WebElement ch2 = driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[1]/div[2]/input"));
//		Locatable locatch2 = (Locatable) ch2;
//		mouse.click(locatch2.getCoordinates());
//		WebElement ch3 = driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[1]/div[3]/input"));
//		Locatable locatch3 = (Locatable) ch3;
//		mouse.click(locatch3.getCoordinates());
//		WebElement ch4 = driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[1]/div[4]/input"));
//		Locatable locatch4 = (Locatable) ch4;
//		mouse.click(locatch4.getCoordinates());
//		WebElement rb1 = driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[2]/div/div/div[1]/label"));
//		Locatable locatrb1 = (Locatable) rb1;
//		mouse.click(locatrb1.getCoordinates());
//
//		// next page
//		driver.findElement(By.xpath("//html/body/div[4]/div/div/form/div[3]/button")).click();
//		Thread.sleep(5000);
//
//		// next page
//		driver.findElement(By.className("MT3")).click();
//		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[2]/div/div/input[2]")).click();
//		Thread.sleep(5000);
//		
//		try {
//			assertEquals("Hire | Clozer", driver.getTitle());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}
//
	@After
	public void tearDown() throws Exception {
		driver.close();
		
	}
}

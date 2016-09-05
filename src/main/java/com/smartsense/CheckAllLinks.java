package com.smartsense;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utill.Utils;

public class CheckAllLinks {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver ff = new ChromeDriver();
		ff.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

		// ff.get("http://www.yahoo.com/");

		List<WebElement> allImages = Utils.findAllLinks(ff);

		System.out.println("Total number of elements found " + allImages.size());

		for (WebElement element : allImages) {

			try

			{

				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ Utils.isLinkBroken(new URL(element.getAttribute("href"))));

				// System.out.println("URL: " +
				// element.getAttribute("outerhtml")+ " returned " +
				// isLinkBroken(new URL(element.getAttribute("href"))));

			}

			catch (Exception exp)

			{

				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());

			}

		}

	}

}

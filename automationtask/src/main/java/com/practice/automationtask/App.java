package com.practice.automationtask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
	static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        
        
        driver.get("https://unicreds.com/contact-us");
        driver.manage().window().maximize();
        System.out.print("Full Name:");
        String name = scanner.nextLine();
        driver.findElement(By.id("fullname")).sendKeys(name);
        System.out.print("Email:");
        String email = scanner.nextLine();
        driver.findElement(By.name("email")).sendKeys(email);
        WebElement country =  driver.findElement(By.xpath("//*[@id='__next']/div[2]/section/div/div[2]/div[2]/div[2]/div/form/select"));
        Select obj = new Select(country);
        obj.selectByValue("1");
        System.out.print("Phone:");
        Long p = scanner.nextLong();
        String phone = p.toString();
        driver.findElement(By.name("phone")).sendKeys(phone);
        scanner.nextLine();
        System.out.print("Message:");
        String message = scanner.nextLine();
        driver.findElement(By.name("message")).sendKeys(message);
        driver.findElement(By.id("contactButton")).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        String msg1 = "Message sent successfully!";
        String msg2 = driver.findElement(By.id("formMessage")).getText();
        if (msg1.equals(msg2)){
        	System.out.println("form submitted successfully");
        } else {
        	System.out.println("OOpss!!");
        }
        driver.close();
        driver.quit();

    }
}

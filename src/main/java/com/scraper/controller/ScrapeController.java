package com.scraper.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scrape")
public class ScrapeController {

    @GetMapping
    public String scrapePage(@RequestParam String url) {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        String pageSource = driver.getPageSource();
        driver.quit();
        return pageSource;
    }
}

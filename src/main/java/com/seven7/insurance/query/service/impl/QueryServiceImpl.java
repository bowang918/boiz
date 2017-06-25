/**
 * 
 */
package com.seven7.insurance.query.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.seven7.insurance.query.dto.ImageDTO;
import com.seven7.insurance.query.service.QueryService;

/**
 * @author Seven7
 *
 */
@Service
@Scope(scopeName="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class QueryServiceImpl implements QueryService {

	@Value("#{systemProperties['webdriver.chrome.driver']}")
	private String driverPath;

	private ChromeDriverService service;
	private WebDriver driver;

	@PostConstruct
	private void init() {
		try {
			createAndStartService();
			createDriver();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File(driverPath)).usingAnyFreePort()
				.build();
		service.start();
	}

	private void createAndStopService() {
		service.stop();
	}

	private void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	private void quitDriver() {
		driver.quit();
	}

	@Override
	public ImageDTO openLoginPage() {

		driver.get("https://icorepnbs.pingan.com.cn/icore_pnbs/");
		driver.findElement(By.id("j_username")).sendKeys("SHWFQX-00001");
		driver.findElement(By.id("j_password")).sendKeys("3GN2wNJ5");

		return ImageDTO.from(driver.findElement(By.id("validateCodeImg")));
	}

	@Override
	public void login(String code) {
		// TODO Auto-generated method stub
	}

}

/**
 * 
 */
package com.seven7.insurance.query.dto;

import java.io.Serializable;

import org.openqa.selenium.WebElement;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Seven7
 *
 */
@Getter
@Setter
public class ImageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4156441612393393047L;

	private String src;

	private String width;

	private String height;

	public static ImageDTO from(WebElement image) {
		ImageDTO code = new ImageDTO();

		code.setSrc(image.getAttribute("src"));
		code.setHeight(image.getAttribute("height"));
		code.setWidth(image.getAttribute("width"));

		return code;
	}

}

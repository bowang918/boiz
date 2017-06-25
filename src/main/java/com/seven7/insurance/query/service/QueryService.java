/**
 * 
 */
package com.seven7.insurance.query.service;

import com.seven7.insurance.query.dto.ImageDTO;

/**
 * @author Seven7
 *
 */
public interface QueryService {

	/**
	 * 
	 * @return
	 */
	public ImageDTO openLoginPage();

	/**
	 * 
	 * @param code
	 */
	public void login(String code);

}

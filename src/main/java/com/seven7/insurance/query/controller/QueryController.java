/**
 * 
 */
package com.seven7.insurance.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.seven7.insurance.query.dto.ImageDTO;
import com.seven7.insurance.query.service.QueryService;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;

/**
 * @author Seven7
 *
 */
@Controller
public class QueryController {
	
	@Autowired
	private QueryService queryService;
	
	public String login(){
		return "";
	}
	
	@ExtDirectMethod
	public ImageDTO startQuery(){
		return queryService.openLoginPage();
	}
	

}

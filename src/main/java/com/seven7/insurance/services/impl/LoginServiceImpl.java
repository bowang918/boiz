/**
 *
 */
package com.seven7.insurance.services.impl;

import com.seven7.insurance.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FANFAN
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static String LOGIN_PAGIN = "/extranet_login.jsp";

    private static String LOGIN_URL = "/verifyIdentifyingCodeAndLogin";

    private static String userName = "SHWFQX-00001";

    private static String password = "3GN2wNJ5";

    private static String fieldUserName = "j_username";

    private static String fieldPassword = "j_password";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void login() {
        RestTemplateBuilder builder = new RestTemplateBuilder();

        builder.rootUri("https://icorepnbs.pingan.com.cn/icore_pnbs/");

        Map<String, String> params = new HashMap<>();

        restTemplate.postForLocation(LOGIN_PAGIN, params);
    }

}

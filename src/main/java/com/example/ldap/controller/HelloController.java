package com.example.ldap.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/auth")
	public String check() {

		return "LDAP Working with remote LDAP server";
	}
	
    @GetMapping("/data")
    public String index() {

        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)
                        SecurityContextHolder.getContext().getAuthentication();

        LdapUserDetailsImpl principal = (LdapUserDetailsImpl) authentication.getPrincipal();

        System.out.println("authentication: " + authentication);
        System.out.println("principal: " + principal);
        return principal.getUsername();
    }
}

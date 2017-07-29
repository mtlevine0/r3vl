package io.dailydev.r3vl.api.service;

public interface SecurityService {
	String findLoggedInUsername();
	void autologin(String username, String password);
}

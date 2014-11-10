package com.drgeb.login.client.vw;

import javafx.stage.Stage;

import org.springframework.security.authentication.AuthenticationManager;

public interface ScreensConfig {
	void setStage(Stage stage);
	Stage getStage();
	void setAuthenticationManager(AuthenticationManager authenticationManager);
}

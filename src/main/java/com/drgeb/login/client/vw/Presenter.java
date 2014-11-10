package com.drgeb.login.client.vw;

import org.springframework.security.authentication.AuthenticationManager;

import com.drgeb.login.client.ScreensConfiguration;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public interface Presenter extends Initializable {
	void setStage(Stage stage);
	Stage getStage();
	void setScreenConfiguation(ScreensConfiguration screens);
	void setAuthenticationManager(AuthenticationManager authenticationManager);

}

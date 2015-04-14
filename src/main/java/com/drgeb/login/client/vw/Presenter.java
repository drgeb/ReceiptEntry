package com.drgeb.login.client.vw;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import org.springframework.security.authentication.AuthenticationManager;

import com.drgeb.login.client.spring.ScreensConfiguration;

public interface Presenter extends Initializable,ScreensConfig {

	void setScreenConfiguation(ScreensConfiguration screens);
}

package com.drgeb.login.client.vw;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.springframework.security.authentication.AuthenticationManager;

import com.drgeb.login.client.spring.ScreensConfiguration;

public class PresenterImpl implements Presenter {
	@FXML
	private Pane root;
	
	protected ScreensConfiguration screens;
	protected AuthenticationManager authenticationManager;
	protected Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setScreenConfiguation(ScreensConfiguration screens) {
		this.screens = screens;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Stage stage = (Stage) root.getScene().getWindow();
	}

	@Override
	public Stage getStage() {
		return this.stage;
	}
}

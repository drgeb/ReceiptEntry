/*
 * Copyright (c) 2012, Stephen Chin
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL STEPHEN CHIN OR ORACLE CORPORATION BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.drgeb.login.client;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.airhacks.afterburner.injection.Injector;
import com.airhacks.afterburner.views.FXMLView;
import com.drgeb.login.client.vw.Presenter;
import com.drgeb.login.client.vw.addcustomer.AddCustomerView;
import com.drgeb.login.client.vw.error.ErrorView;
import com.drgeb.login.client.vw.login.LoginView;
import com.drgeb.receiptentry.roles.Role;
import com.drgeb.receiptentry.roles.RoleManager;
import com.drgeb.receiptentry.vw.receipttable.ReceiptTableView;

@Configuration
@Lazy
public class ScreensConfiguration {
	private Stage primaryStage;

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	private RoleManager roleManager = new RoleManager();
	private Logger logger = LoggerFactory.getLogger(ScreensConfiguration.class);
	
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void showScreen(Parent screen) {
		primaryStage.setScene(new Scene(screen, 777, 500));
		primaryStage.show();
	}

	private void showDialog(FXMLView view) {
		Scene scene = new Scene(view.getView());
		Presenter presenter = (Presenter) view.getPresenter();
		//Initialization should be Autowired in!!
		presenter.setStage(primaryStage);
		presenter.setScreenConfiguation(this);
		presenter.setAuthenticationManager(authenticationManager);
		// final String uri =
		// getClass().getResource("login.css").toExternalForm();
		// scene.getStylesheets().add(uri);

		primaryStage.setScene(scene);

		// center stage on screen
		primaryStage.centerOnScreen();

		EventType<WindowEvent> eventType = WindowEvent.WINDOW_CLOSE_REQUEST;
		primaryStage.addEventHandler(eventType, (WindowEvent t) -> {
			;
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void errorDialog() {
		ErrorView errorView = new ErrorView();
		showDialog(errorView);
	}

	public void customerDialog() {
		AddCustomerView addCustomerView = new AddCustomerView();
		showDialog(addCustomerView);
	}

	@Bean
	public LoginView getLoginView() {
		LoginView loginView = new LoginView();
		return loginView;
	}

	public void loginDialog() {
		LoginView loginView = getLoginView();
		showDialog(loginView);
	}

	public void receiptEntryDialog() {
		// TODO Auto-generated method stub
		logger.info("Starting Application");
		// List<String> parameters = this.getParameters().getRaw();
		// String [] args= parameters.toArray(new String[parameters.size()]);

		// Manually set the Role of a User
		// Ones Users are added to application we can change this to be set from
		// the users profile.
		final ObservableList<Role> activeRoles = FXCollections
				.observableArrayList();
		activeRoles.add(Role.Viewer);
		roleManager.setActiveRoles(activeRoles);

		Map<Object, Object> customProperties = new HashMap<>();
		customProperties.put("roleManager", roleManager);
		/*
		 * any function which accepts an Object as key and returns and return an
		 * Object as result can be used as source.
		 */
		Injector.setConfigurationSource(customProperties::get);

		ReceiptTableView appView = new ReceiptTableView();
		Scene scene = new Scene(appView.getView());
		primaryStage.setTitle("GINGERLICEUOS RECEIPT ENTRY");
		//final String uri = getClass().getResource("app.css").toExternalForm();
		//scene.getStylesheets().add(uri);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
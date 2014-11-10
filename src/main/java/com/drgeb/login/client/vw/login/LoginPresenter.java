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

package com.drgeb.login.client.vw.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.drgeb.login.client.vw.PresenterImpl;

public class LoginPresenter extends PresenterImpl {
	@FXML
	Label header;
	@FXML
	TextField username;
	@FXML
	TextField password;
	private Stage stage;

	private Logger logger= LoggerFactory.getLogger(LoginPresenter.class);
	
	@FXML
	public void login() {
		Authentication authToken = new UsernamePasswordAuthenticationToken(
				username.getText(), password.getText());
		try {
			authToken = authenticationManager.authenticate(authToken);
			SecurityContextHolder.getContext().setAuthentication(authToken);
		} catch (AuthenticationException e) {
			header.setText("Login failure, please try again:");
			header.setTextFill(Color.DARKRED);
			return;
		}
		getStage().close();
		screens.receiptTableDialog();
	}

	@FXML
	public void employee() {
		username.setText("employee");
		password.setText("lol");
	}

	@FXML
	public void manager() {
		username.setText("manager");
		password.setText("password");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("LoginPresenter initialized.");
	}
}

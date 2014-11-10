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

package com.drgeb.receiptentry;

import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.airhacks.afterburner.injection.Injector;
import com.drgeb.login.client.CustomerAppConfiguration;
import com.drgeb.login.client.ScreensConfiguration;

@SuppressWarnings("restriction")
public class ReceiptEntryApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	private ApplicationContext applicationContext;

	public void start(Stage stage) throws Exception {
		applicationContext = new AnnotationConfigApplicationContext(
				CustomerAppConfiguration.class);
		ScreensConfiguration screens = applicationContext
				.getBean(ScreensConfiguration.class);
		printBeans();
		screens.setStage(stage);
		screens.loginDialog();
	}

	public void printBeans() {
		String[] list = applicationContext.getBeanDefinitionNames();
		for (String item : list) {
			System.out.println(item);
		}
	}

	public void stop() throws Exception {
		Injector.forgetAll();
	}

}
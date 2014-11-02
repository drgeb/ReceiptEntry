package com.drgeb.receiptentry;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.airhacks.afterburner.injection.Injector;
import com.drgeb.receiptentry.roles.Role;
import com.drgeb.receiptentry.roles.RoleManager;
import com.drgeb.receiptentry.vw.receipttable.ReceiptTableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.airhacks.afterburner.injection.Injector;

public class App extends Application {

    private static Logger logger = LogManager.getLogger(App.class);
    private RoleManager roleManager = new RoleManager();

    @Override
    public void start(Stage stage) throws Exception {
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
         * any function which accepts an Object as key and returns
         * and return an Object as result can be used as source.
         */
        Injector.setConfigurationSource(customProperties::get);
        
	ReceiptTableView appView = new ReceiptTableView();
	Scene scene = new Scene(appView.getView());
	stage.setTitle("GINGERLICEUOS RECEIPT ENTRY");
	final String uri = getClass().getResource("app.css").toExternalForm();
	scene.getStylesheets().add(uri);
	stage.setScene(scene);
	stage.show();
    }

    @Override
    public void stop() throws Exception {
	Injector.forgetAll();
    }

    public static void main(String[] args) {
	launch(args);
    }
}

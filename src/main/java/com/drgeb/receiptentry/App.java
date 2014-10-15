package com.drgeb.receiptentry;

import java.util.List;

import com.airhacks.afterburner.injection.Injector;
import com.drgeb.receiptentry.vw.receipttable.Receipttable;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author adam-bien.com
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	List<String> parameters = this.getParameters().getRaw();
    	String [] args= (String[]) parameters.toArray(new String[parameters.size()]);
    	
    	Receipttable appView = new Receipttable();
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

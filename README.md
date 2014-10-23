ReceiptEntry
==============

ReceiptEntry is a JavaFX application that I created for my friend Kenneth Blum and Rosa so they can use this for their Ginger corporation to keep track of their receipts.

Goal: To develop an FXML architecture where one has "Less Code, Increased Productivity"

Design:
Example JavaFX application using the AfterBurner FX architecture of Adam Bien.
"Afterburner is a "Just-Enough-Framework" following design principles Convetion over Configuration.
As a result the code structure is such that the presentaion layer for each Stage is contained in a package.
The presentation layer code is therefore in one directory containing one fxml file, a css file, a presenter class and one FXML View class.
The naming convention that must be followed is as follows:

Name of package or folder must be in lowercase.
Name of css file is: <package_name>.css
Name of FXML file is: <package_name>.fxml
Name of View Class file is: <package_name>.java
Name of Presenter Class file is: <package_name>Presenter.java

For example: 
	


Jumpstart with:

```shell
mvn clean package -DskipTests
java -jar 
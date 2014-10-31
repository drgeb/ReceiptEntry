package com.drgeb.receiptentry.roles;

import javafx.fxml.FXML;
import javafx.scene.Node;

public class RoleController {

    @FXML
    private Node root;

    private RoleManager roleManager;

    public RoleController(RoleManager roleManager) {
	this.roleManager = roleManager;
    }

    @FXML
    public void initialize() {
	roleManager.assignRolesToNodeTree(root);
    }
}

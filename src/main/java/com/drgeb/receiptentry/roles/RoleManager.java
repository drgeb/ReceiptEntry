package com.drgeb.receiptentry.roles;

import javafx.collections.*;
import javafx.scene.*;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.App;

public class RoleManager {
    private final Map<Node, List<Role>> nodeRoles = new HashMap<>();
    private ObservableList<Role> activeRoles;
    private static Logger logger = LogManager.getLogger(RoleManager.class);
    
    public final ListChangeListener<Role> ACTIVE_ROLE_LISTENER = new ListChangeListener<Role>() {
	@Override
	public void onChanged(Change<? extends Role> c) {
	    showActiveNodes();
	}
    };

    public void setActiveRoles(ObservableList<Role> activeRoles) {
	if (this.activeRoles != null) {
	    this.activeRoles.removeListener(ACTIVE_ROLE_LISTENER);
	}
	this.activeRoles = activeRoles;
	this.activeRoles.addListener(ACTIVE_ROLE_LISTENER);
    }
    
    public ObservableList<Role> getActiveRoles() {
	return this.activeRoles;
    }

    public void showActiveNodes() {
	for (Node node : nodeRoles.keySet()) {
	    logger.debug("for node: " + node + " isActive(node)= "
		    + isActive(node));
	    node.setVisible(isActive(node));
	}
    }

    public void assignRole(Node node, Role... roles) {
	if (roles.length == 0) {
	    nodeRoles.remove(node);
	    return;
	}

	nodeRoles.put(node, Arrays.asList(roles));
    }

    private boolean isActive(Node node) {
	if (activeRoles == null) {
	    return false;
	}

	for (Role role : nodeRoles.get(node)) {
	    if (activeRoles.contains(role)) {
		return true;
	    }
	}

	return false;
    }

    public void assignRolesToNodeTree(Node node) {
	Object userData = node.getUserData();
	if (userData instanceof ObservableList) {
	    List<Role> roles = new ArrayList<>();
	    for (Object object : (ObservableList) userData) {
		if (object instanceof Role) {
		    logger.info("Adding Role: " + object.toString()
			    + " to Node: " + node.toString());
		    roles.add((Role) object);
		}
	    }

	    Role[] roleArray = new Role[roles.size()];
	    int i = 0;
	    for (Role role : roles) {
		roleArray[i++] = role;
	    }
	    assignRole(node, roleArray);
	}

	if (node instanceof Parent) {
	    Parent parent = (Parent) node;
	    for (Node child : parent.getChildrenUnmodifiable()) {
		assignRolesToNodeTree(child);
	    }
	}
    }

    public void remove(Role role) {
	// TODO Auto-generated method stub
	if (activeRoles.contains(role)) {
	    activeRoles.remove(role);
	}
	this.showActiveNodes();
    }

    public void add(Role role) {
	// TODO Auto-generated method stub
	if (!activeRoles.contains(role)) {
	    activeRoles.add(role);
	}
	this.showActiveNodes();
    }
}

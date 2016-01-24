package com.anrisoftware.geophylo.client.geolayout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

import com.anrisoftware.geophylo.GeoLayout;
import com.google.gwt.user.client.ui.Label;

@Connect(GeoLayout.class)
public class GeoLayoutConnector extends AbstractComponentConnector {

	
	public GeoLayoutConnector() {

	}

	@Override
	protected Widget createWidget() {
		return GWT.create(Label.class);
	}

	@Override
	public Label getWidget() {
		return (Label) super.getWidget();
	}


}


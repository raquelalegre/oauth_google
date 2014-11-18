package uk.ac.rdg.client;

import uk.ac.rdg.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Oauth_google implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button loginButton = new Button("Log In");
		
		// We can add style names to widgets
		loginButton.addStyleName("loginButton");

		// Add sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element		
		RootPanel.get("loginButtonContainer").add(loginButton);
		
		// Create a handler for the sendButton 
		class MyHandler implements ClickHandler {
			/**
			 * Fired when the user clicks on the login button.
			 */
			public void onClick(ClickEvent event) {
				authenticate();
			}

			private void authenticate() {
				
				
			}
		}

		// Add a handler to log in the server
		MyHandler handler = new MyHandler();
		loginButton.addClickHandler(handler);
	}
}

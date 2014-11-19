package uk.ac.rdg.client;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Oauth_google implements EntryPoint {
	
	  private static final String GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth";

	  // This app's personal client ID assigned by the Google APIs Console
	  // (c).
	  private static final String GOOGLE_CLIENT_ID = "969364722198-4sht8vros6g21is42hcbmna741f6g5d5.apps.googleusercontent.com";
	  private static final String CHARME_NODE_CLIENT_ID = "8f14a39990bea5da8742";

	  // The auth scope being requested. This scope will allow the application to
	  // identify who the authenticated user is.
	  private static final String PLUS_ME_SCOPE = "https://www.googleapis.com/auth/plus.me";
	  
	// Use the implementation of Auth intended to be used in the GWT client app.
	  private static final Auth AUTH = Auth.get();

	
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
		        final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL, GOOGLE_CLIENT_ID)
	            .withScopes(PLUS_ME_SCOPE);

	        // Calling login() will display a popup to the user the first time it is
	        // called. Once the user has granted access to the application,
	        // subsequent calls to login() will not display the popup, and will
	        // immediately result in the callback being given the token to use.
	        AUTH.login(req, new Callback<String, Throwable>() {
	          @Override
	          public void onSuccess(String token) {
	            Window.alert("Got an OAuth token:\n" + token + "\n"
	                + "Token expires in " + AUTH.expiresIn(req) + " ms\n");
	          }

	          @Override
	          public void onFailure(Throwable caught) {
	            Window.alert("Error:\n" + caught.getMessage());
	          }
	        });
	      }				
				
			}

		// Add a handler to log in the server
		MyHandler handler = new MyHandler();
		loginButton.addClickHandler(handler);
	}
}

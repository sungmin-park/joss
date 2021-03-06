package org.javaswift.joss.command.impl.factory;

import org.apache.http.client.HttpClient;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.command.impl.identity.BasicAuthenticationCommandImpl;
import org.javaswift.joss.command.impl.identity.KeystoneAuthenticationCommandImpl;
import org.javaswift.joss.command.shared.factory.AuthenticationCommandFactory;
import org.javaswift.joss.command.shared.identity.AuthenticationCommand;

import static org.javaswift.joss.client.factory.AuthenticationMethod.*;

public class AuthenticationCommandFactoryImpl implements AuthenticationCommandFactory {

    @Override
    public AuthenticationCommand createAuthenticationCommand(HttpClient httpClient, AuthenticationMethod authenticationMethod,
                                                             String url, String tenantName, String tenantId,
                                                             String username, String password) {
        switch (authenticationMethod) {
            case BASIC :
                return new BasicAuthenticationCommandImpl(httpClient, url, username, password);
            case KEYSTONE:
            default:
                return new KeystoneAuthenticationCommandImpl(httpClient, url, tenantName, tenantId, username, password);
        }
    }

}

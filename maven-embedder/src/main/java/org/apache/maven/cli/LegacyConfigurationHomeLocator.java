package org.apache.maven.cli;

import java.io.File;
import java.io.IOException;

/**
 * Implements legacy behavior for getting user's configuration home (.m2) directory.
 * @author Petr Kozelka
 */
public class LegacyConfigurationHomeLocator implements ConfigurationHomeLocator {
    public static final String USER_HOME = System.getProperty( "user.home" );
    public static final File USER_MAVEN_CONFIGURATION_HOME = new File(USER_HOME, ".m2" );

    public File locate(File initialDirectory) throws IOException {
        return USER_MAVEN_CONFIGURATION_HOME;
    }
}

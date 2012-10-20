package org.apache.maven.cli;

import java.io.File;
import java.io.IOException;

/**
 * @author Petr Kozelka
 */
public class DefaultConfigurationHomeLocator implements ConfigurationHomeLocator {
    public static final String USER_HOME = System.getProperty( "user.home" );
    public static final File USER_MAVEN_CONFIGURATION_HOME = new File(USER_HOME, ".m2" );

    /**
     * Locates nearest configuration home ( = <code>.m2</code> ) towards the user.home directory.
     *
     * @param initialDirectory the directory starting the search; this one is actually never returned
     * @return nearest configuration home above initialDirectory, or {@link #USER_MAVEN_CONFIGURATION_HOME} if none found
     */
    public File locate(File initialDirectory) throws IOException {
        final File userHome = new File(USER_HOME).getCanonicalFile();
        File dir = initialDirectory.getCanonicalFile();
        while (dir != null) {
            if (dir.equals(userHome)) {
                // we reached ${user.home}/.m2 - no matter if it exists, we will use it
                break;
            }
            dir = dir.getParentFile();
            final File m2dir = new File(dir, ".m2");
            if (!m2dir.isDirectory()) {
                continue;
            }
            return m2dir;
        }
        return USER_MAVEN_CONFIGURATION_HOME;
    }
}

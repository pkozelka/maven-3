package org.apache.maven.cli;

import java.io.File;
import java.io.IOException;

/**
 * @author Petr Kozelka
 */
public interface ConfigurationHomeLocator {
    File locate(File initialDirectory) throws IOException;
}

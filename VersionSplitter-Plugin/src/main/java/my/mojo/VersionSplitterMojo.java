package my.mojo;

import java.util.Optional;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "VersionSplitter", defaultPhase = LifecyclePhase.INITIALIZE, requiresProject = true)
public class VersionSplitterMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        splitVersion(project.getProperties());
    }

    /* package private for testing */
    void splitVersion(Properties projectProperties) throws MojoExecutionException {
    }
}

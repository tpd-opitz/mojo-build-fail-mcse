package my.mojo;

import java.io.File;
import java.util.Optional;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "FileSize", defaultPhase = LifecyclePhase.PREPARE_PACKAGE, requiresProject = true)
public class FileSizeMojo extends AbstractMojo {

    @Parameter(readonly = true, required = true)
    private File targetFile;

    @Parameter(defaultValue = "file.size", readonly = true, required = false)
    private String destPropertyName;

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        findFileSize(project.getProperties(), targetFile, destPropertyName);
    }

    void findFileSize(Properties properties, File targetFile, String destPropertyName) throws MojoExecutionException {
        Optional.ofNullable(targetFile).orElseThrow(() -> new MojoExecutionException("target.file is required"));
        if (targetFile.exists()) {
            properties.setProperty(destPropertyName, String.valueOf(targetFile.length()));
        } else {
            throw new MojoExecutionException(String.format("file %s does not exist", targetFile.toString()));
        }
    }
}

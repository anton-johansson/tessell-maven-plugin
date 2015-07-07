package org.tessell.maven;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.tessell.generators.Generator;

/**
 * Maven Mojo for generating Tessell sources.
 *
 * @author Anton Johansson
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class GenerateMojo extends AbstractMojo {

  @Parameter(defaultValue = "src/main/", required = true)
  private File inputDirectory;

  @Parameter(defaultValue = "target/generated-sources/tessell/", required = true)
  private File outputDirectory;

  @Parameter
  private String viewsPackageName;

  @Parameter
  private String resourcesPackageName;

  @Parameter
  private String[] additionalViewgenFiles = new String[0];

  @Component
  private MavenProject project;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    project.addCompileSourceRoot(outputDirectory.getAbsolutePath());
    try {
      Generator generator = new Generator(inputDirectory, outputDirectory);
      generator.setViewsPackageName(viewsPackageName);
      generator.setResourcesPackageName(resourcesPackageName);
      generator.setAdditionalViewgenFiles(additionalViewgenFiles);
      generator.generate();
    } catch (Exception e) {
      throw new MojoExecutionException("Could not generate tessell sources", e);
    }
  }
}

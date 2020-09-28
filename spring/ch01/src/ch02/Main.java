package ch02;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MavenBuildRunner buildRunner = new MavenBuildRunner();
		buildRunner.setMavenPath("c:\\temp");
		
		Project sampleProject = new Project();
		List<String> srcDirs = new ArrayList<String>();
		srcDirs.add("src");
		srcDirs.add("srcResources");
		sampleProject.setSrcDirs(srcDirs);
		sampleProject.setBinDir("bin");
		sampleProject.setBuildRunner(buildRunner);

		sampleProject.build();
	}
}

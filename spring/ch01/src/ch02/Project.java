package ch02;

import java.util.List;

public class Project {
	private List<String> srcDirs;
	private String binDir;
	private BuildRunner buildRunner;

	public void setBinDir(String binDir) {
		this.binDir = binDir;
	}

	public void setSrcDirs(List<String> srcDirs) {
		this.srcDirs = srcDirs;
	}

	public void setBuildRunner(BuildRunner buildRunner) {
		this.buildRunner = buildRunner;
	}

	public void build() {
		buildRunner.build(srcDirs, binDir);
	}


}

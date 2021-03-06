package com.dubture.composer.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.IBuildpathContainer;
import org.eclipse.dltk.core.IBuildpathEntry;
import org.eclipse.dltk.core.IScriptProject;


/**
 * 
 * Composer buildpath container is responsible for resolving packages from a project in
 * the local bundle storage.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class ComposerBuildpathContainer implements IBuildpathContainer {

    private IScriptProject project;
    private IPath path;

    public ComposerBuildpathContainer(IPath path, IScriptProject project)
    {
        this.path = path;
        this.project = project;
    }

    @Override
    public IPath getPath()
    {
        return path;
    }
    
    @Override
    public int getKind()
    {
        return IBuildpathContainer.K_SYSTEM;
    }
    
    @Override
    public String getDescription()
    {
        if (path.segmentCount() == 1) {
            return "Composer";
        }
        return path.lastSegment();
    }
    
    @Override
    public IBuildpathEntry[] getBuildpathEntries()
    {
        PackageManager manager = ModelAccess.getInstance().getPackageManager();
        
        if (project == null) {
            return new IBuildpathEntry[0];    
        }
            
        List<InstalledPackage> packages = manager.getInstalledPackages(project);
        
        if (packages == null) {
            return new IBuildpathEntry[0];
        }
        
        List<IBuildpathEntry> entries = new ArrayList<IBuildpathEntry>();
        for (InstalledPackage pack : packages) {
            
//            Logger.debug("composer buildpathcontainer adding " + pack.getBuildpathEntry().getPath().toString() + " to buildpath entries");
            entries.add(pack.getBuildpathEntry());
        }
        
        return entries.toArray(new IBuildpathEntry[entries.size()]);
    }
}
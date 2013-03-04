package com.dubture.composer.ui.editor.composer;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.dubture.composer.ui.editor.ComposerFormPage;
import com.dubture.composer.ui.editor.ComposerSection;
import com.dubture.composer.ui.parts.composer.DependencySearch;

public class DependencySearchSection extends ComposerSection {

	public DependencySearchSection(ComposerFormPage page, Composite parent) {
		super(page, parent, Section.DESCRIPTION);
		createClient(getSection(), page.getManagedForm().getToolkit());
	}

	@Override
	protected void createClient(Section section, FormToolkit toolkit) {
		section.setText("Packagist Search");
		section.setDescription("Search for packages and add the selected packages to the opened section on the left.");
		section.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		DependencySearch dependencySearch = new DependencySearch(section, composerPackage, toolkit, "Add Dependencies");
		
		section.setClient(dependencySearch.getBody());
	}
}

package com.example.application.views.employmentwizard;

import com.example.application.views.employmentwizard.experienceform.ExperienceFormView;
import com.example.application.views.employmentwizard.personform.PersonFormView;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import javax.annotation.security.PermitAll;

@RoutePrefix("employment-wizard")
@ParentLayout(MainView.class)
@Route(value = "start-employment", layout = MainView.class)
@PermitAll
public class EmploymentWizardView extends VerticalLayout implements RouterLayout {

    public EmploymentWizardView() {
        add(new H3("This is the Employment Wizard!"));

        add(new H5("Make sure you are ready to start the process, and then click Start!"));

        HorizontalLayout steps = new HorizontalLayout(
            new Button("Person Info", e -> {
                e.getSource().getUI().ifPresent(ui ->
                        ui.navigate(PersonFormView.class));
            }),
            new Button("Experience Info", e -> {
                e.getSource().getUI().ifPresent(ui ->
                    ui.navigate(ExperienceFormView.class));
            })
        );
        add(steps);
    }
}

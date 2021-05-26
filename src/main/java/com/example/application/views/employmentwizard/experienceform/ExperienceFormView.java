package com.example.application.views.employmentwizard.experienceform;

import com.example.application.views.employmentwizard.EmploymentWizardView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import javax.annotation.security.PermitAll;

@Route(value = "experience-step", layout = EmploymentWizardView.class)
@PageTitle("Experience Form")
@AnonymousAllowed
public class ExperienceFormView extends Div {

    private TextField position = new TextField("Position");
    private DatePicker startDate = new DatePicker("Start Date");
    private DatePicker endDate = new DatePicker("End Date");
    private TextArea responsibilities = new TextArea("Responsibilities");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    public ExperienceFormView() {
        addClassName("experience-form-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());
    }

    private Component createTitle() {
        return new H3("Experience information");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(position, startDate, endDate, responsibilities);
        formLayout.setColspan(position, 2);
        formLayout.setColspan(responsibilities, 2);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
}

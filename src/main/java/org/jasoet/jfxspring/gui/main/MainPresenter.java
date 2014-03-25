package org.jasoet.jfxspring.gui.main;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.jasoet.jfxspring.gui.detail.ContactDetailPresenter;
import org.jasoet.jfxspring.gui.search.ContactSearchPresenter;

import javax.inject.Inject;

public class MainPresenter {
    @FXML
    private Parent root;
    @FXML
    private BorderPane contentArea;

    @Inject
    private ContactSearchPresenter contactSearchPresenter;
    @Inject
    private ContactDetailPresenter contactDetailPresenter;

    public Parent getView() {
        return root;
    }

    public void showSearchContacts() {
        contactSearchPresenter.search(null);
        contentArea.setCenter(contactSearchPresenter.getView());
    }

    public void showContactDetail(Long contactId) {
        contactDetailPresenter.setContact(contactId);
        contentArea.setCenter(contactDetailPresenter.getView());
    }
}

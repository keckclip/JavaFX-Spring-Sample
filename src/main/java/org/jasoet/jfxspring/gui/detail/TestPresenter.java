package org.jasoet.jfxspring.gui.detail;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Deny Prasetyo,S.T
 * Java(Script) Developer and Trainer
 * Co-Founder | 2ndStack Studio
 * jasoet87@gmail.com
 * <p/>
 * http://github.com/jasoet
 * http://bitbucket.com/jasoet
 *
 * @jasoet
 */


public class TestPresenter implements Initializable {

    public AnchorPane root;
    public TableView tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public Parent getView() {
        return root;
    }
}

package org.jasoet.jfxspring.gui;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import org.jasoet.jfxspring.gui.detail.ContactDetailPresenter;
import org.jasoet.jfxspring.gui.detail.TestPresenter;
import org.jasoet.jfxspring.gui.main.MainPresenter;
import org.jasoet.jfxspring.gui.search.ContactSearchPresenter;
import org.jasoet.jfxspring.service.ContactService;
import org.jasoet.jfxspring.service.SimpleContactService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;

@Configuration
public class FirstContactAppFactory {
    @Bean
    public MainPresenter mainPresenter() {
        return loadPresenter("/fxml/Main.fxml");
    }

    @Bean
    public ContactSearchPresenter contactSearchPresenter() {
        return loadPresenter("/fxml/ContactSearch.fxml");
    }

    @Bean
    public ContactDetailPresenter contactDetailPresenter() {
        return loadPresenter("/fxml/ContactDetail.fxml");
    }

    @Bean
    public TestPresenter testPresenter() {
        return loadPresenter("/fxml/Test.fxml");
    }
    @Bean
    public ContactService contactService() {
        return new SimpleContactService();
    }

    private <T> T loadPresenter(String fxmlFile) {
        try {

            URL location = getClass().getResource(fxmlFile);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            fxmlLoader.load(location.openStream());

            return (T) fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(String.format("Unable to load FXML file '%s'", fxmlFile), e);
        }
    }
}

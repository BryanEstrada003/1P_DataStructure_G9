/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.contacts.Contact;
import com.mycompany.contacts.User;
import com.mycompany.contacts.Util;
import ec.edu.espol.TDAs.ArrayList;
import ec.edu.espol.TDAs.DoublyLinkedList;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author angelozurita
 */
public class ContactsController implements Initializable {

    @FXML
    private AnchorPane principal_page;
    @FXML
    private AnchorPane header;
    @FXML
    private Label title_contacts;
    @FXML
    private ImageView newcontact;
    @FXML
    private ImageView lupa;
    @FXML
    private Pane show_contact;
    private ImageView regresar;
    @FXML
    private ImageView salir;
    @FXML
    private ImageView groups;
    @FXML
    private ImageView profile_picture;
    @FXML
    private Label name_lastname;
    private User owner;
    @FXML
    private AnchorPane nav;
    @FXML
    private TextField search;
    @FXML
    private VBox Vbox_contacts;
    @FXML
    private ImageView subir;
    @FXML
    private ImageView bajar;
    @FXML
    private ImageView profile_picture1;
    @FXML
    private Label name_lastname1;
    @FXML
    private HBox contact1;
    @FXML
    private VBox clasification1;
    @FXML
    private ImageView profile_picture2;
    @FXML
    private Label name_lastname2;
    @FXML
    private VBox clasification2;
    @FXML
    private ImageView profile_picture3;
    @FXML
    private Label name_lastname3;
    @FXML
    private VBox clasification3;
    @FXML
    private ImageView profile_picture4;
    @FXML
    private Label name_lastname4;
    @FXML
    private VBox clasification4;
    @FXML
    private ImageView profile_picture5;
    @FXML
    private Label name_lastname5;
    @FXML
    private VBox clasification5;

    private DoublyLinkedList<Contact> contactos;
    private ListIterator<Contact> ite;

    /**
     * Initializes the controller class.
     */
    public User getOwner() {
        return owner;

    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        set_owner();
        newcontact.setImage(new Image("Iconos/crear_contacto.png"));
        groups.setImage(new Image("Iconos/flecha-izquierda.png"));
        salir.setImage(new Image("Iconos/salir.png"));
        lupa.setImage(new Image("Iconos/buscar.png"));
        principal_page.getStyleClass().add("blackbackgorund");
        header.getStyleClass().add("blackbackgorund");
        nav.getStyleClass().add("blackbackgorund");
        show_contact.getStyleClass().add("blackbackgorund");
        search.getStyleClass().add("text-field");
        subir.setImage(new Image("Iconos/subir.png"));
        bajar.setImage(new Image("Iconos/bajar.png"));
        profile_picture.setPreserveRatio(true);
        profile_picture.setSmooth(true);
        profile_picture.setFitWidth(80);
        profile_picture.setFitHeight(80);
        profile_picture.setImage(new Image("Profile_pictures/" + owner.getPersonal_user() + "/" + owner.getPersonal_user() + ".png"));
        name_lastname.setText(owner.getName() + owner.getLastname());
//        profile_picture.setFitWidth(80); 
//        profile_picture.setFitHeight(80);
//        profile_picture.setPreserveRatio(true); 
//        profile_picture.setSmooth(true); 
//
//        if (owner != null) {
//            name_lastname.setText(Util.title(owner.getName()) + "  " + Util.title(owner.getLastname()));
//        } else {
//            name_lastname.setText("Name  Lastname");
//        }
//
//        try {
//            String personal_image = "Profile_pictures/" + owner.getPersonal_user() + "/" + owner.getPersonal_user() + ".png";
//            System.out.println(personal_image);
//            profile_picture.setImage(new Image(personal_image));
//        } catch (Exception e) {
//            profile_picture.setImage(new Image("Iconos/cambiar_foto.png"));
//        }
        this.contactos = Util.listaContacto2();
        this.ite = this.contactos.listIterator();
        name_lastname1.setText(ite.next().getName());
        name_lastname2.setText(ite.next().getName());
        name_lastname3.setText(ite.next().getName());
        name_lastname4.setText(ite.next().getName());
        name_lastname5.setText(ite.next().getName());

    }

    @FXML
    private void salir(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setHeaderText("ARE YOU SURE YOU WANT TO LEAVE COMPLETELY ");
        alert.setContentText("CONFIRMATION");

        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("YES");
        ((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("NO");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void set_owner() {
        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("User_login.ser"))) {
            owner = (User) in.readObject();

        } catch (IOException ioe) {

        } catch (ClassNotFoundException c) {

        }
    }
    private int nVez = 1;
    private boolean clickDown = false, clickup = false;

    @FXML
    private void subir(MouseEvent event) {
        int cont = 0;
        ArrayList<Contact> nuevaList = new ArrayList<>();
        if (nVez == 1 || clickDown == true) {
            nuevaList.clear();
            while (cont < 11) {
                nuevaList.addFirst(ite.previous());
                cont++;
            }
        } else {
            nuevaList.clear();
            while (cont < 5) {
                nuevaList.addFirst(ite.previous());
                cont++;
            }
        }
        nVez++;
        clickDown = false;
        clickup = true;
        name_lastname1.setText(nuevaList.get(0).getName());
        name_lastname2.setText(nuevaList.get(1).getName());
        name_lastname3.setText(nuevaList.get(2).getName());
        name_lastname4.setText(nuevaList.get(3).getName());
        name_lastname5.setText(nuevaList.get(4).getName());
    }

    @FXML
    private void bajar(MouseEvent event) {
        int cont = 0;
        ArrayList<Contact> nuevaList = new ArrayList<>();
        if (clickup == true) {
            nuevaList.clear();
            while (cont < 11) {
                nuevaList.addFirst(ite.next());
                cont++;
            }
            name_lastname1.setText(nuevaList.get(4).getName());
            name_lastname2.setText(nuevaList.get(3).getName());
            name_lastname3.setText(nuevaList.get(2).getName());
            name_lastname4.setText(nuevaList.get(1).getName());
            name_lastname5.setText(nuevaList.get(0).getName());
        } else {
            nuevaList.clear();
            while (cont < 5) {
                nuevaList.add(ite.next());
                cont++;
            }
            name_lastname1.setText(nuevaList.get(0).getName());
            name_lastname2.setText(nuevaList.get(1).getName());
            name_lastname3.setText(nuevaList.get(2).getName());
            name_lastname4.setText(nuevaList.get(3).getName());
            name_lastname5.setText(nuevaList.get(4).getName());
        }
        nVez++;
        clickDown = true;
        clickup = false;
    }

    @FXML
    private void showcontact(MouseEvent event) {
    }

    @FXML
    private void agregar_contacto(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newcontact.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) header.getScene().getWindow();
        stage.setScene(scene);
    }

}

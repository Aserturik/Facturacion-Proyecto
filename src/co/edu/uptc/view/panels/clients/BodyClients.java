package co.edu.uptc.view.panels.clients;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.ButtonImage;
import co.edu.uptc.view.panels.fathers.BodyPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BodyClients extends BodyPanel {
    private boolean isEdit;
    private GridBagConstraints gbc;
    private ButtonImage buttonClients, buttonAdd, buttonEdit, buttonDelete, buttonCheck;
    private JComboBox comboBoxDocumentType;
    private TextFieldGray textFieldDocument, textFieldName, textFieldLastName, textFieldAddress,CityAdress;
    private EventsView eventsView;
    private Person selectedClient;
    private List<Person> clients;
    private PanelClients panelClients;

    public BodyClients(EventsView eventsView, PanelClients panelClients) {
        super();
        this.setEventsView(eventsView);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        initComponents();
        inabiliteFields();
        this.panelClients = panelClients;
        clients = panelClients.getPrincipalPanel().getFrame().getClients();
    }

    public void generalGbc(int x, int y,int height,int insets){
        gbc.gridy = y;
        gbc.gridx = x;
        gbc.gridwidth = 1;
        gbc.gridheight = height;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(insets,insets,insets,insets);
    }

    public void initComponents(){
        buttonClients();
        comboBoxDocumentType();
        textFieldDocument();
        textFieldName();
        textFieldLastName();
        textFieldAddress();
        textFielCityAdress();
        buttonAdd();
        buttonEdit();
        buttonDelete();
        buttonCheck();
    }

    public void buttonClients(){
        this.buttonClients = new ButtonImage("client", false, 255,255, 255);
        generalGbc(0,0,6,15);
        gbc.insets = new Insets(80,80,80,15);
        this.add(this.buttonClients, gbc);
    }

    public void comboBoxDocumentType(){
        this.comboBoxDocumentType = new JComboBox();
        this.comboBoxDocumentType.setModel(new DefaultComboBoxModel(new String[] { "Cédula de ciudadanía", "Tarjeta de identidad" }));
        this.comboBoxDocumentType.setSize(312,35);
        generalGbc(1,0,1,3);
        this.add(this.comboBoxDocumentType, gbc);
    }

    public void textFieldDocument(){
        this.textFieldDocument = new TextFieldGray("Numero de Documento");
        this.textFieldDocument.setBig();
        generalGbc(1,1,1,3);
        this.add(this.textFieldDocument, gbc);
    }

    public void textFieldName(){
        this.textFieldName = new TextFieldGray("Nombre");
        this.textFieldName.setBig();
        generalGbc(1,2,1,3);
        this.add(this.textFieldName, gbc);
    }

    public void textFieldLastName(){
        this.textFieldLastName = new TextFieldGray("Apellido");
        this.textFieldLastName.setBig();
        generalGbc(1,3,1,3);
        this.add(textFieldLastName, gbc);
    }

    public void textFieldAddress(){
        this.textFieldAddress = new TextFieldGray("Dirección de residencia");
        this.textFieldAddress.setBig();
        generalGbc(1,4,1,3);
        this.add(this.textFieldAddress, gbc);
    }

    public void textFielCityAdress(){
        this.CityAdress = new TextFieldGray("Ciudad de residencia");
        this.CityAdress.setBig();
        generalGbc(1,5,1,3);
        this.add(this.CityAdress, gbc);
    }

    public void buttonAdd(){
        this.buttonAdd = new ButtonImage("addPerson", true, 255,255, 255);
        generalGbc(2,0,3,15);
        gbc.insets = new Insets(80,50,15,15);
        this.add(this.buttonAdd, gbc);

        buttonAdd.addActionListener(e -> {
            setEdit(true);
            habilitateFields();
            eventsView.ocultHeaderClients();
        });
    }

    public void buttonEdit(){
        this.buttonEdit = new ButtonImage("edit", true, 255,255, 255);
        generalGbc(3,0,3,15);
        gbc.insets = new Insets(80,15,15,80);
        this.add(this.buttonEdit, gbc);

        buttonEdit.addActionListener(e -> {
            setEdit(true);
            habilitateFields();
            eventsView.ocultHeaderClients();
        });
    }

    public void buttonDelete(){
        this.buttonDelete = new ButtonImage("delete", true, 255,255, 255);
        generalGbc(2,3,3,15);
        gbc.insets = new Insets(15,50,80,15);
        this.add(this.buttonDelete, gbc);

        buttonDelete.addActionListener(e -> {
            optionPaneDelete();
        });
    }

    private void optionPaneDelete() {
        int option = JOptionPane.showConfirmDialog(null, "Desea eliminar al cliente?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            deleteClient();
        }else {
            JOptionPane.showMessageDialog(null, "Cliente no eliminado");
        }
    }

    private void deleteClient() {
        clients.remove(selectedClient);
        eventsView.showNormalHeaderClients();
        eventsView.openSelectedPerson();
        panelClients.getHeaderClients().setListClients(clients);
    }

    public void buttonCheck(){
        this.buttonCheck = new ButtonImage("chek", true, 255,255, 255);
        generalGbc(3,3  ,3,15);
        gbc.insets = new Insets(15,15,80,80);
        this.add(this.buttonCheck, gbc);

        buttonCheck.addActionListener(e -> {
            setEdit(false);
            inabiliteFields();
            eventsView.showNormalHeaderClients();
            eventsView.openSelectedPerson();
        });
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
        if (isEdit){
            this.buttonEdit.opacity(0.5f);
            this.buttonDelete.opacity(0.5f);
            this.buttonAdd.opacity(0.5f);
            this.buttonCheck.opacity(1f);
        }else {
            this.buttonEdit.opacity(1f);
            this.buttonDelete.opacity(1f);
            this.buttonAdd.opacity(1f);
            this.buttonCheck.opacity(0.5f);
        }
    }

    public void habilitateFields(){
        this.comboBoxDocumentType.setEditable(false);
        this.comboBoxDocumentType.setEditable(false);
        comboBoxDocumentType.setEnabled(true);
        this.textFieldDocument.setEditable(true);
        this.textFieldName.setEditable(true);
        this.textFieldLastName.setEditable(true);
        this.textFieldAddress.setEditable(true);
        this.CityAdress.setEditable(true);
    }

    public void inabiliteFields(){
        this.comboBoxDocumentType.setEditable(false);
        comboBoxDocumentType.setEnabled(false);
        this.textFieldDocument.setEditable(false);
        this.textFieldName.setEditable(false);
        this.textFieldLastName.setEditable(false);
        this.textFieldAddress.setEditable(false);
        this.CityAdress.setEditable(false);
    }

    public void modeSelected(){
        inabiliteFields();
        setEdit(true);
    }

    public Person getSelectedClient(){
        return selectedClient;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public void setListClients(List<Person> clients) {
        this.clients = clients;
    }
    public void showClientData(Person client){
        this.selectedClient = client;
        this.comboBoxDocumentType.setSelectedItem(setDocumentType(client.isAdult()));
        this.textFieldDocument.setText(client.getDocument());
        this.textFieldName.setText(client.getName());
        this.textFieldLastName.setText(client.getLastName());
        this.textFieldAddress.setText(client.getAddress());
        this.CityAdress.setText(client.getCity());
    }

    private Object setDocumentType(boolean isAdult) {
        System.out.println(isAdult);
        if (isAdult){
            return comboBoxDocumentType.getItemAt(0);
        }else {
            return comboBoxDocumentType.getItemAt(1);
        }
    }

    public void setPanelClients(PanelClients panelClients) {
        this.panelClients = panelClients;
    }
}

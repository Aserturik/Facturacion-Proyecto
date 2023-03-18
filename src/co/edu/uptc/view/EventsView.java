package co.edu.uptc.view;

import co.edu.uptc.pojo.Person;

public interface EventsView {
    void openHome();
    void openClients();
    void openProducts();
    void openBill();
    void openEditBill(int index);
    void openEditBill();
    void openAddBill();
    void searchBill();
    void saveBillAndExit();
    void ocultHeaderClients();
    void ocultHeaderProducts();
    void showNormalHeaderClients();
    void showNormalHeaderProducts();
    void comboBoxClients();
    void selectClient();
    void enableFooterButtons();
    void openSelectedPerson();
    void showClientData(Person person);
}

package co.edu.uptc.model;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class ListClients implements Cloneable{
    private List<Person> clientsOriginal;
    private List<Person> clientsClone;
    private Contract.Model model;

    public ListClients(Contract.Model model) {
        this.model = model;
        loadClients();
        loadClientsClone();
    }

    private void loadClients(){
        clientsOriginal = new UptcList<>();
        clientsOriginal.add(new Person(true, 123, "Juan", "Perez", "Calle 1", "123456789"));
        clientsOriginal.add(new Person(true, 456, "Maria", "Gomez", "Calle 2", "987654321"));
        clientsOriginal.add(new Person(true, 789, "Pedro", "Gonzalez", "Calle 3", "123456789"));
        clientsOriginal.add(new Person(false, 101, "Luisa", "Gutierrez", "Calle 4", "987654321"));
        clientsOriginal.add(new Person(true, 112, "Carlos", "Ramirez", "Calle 5", "123456789"));
        clientsOriginal.add(new Person(false, 131, "Camila", "Garcia", "Calle 6", "987654321"));
        clientsOriginal.add(new Person(true, 141, "Andres", "Rodriguez", "Calle 7", "123456789"));
        clientsOriginal.add(new Person(false, 151, "Sofia", "Hernandez", "Calle 8", "987654321"));
        clientsOriginal.add(new Person(true, 161, "Jose", "Lopez", "Calle 9", "123456789"));
        clientsOriginal.add(new Person(false, 171, "Laura", "Martinez", "Calle 10", "987654321"));
    }

    private void loadClientsClone(){
        clientsClone = new UptcList<>();
        for ( Person client : clientsOriginal ) {
            clientsClone.add(client.clone(client));
        }
    }

    public boolean isSearch(boolean isAdult, String documentNumber){
        boolean isSearch = false;
        for ( Person client : clientsClone ) {
            if (client.isAdult() == isAdult && client.getDocument().equals(documentNumber)) {
                isSearch = true;
                break;
            }
        }
        return isSearch;
    }

    public List<Person> searchAllPersons(String character) {
        UptcList<Person> list = new UptcList<>();
        for (Person person : clientsClone) {
            if (person.getDocument().toLowerCase().contains(character) ||
                    person.getName().toLowerCase().contains(character) ||
                    person.getLastName().toLowerCase().contains(character) ||
                    person.getAddress().toLowerCase().contains(character) ||
                    person.getCity().toLowerCase().contains(character))
                list.add(person);
        }
        return list;
    }

    public List<Person> getClientsClone() {
        return clientsClone;
    }

    public boolean isValidDocument(String document) {
        try {
            Integer.parseInt(document);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Person> getNewClients(Person newPerson) {
        clientsOriginal.add(newPerson);
        clientsClone.add(newPerson.clone(newPerson));
        return clientsClone;
    }

    public boolean getEditClients(int indexOf, Person newPerson) {
        clientsOriginal.set(indexOf, newPerson);
        clientsClone.set(indexOf, newPerson.clone(newPerson));

        model.setListClientsView(clientsClone);
        // hacer la condicion de editar siempre y cuando no este referenciado en una factura
        return true;
    }

    public Contract.Model getModel() {
        return model;
    }
}

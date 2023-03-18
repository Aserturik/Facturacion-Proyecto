package co.edu.uptc.model;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Person;

import java.util.List;

public class ListClients implements Cloneable{
    private List<Person> clientsOriginal;
    private List<Person> clientsClone;

    public ListClients() {
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

    public List<Person> getClientsClone() {
        return clientsClone;
    }

}

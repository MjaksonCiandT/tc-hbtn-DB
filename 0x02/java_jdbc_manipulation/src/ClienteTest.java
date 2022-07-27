package org.example;

public class ClienteTest {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:sqlite_database_marco_2022.db";

        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(url);

        clienteDAOImpl.createTable(url);

        Cliente c1 = new Cliente();
        c1.setNome("Danilo R. Pereira");
        c1.setIdade(37);
        c1.setCpf("111.111.111-11");
        c1.setRg("222.222.222-22");

        Cliente c1iente2 = new Cliente();
        c1iente2.setNome("Joao Oliveira Silva");
        c1iente2.setIdade(55);
        c1iente2.setCpf("888.111.111-11");
        c1iente2.setRg("777.222.222-22");

        clienteDAOImpl.insert(url, c1);
        clienteDAOImpl.insert(url, c1iente2);

        clienteDAOImpl.selectAll(url);

        clienteDAOImpl.update(url, 1, "Danilo Rodrigues Pereira", 38);
        clienteDAOImpl.selectAll(url);

        clienteDAOImpl.delete(url, 2);
        clienteDAOImpl.selectAll(url);
    }

}

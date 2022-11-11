package bean;

import lombok.AllArgsConstructor;
import repository.ClientRepository;
import entity.Client;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

import static java.lang.Math.round;

@ManagedBean(name = "clientBean")
@RequestScoped
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ClientBean {
    static Client clientBean;
    int totalClients;
    List<Client> listClients;

    @PostConstruct
    public void init() {
        ClientRepository.setup();
        listClients = ClientRepository.getAll();
    }

    public static void getData(Client client) {
        clientBean = client;
    }

    public String getCPF() {
        return clientBean.getId();
    }

    public String getClient() {
        return clientBean.getClient();
    }

    public String getDesert() {
         if(clientBean.getDesert().equals("n")) {
             return "Não";
         } else {
             return "Sim";
         }
    }

    public Integer getGuests() {
        return clientBean.getGuests();
    }

    public double getPriceGuest() {
        return clientBean.getPriceGuest();
    }

    public double getPriceGuests() {
        return clientBean.getPriceGuests();
    }

    public int getWaiters() {
        return clientBean.getWaiters();
    }

    public double getPriceWaiters() {
        return round(clientBean.getPriceWaiters());
    }

    public double getPriceTotal() {
        return round(clientBean.getPriceTotal());
    }

    public int totalClients() {
        return totalClients = listClients.size();
    }

    public String deleteClient(String id) {
          return ClientRepository.deletar(id);
    };


}


package bean;

import repository.ClientRepository;
import entity.Client;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "clientBean")
@RequestScoped
@Data
@Builder
@NoArgsConstructor

public class ClientBean {
    static Client clientBean;
    static List listBean;

    public static void getData(Client client) {
        clientBean = client;
    }

    public static void getAllData(List all) {
        listBean = all;
    }

    public String getCPF() {
        return clientBean.getId();
    }

    public String getClient() {
        return clientBean.getClient();
    }

    public String getDesert() {
        return clientBean.getDesert();
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
        return clientBean.getPriceWaiters();
    }

    public double getPriceTotal() {
        return clientBean.getPriceTotal();
    }

    public List getTableAll() {
        return ClientRepository.searchAll();
    }

}


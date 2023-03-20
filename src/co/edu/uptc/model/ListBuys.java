package co.edu.uptc.model;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Buy;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class ListBuys {
    private List<Buy> buys;
    private List<Buy> buysClone;
    private Contract.Model model;

    public ListBuys(GeneralModel generalModel) {
        this.model = generalModel;
        loadBuys();
        loadBuysClone();
    }

    private void loadBuys() {
        buys = new UptcList<>();
        buys.add(new Buy(model.getProducts().get(0), 2));
        buys.add(new Buy(model.getProducts().get(1), 3));
        buys.add(new Buy(model.getProducts().get(2), 4));
    }


    private void loadBuysClone() {
        buysClone = new UptcList<>();
        for (Buy buy : buys) {
            buysClone.add(buy.clone());
        }
    }

    public List<Buy> getBuysClone() {
        return buysClone;
    }
}

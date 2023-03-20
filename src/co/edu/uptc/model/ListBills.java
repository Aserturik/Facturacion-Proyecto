package co.edu.uptc.model;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Bill;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class ListBills {
    private List<Bill> bills;
    private List<Bill> billsClone;
    private Contract.Model model;

    public ListBills(Contract.Model model) {
        this.model = model;
        loadBills();
        loadBillsClone();
    }

    private void loadBills() {
        bills = new UptcList<>();
        bills.add(new Bill(model.getClients().get(2), model.getBuys()));
        bills.add(new Bill(model.getClients().get(1), model.getBuys()));
        bills.add(new Bill(model.getClients().get(0), model.getBuys()));
    }

    private void loadBillsClone() {
        billsClone = new UptcList<>();
        for (Bill bill : bills) {
            billsClone.add(bill.clone());
        }
    }

    public List<Bill> getBillsClone() {
        return billsClone;
    }
}

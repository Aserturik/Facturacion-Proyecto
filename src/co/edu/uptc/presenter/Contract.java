package co.edu.uptc.presenter;

public interface Contract {
    interface View{
        void setPresenter(Presenter presenter);
        void start();
    }

    interface Presenter{
        void setView(View view);
        void setModel(Model model);
    }

    interface Model{
        void setPresenter(Presenter presenter);
    }
}

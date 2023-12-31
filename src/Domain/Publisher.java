package Domain;

import Presentation.Subcriber;

public interface Publisher {
    public void attach(Subcriber subscriber);

    public void detach(Subcriber subscriber);

    public void notifySubcriber();
}

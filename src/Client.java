import Abstracts.Human;

public class Client extends Human {

    private int clientBudget;

    public Client(int id, String name, String email, String phone, int clientBudget) {
        super(id, name, email, phone);
        this.clientBudget = clientBudget;
    }

    public int getClientBudget() {
        return clientBudget;
    }

    public boolean canAfford(int amount) {
        return clientBudget >= amount;
    }

    public void spendBudget(int amount) {
        if (!canAfford(amount)) {
            throw new IllegalArgumentException("Not enough budget");
        }
        clientBudget -= amount;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

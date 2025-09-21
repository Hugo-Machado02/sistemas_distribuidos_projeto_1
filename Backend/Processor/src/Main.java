import model.Message;
import repository.MessageRepository;

public class Main {
    public static void main(String[] args) {
        MessageRepository repo = new MessageRepository();

        // Adicionar mensagem
        repo.save(new Message("Josélio", "Olá mundo!"));
        repo.save(new Message("Maria", "Oi, tudo bem?"));

        // Listar mensagens
        for (Message m : repo.findAll()) {
            System.out.println(m.getName() + ": " + m.getMessage());
        }
    }
}

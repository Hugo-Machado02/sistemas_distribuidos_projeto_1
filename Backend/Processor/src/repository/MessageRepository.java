package repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import model.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    private final File storageFile = new File("data/messages.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Message> messages = new ArrayList<>();

    public MessageRepository() {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();
        }
        loadFromFile();
    }
    
    // Salva nova mensagem
    public void save(Message message) {
        messages.add(message);
        saveToFile();
    }

    // Retorna todas as mensagens
    public List<Message> findAll() {
        return new ArrayList<>(messages);
    }
    
    private void loadFromFile() {
        if (storageFile.exists()) {
            try {
                messages = mapper.readValue(storageFile,
                        new TypeReference<List<Message>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

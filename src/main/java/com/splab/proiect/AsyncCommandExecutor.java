package com.splab.proiect;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncCommandExecutor {

    // Această adnotare @Async este magia
    // Îi spune lui Spring să ruleze această metodă
    // pe un alt fir de execuție (din thread pool)
    @Async
    public <T> void executeCommand(Command<T> command) {
        // Obținem ID-ul thread-ului curent ca să demonstrăm
        // că rulează pe un thread diferit de cel al controller-ului
        long threadId = Thread.currentThread().getId();
        System.out.println(
            "AsyncCommandExecutor: Se execută comanda pe thread-ul: " + threadId
        );
        
        // Aici se execută logica de business (care poate dura mult)
        command.execute();
        
        System.out.println(
            "AsyncCommandExecutor: S-a terminat comanda pe thread-ul: " + threadId
        );
    }
}
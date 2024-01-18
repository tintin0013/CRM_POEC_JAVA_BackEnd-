package com.Certif.SlackLike.controller;



import com.Certif.SlackLike.model.Message;
import com.Certif.SlackLike.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public ResponseEntity<?> getAllMessages() {
        if (messageService.getAllMessages().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(messageService.getAllMessages());
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable("id") Integer id){
        for(Message m : messageService.getAllMessages()){
            if(m.getId().equals(id))
                return ResponseEntity.ok(m);
        }
        return ResponseEntity.status(404).body("Message with ID " + id + " not found");
    }



    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message newMessage){
        messageService.createMessage(newMessage);
        return ResponseEntity.ok(newMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") Integer id){
        if(messageService.getMessageById(id).isEmpty()){
            return ResponseEntity.status(404).body("Message with 'ID " + id + " not found");
        }else{
            messageService.deleteMessage(id);
            //return ResponseEntity.ok("ok");
            return ResponseEntity.status(200).body("");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@RequestBody Message message, @PathVariable("id") Integer id){
        if (message.getId() == null){
            return ResponseEntity.badRequest().body("Request Error : Missing Message identifier");
        }
        if (!message.getId().equals(id)){
            return ResponseEntity.badRequest().body("Identifier values are different");
        }
        return ResponseEntity.ok(messageService.updateMessage( message));

    }





}

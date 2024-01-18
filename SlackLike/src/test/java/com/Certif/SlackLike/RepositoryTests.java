package com.Certif.SlackLike;

import com.Certif.SlackLike.model.*;
import com.Certif.SlackLike.repository.ChannelRepository;
import com.Certif.SlackLike.repository.MessageRepository;
import com.Certif.SlackLike.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Test
    void testAddUser() {

        //User user = new User("Jean Claude", "Dusse", "JCD", 0);
        User user = new User("Gerard" , "Darmon","GD", UserStatus.INACTIVE);
        userRepository.save(user);


    }

    @Test
    void  testAddChannel(){

        //Channel channel = new Channel("Canal1",LocalDateTime.now(),0);
        Channel channel = new Channel("Canal3",LocalDateTime.now(), ChannelStatus.ACTIVE);
        channelRepository.save(channel);

    }

    @Test
    void testAddMessage(){
        Optional<User> users1 = userRepository.findById(1);
        Optional<Channel> channel1 = channelRepository.findById(1);

        if ( channel1.isPresent() && users1.isPresent() ){
           User util1 = users1.get()  ;
            Channel canal1 = channel1.get();
            //Message message = new Message("test message", LocalDateTime.now(),util1,canal1,1);
            Message message = new Message("New Message", LocalDateTime.now(),util1,canal1,MessageStatus.ACTIVE);
            messageRepository.save(message);
        }



    }


}

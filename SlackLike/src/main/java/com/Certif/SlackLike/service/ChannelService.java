package com.Certif.SlackLike.service;



import com.Certif.SlackLike.model.Channel;

import com.Certif.SlackLike.repository.ChannelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository channelRepository;

    // getAllChannels
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    // getChannelById
    public Optional<Channel> getChannelById(Integer id) {

        return channelRepository.findById(id);
    }

    //createChannel
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    //updateChannel
    public Channel updateChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    //deleteChannel
    public boolean deleteChannel(Integer id) {
        if (getChannelById(id).isEmpty())
            return false;
        else {



            channelRepository.deleteById(id);
            return true;
        }


    }
}


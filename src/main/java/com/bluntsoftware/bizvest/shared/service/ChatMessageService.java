package com.bluntsoftware.bizvest.shared.service;

import com.bluntsoftware.bizvest.exception.AppException;
import com.bluntsoftware.bizvest.shared.domain.ChatMessage;
import com.bluntsoftware.bizvest.model.MessageStatus;
import com.bluntsoftware.bizvest.shared.repository.ChatMessageRepository;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    private final MongoTemplate mongoTemplate;

    public ChatMessageService(ChatMessageRepository repository, ChatRoomService chatRoomService,@Qualifier("sharedMongoTemplate") MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.chatRoomService = chatRoomService;
        this.mongoTemplate = mongoTemplate;
    }

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        repository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(String senderId, String recipientId) {
        if(senderId ==  null){
            return repository.countByRecipientIdAndStatus(recipientId, MessageStatus.RECEIVED);
        }
        return repository.countBySenderIdAndRecipientIdAndStatus(senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);
        var messages = chatId.map(repository::findByChatId).orElse(new ArrayList<>());
        if(messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }
        return messages;
    }

    public ChatMessage findById(String id) {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    chatMessage.setStatus(MessageStatus.DELIVERED);
                    return repository.save(chatMessage);
                })
                .orElseThrow(() -> new AppException( HttpStatus.NOT_FOUND,"can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
        Query query = new Query(Criteria
                        .where("senderId").is(senderId)
                        .and("recipientId").is(recipientId));
        Update update = Update.update("status", status);
        UpdateResult result = mongoTemplate.updateMulti(query, update, ChatMessage.class);
        log.info("{}",result);

    }
}

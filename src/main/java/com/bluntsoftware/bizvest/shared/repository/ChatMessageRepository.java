package com.bluntsoftware.bizvest.shared.repository;

import com.bluntsoftware.bizvest.shared.domain.ChatMessage;
import com.bluntsoftware.bizvest.model.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);
    long countByRecipientIdAndStatus( String recipientId, MessageStatus status);
    List<ChatMessage> findByChatId(String chatId);
}

package com.example.notification.service;

import com.example.notification.entity.Notification;
import com.example.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;


    public String saveNotification(Notification notification) {
        notificationRepository.save(notification);
        return "Notification saved Successfully";
    }

    public String deleteNotification(Long nId) {
        notificationRepository.deleteById(nId);
        return "Notification deleted Successfully";
    }

    public List<Notification> getAllNotifications() {

        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long nId) {

        return notificationRepository.findById(nId).get();
    }
    public String updateNotification(Long nId, Notification updatedNotification) {
        Optional<Notification> existingNotificationOpt = notificationRepository.findById(nId);
        if (existingNotificationOpt.isPresent()) {
            Notification existingNotification = existingNotificationOpt.get();
            existingNotification.setMsg(updatedNotification.getMsg());
            existingNotification.setEmpNic(updatedNotification.getEmpNic());
            existingNotification.setTimeStamp(updatedNotification.getTimeStamp());
            notificationRepository.save(existingNotification);
            return "Notification updated successfully";
        } else {
            return "Notification not found";
        }
    }





}
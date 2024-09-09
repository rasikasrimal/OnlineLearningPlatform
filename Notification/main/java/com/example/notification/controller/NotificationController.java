package com.example.notification.controller;

import com.example.notification.entity.Notification;
import com.example.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/save")
    public String saveNotification(@RequestBody Notification notification) {

        notificationService.saveNotification(notification);
        return "Successfully saved notification";
    }

    @DeleteMapping("/{nId}")
    public String deleteNotification(@PathVariable Long nId) {

        notificationService.deleteNotification(nId);
        return "Successfully deleted notification";
    }

    @GetMapping("/viewAll")
    public List<Notification> viewAllNotifications() {

        return notificationService.getAllNotifications();
    }

    @GetMapping("/{nId}")
    public Notification viewNotification(@PathVariable Long nId) {

        return notificationService.getNotificationById(nId);
    }
    @PutMapping("/{nId}")
    public String updateNotification(@PathVariable Long nId, @RequestBody Notification updatedNotification) {
        return notificationService.updateNotification(nId, updatedNotification);
    }

}

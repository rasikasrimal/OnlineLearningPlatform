package com.example.onlinelearningmanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class ProgressTracking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)


        private int progressId;

        private int student;

        private int lesson;

        private int completed;

        private Date completionDate;

}

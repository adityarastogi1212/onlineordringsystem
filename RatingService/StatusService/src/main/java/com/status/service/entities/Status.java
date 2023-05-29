package com.status.service.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user_status")
public class Status {
    @Id
    private String statusId;
    private String userId;
    private String paymentId;
    private  String status;
    private  String feedback;
}

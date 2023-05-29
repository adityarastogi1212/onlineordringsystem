package com.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Status {
    private String statusId;
    private String userId;
    private String paymentId;
    private String status;
    private String feedback;

    private Payment payment;
}

package org.zerock.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String text;

    private String  replyer;


}

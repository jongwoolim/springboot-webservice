package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;


}

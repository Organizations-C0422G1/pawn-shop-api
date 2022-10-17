package com.pawn_shop.model.pawn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PawnImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "pawn_item_id",referencedColumnName = "id")
    private PawnItem pawnItem;
}

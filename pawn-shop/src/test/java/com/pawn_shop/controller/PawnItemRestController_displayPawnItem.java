package com.pawn_shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PawnItemRestController_displayPawnItem {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displayPawnItem_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pawnItemRest/list/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[3].name").value("Yamaha Exciter"))
                .andExpect(jsonPath("content[3].pawnType.id").value("Xe Máy"))
                .andExpect(jsonPath("content[3].status").value(false))
                .andExpect(jsonPath("content[3].endDate").value("2022-05-15"))
                .andExpect(jsonPath("content[3].itemPrice").value(12000000));
    }

    @Test
    public void displayPawnItem_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/pawnItemRest/list?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[2].name").value("Tủ lạnh Sharp Inverter"))
                .andExpect(jsonPath("content[2].pawnType.id").value("Đồ Gia Dụng"))
                .andExpect(jsonPath("content[2].status").value(false))
                .andExpect(jsonPath("content[2].endDate").value("2022-04-15"))
                .andExpect(jsonPath("content[2].itemPrice").value(4000000));
    }
}

package com.pawn_shop.dto;

import com.pawn_shop.model.login.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto implements Validator {
    private Long id;

    @NotBlank(message = "Vui lòng nhập vào")
    private String title;

    @NotBlank(message = "Vui lòng nhập vào")
    private String content;

    @NotBlank(message = "Vui lòng nhập vào")
    private String postingDay;

    @NotBlank(message = "Vui lòng nhập vào")
    private String imgUrl;

    private boolean status;

    private AppUser appUser;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewsDto newsDto = (NewsDto) target;
        LocalDate postingDay;
        if (newsDto.getPostingDay()=="") {
            errors.rejectValue("postingDay","postingDay","Vui lòng nhập vào");
        } else {
            try {
                postingDay = LocalDate.parse(newsDto.getPostingDay());
                if (postingDay.isBefore(LocalDate.now()) || postingDay.isAfter(LocalDate.now())) {
                    errors.rejectValue("postingDay","postingDay","Vui lòng nhập đúng ngày hiện tại");
                }
            } catch (Exception e) {
                errors.rejectValue("postingDay","postingDay","Vui lòng nhập đúng định dạng dd/MM/yyyy");
            }
        }
    }
}
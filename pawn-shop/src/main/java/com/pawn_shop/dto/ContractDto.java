package com.pawn_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto implements Validator {
    private Long id;
    private CustomerDto customerDto;
    private PawnItemDto pawnItemDto;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        if (!contractDto.customerDto.getName().equals("")){
            if (contractDto.customerDto.getName().length()>40||contractDto.customerDto.getName().length()<2){
                errors.rejectValue("customerDto.name",
                        "create.name",
                        "Vui lòng nhập đúng định dạng");
            }
            if (!contractDto.customerDto.getName().matches("^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]+" +
                    "( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ0-9]*)+$")){
                errors.rejectValue("customerDto.name",
                        "create.name",
                        "Vui lòng viết hoa chữ cái đầu");
            }
            if (contractDto.customerDto.getName()==null){
                errors.rejectValue("customerDto.name",
                        "create.name",
                        "Vui lòng nhập tên");
            }
        } else {
            errors.rejectValue("customerDto.name",
                    "create.name",
                    "Vui lòng nhập tên");
        }

        if (!contractDto.customerDto.getPhoneNumber().equals("")){
            if (!contractDto.customerDto.getPhoneNumber().matches("^0\\d{9}$")){
                errors.rejectValue("customerDto.phoneNumber",
                        "create.phoneNumber",
                        "Vui lòng nhập đúng định dạng");
            }
            if (contractDto.customerDto.getPhoneNumber() == null){
                errors.rejectValue("customerDto.phoneNumber",
                        "create.phoneNumber",
                        "Vui lòng nhập số điện thoại");
            }
        }else {
            errors.rejectValue("customerDto.phoneNumber",
                    "create.phoneNumber",
                    "Vui lòng nhập số điện thoại");
        }

        if (contractDto.customerDto.getAddressDto().getDistrictDto().getId() == null){
            errors.rejectValue("customerDto.addressDto.districtDto.id",
                    "create.district",
                    "Vui lòng chọn Quận/Huyện");
        }

        if (contractDto.pawnItemDto.getPawnTypeDto().getId() == null){
            errors.rejectValue("pawnItemDto.pawnType.id",
                    "create.pawnType",
                    "Vui lòng chọn loại đồ");
        }
    }
}

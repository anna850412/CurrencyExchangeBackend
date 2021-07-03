package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class Category {
    public String idCategory;
    public String strCategory;
    public String strCategoryThumb;
    public String strCategoryDescription;
}

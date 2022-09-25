package com.infoshareacademy.mistrzowieVaBank.validator;


import com.infoshareacademy.mistrzowieVaBank.dao.WineDao;
import com.infoshareacademy.mistrzowieVaBank.entity.Wine;
import com.infoshareacademy.mistrzowieVaBank.form.WineForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductFormValidator implements Validator {
 
   @Autowired
   private WineDao wineDao;
 
   // This validator only checks for the ProductForm.
   @Override
   public boolean supports(Class<?> clazz) {
      return clazz == WineForm.class;
   }
 
   @Override
   public void validate(Object target, Errors errors) {
      WineForm wineForm = (WineForm) target;
 
      // Check the fields of ProductForm.
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "NotEmpty.wineForm.id");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.wineForm.name");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.wineForm.price");
 
      Long id = wineForm.getId();
      if (id != null) {
         if (id.equals("\\s+")) {
            errors.rejectValue("id", "Pattern.wineForm.id");
         } else if (wineForm.isNewProduct()) {
            Wine wine = wineDao.findWine(id);
            if (wine != null) {
               errors.rejectValue("id", "Duplicate.wineForm.id");
            }
         }
      }
   }
 
}

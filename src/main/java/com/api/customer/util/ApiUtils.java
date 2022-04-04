package com.api.customer.util;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import javax.swing.text.MaskFormatter;

public abstract class ApiUtils {

	/**MSG_ID_CUSTOMER_NOT_FOUND */
	public static final String MSG_ID_CUSTOMER_NOT_FOUND = "This id was not found.";
	
	/**LIST_NOT_FOUND*/
	public static final String LIST_NOT_FOUND = "There are no registered costumers.";

	/**MSG_ERROR_EDIT_CUSTOMER*/
	public static final String MSG_ERROR_EDIT_CUSTOMER = "There was an error editing consumer data.";
	
	/**MASK_ZIP_CODE*/
	public static final String MASK_ZIP_CODE = "#####-###";
	
	/**formatter for Local date*/
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
	
	
	/**
	 * Create a dynamic mask
     * @param value and pattern
     * @throws ParseException if mask does not contain valid mask characters
     */
	public static String applyMask(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(Boolean.FALSE);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }
	
	

}

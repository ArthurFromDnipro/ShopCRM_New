use shopcrm;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_to_category`;
INSERT INTO `shopcrm`.`crm_product_to_category`
(`product_id`,
`category_id`,
`main_category`)
SELECT `oc_product_to_category`.`product_id`,
    `oc_product_to_category`.`category_id`,
    `oc_product_to_category`.`main_category`
FROM `shopcrm`.`oc_product_to_category`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_special`;
INSERT INTO `shopcrm`.`crm_product_special`
(`product_special_id`,
`product_id`,
`customer_group_id`,
`priority`,
`price`,
`date_start`,
`date_end`)
SELECT `oc_product_special`.`product_special_id`,
    `oc_product_special`.`product_id`,
    `oc_product_special`.`customer_group_id`,
    `oc_product_special`.`priority`,
    `oc_product_special`.`price`,
    `oc_product_special`.`date_start`,
    `oc_product_special`.`date_end`
FROM `shopcrm`.`oc_product_special`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_option_value`;
INSERT INTO `shopcrm`.`crm_product_option_value`
(`product_option_value_id`,
`product_option_id`,
`product_id`,
`option_id`,
`option_value_id`,
`quantity`,
`subtract`,
`price`,
`price_prefix`,
`points`,
`points_prefix`,
`weight`,
`weight_prefix`)
SELECT `oc_product_option_value`.`product_option_value_id`,
    `oc_product_option_value`.`product_option_id`,
    `oc_product_option_value`.`product_id`,
    `oc_product_option_value`.`option_id`,
    `oc_product_option_value`.`option_value_id`,
    `oc_product_option_value`.`quantity`,
    `oc_product_option_value`.`subtract`,
    `oc_product_option_value`.`price`,
    `oc_product_option_value`.`price_prefix`,
    `oc_product_option_value`.`points`,
    `oc_product_option_value`.`points_prefix`,
    `oc_product_option_value`.`weight`,
    `oc_product_option_value`.`weight_prefix`
FROM `shopcrm`.`oc_product_option_value`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_option`;
INSERT INTO `shopcrm`.`crm_product_option`
(`product_option_id`,
`product_id`,
`option_id`,
`option_value`,
`required`)
SELECT `oc_product_option`.`product_option_id`,
    `oc_product_option`.`product_id`,
    `oc_product_option`.`option_id`,
    `oc_product_option`.`option_value`,
    `oc_product_option`.`required`
FROM `shopcrm`.`oc_product_option`;
COMMIT;

TRUNCATE `shopcrm`.`crm_product_image`;
INSERT INTO `shopcrm`.`crm_product_image`
(`product_image_id`,
`product_id`,
`image`,
`sort_order`)
SELECT `oc_product_image`.`product_image_id`,
    `oc_product_image`.`product_id`,
    `oc_product_image`.`image`,
    `oc_product_image`.`sort_order`
FROM `shopcrm`.`oc_product_image`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_discount`;
INSERT INTO `shopcrm`.`crm_product_discount`
(`product_discount_id`,
`product_id`,
`customer_group_id`,
`quantity`,
`priority`,
`price`,
`date_start`,
`date_end`)
SELECT `oc_product_discount`.`product_discount_id`,
    `oc_product_discount`.`product_id`,
    `oc_product_discount`.`customer_group_id`,
    `oc_product_discount`.`quantity`,
    `oc_product_discount`.`priority`,
    `oc_product_discount`.`price`,
    `oc_product_discount`.`date_start`,
    `oc_product_discount`.`date_end`
FROM `shopcrm`.`oc_product_discount`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_description`;
INSERT INTO `shopcrm`.`crm_product_description`
(`product_id`,
`language_id`,
`name`,
`description`,
`meta_description`,
`meta_keyword`,
`seo_title`,
`seo_h1`,
`tag`)
SELECT `oc_product_description`.`product_id`,
    `oc_product_description`.`language_id`,
    `oc_product_description`.`name`,
    `oc_product_description`.`description`,
    `oc_product_description`.`meta_description`,
    `oc_product_description`.`meta_keyword`,
    `oc_product_description`.`seo_title`,
    `oc_product_description`.`seo_h1`,
    `oc_product_description`.`tag`
FROM `shopcrm`.`oc_product_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product_attribute`;
INSERT INTO `shopcrm`.`crm_product_attribute`
(`product_id`,
`attribute_id`,
`language_id`,
`text`)
SELECT `oc_product_attribute`.`product_id`,
    `oc_product_attribute`.`attribute_id`,
    `oc_product_attribute`.`language_id`,
    `oc_product_attribute`.`text`
FROM `shopcrm`.`oc_product_attribute`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_product`;
INSERT INTO `shopcrm`.`crm_product`
(`product_id`,
`model`,
`sku`,
`upc`,
`ean`,
`jan`,
`isbn`,
`mpn`,
`location`,
`quantity`,
`stock_status_id`,
`image`,
`manufacturer_id`,
`shipping`,
`price`,
`points`,
`tax_class_id`,
`date_available`,
`weight`,
`weight_class_id`,
`length`,
`width`,
`height`,
`length_class_id`,
`subtract`,
`minimum`,
`sort_order`,
`status`,
`date_added`,
`date_modified`,
`viewed`)
SELECT `oc_product`.`product_id`,
    `oc_product`.`model`,
    `oc_product`.`sku`,
    `oc_product`.`upc`,
    `oc_product`.`ean`,
    `oc_product`.`jan`,
    `oc_product`.`isbn`,
    `oc_product`.`mpn`,
    `oc_product`.`location`,
    `oc_product`.`quantity`,
    `oc_product`.`stock_status_id`,
    `oc_product`.`image`,
    `oc_product`.`manufacturer_id`,
    `oc_product`.`shipping`,
    `oc_product`.`price`,
    `oc_product`.`points`,
    `oc_product`.`tax_class_id`,
    `oc_product`.`date_available`,
    `oc_product`.`weight`,
    `oc_product`.`weight_class_id`,
    `oc_product`.`length`,
    `oc_product`.`width`,
    `oc_product`.`height`,
    `oc_product`.`length_class_id`,
    `oc_product`.`subtract`,
    `oc_product`.`minimum`,
    `oc_product`.`sort_order`,
    `oc_product`.`status`,
    `oc_product`.`date_added`,
    `oc_product`.`date_modified`,
    `oc_product`.`viewed`
FROM `shopcrm`.`oc_product`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_option_value_description`;
INSERT INTO `shopcrm`.`crm_option_value_description`
(`option_value_id`,
`language_id`,
`option_id`,
`name`)
SELECT `oc_option_value_description`.`option_value_id`,
    `oc_option_value_description`.`language_id`,
    `oc_option_value_description`.`option_id`,
    `oc_option_value_description`.`name`
FROM `shopcrm`.`oc_option_value_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_option_value`;
INSERT INTO `shopcrm`.`crm_option_value`
(`option_value_id`,
`option_id`,
`image`,
`sort_order`)
SELECT `oc_option_value`.`option_value_id`,
    `oc_option_value`.`option_id`,
    `oc_option_value`.`image`,
    `oc_option_value`.`sort_order`
FROM `shopcrm`.`oc_option_value`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_option_description`;
INSERT INTO `shopcrm`.`crm_option_description`
(`option_id`,
`language_id`,
`name`)
SELECT `oc_option_description`.`option_id`,
    `oc_option_description`.`language_id`,
    `oc_option_description`.`name`
FROM `shopcrm`.`oc_option_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_option`;
INSERT INTO `shopcrm`.`crm_option`
(`option_id`,
`type`,
`sort_order`)
SELECT `oc_option`.`option_id`,
    `oc_option`.`type`,
    `oc_option`.`sort_order`
FROM `shopcrm`.`oc_option`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_language`;
INSERT INTO `shopcrm`.`crm_language`
(`language_id`,
`name`,
`code`,
`locale`,
`image`,
`directory`,
`filename`,
`sort_order`,
`status`)
SELECT `oc_language`.`language_id`,
    `oc_language`.`name`,
    `oc_language`.`code`,
    `oc_language`.`locale`,
    `oc_language`.`image`,
    `oc_language`.`directory`,
    `oc_language`.`filename`,
    `oc_language`.`sort_order`,
    `oc_language`.`status`
FROM `shopcrm`.`oc_language`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_currency`;
INSERT INTO `shopcrm`.`crm_currency`
(`currency_id`,
`title`,
`code`,
`symbol_left`,
`symbol_right`,
`decimal_place`,
`value`,
`status`,
`date_modified`)
SELECT `oc_currency`.`currency_id`,
    `oc_currency`.`title`,
    `oc_currency`.`code`,
    `oc_currency`.`symbol_left`,
    `oc_currency`.`symbol_right`,
    `oc_currency`.`decimal_place`,
    `oc_currency`.`value`,
    `oc_currency`.`status`,
    `oc_currency`.`date_modified`
FROM `shopcrm`.`oc_currency`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_category_description`;
INSERT INTO `shopcrm`.`crm_category_description`
(`category_id`,
`language_id`,
`name`,
`description`,
`meta_description`,
`meta_keyword`,
`seo_title`,
`seo_h1`)
SELECT `oc_category_description`.`category_id`,
    `oc_category_description`.`language_id`,
    `oc_category_description`.`name`,
    `oc_category_description`.`description`,
    `oc_category_description`.`meta_description`,
    `oc_category_description`.`meta_keyword`,
    `oc_category_description`.`seo_title`,
    `oc_category_description`.`seo_h1`
FROM `shopcrm`.`oc_category_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_category`;
INSERT INTO `shopcrm`.`crm_category`
(`category_id`,
`image`,
`parent_id`,
`top`,
`column`,
`sort_order`,
`status`,
`date_added`,
`date_modified`)
SELECT `oc_category`.`category_id`,
    `oc_category`.`image`,
    `oc_category`.`parent_id`,
    `oc_category`.`top`,
    `oc_category`.`column`,
    `oc_category`.`sort_order`,
    `oc_category`.`status`,
    `oc_category`.`date_added`,
    `oc_category`.`date_modified`
FROM `shopcrm`.`oc_category`;



TRUNCATE `shopcrm`.`crm_attribute_group_description`;
INSERT INTO `shopcrm`.`crm_attribute_group_description`
(`attribute_group_id`,
`language_id`,
`name`)
SELECT `oc_attribute_group_description`.`attribute_group_id`,
    `oc_attribute_group_description`.`language_id`,
    `oc_attribute_group_description`.`name`
FROM `shopcrm`.`oc_attribute_group_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_attribute_group`;
INSERT INTO `shopcrm`.`crm_attribute_group`
(`attribute_group_id`,
`sort_order`)
SELECT `oc_attribute_group`.`attribute_group_id`,
    `oc_attribute_group`.`sort_order`
FROM `shopcrm`.`oc_attribute_group`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_attribute_description`;
INSERT INTO `shopcrm`.`crm_attribute_description`
(`attribute_id`,
`language_id`,
`name`)
SELECT `oc_attribute_description`.`attribute_id`,
    `oc_attribute_description`.`language_id`,
    `oc_attribute_description`.`name`
FROM `shopcrm`.`oc_attribute_description`;
COMMIT;

START TRANSACTION;
TRUNCATE `shopcrm`.`crm_attribute`;
INSERT INTO `shopcrm`.`crm_attribute`
(`attribute_id`,
`attribute_group_id`,
`sort_order`)
SELECT `oc_attribute`.`attribute_id`,
    `oc_attribute`.`attribute_group_id`,
    `oc_attribute`.`sort_order`
FROM `shopcrm`.`oc_attribute`;
COMMIT;
quit
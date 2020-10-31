package com.motaharinia.persistence.orm.etcitem;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;


/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-10-28 <br>
 * Time: 22:12:23 <br>
 * Description:<br>
 * کلاس کالکشن مقادیر ثابت
 * ETCITEM : (Et cetera Items)
 * این مقادیر برای توسعه دهندگان شفاف هستند و در سامانه به صورت داینامیک در ماژول خاصی کم و زیاد نمیشوند مانند جنسیت که یا مرد است یا زن
 */

@Document(collection = "etc_item")
public class EtcItem {
    /**
     * شناسه
     */
    @Id
    private String  id;


    /**
     * نوع مقدار ثابت
     * مثلا نوع جنسیت یا نوع سات یا نوع ملیت
     * مقدار مثال برای مذهب:
     * faith
     */
    @Size(max = 100)
    @Field(name = "type")
    private String type;

    /**
     * تگ مقدار ثابت برای جستجوی گروهی فیلتر کردن در کامبوها استفاده میشود
     * مثلا میخواهیم در چندین سطر مقادیر ثایت که همه از یک نوع هستند برای بعضی از آنها یک تگ بزنیم که بعدا در کدنویسی با آن تگ آنها را بشناسیم
     * مقدار مثال برای مذهب:
     * CATHOLIC
     */
    @Size(max = 100)
    @Field(name = "type_tag")
    private String typeTag;


    /**
     * مقدار کلیدی مقدار ثابت
     * که در کامبوها استفاده میشود
     * مقدار مثال برای مذهب:
     * CATHOLIC
     * ORTHODOX
     * PROTESTANT
     */
    @Size(max = 100)
    @Field(name = "value")
    private String value;

    /**
     * کلید ترجمه عنوان مقدار ثابت
     * عنوان یا کپشن که در کامبوها استفاده میشود
     * این عنوانها به صورت خودکار در زمان تبدیل مدل به جیسون در کنترلر ترجمه میشوند
     * مسیر فایلهای ترجمه این عناوین در پروژه: src/main/resources/lang/module/common/etcitem/
     * مقدار مثال برای مذهب:
     * etcItem.common.user.faith.CATHOLIC
     * etcItem.common.user.faith.ORTHODOX
     * etcItem.common.user.faith.PROTESTANT
     */
    @Size(max = 255)
    @Field(name = "lang_key")
    private String langKey;


    /**
     * ترتیب قرارگیری مقدار ثابت. مثلا در کامبو
     */
    @Field(name = "order_column")
    private Integer orderColumn;


    /**
     * متد سازنده پیش فرض
     */
    public EtcItem() {
    }

    /**
     * متد سازنده
     *
     * @param type        نوع مقدار ثابت
     * @param typeTag     تگ مقدار ثابت برای جستجوی گروهی فیلتر کردن در کامبوها استفاده میشود
     * @param value       مقدار کلیدی مقدار ثابت
     * @param orderColumn ترتیب قرارگیری مقدار ثابت. مثلا در کامبو
     * @param langKey     کلید ترجمه عنوان مقدار ثابت
     */
    public EtcItem(String type, String typeTag, String value, Integer orderColumn, String langKey) {
        this.type = type;
        this.typeTag = typeTag;
        this.value = value;
        this.orderColumn = orderColumn;
        this.langKey = langKey;
    }

    public EtcItem(String type, String typeTag, String value, String langKey) {
        this.type = type;
        this.typeTag = typeTag;
        this.value = value;
        this.langKey = langKey;
    }


    @Override
    public String toString() {
        return "EtcItem{" + "id=" + id + ", type=" + type + ", typeTag=" + typeTag + ", value=" + value + ", langKey=" + langKey + '}';
    }


    //getter-setter:
    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeTag() {
        return typeTag;
    }

    public void setTypeTag(String typeTag) {
        this.typeTag = typeTag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(Integer orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

}

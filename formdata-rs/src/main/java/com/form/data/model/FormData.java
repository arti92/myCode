package com.form.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "form_data")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class FormData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String formData1;
    @NotBlank
    private String formData2;
    @NotBlank
    private String formData3;
    @NotBlank
    private String formData4;
    @NotBlank
    private String formData5;

    @NotBlank
    private String activeRecord;
    @NotBlank
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormData1() {
        return formData1;
    }

    public void setFormData1(String formData1) {
        this.formData1 = formData1;
    }

    public String getFormData2() {
        return formData2;
    }

    public void setFormData2(String formData2) {
        this.formData2 = formData2;
    }

    public String getFormData3() {
        return formData3;
    }

    public void setFormData3(String formData3) {
        this.formData3 = formData3;
    }

    public String getFormData4() {
        return formData4;
    }

    public void setFormData4(String formData4) {
        this.formData4 = formData4;
    }

    public String getFormData5() {
        return formData5;
    }

    public void setFormData5(String formData5) {
        this.formData5 = formData5;
    }

    public String getActiveRecord() {
        return activeRecord;
    }

    public void setActiveRecord(String activeRecord) {
        this.activeRecord = activeRecord;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
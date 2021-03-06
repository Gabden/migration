package ru.gabdulin.migration.main.models.old.admin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
public class SalesEvents implements Serializable {

    private static final long serialVersionUID = -1392496777727589709L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column
    private String bannerUrl;

    @Transient
    private String dataImg;

    public SalesEvents() {
    }

    public SalesEvents(String fileName, String contentType, byte[] bytes, String bannerUrl) {
        this.fileName = fileName;
        this.fileType = contentType;
        this.fileData = bytes;
        this.bannerUrl = bannerUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getDataImg() {
        setDataImg();
        return dataImg;
    }

    private void setDataImg() {
        if (fileData != null && fileData.length > 0) {
            this.dataImg = Base64.getEncoder().encodeToString(fileData);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public void setDataImg(String dataImg) {
        this.dataImg = dataImg;
    }

    @Override
    public String toString() {
        return "SalesEvents{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}

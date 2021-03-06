package ru.gabdulin.migration.main.models.old.admin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;

@Entity
public class LifeEvents implements Serializable {

    private static final long serialVersionUID = -1392496777727589709L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfEvent;

    @Column(name="description_of_event",columnDefinition="LONGTEXT")
    private String descriptionOfEvent;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PhotoOfEvent> photos = new ArrayList<>();

    @Transient
    private Set<String> listOfDataImg;

    public LifeEvents() {
    }

    public LifeEvents(String nameOfEvent, String descriptionOfEvent, List<PhotoOfEvent> photos) {
        this.nameOfEvent = nameOfEvent;
        this.descriptionOfEvent = descriptionOfEvent;
        this.photos = photos;
    }

    public List<String> getListOfDataImg() {
        setDataImg();
        return setDataImg();
    }

    private List<String> setDataImg() {
        List<String> base64Photos = new ArrayList<>();
        if (this.photos.size() != 0){
            photos.forEach(photo ->{
                String base64Photo = Base64.getEncoder().encodeToString(photo.getFileData());
                base64Photos.add(base64Photo);
            });
        }
        return base64Photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getDescriptionOfEvent() {
        return descriptionOfEvent;
    }

    public void setDescriptionOfEvent(String descriptionOfEvent) {
        this.descriptionOfEvent = descriptionOfEvent;
    }

    public List<PhotoOfEvent> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoOfEvent> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "LifeEvents{" +
                "id=" + id +
                ", nameOfEvent='" + nameOfEvent + '\'' +
                ", descriptionOfEvent='" + descriptionOfEvent + '\'' +
                ", photos=" + photos +
                '}';
    }
}

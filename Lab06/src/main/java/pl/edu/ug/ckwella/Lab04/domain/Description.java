package pl.edu.ug.ckwella.Lab04.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Description {
    private long id;
    private String damages;
    private String additionalInformation;

    public Description(String damages, String additionalInformation) {
        this.damages = damages;
        this.additionalInformation = additionalInformation;
    }

    public Description() {
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public String getDamages() {
        return damages;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


}

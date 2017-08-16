package com.mycompany.bynder.domain;

import com.bynder.sdk.model.Media;
import com.bynder.sdk.model.MediaItem;
import com.bynder.sdk.model.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@XmlRootElement
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor
@Getter
public class BinderMedia {

    private Media media;

    public static BinderMedia create(Media media){
        return new BinderMedia(media);
    }

    @XmlElement
    public String getId() {
        return media.getId();
    }

    @XmlElement
    public String getName() {
        return media.getName();
    }

    @XmlElement
    public String getDescription() {
        return media.getDescription();
    }

    @XmlElement
    public String getCopyright() {
        return media.getCopyright();
    }

    @XmlElement
    public Boolean getArchive() {
        return media.getArchive();
    }

    @XmlElement
    public String getDateCreated() {
        return media.getDateCreated();
    }

    @XmlElement
    public String getDateModified() {
        return media.getDateModified();
    }

    @XmlElement
    public String getDatePublished() {
        return media.getDatePublished();
    }

    @XmlElement
    public MediaType getType() {
        return media.getType();
    }

    @XmlElement
    public String getBrandId() {
        return media.getBrandId();
    }

    @XmlElement
    public int getHeight() {
        return media.getHeight();
    }

    @XmlElement
    public int getWidth() {
        return media.getWidth();
    }

    @XmlElement
    public String getOrientation() {
        return media.getOrientation();
    }

    @XmlElement
    public long getFileSize() {
        return media.getFileSize();
    }

    @XmlElement
    public Boolean isPublic() {
        return media.isPublic();
    }

    @XmlElement
    public String getOriginal() {
        return media.getOriginal();
    }

    @XmlElement
    public List<String> getTags() {
        return media.getTags();
    }

    @XmlElement
    public List<String> getExtensions() {
        return media.getExtensions();
    }

    @XmlElement
    public List<String> getVideoPreviewURLs() {
        return media.getVideoPreviewURLs();
    }

    @XmlElement
    public List<String> getPropertyOptions() {
        return media.getPropertyOptions();
    }

    @XmlElement
    public Map<String, String> getThumbnails() {
        return media.getThumbnails();
    }

    @XmlElement
    public List<MediaItem> getMediaItems() {
        return media.getMediaItems();
    }

}

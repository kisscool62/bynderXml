package com.mycompany.bynder.domain.media;

import com.bynder.sdk.api.BynderApi;
import com.bynder.sdk.model.Media;
import com.bynder.sdk.model.MediaItem;
import com.bynder.sdk.model.MediaType;
import com.mycompany.bynder.domain.BynderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BynderMedia implements BynderEntity {

    /**
     * Media id.
     */
    private String id;
    /**
     * Media name.
     */
    private String name;
    /**
     * Media description.
     */
    private String description;
    /**
     * Copyright of the media.
     */
    private String copyright;
    /**
     * Media archive status.
     */
    private Boolean archive;
    /**
     * Date created.
     */
    private String dateCreated;
    /**
     * Date modified.
     */
    private String dateModified;
    /**
     * Date published.
     */
    private String datePublished;
    /**
     * Media type. Possible values are: image, document, audio and video.
     */
    private MediaType type;
    /**
     * Id of the brand the media belongs to.
     */
    private String brandId;
    /**
     * Height of the original media file.
     */
    private int height;
    /**
     * Width of the original media file.
     */
    private int width;
    /**
     * Orientation of the original media file.
     */
    private String orientation;
    /**
     * File size of the original media file in bytes.
     */
    private long fileSize;
    /**
     * Media public status.
     */
    private Boolean isPublic;
    /**
     * Media original URL.
     */
    private String original;
    /**
     * Tags of the media.
     */
    private List<String> tags;
    /**
     * Extension of the media file.
     */
    private List<String> extensions;
    /**
     * Video preview URLs.
     */
    private List<String> videoPreviewURLs;
    /**
     * Property options assigned to the media.
     */
    private List<String> propertyOptions;
    /**
     * Generated thumbnails for the media.
     */
    private Map<String, String> thumbnails;
    /**
     * Media items for the media. Including derivatives, additional and original. To get this
     * information we have to call {@link BynderApi#getMediaInfo(Map)} with the media id and
     * versions equal to true.
     */
    private List<MediaItem> mediaItems;

    public static BynderMedia create(Media media){
        return builder()
                .id(media.getId())
                .archive(media.getArchive())
                .brandId(media.getBrandId())
                .copyright(media.getCopyright())
                .dateCreated(media.getDateCreated())
                .dateModified(media.getDateModified())
                .datePublished(media.getDatePublished())
                .description(media.getDescription())
                .extensions(media.getExtensions())
                .fileSize(media.getFileSize())
                .height(media.getHeight())
                .isPublic(media.isPublic())
                .mediaItems(media.getMediaItems())
                .name(media.getName())
                .orientation(media.getOrientation())
                .original(media.getOriginal())
                .tags(media.getTags())
                .propertyOptions(media.getPropertyOptions())
                .thumbnails(media.getThumbnails())
                .type(media.getType())
                .videoPreviewURLs(media.getVideoPreviewURLs())
                .width(media.getWidth())
                .build();
    }


}

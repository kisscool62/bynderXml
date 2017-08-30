package com.mycompany.bynder.domain.metaproperty;

import com.bynder.sdk.model.Metaproperty;
import com.bynder.sdk.model.MetapropertyOption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BynderMetaproperty {


    /**
     * Id of the metaproperty.
     */
    private String id;
    /**
     * Name of the metaproperty.
     */
    private String name;
    /**
     * Label of the metaproperty.
     */
    private String label;
    /**
     * Child metaproperty options.
     */
    //TODO create a custom MetapropertyOption to be able to set values
    private List<MetapropertyOption> options;
    /**
     * True if metaproperty option has filterable turned on.
     */
    private Boolean isFilterable;
    /**
     * Order in which the metaproperty should appear.
     */
    private int zindex;

    public static BynderMetaproperty create(Metaproperty metaproperty){
        return builder()
                .id(metaproperty.getId())
                .name(metaproperty.getName())
                .label(metaproperty.getLabel())
                .options(metaproperty.getOptions())
                .isFilterable(metaproperty.isFilterable())
                .zindex(metaproperty.getZindex())
                .build();
    }

    public void addOption(MetapropertyOption option){
        if (this.options != null){
            this.options = new ArrayList<MetapropertyOption>();
        }
        this.options.add(option);
    }


}

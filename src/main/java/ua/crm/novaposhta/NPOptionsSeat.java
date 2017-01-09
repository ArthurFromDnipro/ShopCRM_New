package ua.crm.novaposhta;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPOptionsSeat {
    private String volumetricVolume = "0.001";
    private String volumetricWidth = "10";
    private String volumetricLength = "10";
    private String volumetricHeight = "10";
    private String weight = "0.2";

    public NPOptionsSeat() {
    }

    public NPOptionsSeat(String volumetricVolume, String volumetricWidth, String volumetricLength, String volumetricHeight, String weight) {
        this.volumetricVolume = volumetricVolume;
        this.volumetricWidth = volumetricWidth;
        this.volumetricLength = volumetricLength;
        this.volumetricHeight = volumetricHeight;
        this.weight = weight;
    }


    public String getVolumetricVolume() {
        return volumetricVolume;
    }

    public void setVolumetricVolume(String volumetricVolume) {
        this.volumetricVolume = volumetricVolume;
    }

    public String getVolumetricWidth() {
        return volumetricWidth;
    }

    public void setVolumetricWidth(String volumetricWidth) {
        this.volumetricWidth = volumetricWidth;
    }

    public String getVolumetricLength() {
        return volumetricLength;
    }

    public void setVolumetricLength(String volumetricLength) {
        this.volumetricLength = volumetricLength;
    }

    public String getVolumetricHeight() {
        return volumetricHeight;
    }

    public void setVolumetricHeight(String volumetricHeight) {
        this.volumetricHeight = volumetricHeight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NPOptionsSeat{" +
                "volumetricVolume='" + volumetricVolume + '\'' +
                ", volumetricWidth='" + volumetricWidth + '\'' +
                ", volumetricLength='" + volumetricLength + '\'' +
                ", volumetricHeight='" + volumetricHeight + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

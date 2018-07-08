package www.petapp.com.thepetapp.model;

public class PetCardItem {

    private int imageURL;
    private String description;

    public PetCardItem(int imageURL, String description) {
        this.imageURL = imageURL;
        this.description = description;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

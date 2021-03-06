package bestoffer.kau.edu.bestoffer;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by user on 24/02/18.
 */

public class items {
   public static ArrayList<items> ItemList = new ArrayList<items>() ;
   private int index ;
    private String id ;
    private String name ;
    private String type ;
    private String description ;
    private double price ;
    private String pictureLink ;
    private double offer ;
    private String supermarket ;
    private Bitmap img;

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer ;

    }

    public String getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket;
    }

    public static items getItem (String id , String supermarket){

        for (items item: items.ItemList) {
            if(item.getId().equals(id) && item.getSupermarket().equals(supermarket))
                return item ;

        }


        return null ;
    }

    public static items getItemByIndex(int index){

        for (items item:items.ItemList) {
            if(item.getIndex() == index)
                return item ;
        }
        return null ;
    }
}

package ca.dss.csd.cct.project.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "dataset")
public class AppData {

    @MongoId
    private ObjectId id;
    @NotBlank
    @Min(value = 3)@Max(value = 20)
    private String appName;
    @NotBlank
    @Min(value = 3)@Max(value = 20)
    private String appId;
    @Min(value = 3)@Max(value = 20)
    @NotBlank
    private String category;
    @NotBlank
    @Min(value = 3)@Max(value = 20)
    private String rating;
    @NotBlank
    @Min(value = 4)@Max(value = 5)
    private String free;
    @NotBlank
    private String price;
    @NotBlank
    private String size;
    @NotBlank
    private String androidVersion;
    @NotBlank
    private String developerId;

    public AppData() {}

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }


    @Override
    public String toString() {
        return this.appName + this.appId;
    }
}

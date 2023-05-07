package ca.dss.csd.cct.project.entity;

import jakarta.validation.constraints.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "dataset")
public class AppData {

    @MongoId
    private ObjectId id;
    @NotBlank(message = "Application name must be longer than 3 characters and shorter than 100")
    @Size(min = 3, max = 100, message = "Application name must be longer than 3 characters and shorter than 30")
    private String appName;
    @NotBlank(message = "Id must be between 3 and 20 characters ")
    @Size(min = 3, max = 100, message = "Id must be between 3 and 100 characters ")
    private String appId;
    @NotBlank(message = "Category name must be longer than 3 characters")
    @Size(min = 3, message = "Category name must be longer than 3 characters")
    private String category;
    @NotBlank(message = "Rating field cannot be empty")
    @Pattern(regexp = "[0-9]", message = "Price must be a number number only")
    private String rating;
    @NotBlank
    @Size(min = 4, max = 5, message = "Please, insert True or False")
    private String free;
    @NotBlank
    private String price;
    @NotBlank(message = "Please, provide application size")
    private String size;
    @NotBlank(message = "Please, provide minimum android version")
    private String androidVersion;
    @NotBlank(message = "Developer ID must be provided")
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
